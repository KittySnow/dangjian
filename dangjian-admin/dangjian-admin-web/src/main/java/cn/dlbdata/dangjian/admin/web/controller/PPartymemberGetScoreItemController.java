package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberGetScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberGetScoreItemService;
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
@RequestMapping("/ppartymembergetscoreitem")

public class PPartymemberGetScoreItemController {

    @Autowired
    private PPartymemberGetScoreItemService pPartymemberGetScoreItemService;


    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymemberGetScoreItem pPartymemberGetScoreItem){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymemberGetScoreItemService.insert(pPartymemberGetScoreItem);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymemberGetScoreItem> pPartymemberGetScoreItemList = pPartymemberGetScoreItemService.selectByExample(new PPartymemberGetScoreItemExample());
        result.setSuccess(true);
        result.setData(pPartymemberGetScoreItemList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymemberGetScoreItem> pPartymemberGetScoreItemList = pPartymemberGetScoreItemService.selectByExample(new PPartymemberGetScoreItemExample());
        PageInfo<PPartymemberGetScoreItem> p=new PageInfo<PPartymemberGetScoreItem>(pPartymemberGetScoreItemList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer itemid){
        ResultUtil result = new ResultUtil();
        PPartymemberGetScoreItemExample example = new PPartymemberGetScoreItemExample();
        if(pPartymemberGetScoreItemService.deleteByPrimaryKey(itemid)>0){
            result.setSuccess(true);
            result.setMsg("删除成功");
        }else{
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value="/updateById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PPartymemberGetScoreItem pPartymemberGetScoreItem){
        ResultUtil result = new ResultUtil();
        if(pPartymemberGetScoreItemService.updateByPrimaryKey(pPartymemberGetScoreItem)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value="/queryById",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer itemid){
        ResultUtil result = new ResultUtil();
        PPartymemberGetScoreItem pPartymemberGetScoreItem = pPartymemberGetScoreItemService.selectByPrimaryKey(itemid);
        result.setSuccess(true);
        result.setData(pPartymemberGetScoreItem);
        return result.getResult();
    }
}