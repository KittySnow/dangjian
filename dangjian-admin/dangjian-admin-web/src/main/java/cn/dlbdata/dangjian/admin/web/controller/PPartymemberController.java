package cn.dlbdata.dangjian.admin.web.controller;

import cn.dlbdata.dangjian.admin.dao.model.*;
import cn.dlbdata.dangjian.admin.service.*;
import cn.dlbdata.dangjian.common.util.DateUtil;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

@Controller
@RequestMapping("/ppartymember")

public class PPartymemberController {

    @Autowired
    private PPartymemberService pPartymemberService;

    @Autowired
    private PUserService pUserService;

    @Autowired
    private PDepartmentService pDepartmentService;

    @Autowired
    private PAvantgradeService pAvantgradeService;

    @Autowired
    private PScorePartyService pScorePartyService;

    @RequestMapping(value="/save",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PPartymember pPartymember){
        ResultUtil result = new ResultUtil();
        int callbackId = pPartymemberService.insert(pPartymember);
        result.setData(callbackId);
        result.setSuccess(true);
        return result.getResult();
    }

    @RequestMapping(value="/getList",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(new PPartymemberExample());
        result.setSuccess(true);
        result.setData(pPartymemberList);
        return result.getResult();
    }

    @RequestMapping(value="/list",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize){
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize,true);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(new PPartymemberExample());
        PageInfo<PPartymember> p=new PageInfo<PPartymember>(pPartymemberList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value="/deleteById",method= RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer id){
        ResultUtil result = new ResultUtil();
        PPartymemberExample example = new PPartymemberExample();
        if(pPartymemberService.deleteByPrimaryKey(id)>0){
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
    public Map<String, Object> updateById(PPartymember pPartymember){
        ResultUtil result = new ResultUtil();
        if(pPartymemberService.updateByPrimaryKey(pPartymember)>0){
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
        PPartymember pPartymember = pPartymemberService.selectByPrimaryKey(id);
        result.setSuccess(true);
        result.setData(pPartymember);
        return result.getResult();
    }

    @RequestMapping(value="/queryByUserId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByUserId(Integer userid){
        ResultUtil result = new ResultUtil();
        PPartymember pPartymember = pPartymemberService.selectByUserId(userid);
        if(pPartymember!=null){
            result.setSuccess(true);
            result.setData(pPartymember);
        }else{
            result.setSuccess(false);
            result.setMsg("没有找到对应的党员");
        }
        return result.getResult();
    }

    //根据角色ID查用户
    @RequestMapping(value="/queryByRoleId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByRoleId(Integer roleid){
        ResultUtil result = new ResultUtil();
        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria criteria =  pUserExample.createCriteria();
        criteria.andRoleidEqualTo(roleid);
        List<PUser> pUserList = pUserService.selectByExample(pUserExample);
        PPartymember pPartymember = pPartymemberService.selectByUserId(pUserList.get(0).getUserid());
        int people = pDepartmentService.getSumPeople();
        int department = pDepartmentService.getSumDepartment();
        String s="{\"name\":\""+ pPartymember.getName() + "\",\"branchSum\":\""+department+"\",\"peopleSum\":\""+people+"\"}";
        if(pPartymember!=null){
            result.setSuccess(true);
            result.setData(s);
        }else{
            result.setSuccess(false);
            result.setMsg("没有找到对应的党员");
        }
        return result.getResult();
    }


    //支部党员信息
    @RequestMapping(value="/queryByDepartmentId",method= RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryByDepartmentId(Integer departmentid){
        ResultUtil result = new ResultUtil();

        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(pPartymemberExample);

        result.setSuccess(true);
        result.setData(pPartymemberList);
        return result.getResult();
    }


    //支部党员信息（组织生活扣分）
    @RequestMapping(value="/getPartymemberByDepartmentidCleanScore",method= RequestMethod.GET)
    @ResponseBody
    /*
    status:0 代表 等待领导审核 NULL 代表等待支部书记审核，1代表领导已审核
    * */
    public Map<String, Object> getPartymemberByDepartmentidCleanScore(Integer departmentid,@RequestParam(required=false) Integer status){
        ResultUtil result = new ResultUtil();
        result.setSuccess(true);

        return result.getResult();
    }

    //支部党员信息（部门先锋评定）
    @RequestMapping(value="/getPartymemberByDepartmentid",method= RequestMethod.GET)
    @ResponseBody
    /*
    status:0 代表 等待领导审核 NULL 代表等待支部书记审核，1代表领导已审核
    * */
    public Map<String, Object> getPartymemberByDepartmentid(Integer departmentid,@RequestParam(required=false) Integer status){
        ResultUtil result = new ResultUtil();
        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(pPartymemberExample);
        PPartymember leader = pPartymemberService.selectBranchByDepartmentId(departmentid);

        List<JSONObject> list = new ArrayList<>();
        for (PPartymember pPartymember:pPartymemberList){
            JSONObject json = JSON.parseObject(JSON.toJSONString(pPartymember));

            //根据用虎ID 找审核没
            PAvantgradeExample pA = new PAvantgradeExample();
            PAvantgradeExample.Criteria ct = pA.createCriteria();
            ct.andUseridEqualTo(pPartymember.getUserid());
            ct.andYearEqualTo(Calendar.getInstance().get(Calendar.YEAR));
            List<PAvantgrade> pAvantgradeList = pAvantgradeService.selectByExample(pA);

            if(leader!=null){
                json.put("branchName", leader.getName());
            }else{
                json.put("branchName", "暂无党支书");
            }

            json.put("tempint", null);
            //NULL所有人的状态 1代表审核申请 2代表已审核
            if(status == null ){
                if(pAvantgradeList.size()==0){
                    json.put("tempint", null);
                }else{

                    int temp = 0;

                    for (PAvantgrade pAvantgrade:pAvantgradeList){
                        //2代表通过 3代表拒绝
                        if(pAvantgrade.getStatus() == 2 || pAvantgrade.getStatus() == 3 ){
                            temp = 1;
                        }
                    }
                    json.put("tempint", temp);
                }

                list.add(json);

            }else if(status==1 ||  status==0){

                if(pAvantgradeList!=null) {
                    if(pAvantgradeList.size()!=0) {

                        int temp = 0;
                        for (PAvantgrade pAvantgrade : pAvantgradeList) {
                            //2代表通过 3代表拒绝
                            if (pAvantgrade.getStatus() == 2 || pAvantgrade.getStatus() == 3) {
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

        }
        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }


    //思想考核评定
    //支部党员信息
    @RequestMapping(value="/getReportByDepartmentid",method= RequestMethod.GET)
    @ResponseBody
    /*
    status:0 代表 等待领导审核 NULL 代表等待支部书记审核，1代表领导已审核
    * */
    public Map<String, Object> getReportByDepartmentid(Integer departmentid,Integer moudleId,@RequestParam(required=false) Integer status){
        ResultUtil result = new ResultUtil();
        PPartymemberExample pPartymemberExample = new PPartymemberExample();
        PPartymemberExample.Criteria pPartymemberCriteria =  pPartymemberExample.createCriteria();
        pPartymemberCriteria.andDepartmentidEqualTo(departmentid);
        List<PPartymember> pPartymemberList = pPartymemberService.selectByExample(pPartymemberExample);
        PPartymember leader = pPartymemberService.selectBranchByDepartmentId(departmentid);

        List<JSONObject> list = new ArrayList<>();
        if(pPartymemberList!=null){
            if(pPartymemberList.size()!=0){
                for (PPartymember pPartymember:pPartymemberList){
                    JSONObject json = JSON.parseObject(JSON.toJSONString(pPartymember));

                    //根据用户ID 找思想汇报审核没

                    PScorePartyExample example = new PScorePartyExample();
                    PScorePartyExample.Criteria ct = example.createCriteria();
                    ct.andDetailIdEqualTo(moudleId);
                    Integer year = Calendar.getInstance().get(Calendar.YEAR);
                    ct.andYearEqualTo(Calendar.getInstance().get(Calendar.YEAR));
                    ct.andUserIdEqualTo(pPartymember.getUserid());
                    List<PScoreParty> pScorePartyList= pScorePartyService.selectByExample(example);

                    if(leader!=null){
                        json.put("branchName", leader.getName());
                    }else{
                        json.put("branchName", "暂无党支书");
                    }


                    //1所有人没审批中 2代表审核通过 3代表超期未加分
                    if(pScorePartyList != null ){

                        if(pScorePartyList.size()!=0){

                            json.put("tempint", 2);

                        }else{
                            if(moudleId==11){

                                if(new Date().getTime()<DateUtil.getYearMiddle(year).getTime()){
                                    json.put("tempint", 1);
                                }else{
                                    json.put("tempint", 3);
                                }
                            }

                            if(moudleId==12){

                                if(new Date().getTime()<DateUtil.getYearLast(year).getTime()){
                                    json.put("tempint", 1);
                                }else{
                                    json.put("tempint", 3);
                                }
                            }
                        }

                    }else{

                        json.put("tempint", 1);
                    }

                    list.add(json);

                }

            }

        }

        result.setSuccess(true);
        result.setData(list);
        return result.getResult();
    }

}
