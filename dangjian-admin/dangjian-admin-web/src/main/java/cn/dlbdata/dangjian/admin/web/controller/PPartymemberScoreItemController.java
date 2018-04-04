package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItem;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberScoreItemExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberScoreItemService;
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
@RequestMapping("/ppartymemberscoreitem")

public class PPartymemberScoreItemController {

    @Autowired
    private PPartymemberScoreItemService pPartymemberScoreItemService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymemberScoreItem pPartymemberScoreItem){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymemberScoreItemService.insert(pPartymemberScoreItem);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymemberScoreItem> pPartymemberScoreItemList = pPartymemberScoreItemService.selectByExample(new PPartymemberScoreItemExample());
        result.setSuccess(true);
        result.setData(pPartymemberScoreItemList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymemberScoreItem> pPartymemberScoreItemList = pPartymemberScoreItemService.selectByExample(new PPartymemberScoreItemExample());
        PageInfo<PPartymemberScoreItem> p=new PageInfo<PPartymemberScoreItem>(pPartymemberScoreItemList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer itemid){
        ResultUtil result = new ResultUtil();
        PPartymemberScoreItemExample example = new PPartymemberScoreItemExample();
        if(pPartymemberScoreItemService.deleteByPrimaryKey(itemid)>0){
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
    public Map<String, Object> updateById(PPartymemberScoreItem pPartymemberScoreItem){
        ResultUtil result = new ResultUtil();
        if(pPartymemberScoreItemService.updateByPrimaryKey(pPartymemberScoreItem)>0){
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
    public Map<String, Object> queryById(Integer itemid){
        ResultUtil result = new ResultUtil();
        PPartymemberScoreItem pPartymemberScoreItem = pPartymemberScoreItemService.selectByPrimaryKey(itemid);
        result.setSuccess(true);
        result.setData(pPartymemberScoreItem);
        return result.getResult();
    }
}