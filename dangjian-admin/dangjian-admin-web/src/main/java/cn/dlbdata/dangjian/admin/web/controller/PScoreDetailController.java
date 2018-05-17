package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.PScoreDetail;
import cn.dlbdata.dangjian.admin.dao.model.PScoreDetailExample;
import cn.dlbdata.dangjian.admin.service.PScoreDetailService;
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
@RequestMapping("/pscoredetail")

public class PScoreDetailController {

    @Autowired
    private PScoreDetailService pScoreDetailService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PScoreDetail pScoreDetail) {
        ResultUtil result = new ResultUtil();
        int callbackId = pScoreDetailService.insert(pScoreDetail);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(new PScoreDetailExample());
        result.setSuccess(true);
        result.setData(pScoreDetailList);
        return result.getResult();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize, true);
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(new PScoreDetailExample());
        PageInfo<PScoreDetail> p = new PageInfo<PScoreDetail>(pScoreDetailList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value = "/deleteById", method = {RequestMethod.DELETE, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> deleteById(Integer id) {
        ResultUtil result = new ResultUtil();
        PScoreDetailExample example = new PScoreDetailExample();
        if (pScoreDetailService.deleteByPrimaryKey(id) > 0) {
            result.setSuccess(true);
            result.setMsg("删除成功");
        } else {
            result.setMsg("删除失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }


    @RequestMapping(value = "/updateById", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateById(PScoreDetail pScoreDetail) {
        ResultUtil result = new ResultUtil();
        if (pScoreDetailService.updateByPrimaryKey(pScoreDetail) > 0) {
            result.setSuccess(true);
            result.setMsg("修改成功");
        } else {
            result.setSuccess(false);
            result.setMsg("修改失败");
        }
        return result.getResult();
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById(Integer id) {
        ResultUtil result = new ResultUtil();
        PScoreDetail pScoreDetail = pScoreDetailService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pScoreDetail);
        return result.getResult();
    }

    @RequestMapping(value = "/queryByStudyList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByStudyList() {
        ResultUtil result = new ResultUtil();
        PScoreDetailExample pScoreDetailExample = new PScoreDetailExample();
        PScoreDetailExample.Criteria criteria = pScoreDetailExample.createCriteria();
        criteria.andTitleLike("%自主%");
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(pScoreDetailExample);
        result.setSuccess(true);
        result.setData(pScoreDetailList);
        return result.getResult();
    }

    @RequestMapping(value = "/queryByJoinList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByJoinList() {
        ResultUtil result = new ResultUtil();
        PScoreDetailExample pScoreDetailExample = new PScoreDetailExample();
        PScoreDetailExample.Criteria criteria = pScoreDetailExample.createCriteria();
        criteria.andTitleLike("%参加活动%");
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(pScoreDetailExample);
        result.setSuccess(true);
        result.setData(pScoreDetailList);
        return result.getResult();
    }

    @RequestMapping(value = "/queryByRoleMenu", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByRoleMenu(Integer roleid) {
        ResultUtil result = new ResultUtil();
//        if( roleid == null) {
//        	 result.setSuccess(false);
//        	 result.setData("获取角色失败");
//        	 return result.getResult();
//        }
        PScoreDetailExample pScoreDetailExample = new PScoreDetailExample();
        PScoreDetailExample.Criteria criteria = pScoreDetailExample.createCriteria();
        criteria.andAdderRoleIdEqualTo(roleid);
        List<PScoreDetail> pScoreDetailList = pScoreDetailService.selectByExample(pScoreDetailExample);
        result.setSuccess(true);
        result.setData(pScoreDetailList);
        return result.getResult();
    }

    /**
     * 待办事项
     *
     * @param userId
     * @return
     * @author July july_sky@foxmail.com
     * @date 2018-04-14 13:21:20
     * @Copyright ©2015-2035 湘豫(北京)科技有限公司. All Rights Reserved.
     * @version 1.0
     */
    @RequestMapping(value = "/todoList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> todoList(Integer userId) {
        ResultUtil result = new ResultUtil();
        result.setSuccess(true);
        result.setData(pScoreDetailService.selectTodoList(userId));
        return result.getResult();
    }
    /**
     * 
     * @param userId
     * @return count总数
     */
    @RequestMapping(value = "/todoListCount", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> todoListCount(Integer userId) {
        ResultUtil result = new ResultUtil();
        if(userId == null)
        {
        	 result.setSuccess(false);
             result.setMsg("获取总数失败");
        }
        int count = pScoreDetailService.selectTodoListCount(userId);
        result.setSuccess(true);
        result.setData(count);
        return result.getResult();
    }
    
    
}