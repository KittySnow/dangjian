package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PScoreProject;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProjectExample;
import cn.dlbdata.dangjian.admin.service.PScoreProjectService;
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
@RequestMapping("/pscoreproject")

public class PScoreProjectController{

    @Autowired
    private PScoreProjectService pScoreProjectService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PScoreProject pScoreProject){
        ResultUtil result = new ResultUtil();
        int callbackId = pScoreProjectService.insert(pScoreProject);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PScoreProject> pScoreProjectList = pScoreProjectService.selectByExample(new PScoreProjectExample());
        result.setSuccess(true);
        result.setData(pScoreProjectList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PScoreProject> pScoreProjectList = pScoreProjectService.selectByExample(new PScoreProjectExample());
        PageInfo<PScoreProject> p=new PageInfo<PScoreProject>(pScoreProjectList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= {RequestMethod.DELETE,RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PScoreProjectExample example = new PScoreProjectExample();
        if(pScoreProjectService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PScoreProject pScoreProject){
        ResultUtil result = new ResultUtil();
        if(pScoreProjectService.updateByPrimaryKey(pScoreProject)>0){
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
        PScoreProject pScoreProject = pScoreProjectService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pScoreProject);
        return result.getResult();
    }

    @RequestMapping(value="/listByUser",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> listByUser(PScoreProject pScoreProject){
        ResultUtil result = new ResultUtil();
        if (pScoreProject == null || pScoreProject.getUserId() == null) {
            result.setSuccess(false);
            result.setMsg("党员不能为空");
        }
        PageHelper.startPage(1, 200,true);
        List<PScoreProject> pScoreProjectList = pScoreProjectService.selectByUserExample(pScoreProject);
        PageInfo<PScoreProject> p=new PageInfo<PScoreProject>(pScoreProjectList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }
}