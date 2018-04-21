package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartment;
import cn.dlbdata.dangjian.admin.dao.model.PActiveDepartmentExample;
import cn.dlbdata.dangjian.admin.service.PActiveDepartmentService;
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
@RequestMapping("/pactivedepartment")

public class PActiveDepartmentController {

    @Autowired
    private PActiveDepartmentService pActiveDepartmentService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PActiveDepartment pActiveDepartment){
        ResultUtil result = new ResultUtil();
        int callbackId = pActiveDepartmentService.insert(pActiveDepartment);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PActiveDepartment> pActiveDepartmentList = pActiveDepartmentService.selectByExample(new PActiveDepartmentExample());
        result.setSuccess(true);
        result.setData(pActiveDepartmentList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActiveDepartment> pActiveDepartmentList = pActiveDepartmentService.selectByExample(new PActiveDepartmentExample());
        PageInfo<PActiveDepartment> p=new PageInfo<PActiveDepartment>(pActiveDepartmentList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PActiveDepartmentExample example = new PActiveDepartmentExample();
        if(pActiveDepartmentService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PActiveDepartment pActiveDepartment){
        ResultUtil result = new ResultUtil();
        if(pActiveDepartmentService.updateByPrimaryKey(pActiveDepartment)>0){
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
    public Map<String, Object> queryById(Integer id){
        ResultUtil result = new ResultUtil();
        PActiveDepartment pActiveDepartment = pActiveDepartmentService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pActiveDepartment);
        return result.getResult();
    }
}