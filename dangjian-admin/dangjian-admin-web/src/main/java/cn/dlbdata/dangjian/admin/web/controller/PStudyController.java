package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PStudy;
import cn.dlbdata.dangjian.admin.dao.model.PStudyExample;
import cn.dlbdata.dangjian.admin.service.PStudyService;
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
@RequestMapping("/pstudy")

public class PStudyController {

    @Autowired
    private PStudyService pStudyService;


    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PStudy pStudy){
        ResultUtil result = new ResultUtil();
        int callbackId = pStudyService.insert(pStudy);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PStudy> pStudyList = pStudyService.selectByExample(new PStudyExample());
        result.setSuccess(true);
        result.setData(pStudyList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PStudy> pStudyList = pStudyService.selectByExample(new PStudyExample());
        PageInfo<PStudy> p=new PageInfo<PStudy>(pStudyList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer studyid){
        ResultUtil result = new ResultUtil();
        PStudyExample example = new PStudyExample();
        if(pStudyService.deleteByPrimaryKey(studyid)>0){
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
    public Map<String, Object> updateById(PStudy pStudy){
        ResultUtil result = new ResultUtil();
        if(pStudyService.updateByPrimaryKey(pStudy)>0){
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
    public Map<String, Object> queryById(Integer studyid){
        ResultUtil result = new ResultUtil();
        PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);
        result.setSuccess(true);
        result.setData(pStudy);
        return result.getResult();
    }
}