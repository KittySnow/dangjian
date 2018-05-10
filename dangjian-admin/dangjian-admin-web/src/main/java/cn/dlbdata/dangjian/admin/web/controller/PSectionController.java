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

import cn.dlbdata.dangjian.admin.dao.model.PSection;
import cn.dlbdata.dangjian.admin.dao.model.PSectionExample;
import cn.dlbdata.dangjian.admin.service.PSectionService;
import cn.dlbdata.dangjian.common.util.ResultUtil;

@Controller
@RequestMapping("/pSection")
public class PSectionController {
	

    @Autowired
    private PSectionService pSectionService;
    
    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PSection pSection){
        ResultUtil result = new ResultUtil();
        int callbackId = pSectionService.insert(pSection);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PSection> pSectionList = pSectionService.selectByExample(new PSectionExample());
        result.setSuccess(true);
        result.setData(pSectionList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PSection> pSectionList = pSectionService.selectByExample(new PSectionExample());
        PageInfo<PSection> p=new PageInfo<PSection>(pSectionList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        if(pSectionService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PSection pSection){
        ResultUtil result = new ResultUtil();
        if(pSectionService.updateByPrimaryKey(pSection)>0){
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
        PSection pSection = pSectionService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pSection);
        return result.getResult();
    }
    
  
}
