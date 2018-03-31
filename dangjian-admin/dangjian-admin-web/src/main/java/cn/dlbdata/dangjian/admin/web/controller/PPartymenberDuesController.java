package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymenberDuesExample;
import cn.dlbdata.dangjian.admin.service.PPartymenberDuesService;
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
@RequestMapping("/ppartymenberdues")

public class PPartymenberDuesController {

    @Autowired
    private PPartymenberDuesService pPartymenberDuesService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymenberDues pPartymenberDues){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymenberDuesService.insert(pPartymenberDues);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymenberDues> pPartymenberDuesList = pPartymenberDuesService.selectByExample(new PPartymenberDuesExample());
        result.setSuccess(true);
        result.setData(pPartymenberDuesList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymenberDues> pPartymenberDuesList = pPartymenberDuesService.selectByExample(new PPartymenberDuesExample());
        PageInfo<PPartymenberDues> p=new PageInfo<PPartymenberDues>(pPartymenberDuesList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer dues_id){
        ResultUtil result = new ResultUtil();
        PPartymenberDuesExample example = new PPartymenberDuesExample();
        if(pPartymenberDuesService.deleteByPrimaryKey(dues_id)>0){
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
    public Map<String, Object> updateById(PPartymenberDues pPartymenberDues){
        ResultUtil result = new ResultUtil();
        if(pPartymenberDuesService.updateByPrimaryKey(pPartymenberDues)>0){
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
    public Map<String, Object> queryById(Integer dues_id){
        ResultUtil result = new ResultUtil();
        PPartymenberDues pPartymenberDues = pPartymenberDuesService.selectByPrimaryKey(dues_id);
        result.setSuccess(true);
        result.setData(pPartymenberDues);
        return result.getResult();
    }
}