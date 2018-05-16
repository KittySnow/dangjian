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

import cn.dlbdata.dangjian.admin.dao.model.PDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PDepartmentExample;
import cn.dlbdata.dangjian.admin.service.PDepartmentService;
import cn.dlbdata.dangjian.common.util.ResultUtil;

@Controller
@RequestMapping("/pdepartment")
public class PDepartmentController {

    @Autowired
    private PDepartmentService pDepartmentService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PDepartment pDepartment){
        ResultUtil result = new ResultUtil();
        int callbackId = pDepartmentService.insert(pDepartment);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PDepartment> pDepartmentList = pDepartmentService.selectByExample(new PDepartmentExample());
        result.setSuccess(true);
        result.setData(pDepartmentList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PDepartment> pDepartmentList = pDepartmentService.selectByExample(new PDepartmentExample());
        PageInfo<PDepartment> p=new PageInfo<PDepartment>(pDepartmentList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteById(Integer departmentid){
        ResultUtil result = new ResultUtil();
        if(pDepartmentService.deleteByPrimaryKey(departmentid)>0){
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
    public Map<String, Object> updateById(PDepartment pDepartment){
        ResultUtil result = new ResultUtil();
        if(pDepartmentService.updateByPrimaryKey(pDepartment)>0){
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
    public Map<String, Object> queryById(Integer departmentid){
        ResultUtil result = new ResultUtil();
        PDepartment pDepartment = pDepartmentService.selectByPrimaryKey(departmentid);
        result.setSuccess(true);
        result.setData(pDepartment);
        return result.getResult();
    }

    @RequestMapping(value="/getSumPeople",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getSumPeople(){
        ResultUtil result = new ResultUtil();
        Integer sum = pDepartmentService.getSumPeople();
        result.setSuccess(true);
        result.setData(sum);
        return result.getResult();
    }
}