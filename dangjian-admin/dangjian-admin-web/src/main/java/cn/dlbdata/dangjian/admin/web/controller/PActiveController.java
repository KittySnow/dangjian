package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.service.PActiveService;
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
/**
 * @packageName PActiveController
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 活动接口
 */
@Controller
@RequestMapping("/active")
public class PActiveController {

    @Autowired
    private PActiveService pActiveService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PActive pActive){
        ResultUtil result = new ResultUtil();
        int callbackId = pActiveService.insert(pActive);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PActive> pActiveList = pActiveService.selectByExample(new PActiveExample());
        result.setSuccess(true);
        result.setData(pActiveList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PActive> pActiveList = pActiveService.selectByExample(new PActiveExample());
        PageInfo<PActive> p=new PageInfo<PActive>(pActiveList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer activeid){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        if(pActiveService.deleteByPrimaryKey(activeid)>0){
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
    public Map<String, Object> updateById(PActive pActive){
        ResultUtil result = new ResultUtil();
        if(pActiveService.updateByPrimaryKey(pActive)>0){
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
    public Map<String, Object> queryById(Integer activeid){
        ResultUtil result = new ResultUtil();
        PActive pActive = pActiveService.selectByPrimaryKey(activeid);
        result.setSuccess(true);
        result.setData(pActive);
        return result.getResult();
    }
}