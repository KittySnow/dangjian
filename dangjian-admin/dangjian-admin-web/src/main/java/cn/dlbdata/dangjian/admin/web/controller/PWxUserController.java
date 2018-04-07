package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PWxUser;
import cn.dlbdata.dangjian.admin.dao.model.PWxUserExample;
import cn.dlbdata.dangjian.admin.service.PWxUserService;
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
@RequestMapping("/pwxuser")

public class PWxUserController {

    @Autowired
    private PWxUserService pWxUserService;


    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PWxUser pWxUser){
        ResultUtil result = new ResultUtil();
        int callbackId = pWxUserService.insert(pWxUser);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PWxUser> pWxUserList = pWxUserService.selectByExample(new PWxUserExample());
        result.setSuccess(true);
        result.setData(pWxUserList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PWxUser> pWxUserList = pWxUserService.selectByExample(new PWxUserExample());
        PageInfo<PWxUser> p=new PageInfo<PWxUser>(pWxUserList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PWxUserExample example = new PWxUserExample();
        if(pWxUserService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PWxUser pWxUser){
        ResultUtil result = new ResultUtil();
        if(pWxUserService.updateByPrimaryKey(pWxUser)>0){
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
        PWxUser pWxUser = pWxUserService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pWxUser);
        return result.getResult();
    }
}