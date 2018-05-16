package cn.dlbdata.dangjian.admin.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.dlbdata.dangjian.admin.dao.model.PFeature;
import cn.dlbdata.dangjian.admin.dao.model.PFeatureExample;
import cn.dlbdata.dangjian.admin.service.PFeatureService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
@Controller
@RequestMapping("/pfeature")

public class PFeatureController{

    @Autowired
    private PFeatureService pFeatureService;


    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PFeature pFeature){
        ResultUtil result = new ResultUtil();
        int callbackId = pFeatureService.insert(pFeature);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PFeature> pFeatureList = pFeatureService.selectByExample(new PFeatureExample());
        result.setSuccess(true);
        result.setData(pFeatureList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PFeature> pFeatureList = pFeatureService.selectByExample(new PFeatureExample());
        PageInfo<PFeature> p=new PageInfo<PFeature>(pFeatureList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteById(Integer featureid){
        ResultUtil result = new ResultUtil();
        PFeatureExample example = new PFeatureExample();
        if(pFeatureService.deleteByPrimaryKey(featureid)>0){
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
    public Map<String, Object> updateById(PFeature pFeature){
        ResultUtil result = new ResultUtil();
        if(pFeatureService.updateByPrimaryKey(pFeature)>0){
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
    public Map<String, Object> queryById(Integer featureid){
        ResultUtil result = new ResultUtil();
        PFeature pFeature = pFeatureService.selectByPrimaryKey(featureid);
        result.setSuccess(true);
        result.setData(pFeature);
        return result.getResult();
    }
}