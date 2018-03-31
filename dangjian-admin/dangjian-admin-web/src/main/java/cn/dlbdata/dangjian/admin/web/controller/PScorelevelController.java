package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PScorelevel;
import cn.dlbdata.dangjian.admin.dao.model.PScorelevelExample;
import cn.dlbdata.dangjian.admin.service.PScorelevelService;
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
@RequestMapping("/pscorelevel")

public class PScorelevelController {

    @Autowired
    private PScorelevelService pScorelevelService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PScorelevel pScorelevel){
        ResultUtil result = new ResultUtil();
        int callbackId = pScorelevelService.insert(pScorelevel);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PScorelevel> pScorelevelList = pScorelevelService.selectByExample(new PScorelevelExample());
        result.setSuccess(true);
        result.setData(pScorelevelList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PScorelevel> pScorelevelList = pScorelevelService.selectByExample(new PScorelevelExample());
        PageInfo<PScorelevel> p=new PageInfo<PScorelevel>(pScorelevelList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer scoreid){
        ResultUtil result = new ResultUtil();
        PScorelevelExample example = new PScorelevelExample();
        if(pScorelevelService.deleteByPrimaryKey(scoreid)>0){
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
    public Map<String, Object> updateById(PScorelevel pScorelevel){
        ResultUtil result = new ResultUtil();
        if(pScorelevelService.updateByPrimaryKey(pScorelevel)>0){
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
    public Map<String, Object> queryById(Integer scoreid){
        ResultUtil result = new ResultUtil();
        PScorelevel pScorelevel = pScorelevelService.selectByPrimaryKey(scoreid);
        result.setSuccess(true);
        result.setData(pScorelevel);
        return result.getResult();
    }
}