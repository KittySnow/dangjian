package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.PScoreDetailService;
import cn.dlbdata.dangjian.admin.service.PScorePartyService;
import cn.dlbdata.dangjian.admin.service.PScoreProjectService;
import cn.dlbdata.dangjian.common.util.HttpResult;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.api.client.util.ArrayMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/pscoreparty")

public class PScorePartyController{

    @Autowired
    private PScorePartyService pScorePartyService;

    @Autowired
    private PScoreDetailService pScoreDetailService;
    @Autowired
    private PScoreProjectService pScoreProjectService;


    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        int callbackId = pScorePartyService.insert(pScoreParty);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PScoreParty> pScorePartyList = pScorePartyService.selectByExample(new PScorePartyExample());
        result.setSuccess(true);
        result.setData(pScorePartyList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PScoreParty> pScorePartyList = pScorePartyService.selectByExample(new PScorePartyExample());
        PageInfo<PScoreParty> p=new PageInfo<PScoreParty>(pScorePartyList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= {RequestMethod.DELETE,RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PScorePartyExample example = new PScorePartyExample();
        if(pScorePartyService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if(pScorePartyService.updateByPrimaryKey(pScoreParty)>0){
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
        PScoreParty pScoreParty = pScorePartyService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pScoreParty);
        return result.getResult();
    }


    @RequestMapping(value="/queryByUserId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByUserId(Integer userid,int year){
        ResultUtil result = new ResultUtil();
        PScorePartyExample pScorePartyExample = new PScorePartyExample();
        PScorePartyExample.Criteria ct = pScorePartyExample.createCriteria();
        ct.andUserIdEqualTo(userid);
        ct.andYearEqualTo(year);
        List<PScoreParty> pScorePartyList = pScorePartyService.selectByExample(pScorePartyExample);
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(new PScoreDetailExample());


        Map<Integer,String> detailIndo = new ArrayMap<Integer, String>();
        for (int i = 0; i < pScoreDetailList.size(); i++) {
            PScoreDetail pScoreDetail = pScoreDetailList.get(i);
            detailIndo.put(pScoreDetail.getId(),pScoreDetail.getTitle());
        }
        for (int i = 0; i < pScorePartyList.size(); i++) {
            PScoreParty pScoreParty = pScorePartyList.get(i);
            pScoreParty.setDetailTitle(detailIndo.get(pScoreParty.getDetailId()));
        }
        result.setSuccess(true);
        result.setData(pScorePartyList);
        return result.getResult();
    }

    /**
     * 扫码获取积分
     *
     * @author July july_sky@foxmail.com
     * @date 2018-04-01 09:09:22
     * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
     * @version 1.0
     * @param pScoreParty
     * @return
     */
    @RequestMapping(value="/scanCode",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateScanCode(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if (pScoreParty.getDetailId() == null || pScoreParty.getUserId() == null || pScoreParty.getAdderId() == null){
            result.setSuccess(false);
            result.setMsg("请求参数不完整");
            return result.getResult();
        }
        if(pScorePartyService.updateScanCode(pScoreParty)>0){
            result.setSuccess(true);
            result.setMsg("添加成功");
            return result.getResult();
        }
        result.setSuccess(false);
        result.setMsg("已经获取积分，无需重复获取");
        return result.getResult();
    }

    @RequestMapping(value="/scoreCustom",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateScoreCustom(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if (pScoreParty.getDetailId() == null || pScoreParty.getUserId() == null || pScoreParty.getAdderId() == null || pScoreParty.getScore() == null || pScoreParty.getScore() <= 0){
            result.setSuccess(false);
            result.setMsg("请求参数不完整");
            return result.getResult();
        }
        if(pScorePartyService.updateScoreCustom(pScoreParty)>0){
            result.setSuccess(true);
            result.setMsg("添加成功");
            return result.getResult();
        }
        result.setSuccess(false);
        result.setMsg("已经获取积分，无需重复获取");
        return result.getResult();
    }

    @RequestMapping(value="/scoreClean",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateSscoreClean(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if (pScoreParty.getDetailId() == null || pScoreParty.getUserId() == null || pScoreParty.getAdderId() == null){
            result.setSuccess(false);
            result.setMsg("请求参数不完整");
            return result.getResult();
        }
        if(pScorePartyService.updateSscoreClean(pScoreParty)>0){
            result.setSuccess(true);
            result.setMsg("扣除成功");
            return result.getResult();
        }
        result.setSuccess(false);
        result.setMsg("已无可扣除积分");
        return result.getResult();
    }

    @RequestMapping(value="/updateAudit",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> updateAudit(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if (pScoreParty.getId() == null || pScoreParty.getApprovedId()==null || pScoreParty.getStatusCd() == null){
            result.setSuccess(false);
            result.setMsg("请求参数不完整");
            return result.getResult();
        }
        if (!"30".equals(pScoreParty.getStatusCd())) {
            pScoreParty.setStatusCd("91");
        }
        if(pScorePartyService.updateAudit(pScoreParty)>0){
            result.setSuccess(true);
            result.setMsg("审核成功");
            return result.getResult();
        }
        result.setSuccess(false);
        result.setMsg("已审核，无需重复审核");
        return result.getResult();
    }



    @RequestMapping(value="/getRole",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getRole(PScoreParty pScoreParty){
        ResultUtil result = new ResultUtil();
        if (pScoreParty.getId() == null || pScoreParty.getApprovedId()==null || pScoreParty.getStatusCd() == null){
            result.setSuccess(false);
            result.setMsg("请求参数不完整");
            return result.getResult();
        }
        if (!"30".equals(pScoreParty.getStatusCd())) {
            pScoreParty.setStatusCd("91");
        }
        if(pScorePartyService.updateAudit(pScoreParty)>0){
            result.setSuccess(true);
            result.setMsg("审核成功");
            return result.getResult();
        }
        result.setSuccess(false);
        result.setMsg("已审核，无需重复审核");
        return result.getResult();
    }


    @RequestMapping(value="/getProjectScoreByUserId",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getProjectScoreByUserId(Integer userId ,Integer year){
        ResultUtil result = new ResultUtil();
        List<PScoreParty> pScorePartyList =pScorePartyService.getProjectScoreByUserId(userId,year);
        List<PScoreProject> pScoreProjectList = pScoreProjectService.selectByExample(new PScoreProjectExample());


        Map<Integer, Double> pScorePartyMap = new ArrayMap<>();
        for(int i=0;i<pScorePartyList.size();i++){
            PScoreParty p = pScorePartyList.get(i);
            pScorePartyMap.put(p.getProjectId(),p.getTypetotalscore());;
        }

        List<PScoreParty> pScoreList =  new ArrayList<>();

        for(int i=0;i<pScoreProjectList.size();i++){
            PScoreParty pScoreParty = new PScoreParty();
            PScoreProject pScoreProject = pScoreProjectList.get(i);
            pScoreParty.setScore(pScoreProject.getScore());
            pScoreParty.setId(pScoreProject.getId());
            pScoreParty.setProjectName(pScoreProject.getProjectName());
            if(pScorePartyMap.get(pScoreProject.getId())!=null){
                pScoreParty.setTotalScore(pScorePartyMap.get(pScoreProject.getId()));
            }else{
                pScoreParty.setTotalScore(0.0);
            }
            pScoreList.add(pScoreParty);
        }

        result.setSuccess(true);
        result.setData(pScoreList);
        return result.getResult();
    }


    //查找某人的分数
    @RequestMapping(value="/getSumScoreByUserId",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getSumScoreByUserId(Integer userId ,Integer year){
        ResultUtil result = new ResultUtil();
        Double dp = pScorePartyService.getSumScoreByUserId(userId,year);
        result.setSuccess(true);
        result.setData(dp);
        return result.getResult();
    }


}