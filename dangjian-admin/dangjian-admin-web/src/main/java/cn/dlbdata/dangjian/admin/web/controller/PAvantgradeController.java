package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PAvantgrade;
import cn.dlbdata.dangjian.admin.dao.model.PAvantgradeExample;
import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.service.PAvantgradePictureService;
import cn.dlbdata.dangjian.admin.service.PAvantgradeService;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.admin.service.PScorePartyService;
import cn.dlbdata.dangjian.admin.web.VO.DjStringUtil;
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
    @Autowired
    private PPartymemberService pPartymemberService;

    @Autowired
    private PScorePartyService pScorePartyService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(String Messge13,
                                    String Messge14,
                                    String Messge15,
                                    Integer departmentid,
                                    Integer userid,Integer partmentid,Double itemscore,
                                    String pic13,String pic14,String pic15){
        ResultUtil result = new ResultUtil();
        PAvantgrade pAvantgrade1 = new PAvantgrade();
        int callbackId1 = -1;
        int callbackId2 = -1;
        int callbackId3 = -1;
        PPartymember leader = pPartymemberService.selectBranchByDepartmentId();
        int leaderId = leader.getId();

        if("".equals(Messge13)||Messge13!=null){
            pAvantgrade1.setCreatetime(new Date());
            pAvantgrade1.setDepartmentid(departmentid);
            pAvantgrade1.setMessage(Messge13);
            pAvantgrade1.setPartmentid(partmentid);
            pAvantgrade1.setUserid(userid);
            pAvantgrade1.setModuleId(13);
            pAvantgrade1.setTitle("获得荣誉");
            pAvantgrade1.setApproveId(leaderId);
            pAvantgrade1.setProjectId(4);
            pAvantgrade1.setStatus(0);
            pAvantgrade1.setItemscore(5.0);
            if(pic13!=null)pAvantgrade1.setMemo(pic13);
            pAvantgrade1.setYear(Calendar.getInstance().get(Calendar.YEAR));
            callbackId1 = pAvantgradeService.insertSelective(pAvantgrade1);

        }
        if("".equals(Messge14)||Messge14!=null) {
            PAvantgrade pAvantgrade2 = new PAvantgrade();
            pAvantgrade2.setCreatetime(new Date());
            pAvantgrade2.setDepartmentid(departmentid);
            pAvantgrade2.setMessage(Messge14);
            pAvantgrade2.setPartmentid(partmentid);
            pAvantgrade2.setUserid(userid);
            pAvantgrade2.setTitle("先锋表彰");
            pAvantgrade2.setApproveId(leaderId);
            pAvantgrade2.setModuleId(14);
            pAvantgrade2.setProjectId(4);
            pAvantgrade2.setItemscore(5.0);
            pAvantgrade2.setStatus(0);
            if(pic14!=null)pAvantgrade2.setMemo(pic14);
            pAvantgrade2.setYear(Calendar.getInstance().get(Calendar.YEAR));
            callbackId2 = pAvantgradeService.insertSelective(pAvantgrade2);

        }
        //pAvantgrade1.setApproveId();
        if("".equals(Messge15)||Messge15!=null) {
            PAvantgrade pAvantgrade3 = new PAvantgrade();
            pAvantgrade3.setMessage(Messge15);
            pAvantgrade3.setPartmentid(partmentid);
            pAvantgrade3.setUserid(userid);
            pAvantgrade3.setModuleId(15);
            pAvantgrade3.setDepartmentid(departmentid);
            pAvantgrade3.setTitle("先锋模范");
            pAvantgrade3.setProjectId(4);
            pAvantgrade3.setStatus(0);
            pAvantgrade3.setApproveId(leaderId);
            pAvantgrade3.setItemscore(itemscore);
            if(pic15!=null)pAvantgrade3.setMemo(pic15);
            pAvantgrade3.setYear(Calendar.getInstance().get(Calendar.YEAR));
            pAvantgrade3.setCreatetime(new Date());
            callbackId3 = pAvantgradeService.insertSelective(pAvantgrade3);
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

    @RequestMapping(value="/examineOK",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> examineOK(PAvantgrade pAvantgrade){
        ResultUtil result = new ResultUtil();
        pAvantgrade.setStatus(2);
        pAvantgrade.setApprovetime(new Date());
        if(pAvantgradeService.updateByPrimaryKeySelective(pAvantgrade)>0){

            PAvantgrade pAvantgrade1 = pAvantgradeService.selectByPrimaryKey(pAvantgrade.getId());
            //添加积分了要
            PScoreParty pScoreParty = new PScoreParty();

            PPartymember pPartymember = pPartymemberService.selectBranchByDepartmentId(pAvantgrade1.getDepartmentid());
            PPartymember bigLeader = pPartymemberService.selectBranchByDepartmentId();

            pScoreParty.setProjectId(pAvantgrade1.getProjectId());
            pScoreParty.setDetailId(pAvantgrade1.getModuleId());
            pScoreParty.setScore(pAvantgrade1.getItemscore());

            pScoreParty.setAdderId(pPartymember.getUserid());
            pScoreParty.setAddTime(pAvantgrade1.getApprovetime());
            pScoreParty.setAddId(pPartymember.getId());
            pScoreParty.setApprovedId(pAvantgrade1.getApproveId());

            pScoreParty.setYear(pAvantgrade1.getYear());
            pScoreParty.setScoreTime(pAvantgrade1.getApprovetime());
            pScoreParty.setAddTime(pAvantgrade1.getCreatetime());
            pScoreParty.setStatusCd("30");
            pScoreParty.setUserId(pPartymember.getUserid());
            pScoreParty.setValidYn("Y");
            int callbackId = pScorePartyService.updateScoreCustom(pScoreParty);
            if(callbackId>0){
                result.setSuccess(true);
                result.setMsg("添加成功");
                return result.getResult();
            }else{
                result.setSuccess(true);
                result.setMsg("已经获取积分，无需重复获取");
            }

        }else{
            result.setSuccess(false);
            result.setMsg("审批失败");
        }
        return result.getResult();
    }

    @RequestMapping(value="/examineNo",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> examineNo(PAvantgrade pAvantgrade){
        ResultUtil result = new ResultUtil();
        pAvantgrade.setStatus(3);
        pAvantgrade.setApprovetime(new Date());
        if(pAvantgradeService.updateByPrimaryKeySelective(pAvantgrade)>0){
            result.setSuccess(true);
            result.setMsg("已审批为不通过");
        }else{
            result.setSuccess(false);
            result.setMsg("审批失败");
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



