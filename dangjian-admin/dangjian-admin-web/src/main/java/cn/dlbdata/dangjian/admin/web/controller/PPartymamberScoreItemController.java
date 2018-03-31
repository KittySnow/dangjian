package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymamberScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymamberScoreItemService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ppartymamberscoreitem")

public class PPartymamberScoreItemController {

    @Autowired
    private PPartymamberScoreItemService pPartymamberScoreItemService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymamberScoreItem pPartymamberScoreItem){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymamberScoreItemService.insert(pPartymamberScoreItem);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymamberScoreItem> pPartymamberScoreItemList = pPartymamberScoreItemService.selectByExample(new PPartymamberScoreItemExample());
        result.setSuccess(true);
        result.setData(pPartymamberScoreItemList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymamberScoreItem> pPartymamberScoreItemList = pPartymamberScoreItemService.selectByExample(new PPartymamberScoreItemExample());
        PageInfo<PPartymamberScoreItem> p=new PageInfo<PPartymamberScoreItem>(pPartymamberScoreItemList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer item_id){
        ResultUtil result = new ResultUtil();
        PPartymamberScoreItemExample example = new PPartymamberScoreItemExample();
        if(pPartymamberScoreItemService.deleteByPrimaryKey(item_id)>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value="/updateById",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PPartymamberScoreItem pPartymamberScoreItem){
        ResultUtil result = new ResultUtil();
        if(pPartymamberScoreItemService.updateByPrimaryKey(pPartymamberScoreItem)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value="/queryById",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer item_id){
        ResultUtil result = new ResultUtil();
        PPartymamberScoreItem pPartymamberScoreItem = pPartymamberScoreItemService.selectByPrimaryKey(item_id);
        result.setSuccess(true);
        result.setData(pPartymamberScoreItem);
        return result.getResult();
    }
}