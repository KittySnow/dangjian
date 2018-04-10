package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.util.HttpResult;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.common.util.StringUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.LocalCache;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 17:28 2018/3/25
 */

@Controller
@RequestMapping("/mp")
public class MpSdkController {
    Logger logger = LoggerFactory.getLogger(MpSdkController.class);

    @Autowired
    private CustomMenuService customMenuService;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private AccessService accessService;

    @RequestMapping(value = "/createMenu", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createMenu(String json) {
        ResultUtil result = new ResultUtil();

        try {
            customMenuService.createMenu(json);
            result.setSuccess(true);
        } catch (DangjianException e) {
            result.setMsg(e.getErrorMsg());
            result.setSuccess(false);
        }

        return result.getResult();
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult userInfo(String openid) {
        GetUserInfo userInfo = new GetUserInfo();
        userInfo.setLang("zh_CN");
        userInfo.setOpenid(openid);

        JSONObject json;
        try {
            json = userInfoService.userInfo(userInfo);
        } catch (DangjianException e) {
            logger.error("", e);

            return HttpResult.failure("数据获取异常.");
        }

        return HttpResult.success(json);
    }

    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getToken() {
        ResultUtil result = new ResultUtil();
        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);

        try {
            String Token = LocalCache.TOKEN_CACHE.getIfPresent("ACCESS_TOKEN");
            if (null == Token || "".equals(Token)) {
                AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
                accessTokenResponse.getAccessToken();
            }
            //获取Ticket
            String jsapi_ticket = getTicket(Token);

            //拿noncestr
            String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
            getaAccessTokenParam.setNonceStr(noncestr);

            //拿timestamp
            long timestamp = System.currentTimeMillis() / 1000;//时间戳
            getaAccessTokenParam.setTimestamp(timestamp);

            //获取signature
            String url = "http://180.169.82.27:7777/";
            String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
            String signature = SHA1(str);
            getaAccessTokenParam.setSignature(signature);

        } catch (DangjianException e) {
            logger.error("", e);

        }


        result.setData(getaAccessTokenParam);
        result.setSuccess(true);
        return result.getResult();
    }


    public static String getTicket(String access_token) {
        String ticket = LocalCache.TICKET_CACHE.getIfPresent("TICKET");
        if (null != ticket && !"".equals(ticket)) {
            return ticket;
        }
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + access_token + "&type=jsapi";//这个url链接和参数不能变
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            http.setRequestMethod("GET"); // 必须是get方式请求
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            System.setProperty("sun.net.client.defaultConnectTimeout", "30000");// 连接超时30秒
            System.setProperty("sun.net.client.defaultReadTimeout", "30000"); // 读取超时30秒
            http.connect();
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            String message = new String(jsonBytes, "UTF-8");
            JSONObject demoJson = JSONObject.fromObject(message);
            System.out.println("JSON字符串：" + demoJson);
            ticket = demoJson.getString("ticket");
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }


    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
