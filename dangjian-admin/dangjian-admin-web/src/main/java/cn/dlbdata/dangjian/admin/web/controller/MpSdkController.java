package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.util.HttpResult;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.AccessTokenResponse;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetaAccessTokenParam;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GrantType;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.AccessService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.util.CommonUtil;
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
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Formatter;
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
    public Map<String, Object> getToken(HttpServletRequest httpRequest,String href) {

        String url ="http://" + httpRequest.getServerName()+ httpRequest.getContextPath() + httpRequest.getServletPath();

        if(httpRequest.getQueryString()!=null) {
           url+="?"+httpRequest.getQueryString();
        }

        if(href!=null) {
           url = href;
        }

        ResultUtil result = new ResultUtil();
        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        try {
            String Token = LocalCache.TICKET_CACHE.getIfPresent("ACCESS_TOKEN");
            if (null == Token || "".equals(Token)) {
                AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
                Token = accessTokenResponse.getAccessToken();
                LocalCache.TICKET_CACHE.put("ACCESS_TOKEN",Token);
            }
            getaAccessTokenParam.setToken(Token);
            //获取Ticket
            String jsapi_ticket = getTicket(Token);

            //拿noncestr
            String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
            getaAccessTokenParam.setNonceStr(noncestr);

            //拿timestamp
            long timestamp = System.currentTimeMillis() / 1000;//时间戳
            getaAccessTokenParam.setTimestamp(timestamp);

            //获取signature
            String str = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
            String signature = getSHA1(str);
            getaAccessTokenParam.setSignature(signature);

        } catch (DangjianException e) {
            logger.error("", e);

        }


        result.setData(getaAccessTokenParam);
        result.setSuccess(true);
        return result.getResult();
    }



    public static String getTicket(String access_token) {
        String ticket = LocalCache.TOKEN_CACHE.getIfPresent("TICKET");
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
        LocalCache.TOKEN_CACHE.put("TICKET",ticket);
        return ticket;
    }



    /**
     * 获取字符串的SHA1编码
     * @param requestStr
     * @return
     */
    private static String getSHA1(String requestStr){
        String signature = new String();
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(requestStr.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return signature;
    }

    /**
     * byte转string(hex)
     * @param hash
     * @return
     */
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash)
        {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    /**
     * 获取媒体文件
     *
     * @param mediaId 媒体文件id
     * @param savePath 文件在本地服务器上的存储路径
     * */
    public static String downloadMedia(String mediaId, String savePath) {

        String filePath = null;

        GetaAccessTokenParam getaAccessTokenParam = new GetaAccessTokenParam();
        getaAccessTokenParam.setSecret("8d72463ffdf8a2232241985b442c1c93");
        getaAccessTokenParam.setAppid("wxef4c83c01085bb38");
        getaAccessTokenParam.setGrantType(GrantType.client_credential);
        String Token = LocalCache.TICKET_CACHE.getIfPresent("ACCESS_TOKEN");
        if (null == Token || "".equals(Token)) {
            AccessTokenResponse accessTokenResponse = accessService.getAccessToken(getaAccessTokenParam);
            Token = accessTokenResponse.getAccessToken();
            LocalCache.TICKET_CACHE.put("ACCESS_TOKEN",Token);
        }
        // 拼接请求地址
        String requestUrl = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        requestUrl = requestUrl.replace("ACCESS_TOKEN", Token).replace("MEDIA_ID", mediaId);
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");

            if (!savePath.endsWith("/")) {
                savePath += "/";
            }
            // 根据内容类型获取扩展名
            String fileExt = CommonUtil.getFileExt(conn.getHeaderField("Content-Type"));
            // 将mediaId作为文件名
            filePath = savePath + mediaId + fileExt;
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1)
                fos.write(buf, 0, size);
            fos.close();
            bis.close();
            conn.disconnect();
            String info = String.format("下载媒体文件成功，filePath=" + filePath);
            System.out.println(info);
        } catch (Exception e) {
            filePath = null;
            String error = String.format("下载媒体文件失败：%s", e);
            System.out.println(error);
        }
        return filePath;
    }
}
