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

import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePicture;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradePictureExample;
import cn.dlbdata.dangjian.admin.service.PAvantgradePictureService;
import cn.dlbdata.dangjian.common.util.ResultUtil;

@Controller
@RequestMapping("/pavantgradepicture")

public class PAvantgradePictureController {

    @Autowired
    private PAvantgradePictureService pAvantgradePictureService;

    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PAvantgradePicture pAvantgradePicture){
        ResultUtil result = new ResultUtil();
        int callbackId = pAvantgradePictureService.insert(pAvantgradePicture);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PAvantgradePicture> pAvantgradePictureList = pAvantgradePictureService.selectByExample(new PAvantgradePictureExample());
        result.setSuccess(true);
        result.setData(pAvantgradePictureList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PAvantgradePicture> pAvantgradePictureList = pAvantgradePictureService.selectByExample(new PAvantgradePictureExample());
        PageInfo<PAvantgradePicture> p=new PageInfo<PAvantgradePicture>(pAvantgradePictureList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PAvantgradePictureExample example = new PAvantgradePictureExample();
        if(pAvantgradePictureService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PAvantgradePicture pAvantgradePicture){
        ResultUtil result = new ResultUtil();
        if(pAvantgradePictureService.updateByPrimaryKey(pAvantgradePicture)>0){
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
    public Map<String, Object> queryById(Integer id){
        ResultUtil result = new ResultUtil();
        PAvantgradePicture pAvantgradePicture = pAvantgradePictureService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pAvantgradePicture);
        return result.getResult();
    }
}