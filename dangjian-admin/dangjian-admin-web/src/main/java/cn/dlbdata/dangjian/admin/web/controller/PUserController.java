package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.admin.web.VO.LoginVO;
import cn.dlbdata.dangjian.common.DO.UserLoginDO;
import cn.dlbdata.dangjian.common.DangjianException;
import cn.dlbdata.dangjian.common.util.*;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.model.access.GetUserInfo;
import cn.dlbdata.dangjian.thirdparty.mp.sdk.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static cn.dlbdata.dangjian.admin.service.util.DangjianUtil.getMD5;

@Controller
@RequestMapping("/puser")
@SessionAttributes("userToken")
public class PUserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PUserController.class);
    private final static String DEFAULT_PASSWORD = "12345678";//用户的默认登录密码。
    private final static String INSERT_ERROR_MSG = "增加新用户时发生异常，本操作失败，请联系管理员！";
    private final static String INSERT_SUCCESS_MSG = "增加新用户成功！";

    @Autowired
    private PUserService puserService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(PUser pUser) {
        ResultUtil result = new ResultUtil();
        pUser.setPassword(getMD5(DEFAULT_PASSWORD));
        int insertedUserId = 0;
        try {
            insertedUserId = puserService.insert(pUser);
            result.setData(insertedUserId);
            result.setSuccess(true);
            result.setMsg(INSERT_SUCCESS_MSG);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage());
            result.setSuccess(false);
            result.setMsg(INSERT_ERROR_MSG);
        }

        return result.getResult();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getList(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        List<PUser> puserList = puserService.selectByExample(new PUserExample());
        result.setSuccess(true);
        result.setData(puserList);
        return result.getResult();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> list(Integer pageNum, Integer pageSize) {
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize, true);
        List<PUser> puserList = puserService.selectByExample(new PUserExample());
        PageInfo<PUser> p = new PageInfo<PUser>(puserList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value = "/allList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> allList(Integer pageNum, Integer pageSize, String searchText) {
        ResultUtil result = new ResultUtil();
        PageHelper.startPage(pageNum, pageSize, true);
        if (searchText == null) {
            searchText = "";
        }
        List<PUser> puserList = puserService.selectAll("%" + searchText + "%");
        PageInfo<PUser> p = new PageInfo<PUser>(puserList);
        result.setSuccess(true);
        result.setData(p);
        return result.getResult();
    }

    @RequestMapping(value = "/deleteById", method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String, Object> deleteById(Integer userid) {
        ResultUtil result = new ResultUtil();
        //PUserExample example = new PUserExample();
        if (puserService.deleteByPrimaryKey(userid) > 0) {
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
    public Map<String, Object> updateById(PUser pUser) {
        ResultUtil result = new ResultUtil();
        if (puserService.updateByPrimaryKeySelective(pUser) > 0) {
            result.setSuccess(true);
            result.setMsg("修改成功");
        } else {
            result.setMsg("修改失败");
            result.setSuccess(false);
        }
        return result.getResult();
    }

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public HttpResult queryById(Integer userId) {
        if (null == userId) {
            return HttpResult.failure("userId不能为空");
        }
        PUser puser = puserService.selectByPrimaryKey(userId);
        if(puser!=null){
            puser.setPassword(null);
            return HttpResult.success(puser);

        }else{
            return HttpResult.success(null);
        }
    }
    
    @RequestMapping(value = "/queryById2", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> queryById2(Integer userid) {
    	ResultUtil result = new ResultUtil();
    	if (null == userid) {
    		result.setMsg("userid不能为空");
    		result.setSuccess(false);
        }
        
      
        PUser puser = puserService.selectByPrimaryKey(userid);
        if(puser!=null){
        	 result.setSuccess(true);
             result.setData(puser);
        }else{
        	 result.setMsg("修改失败");
             result.setSuccess(false);
        }
        return result.getResult();
    }

    /**root directory 直接访问*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {

        if (request.getSession().getAttribute("userToken") != null) {
            return "/dex";
        }

        return "login";
    }



    /**userToken*/
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request) {
        //获取userToken判断 if not null return dex.html else again login
        if (request.getSession().getAttribute("userToken") != null) {
            return "/dex";
        }
        return "login";
    }


   /*@RequestMapping(value = "/login1", method = RequestMethod.GET)
    public String toLogin1(HttpServletRequest request) {

        PUserExample pUserExample = new PUserExample();
        PUserExample.Criteria criteria  = pUserExample.createCriteria();
        criteria.andNameEqualTo("wangjie");

        List<PUser> puserList =  puserService.selectByExample(pUserExample);

        //System.out.println(pUserExample.);

        return "login";
    }*/

    /**user login*/
    @RequestMapping(value = "/tologin", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult tologin(@RequestBody(required = false) UserLoginDO userLoginDO,
                              HttpServletRequest request, HttpServletResponse response) {
        if (null == userLoginDO) {
            return HttpResult.failure("登陆失败，用户名或密码不能为空.");
        }

        String name = userLoginDO.getName();
        String password = StringUtil.getMD5Digest32(userLoginDO.getPassword());

        if (null == name || name.length() <= 0 || null == password || password.length() <= 0) {
            return HttpResult.failure("登陆失败，用户名或密码不能为空.");
        }

        try {
            // 查询用户的账号与密码
            PUser pUser = this.puserService.tologin(name, password);
            if(pUser == null) {
            	 return HttpResult.failure("登陆失败，用户名或密码错误.");
            }
            //检查当前登录用户角色
            if(userLoginDO.getUserType() != null && !userLoginDO.getUserType().equals(pUser.getRoleid()) )
            {
            		if(userLoginDO.getUserType() == 4)
            		{
            			return HttpResult.failure("登陆失败，请使用党员账号进行登录.");
            		}
            		else
            		{
            			return HttpResult.failure("登陆失败，请使用管理账号进行登录.");
            		}
            }
            // 验证通过
            if (pUser != null && pUser.getPassword().equals(password) && pUser.getName().equals(name)) {
                // 尽量 确保 userAgent 唯一性
                String userAgent = request.getHeader("user-agent");
                if (null == userAgent || userAgent.length() <= 0) {
                    userAgent = RandomStringUtils.randomAlphabetic(32);
                }
                
                String token = TokenUtil.token(userAgent, pUser.getUserid());

                LoginVO loginVO = new LoginVO();
                loginVO.setPtoken(token);
                loginVO.setRoleId(pUser.getRoleid());
                loginVO.setUserId(pUser.getUserid());

                if(pUser.getRoleid() == 4)
                {
	                CookieUtil.setCookie(response, "roleId", pUser.getRoleid().toString());
	                CookieUtil.setCookie(response, "userId", pUser.getUserid().toString());
	                CookieUtil.setCookie(response, "ptoken", token);
                }
                else
                {
                		CookieUtil.setCookie(response, "roleId", pUser.getRoleid().toString());
                		CookieUtil.setCookie(response, "manageId", pUser.getUserid().toString());
                		CookieUtil.setCookie(response, "ptoken", token);
                }
                // 登陆保存 token 信息
                if(userLoginDO.getOpenId()!= null){
                    puserService.saveLoginUserInfo(pUser.getUserid(), token, userLoginDO.getOpenId());

                }

                if(pUser.getOpenid()!=null){
                    GetUserInfo getUserInfo = new GetUserInfo();
                    getUserInfo.setLang("zh_CN");
                    getUserInfo.setOpenid(userLoginDO.getOpenId());
                    try {
                        JSONObject jsonObject = userInfoService.userInfo(getUserInfo);
                        String avatar = jsonObject.getString("headimgurl");
                        if(avatar!=null){
                            PUserExample pUserExample = new PUserExample();
                            PUserExample.Criteria ct =  pUserExample.createCriteria();
                            ct.andUseridEqualTo(pUser.getUserid());
                            pUser.setAvatar(avatar);
                            puserService.updateByExampleSelective(pUser,pUserExample);
                            loginVO.setWxInfo(jsonObject);
                        }

                    } catch (DangjianException e) {
                        HttpResult.failure("登陆失败，微信获取用户信息失败.");
                    }
                }


                return HttpResult.success(loginVO);
            } else {
                return HttpResult.failure("登陆失败，用户名或密码错误.");
            }
        } catch (Exception e) {
            LOGGER.error("User login error.", e);

            return HttpResult.failure("登陆失败，系统错误.");
        }
    }

    @RequestMapping("/genUser")
    @ResponseBody
    public HttpResult genUser() {
        puserService.genUser();

        return HttpResult.success();
    }
    
    
    /**
     * 修改密码
     * 
     * 
     */
    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public  Map<String, Object> updatePwd(@RequestBody(required = false) UserLoginDO userLoginDO) {
    	ResultUtil result = new ResultUtil();
		if(StringUtils.isEmpty(userLoginDO.getName())) {
			result.setMsg("账号不能为空");
    		result.setSuccess(false);
    		 return result.getResult();
		 }
		if(StringUtils.isEmpty(userLoginDO.getPassword())) {
			result.setMsg("密码不能为空");
    		result.setSuccess(false);	
    		return result.getResult();
		 }
		if(StringUtils.isEmpty(userLoginDO.getRePassWord())) {
			result.setMsg("新密码不能为空");
    		result.setSuccess(false);	
    		return result.getResult();
		 }
    	PUser pUser = new PUser();
    	pUser.setName(userLoginDO.getName());
    	pUser.setPassword(userLoginDO.getPassword());
    	pUser.setRePassWord(userLoginDO.getRePassWord());
    	int count = puserService.updatePwd(pUser);
    	if(count == 2) {
    		result.setMsg("修改成功");
    		result.setSuccess(true);
    	}else if(count == 3){
    		result.setMsg("账号或者密码错误");
    		result.setSuccess(false);
    	}else if(count == 4) {
    		result.setMsg("");
    		result.setSuccess(false);
    	}else {
    		result.setMsg("");
    		result.setSuccess(false);
    	}

        return result.getResult();
    
    }
}
