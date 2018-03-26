package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PSpace;
import cn.dlbdata.dangjian.admin.dao.model.PSpaceExample;
import cn.dlbdata.dangjian.admin.service.PSpaceService;
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
@RequestMapping("/pspace")
public class PSpaceController {

    @Autowired
    private PSpaceService pSpaceService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PSpace pSpace){
        ResultUtil result = new ResultUtil();
        int callbackId = pSpaceService.insert(pSpace);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PSpace> pSpaceList = pSpaceService.selectByExample(new PSpaceExample());
        result.setSuccess(true);
        result.setData(pSpaceList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PSpace> pSpaceList = pSpaceService.selectByExample(new PSpaceExample());
        PageInfo<PSpace> p=new PageInfo<PSpace>(pSpaceList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteById(Integer spaceid){
        ResultUtil result = new ResultUtil();
        PSpaceExample example = new PSpaceExample();
        if(pSpaceService.deleteByPrimaryKey(spaceid)>0){
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
    public Map<String, Object> updateById(PSpace pSpace){
        ResultUtil result = new ResultUtil();
        if(pSpaceService.updateByPrimaryKey(pSpace)>0){
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
    public Map<String, Object> queryById(Integer spaceid){
        ResultUtil result = new ResultUtil();
        PSpace pSpace = pSpaceService.selectByPrimaryKey(spaceid);
        result.setSuccess(true);
        result.setData(pSpace);
        return result.getResult();
    }
}