package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.*;
import cn.dlbdata.dangjian.common.util.DateUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/pstudy")

public class PStudyController {

    @Autowired
    private PStudyService pStudyService;

    @Autowired
    private PStudyPictureService pStudyPictureService;

    @Autowired
    private PScorePartyService pScorePartyService;
    @Autowired
    private PScoreDetailService pScoreDetailService;

    @Autowired
    private PPartymemberService pPartymemberService;

    @Autowired
    private PUserService pUserService;

    @Autowired
    private PDepartmentService pDepartmentService;

    @Autowired
    private PScoreProjectService pScoreProjectService;

    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(
            Long starttime,Long endtime,Integer projectid,Integer moduleid,String content,
            Integer createUserid,String picids,Integer departmentid,Integer roleid){
        ResultUtil result = new ResultUtil();

        if(starttime==null){
            result.setMsg("活动时间开始时间不能为空");
            result.setSuccess(false);
            return result.getResult();
        }

        if(endtime==null){
            result.setMsg("活动时间结束时间不能为空");
            result.setSuccess(false);
            return result.getResult();
        }

        PStudy pStudy = new PStudy();
        pStudy.setContent(content);
        pStudy.setCreateUserid(createUserid);
        pStudy.setProjectid(projectid);
        pStudy.setModuleid(moduleid);
        pStudy.setDepartmentid(departmentid);
        pStudy.setStatus(0);
        pStudy.setStarttime(new Date(starttime));
        pStudy.setEndtime(new Date(endtime));
        pStudy.setCreatetime(new Date());

        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria criteria =  pUserExample.createCriteria();
        criteria.andDepartmentidEqualTo(departmentid);
        criteria.andRoleidEqualTo(roleid);
        List<PUser> pUserList = pUserService.selectByExample(pUserExample);
        PUser leader = pUserList.get(0);
        pStudy.setApprovalid(leader.getUserid());

        int callbackId = pStudyService.insert(pStudy);
        if(picids !=null ){
            String[] picIds = picids.split(",");
            if(picIds.length!=0){
                Integer[] a = new Integer[picIds.length];
                for(int i=0;i<picIds.length;i++){
                    a[i]=Integer.parseInt(picIds[i]);
                }
                pStudyPictureService.insertList(a,callbackId);
            }
        }

        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }


    @RequestMapping(value="/pass",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> pass(Integer studyid,Integer userid){
        ResultUtil result = new ResultUtil();
        PUser pUser = pUserService.selectByPrimaryKey(userid);
        if(pUser.getRoleid()==4){
            result.setSuccess(false);
            result.setMsg("您无权审批");
        }else{
            PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);

            PStudyExample pStudyExample = new PStudyExample();
            PStudyExample.Criteria criteria =  pStudyExample.createCriteria();
            criteria.andStatusEqualTo(1);
            //获得积分
            PScoreParty pScoreParty = new PScoreParty();
            pScoreParty.setProjectId(pStudy.getDepartmentid());
            pScoreParty.setDetailId((pStudy.getModuleid()));
            pScoreParty.setAddId(pStudy.getCreateUserid());
            pScoreParty.setAdderId(pStudy.getCreateUserid());
            pScoreParty.setApprovedId(userid);
            pScoreParty.setScoreTime(new Date());
            pScoreParty.setAddTime(new Date());
            pScoreParty.setYear(Calendar.getInstance().get(Calendar.YEAR));
            pScoreParty.setValidYn("Y");
            pScoreParty.setStatusCd("30");
            //加的分数要找一下
            PScoreDetail pScoreDetail = pScoreDetailService.selectByPrimaryKey(pStudy.getModuleid());
            pScoreParty.setScore(pScoreDetail.getScore());
            //增加积分
            if(pScorePartyService.updateScoreCustom(pScoreParty)>0){
                //同意审核
                pStudyService.updateByExampleSelective(pStudy,pStudyExample);
                result.setSuccess(true);
                result.setMsg("审核成功，积分已发放");
            }else{
                result.setSuccess(false);
                result.setMsg("已经获取积分，无需重复获取");
            }
        }
        return result.getResult();
    }

    @RequestMapping(value="/getList",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PStudy> pStudyList = pStudyService.selectByExample(new PStudyExample());
        result.setSuccess(true);
        result.setData(pStudyList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PStudy> pStudyList = pStudyService.selectByExample(new PStudyExample());
        PageInfo<PStudy> p=new PageInfo<PStudy>(pStudyList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method=RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer studyid){
        ResultUtil result = new ResultUtil();
        PStudyExample example = new PStudyExample();
        if(pStudyService.deleteByPrimaryKey(studyid)>0){
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
    public Map<String, Object> updateById(PStudy pStudy){
        ResultUtil result = new ResultUtil();
        if(pStudyService.updateByPrimaryKey(pStudy)>0){
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
    public Map<String, Object> queryById(Integer studyid){
        ResultUtil result = new ResultUtil();
        PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);
        result.setSuccess(true);
        result.setData(pStudy);
        return result.getResult();
    }



    //支部党员信息(先锋评定）
    @RequestMapping(value="/getPartymemberByDepartmentid",method= RequestMethod.GET)
    @ResponseBody
    /*
    status:1 代表 等待审核 NULL 代表等待支部书记审核，2代表已通过
    * */
    public Map<String, Object> getPartymemberByDepartmentid(Integer departmentid,@RequestParam(required=false) Integer status){
        ResultUtil result = new ResultUtil();
        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(pPartymemberExample);

        List<JSONObject> list = new ArrayList<>();
        for (PPartymember pPartymember:pPartymemberList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(pPartymember));

            //根据用户ID 找审核没
            PStudyExample pA = new PStudyExample();
            PStudyExample.Criteria ct = pA.createCriteria();
            ct.andCreateUseridEqualTo(pPartymember.getUserid());
            Date startTime = DateUtil.getYearFirst(Calendar.getInstance().get(Calendar.YEAR));
            Date endTime = DateUtil.getYearLast(Calendar.getInstance().get(Calendar.YEAR));
            ct.andCreatetimeLessThanOrEqualTo(new Date());
            List<PStudy> pStudyList = pStudyService.selectByExample(pA);

            //NULL所有人的状态 1代表审核申请 2代表已审核
            if(status == null ){
                if(pStudyList.size()==0){
                    json.put("tempint", null);
                }else{

                    int temp = 0;

                    for (PStudy pStudy:pStudyList){
                        //2代表通过 3代表拒绝
                        if(pStudy.getStatus() == 2 || pStudy.getStatus() == 3 ){
                            temp = 1;
                        }
                    }
                    json.put("tempint", temp);
                }

                list.add(json);

            }else if(status==1 ||  status==0){

                if(pStudyList.size()!=0) {

                    int temp = 0;
                    for (PStudy pStudy : pStudyList) {
                        //2代表通过 3代表拒绝
                        if (pStudy.getStatus() == 2 || pStudy.getStatus() == 3) {
                            temp = 1;
                        }
                    }

                    if (temp == status) {
                        json.put("tempint", temp);
                        list.add(json);
                    }
                }
            }


        }
        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }
}