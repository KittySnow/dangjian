package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ppartymember")

public class PPartymemberController {

    @Autowired
    private PPartymemberService pPartymemberService;

    @Autowired
    private PUserService pUserService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymember pPartymember){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymemberService.insert(pPartymember);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(new PPartymemberExample());
        result.setSuccess(true);
        result.setData(pPartymemberList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(new PPartymemberExample());
        PageInfo<PPartymember> p=new PageInfo<PPartymember>(pPartymemberList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PPartymemberExample example = new PPartymemberExample();
        if(pPartymemberService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PPartymember pPartymember){
        ResultUtil result = new ResultUtil();
        if(pPartymemberService.updateByPrimaryKey(pPartymember)>0){
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
        PPartymember pPartymember = pPartymemberService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pPartymember);
        return result.getResult();
    }

    @RequestMapping(value="/queryByUserId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByUserId(Integer userid){
        ResultUtil result = new ResultUtil();
        PPartymember pPartymember = pPartymemberService.selectByUserId(userid);
        if(pPartymember!=null){
            result.setSuccess(true);
            result.setData(pPartymember);
        }else{
            result.setSuccess(false);
            result.setMsg("没有找到对应的党员");
        }
        return result.getResult();
    }

    //支部党员信息
    @RequestMapping(value="/queryByDepartmentId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByDepartmentId(Integer departmentid){
        ResultUtil result = new ResultUtil();

        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(pPartymemberExample);

        result.setSuccess(true);
        result.setData(pPartymemberList);
        return result.getResult();
    }
}
