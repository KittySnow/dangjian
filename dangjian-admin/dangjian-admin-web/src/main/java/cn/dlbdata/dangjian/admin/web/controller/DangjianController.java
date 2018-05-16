package cn.dlbdata.dangjian.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.dlbdata.dangjian.admin.service.DangjianService;
import cn.dlbdata.dangjian.admin.service.pojo.PartymemberInfoItem;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Author: linfujun
 * @Description:
 * @Date: Created on 13:56 2018/4/7
 */
@Controller
@Api(description = "党建信息")
@RequestMapping("/dangjian")
public class DangjianController {

    @Autowired
    private DangjianService dangjianService;

    @ApiOperation(value = "查询党员信息列表", httpMethod = "GET")
    @RequestMapping(value="/getPartymemberInfoItem",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getPartymemberInfoItemListByDepartmentId(@RequestParam Integer departmentId){
        ResultUtil result = new ResultUtil();

        List<PartymemberInfoItem> partymemberInfoItemList = dangjianService.getPartymemberInfoItemListByDepartmentId(departmentId);
        result.setData(partymemberInfoItemList);
        result.setSuccess(true);

        return result.getResult();
    }

}
