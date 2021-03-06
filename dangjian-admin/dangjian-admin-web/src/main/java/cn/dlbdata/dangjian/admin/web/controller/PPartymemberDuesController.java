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

import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDues;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberDuesExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberDuesService;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.common.util.ResultUtil;

@Controller
@RequestMapping("/ppartymemberdues")

public class PPartymemberDuesController {

    @Autowired
    private PPartymemberDuesService pPartymemberDuesService;

    @Autowired
    private PPartymemberService pPartymemberService;

    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymemberDues pPartymemberDues){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymemberDuesService.insert(pPartymemberDues);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymemberDues> pPartymemberDuesList = pPartymemberDuesService.selectByExample(new PPartymemberDuesExample());
        result.setSuccess(true);
        result.setData(pPartymemberDuesList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymemberDues> pPartymemberDuesList = pPartymemberDuesService.selectByExample(new PPartymemberDuesExample());
        PageInfo<PPartymemberDues> p=new PageInfo<PPartymemberDues>(pPartymemberDuesList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer dues_id){
        ResultUtil result = new ResultUtil();
        PPartymemberDuesExample example = new PPartymemberDuesExample();
        if(pPartymemberDuesService.deleteByPrimaryKey(dues_id)>0){
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
    public Map<String, Object> updateById(PPartymemberDues pPartymemberDues){
        ResultUtil result = new ResultUtil();
        if(pPartymemberDuesService.updateByPrimaryKey(pPartymemberDues)>0){
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
        PPartymemberDues pPartymemberDues = pPartymemberDuesService.selectByPrimaryKey(dues_id);
        result.setSuccess(true);
        result.setData(pPartymemberDues);
        return result.getResult();
    }

    @RequestMapping(value="/queryByUserId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByUserId(Integer userid){
        ResultUtil result = new ResultUtil();
        if(userid==null){
            result.setSuccess(false);
            result.setMsg("请传userid");
        }else{
            //根据用户ID 找到党员ID
            PPartymember pPartymember = pPartymemberService.selectByUserId(userid);

            //根据党员ID 找到记录
            PPartymemberDuesExample pPartymemberDuesExample = new PPartymemberDuesExample();
            PPartymemberDuesExample.Criteria criteria =  pPartymemberDuesExample.createCriteria();
            criteria.andPartyMemberIdEqualTo(pPartymember.getId());
            List<PPartymemberDues> pPartymemberDuesList = pPartymemberDuesService.selectByExample(pPartymemberDuesExample);
            result.setSuccess(true);
            result.setData(pPartymemberDuesList);
        }
        return result.getResult();
    }
}