package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.dao.model.PUserExample;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.admin.web.VO.LoginVO;
import cn.dlbdata.dangjian.common.util.CookieUtil;
import cn.dlbdata.dangjian.common.util.HttpResult;
import cn.dlbdata.dangjian.common.util.ResultUtil;
import cn.dlbdata.dangjian.common.util.TokenUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.RandomStringUtils;
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
    public Map<String, Object> queryById(Integer userid) {
        ResultUtil result = new ResultUtil();
        PUser puser = puserService.selectByPrimaryKey(userid);
        result.setSuccess(true);
        result.setData(puser);
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
    public HttpResult tologin(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "password", required = false) String password,
                              HttpServletRequest request, HttpServletResponse response) {
        if (null == name || name.length() <= 0 || null == password || password.length() <= 0) {
            return HttpResult.failure("登陆失败，用户名或密码不能为空.");
        }

        // 创建返回结果信息工具类
//        ResultUtil result = new ResultUtil();

        try {
            // 查询用户的账号与密码
            PUser pUser = this.puserService.tologin(name, password);
            // 查询roleid
//            PUser pUserRole = this.puserService.findRoleid(name);

            // 验证通过
            if (pUser != null && pUser.getPassword().equals(password)) {
                // 尽量 确保 userAgent 唯一性
                String userAgent = request.getHeader("user-agent");
                if (null == userAgent || userAgent.length() <= 0) {
                    userAgent = RandomStringUtils.randomAlphabetic(32);
                }

                String token = TokenUtil.token(userAgent, pUser.getUserid());

                LoginVO loginVO = new LoginVO();
                loginVO.setPtoken(token);
                loginVO.setRoleId(pUser.getUserid());
                loginVO.setUserId(pUser.getUserid());

                CookieUtil.setCookie(response, "roleId", pUser.getRoleid().toString());
                CookieUtil.setCookie(response, "userId", pUser.getUserid().toString());
                CookieUtil.setCookie(response,"ptoken", token);

                return HttpResult.success(loginVO);
//                //创建session且获取session
//                HttpSession session = request.getSession();
//                //创建user Token
//                UserToken userToken = new UserToken(pUser.getName(),pUser.getPassword(),pUserRole.getRoleid());
//
//                //如果roleid为1
//                if(userToken.getRoleid()==1){
//                    //set值
//                    session.setAttribute("userToken", "userToken");
//                    result.setSuccess(true);
//
//                    return null;
//                }
//
//                //如果roleid为2或3
//                if(userToken.getRoleid()==2 || userToken.getRoleid()==3) {
//                    //set值
//                    session.setAttribute("userToken", "userToken");
//                    result.setSuccess(true);
//
//                    return null;
//                }
//                //返回boolean类型的结果值
            } else {
                return HttpResult.failure("登陆失败，用户名或密码错误.");
//                result.setSuccess(false);
//                result.setMsg("name or password error");
            }

        } catch (Exception e) {
            LOGGER.error("User login error.", e);
//            result.setSuccess(false);
//            result.setMsg("exception error");
            return HttpResult.failure("登陆失败，系统错误.");
        }

        //final return值
//        return null;
    }
}
