package cn.dlbdata.dangjian.admin.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.api.client.util.ArrayMap;

import cn.dlbdata.dangjian.admin.dao.model.PPartymember;
import cn.dlbdata.dangjian.admin.dao.model.PPartymemberExample;
import cn.dlbdata.dangjian.admin.dao.model.PScoreParty;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProject;
import cn.dlbdata.dangjian.admin.dao.model.PScoreProjectExample;
import cn.dlbdata.dangjian.admin.dao.vo.PScorePartyVo;
import cn.dlbdata.dangjian.admin.service.PPartymemberService;
import cn.dlbdata.dangjian.admin.service.PScorePartyService;
import cn.dlbdata.dangjian.admin.service.PScoreProjectService;
import cn.dlbdata.dangjian.common.util.ResultUtil;

@Controller
@RequestMapping("/api/v1")
public class ApiController {
	 @Autowired
     private PPartymemberService pPartymemberService;
	 @Autowired
	 private PScorePartyService pScorePartyService;
     @Autowired
     private PScoreProjectService pScoreProjectService;
     
    /**
     * 支部党员信息
     * @param departmentid
     * @return
     */
    @RequestMapping(value="/selectPartymemberByDeptId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> selectPartymemberByDeptId(Integer departmentid){
        ResultUtil result = new ResultUtil();

        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectPartymemberByDeptId(departmentid);
        result.setSuccess(true);
        result.setData(pPartymemberList);
        return result.getResult();
    }
    
    
    /**
     * 根据用户id获取雷达图
     * @param userId
     * @param year
     * @return
     */
    @RequestMapping(value="/getRadarChartByUserId",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getRadarChartByUserId(Integer userId ,Integer year){
        ResultUtil result = new ResultUtil();
        List<PScoreParty> pScorePartyList = pScorePartyService.getProjectScoreByUserId(userId,year);

        //七个项目列表
        List<PScoreProject> pScoreProjectList = pScoreProjectService.selectByExample(new PScoreProjectExample());


        Map<Integer, Double> pScorePartyMap = new ArrayMap<>();
        for(int i=0;i<pScorePartyList.size();i++){
            PScoreParty p = pScorePartyList.get(i);
            pScorePartyMap.put(p.getProjectId(),p.getTypetotalscore());;
        }


        List<JSONObject> list = new ArrayList<>();

        for(int i=0;i<pScoreProjectList.size();i++){


            PScoreProject pScoreProject = pScoreProjectList.get(i);
            PScoreParty pScoreParty = new PScoreParty();
            pScoreParty.setScore(pScoreProject.getScore());
            pScoreParty.setId(pScoreProject.getId());
            pScoreParty.setProjectName(pScoreProject.getProjectName());


            if(pScorePartyMap.get(pScoreProject.getId())!=null){
                pScoreParty.setTotalScore(pScorePartyMap.get(pScoreProject.getId()));
            }else{
                pScoreParty.setTotalScore(0.0);
            }

            JSONObject json = JSON.parseObject(JSON.toJSONString(pScoreParty));
            list.add(json);
        }

        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }
    
    
    /**
     * 获取党员参加活动的积分明细
     * @param userId
     * @return
     */
    @RequestMapping(value="/getScoreAndActiveList",method= {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map<String, Object> getScoreAndActiveList(Integer userId){
    	ResultUtil result = new ResultUtil();
    	if(userId == null ) {
    		result.setMsg("查询失败！！！");
    		return result.getResult();
    	}
    	List<PScorePartyVo> list = pScorePartyService.getScoreAndActiveList(userId);
    	if(list == null || list.size() == 0) {
    		result.setMsg("查询为空，没有相关的信息");
    		return result.getResult();
    	}
    	result.setData(list);
    	return result.getResult();
    }

}
