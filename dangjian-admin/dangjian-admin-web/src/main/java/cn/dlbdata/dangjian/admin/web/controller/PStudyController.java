package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.*;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pstudy")

public class PStudyController {

    @Autowired
    private PStudyService pStudyService;

    @Autowired
    private PUserService pUserService;

    @Autowired
    private PStudyPictureService pStudyPictureService;

    @Autowired
    private PScorePartyService pScorePartyService;
    @Autowired
    private PScoreDetailService pScoreDetailService;

    @Autowired
    private PScoreProjectService pScoreProjectService;

    @RequestMapping(value="/save",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PStudy pStudy,Integer[] picIds,Integer departmentid,Integer roleid){
        ResultUtil result = new ResultUtil();
        pStudy.setCreatetime(new Date());

        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria criteria =  pUserExample.createCriteria();
        criteria.andDepartmentidEqualTo(departmentid);
        criteria.andRoleidEqualTo(roleid);
        List<PUser> pUserList = pUserService.selectByExample(pUserExample);
        PUser leader = pUserList.get(0);
        pStudy.setApprovalid(leader.getUserid());

        int callbackId = pStudyService.insert(pStudy);

        if(picIds.length!=0){
            for(int i=0;i<picIds.length;i++){
                PStudyPicture pStudyPicture = new PStudyPicture();
                pStudyPicture.setStudyId(callbackId);
                pStudyPicture.setPictureId(picIds[i]);
                pStudyPictureService.insert(pStudyPicture);
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

            //获得积分了要
            PScoreParty pScoreParty = new PScoreParty();
            pScoreParty.setProjectId(pStudy.getDepartmentid());
            pScoreParty.setDetailId((pStudy.getModuleid()));
            pScoreParty.setAddId(pStudy.getCreateUserid());
            pScoreParty.setAdderId(pStudy.getCreateUserid());
            pScoreParty.setApprovedId(userid);
            pScoreParty.setScoreTime(new Date());
            pScoreParty.setAddTime(new Date());
            pScoreParty.setYear(new Date().getYear());
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
}