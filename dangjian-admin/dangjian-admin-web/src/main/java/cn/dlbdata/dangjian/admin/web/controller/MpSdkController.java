package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.CustomMenuService;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(MpSdkController.class);

    @Autowired
    private CustomMenuService customMenuService;

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
            LOGGER.error(e.getErrorMsg());
        }

        return result.getResult();
    }

}
