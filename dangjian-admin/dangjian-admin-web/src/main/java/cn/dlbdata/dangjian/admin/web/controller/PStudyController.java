package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.*;
import cn.dlbdata.dangjian.common.util.DateUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/pstudy")

public class PStudyController {
	private static Logger logger = LoggerFactory.getLogger(PStudyController.class);
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



        PScoreParty pScoreParty = new PScoreParty();
        pScoreParty.setDetailId(moduleid);
        pScoreParty.setUserId(createUserid);

        PScoreParty pScoreDetail = pScorePartyService.isInsertRights(pScoreParty);

        if(pScoreDetail==null){
            result.setMsg("您该项目提交次数已达最大值");
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
        if(picids !=null && !picids.isEmpty()){
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
    
    @RequestMapping(value="/reSubmit",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> reSubmit(Integer studyid,
            Long starttime,Long endtime,Integer projectid,Integer moduleid,String content,
            Integer createUserid,String picids,Integer departmentid,Integer roleid){
        logger.info("reSubmit--studyid->"+studyid+" picids->"+picids + " roleid->"+roleid);
        
        ResultUtil result = new ResultUtil();

        if(studyid==null || studyid == 0){
            result.setMsg("活动ID不存在");
            result.setSuccess(false);
            return result.getResult();
        }

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

        PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);
        if(pStudy == null)
        {
        		result.setMsg("活动不存在或已删除");
            result.setSuccess(false);
            return result.getResult(); 
        }
        
        //删除原来的图片
        PStudyPictureExample picExample = new PStudyPictureExample();
        picExample.createCriteria().andStudyIdEqualTo(studyid);
        pStudyPictureService.deleteByExample(picExample);
        
        //更新信息
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

        pStudyService.updateByPrimaryKeySelective(pStudy);
        if(picids !=null && !picids.isEmpty()){
            String[] picIds = picids.split(",");
            if(picIds.length!=0){
                Integer[] a = new Integer[picIds.length];
                for(int i=0;i<picIds.length;i++){
                    a[i]=Integer.parseInt(picIds[i]);
                }
                pStudyPictureService.insertList(a,studyid);
            }
        }

        result.setData(studyid);
        result.setSuccess(true);
        return result.getResult();
    }


    @RequestMapping(value="/pass",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> pass(Integer studyid,Integer userid){
        ResultUtil result = new ResultUtil();
        PUser pUser = pUserService.selectByPrimaryKey(userid);
        if(pUser.getRoleid()==4){
            result.setSuccess(true);
            result.setMsg("您无权审批");
        }else{
            PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);

            PStudyExample pStudyExample = new PStudyExample();
            PStudyExample.Criteria criteria =  pStudyExample.createCriteria();
            criteria.andStatusEqualTo(1);
            //获得积分
            PScoreParty pScoreParty = new PScoreParty();
            pScoreParty.setProjectId(pStudy.getProjectid());
            pScoreParty.setDetailId((pStudy.getModuleid()));

            PScoreDetail pScoreDetail = pScoreDetailService.selectByPrimaryKey(pStudy.getModuleid());
            pScoreParty.setScore(pScoreDetail.getScore());

            pScoreParty.setAdderId(pStudy.getCreateUserid());

            pScoreParty.setAddId(userid);
            pScoreParty.setAddTime(new Date());

            pScoreParty.setApprovedId(userid);

            pScoreParty.setYear(Calendar.getInstance().get(Calendar.YEAR));
            pScoreParty.setScoreTime(new Date());

            pScoreParty.setUserId(pStudy.getCreateUserid());
//            审核的时候往学习表里面插入数据
            pScoreParty.setValidYn("Y");
            pScoreParty.setStatusCd("30");
            pScoreParty.setRecordId(studyid);
            pScoreParty.setRecordType(2);
            //加的分数要找一下

            //增加积分
            if(pScorePartyService.updateScoreCustom(pScoreParty)>0){
                //同意审核
                pStudy.setStatus(2);
                pStudyService.updateByPrimaryKey(pStudy);
                result.setSuccess(true);
                result.setMsg("审核成功，积分已发放");
            }else{
                //pStudy.setStatus(3);拒绝
                result.setSuccess(false);
                result.setMsg("已经获取积分，无需重复获取");
            }
        }
        return result.getResult();
    }



    @RequestMapping(value="/reject",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> reject(Integer studyid,Integer userid){
        ResultUtil result = new ResultUtil();
        PUser pUser = pUserService.selectByPrimaryKey(userid);
        if(pUser.getRoleid()==4){
            result.setSuccess(true);
            result.setMsg("您无权审批");
        }else{
            PStudy pStudy = pStudyService.selectByPrimaryKey(studyid);

            PStudyExample pStudyExample = new PStudyExample();
            PStudyExample.Criteria criteria =  pStudyExample.createCriteria();
            criteria.andStatusEqualTo(1);

            pStudy.setStatus(3);
            pStudyService.updateByPrimaryKey(pStudy);

            result.setSuccess(true);
            result.setMsg("已驳回该审批");

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
        PStudyPictureExample pA = new PStudyPictureExample();
        PStudyPictureExample.Criteria ct = pA.createCriteria();
        ct.andStudyIdEqualTo(studyid);
        List<PStudyPicture> pStudyPictureList = pStudyPictureService.selectByExample(pA);
        List<JSONObject> list = new ArrayList<>();
        JSONObject json = JSON.parseObject(JSON.toJSONString(pStudy));
        PPartymember pPartymember = pPartymemberService.selectByUserId(pStudy.getCreateUserid());

        PPartymember leader = pPartymemberService.selectBranchByDepartmentId(pStudy.getDepartmentid());

        PPartymember Approval = pPartymemberService.selectByUserId(pStudy.getApprovalid());

        json.put("approvalname",pPartymember.getName());
        json.put("partyname",pPartymember.getName());
        json.put("pictures", pStudyPictureList);

        json.put("branch", leader.getName());

        list.add(json);
        result.setSuccess(true);
        result.setData(json);
        return result.getResult();
    }

    //根据用户ID 和 分类查找相应列表
    @RequestMapping(value="/queryByUserId",method=RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByUserId(Integer UserId,Integer activeType){
        ResultUtil result = new ResultUtil();
        PStudyExample pA = new PStudyExample();
        PStudyExample.Criteria ct = pA.createCriteria();
        Date startTime = DateUtil.getYearFirst(Calendar.getInstance().get(Calendar.YEAR));
        Date endTime = DateUtil.getYearLast(Calendar.getInstance().get(Calendar.YEAR));
        ct.andCreateUseridEqualTo(UserId);
        ct.andModuleidEqualTo(activeType);
        List<PStudy> pStudyList = pStudyService.selectByExample(pA);


        List<JSONObject> list = new ArrayList<>();

        list = this.listetPartName(list,pStudyList);

        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }

    public List<JSONObject> listetPartName(List<JSONObject> list,List<PStudy> pStudyList){
        if(pStudyList!=null){
            if(pStudyList.size()!=0){
                for (PStudy pStudy:pStudyList){

                    JSONObject json = JSON.parseObject(JSON.toJSONString(pStudy));

                    PPartymember pPartymember = pPartymemberService.selectByUserId(pStudy.getCreateUserid());
                    json.put("partyname",pPartymember.getName());

                    list.add(json);
                }
            }
        }
        return list;
    }


    //支部党员信息(先锋评定）
    @RequestMapping(value="/getPartymemberByDepartmentid",method= RequestMethod.GET)
    @ResponseBody
    /*
    status:1 代表 等待审核 NULL 代表等待支部书记审核，2代表已通过
    * */
    public Map<String, Object> getPartymemberByDepartmentid(Integer departmentid,@RequestParam(required=false) Integer status,Integer activeType){


        ResultUtil result = new ResultUtil();

        //
        PStudyExample pA = new PStudyExample();
        PStudyExample.Criteria ct = pA.createCriteria();
        Date startTime = DateUtil.getYearFirst(Calendar.getInstance().get(Calendar.YEAR));
        Date endTime = DateUtil.getYearLast(Calendar.getInstance().get(Calendar.YEAR));
        ct.andCreatetimeLessThanOrEqualTo(new Date());
        ct.andModuleidEqualTo(activeType);
        ct.andDepartmentidEqualTo(departmentid);
        List<PStudy> pStudyList = pStudyService.selectByExample(pA);

        List<JSONObject> list = new ArrayList<>();

        list = this.listetPartName(list,pStudyList);


        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }
}