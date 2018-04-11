package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgrade;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradeExample;
import cn.dlbdata.dangjian.admin.service.PAvantgradeService;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pavantgrade")

public class PAvantgradeController {

    @Autowired
    private PAvantgradeService pAvantgradeService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(String Messge13,
                                    String Messge14,
                                    String Messge15,
                                    Integer departmentid,
                                    Integer userid,Integer partmentid,Double itemscore){
        ResultUtil result = new ResultUtil();
        PAvantgrade pAvantgrade1 = new PAvantgrade();
        int callbackId1 = -1;
        int callbackId2 = -1;
        int callbackId3 = -1;

        if("".equals(Messge13)||Messge13!=null){
            pAvantgrade1.setCreatetime(new Date());
            pAvantgrade1.setDepartmentid(departmentid);
            pAvantgrade1.setMessage(Messge13);
            pAvantgrade1.setPartmentid(partmentid);
            pAvantgrade1.setUserid(userid);
            pAvantgrade1.setModuleId(13);
            pAvantgrade1.setProjectId(4);
            pAvantgrade1.setItemscore(5.0);
            pAvantgrade1.setYear(Calendar.getInstance().get(Calendar.YEAR));
            callbackId1 = pAvantgradeService.insert(pAvantgrade1);
        }
        if("".equals(Messge14)||Messge14!=null) {
            PAvantgrade pAvantgrade2 = new PAvantgrade();
            pAvantgrade2.setCreatetime(new Date());
            pAvantgrade2.setDepartmentid(departmentid);
            pAvantgrade2.setMessage(Messge14);
            pAvantgrade2.setPartmentid(partmentid);
            pAvantgrade2.setUserid(userid);
            pAvantgrade2.setModuleId(14);
            pAvantgrade2.setProjectId(4);
            pAvantgrade2.setItemscore(5.0);
            pAvantgrade2.setYear(Calendar.getInstance().get(Calendar.YEAR));
            callbackId2 = pAvantgradeService.insert(pAvantgrade2);
        }
        //pAvantgrade1.setApproveId();
        if("".equals(Messge15)||Messge15!=null) {
            PAvantgrade pAvantgrade3 = new PAvantgrade();
            pAvantgrade3.setMessage(Messge15);
            pAvantgrade3.setPartmentid(partmentid);
            pAvantgrade3.setUserid(userid);
            pAvantgrade3.setModuleId(15);
            pAvantgrade3.setDepartmentid(departmentid);
            pAvantgrade3.setProjectId(4);
            pAvantgrade3.setItemscore(itemscore);
            pAvantgrade3.setYear(Calendar.getInstance().get(Calendar.YEAR));
            pAvantgrade3.setCreatetime(new Date());
            callbackId3 = pAvantgradeService.insert(pAvantgrade3);
        }

        int[] a ={callbackId1,callbackId2,callbackId3};
        result.setData(a);
        result.setSuccess(true);
        return result.getResult();
    }


    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getListByUserId(Integer userId){
        ResultUtil result = new ResultUtil();
        PAvantgradeExample pA = new PAvantgradeExample();
        PAvantgradeExample.Criteria ct = pA.createCriteria();
        ct.andUseridEqualTo(userId);
        ct.andYearEqualTo(Calendar.getInstance().get(Calendar.YEAR));
        List<PAvantgrade> pAvantgradeList = pAvantgradeService.selectByExample(pA);
        result.setSuccess(true);
        result.setData(pAvantgradeList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PAvantgrade> pAvantgradeList = pAvantgradeService.selectByExample(new PAvantgradeExample());
        PageInfo<PAvantgrade> p=new PageInfo<PAvantgrade>(pAvantgradeList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PAvantgradeExample example = new PAvantgradeExample();
        if(pAvantgradeService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PAvantgrade pAvantgrade){
        ResultUtil result = new ResultUtil();
        if(pAvantgradeService.updateByPrimaryKey(pAvantgrade)>0){
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
        PAvantgrade pAvantgrade = pAvantgradeService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pAvantgrade);
        return result.getResult();
    }
}

