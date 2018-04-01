package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PActive;
import cn.dlbdata.dangjian.admin.dao.model.PActiveExample;
import cn.dlbdata.dangjian.admin.dao.model.PActiveParticipate;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.service.PActiveParticipateService;
import cn.dlbdata.dangjian.admin.service.PActiveService;
import cn.dlbdata.dangjian.admin.service.PScoreDetailService;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.admin.service.impl.PActiveParticipateServiceImpl;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @packageName PActiveController
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 活动接口
 */
@Controller
@RequestMapping("/active")
public class PActiveController {
    private static Logger _log = LoggerFactory.getLogger(PActiveController.class);

    @Autowired
    private PUserService pUserService;
    @Autowired
    private PActiveService pActiveService;
    @Autowired
    private PActiveParticipateService activeParticipateService;
    @Autowired
    private PScoreDetailService scoreDetailService;

    /**
     * 创建活动
     * @return
     */
    @RequestMapping(value="/create",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(Long startTime,Long endTime,Integer activeType,Integer activeStatus,
                                      String activeName,String activePace,String activeCreatePeople,
                                      String activePrincipalPeople,String activeContext) {
        ResultUtil result = new ResultUtil();
        if(startTime==null){
            result.setMsg("活动时间开始时间不能为空");
            result.setSuccess(false);
            return result.getResult();
        }
        if(activeType==null){
            result.setMsg("请传入活动类型");
            result.setSuccess(false);
            return result.getResult();
        }
        PScoreDetail detail = scoreDetailService.selectByPrimaryKey(activeType);
        if(detail==null){
            result.setMsg("活动类型找不到！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActive active = new PActive();
        active.setStartTime(new Date(startTime));
        if(endTime!=null){
            active.setEndTime(new Date(endTime));
        }
        active.setActiveType(detail.getId());
        active.setActiveProjectId(detail.getProjectId());
        active.setActiveStatus(activeStatus);
        active.setActiveName(activeName);
        active.setActivePace(activePace);
        active.setActiveCreatePeople(activeCreatePeople);
        active.setActivePrincipalPeople(activePrincipalPeople);
        active.setActiveContext(activeContext);
        active.setCreateTime(new Date());
        Integer id = pActiveService.insert(active);
        result.setData(id);
        result.setSuccess(true);
        result.setMsg("创建成功！");
        return result.getResult();
    }

    /**
     * 报名活动
     * @param activeId
     * @param userId
     * @return
     */
    @RequestMapping(value="/participate",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> participate(Integer activeId,Integer userId){
        ResultUtil result = new ResultUtil();
        if(pActiveService.selectByPrimaryKey(activeId)==null){
            result.setMsg("活动不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        if(pUserService.selectByPrimaryKey(userId)==null){
            result.setMsg("用户不存在！");
            result.setSuccess(false);
            return result.getResult();
        }
        PActiveParticipate participate = new PActiveParticipate();
        participate.setCreateTime(new Date());
        participate.setUserId(userId);
        participate.setActiveId(activeId);
        participate.setStatus(0);
        activeParticipateService.insert(participate);

        result.setMsg("报名完成");
        result.setSuccess(true);
        return result.getResult();
    }

    /**
     * 查询正在进行的活动，或者已经开始的活动
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getRunningActive",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getRunningActive(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        example.createCriteria().andActiveStatusEqualTo(1)
        .andStartTimeLessThanOrEqualTo(new Date());
        PageHelper.startPage(pageNum, pageSize);
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        PageInfo<PActive> pageInfo=new PageInfo<PActive>(pActiveList);
        result.setSuccess(true);
        result.setData(pageInfo);
        return result.getResult();
    }
    /**
     * 查询正在进行的活动，或者已经开始的活动
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/getParticipateActive",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getParticipateActive(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        example.createCriteria().andActiveStatusEqualTo(1)
        .andStartTimeGreaterThan(new Date());
        PageHelper.startPage(pageNum, pageSize);
        List<PActive> pActiveList = pActiveService.selectByExample(example);
        PageInfo<PActive> pageInfo=new PageInfo<PActive>(pActiveList);
        result.setSuccess(true);
        result.setData(pageInfo);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize);
        List<PActive> pActiveList = pActiveService.selectByExample(new PActiveExample());
        PageInfo<PActive> p=new PageInfo<PActive>(pActiveList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer activeid){
        ResultUtil result = new ResultUtil();
        PActiveExample example = new PActiveExample();
        if(pActiveService.deleteByPrimaryKey(activeid)>0){
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
    public Map<String, Object> updateById(PActive pActive){
        ResultUtil result = new ResultUtil();
        if(pActiveService.updateByPrimaryKey(pActive)>0){
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
    public Map<String, Object> queryById(Integer activeid){
        ResultUtil result = new ResultUtil();
        PActive pActive = pActiveService.selectByPrimaryKey(activeid);
        result.setSuccess(true);
        result.setData(pActive);
        return result.getResult();
    }
}