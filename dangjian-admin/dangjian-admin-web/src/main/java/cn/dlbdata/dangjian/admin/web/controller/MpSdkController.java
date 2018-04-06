package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.util.HttpResult;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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

    @RequestMapping(value="/createMenu",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createMenu(String json){
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

    @RequestMapping(value="/userInfo",method= RequestMethod.GET)
    @ResponseBody
    public HttpResult userInfo(String openid){
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
}
