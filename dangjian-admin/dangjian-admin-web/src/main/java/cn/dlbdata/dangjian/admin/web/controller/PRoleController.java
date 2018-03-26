package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PRole;
import cn.dlbdata.dangjian.admin.dao.model.PRoleFeature;
import cn.dlbdata.dangjian.admin.service.PRoleFeatureService;
import cn.dlbdata.dangjian.admin.service.PRoleService;
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
@RequestMapping("/prole")
public class PRoleController{

    @Autowired
    private PRoleService pRoleService;

    @Autowired
    private PRoleFeatureService pRoleFeatureService;

    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PRole pRole){
        ResultUtil result = new ResultUtil();
        int callbackId = pRoleService.insert(pRole);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(){
        ResultUtil result = new ResultUtil();
        List<PRole> pRoleList = pRoleService.selectByExample("%"+""+"%");
        result.setSuccess(true);
        result.setData(pRoleList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize,String searchText){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        if(searchText == null){
            searchText ="";
        }
        List<PRole> pRoleList = pRoleService.selectByExample("%"+searchText+"%");
        PageInfo<PRole> p=new PageInfo<PRole>(pRoleList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }


    @RequestMapping(value="/deleteById",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> deleteById(Integer roleid){
        ResultUtil result = new ResultUtil();
        if(pRoleService.deleteByPrimaryKey(roleid)>0){
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
    public Map<String, Object> updateById(PRole pRole){
        ResultUtil result = new ResultUtil();
        if(pRoleService.updateByPrimaryKey(pRole)>0){
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
    public Map<String, Object> queryById(Integer roleId){
        ResultUtil result = new ResultUtil();
        PRole pRole = pRoleService.selectByPrimaryKey(roleId);
        result.setSuccess(true);
        result.setData(pRole);
        return result.getResult();
    }


    @RequestMapping(value="/insertFeature",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> insertFeature(Integer roleid,String featureids) {
        ResultUtil result = new ResultUtil();
        String[] featureIdsArr = featureids.split(",");
        List<PRoleFeature> list = new ArrayList<PRoleFeature>();
        for (int i = 0; i < featureIdsArr.length; i++) {
            String s = featureIdsArr[i];
            PRoleFeature pr = new PRoleFeature();
            pr.setFeatureid(Integer.valueOf(s));
            pr.setRoleid(roleid);
            list.add(pr);
        }
        pRoleFeatureService.deleteByRoleId(roleid);
        if(pRoleFeatureService.insert(list)>0){
            result.setSuccess(true);
            result.setMsg("修改成功");
        }else{
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value="/selectFeatureByRoid",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectFeatureByRoid(Integer roleid) {
        ResultUtil result = new ResultUtil();
        List<PRoleFeature> list = pRoleFeatureService.selectByRoid(roleid);

        result.setSuccess(true);
        result.setData(list);
        result.setMsg("修改成功");

        return result.getResult();

    }
}