package cn.dlbdata.dangjian.admin.web.controller;


import cn.dlbdata.dangjian.admin.dao.model.PUser;
import cn.dlbdata.dangjian.admin.service.ADService;
import cn.dlbdata.dangjian.admin.service.PFeatureService;
import cn.dlbdata.dangjian.admin.service.PUserService;
import cn.dlbdata.dangjian.admin.service.pojo.LoginAccount;
import cn.dlbdata.dangjian.common.util.ResultUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Date;

@Controller
@RequestMapping("/ad")
public class AdController {
	public final static SimpleDateFormat SDF	= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public final static String LOGGED_USER	= "loggedUserInfo";
	public final static String SESSION_USER= "userInfo";
	public final static String SESSION_FEATURES= "featureList";
	public final static String SESSION_INVALID	= "请求的会话错误，请登录系统后再使用本系统！";
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ADService adServ;

	@Autowired
	private PUserService userServ;

	@Autowired
	private PFeatureService featureServ;

	private static String getIpAddr(final HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(ip.equals("127.0.0.1")){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > 15){
            if(ip.indexOf(",")>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
	}
	
	/*
	 * 检查登录账号和密码。
	 */
	@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkLogin(
			@RequestParam("loginMail")String loginMail,
			@RequestParam("loginPasswd")String loginPasswd,
			HttpSession session
	) {
		final String msg0	= "邮箱、密码已匹配，登录成功！";		
		final String msg1	= "邮箱、密码不匹配，无法登录！";
		final String msg2	= "账号已被锁定，请3小时后再尝试登录！";
		final String msg3	= "你已经登录了，无法同时进行第2次登录！";
		String retMsg= null;
		final String lowercase	= loginMail.toLowerCase();
		final String ip	= getIpAddr(request);
		ResultUtil result	= new ResultUtil();
		result.setSuccess(false);
		int loginResult	= adServ.checkLogin(loginMail, loginPasswd, ip);
		//0通过验证；1验证失败；2账号被锁定。
		if (0==loginResult)	{
			Date now = new Date(System.currentTimeMillis());
			LoginAccount la	= new LoginAccount();
			la.setLoginMail(lowercase);
			la.setIsLocked(false);
			la.setLoggedTime(now);
			la.setIp(ip);
			session.setAttribute(LOGGED_USER, la);
			retMsg = msg0 + "你本次登录IP地址是："+ip;
			result.setSuccess(true);
		} else if (1==loginResult)	{
			retMsg = msg1 + "你本次登录IP地址是："+ip;
		} else if (2==loginResult)	{
			retMsg = msg2 + "你本次登录IP地址是："+ip;
		} else {
			retMsg = msg3 + "你上次登录IP地址是："+adServ.getLastLoginIp(lowercase);			
		}
		result.setMsg(retMsg);
		
		return result.getResult();
	} 

	/*
	 * 退出登录。
	 * 前端调用地址：http://localhost:8082/latform/ad/logout.do?loginMail=a@b.com
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> logout(HttpSession session) {
		String msg	= null;
		final String ip	= getIpAddr(request);
		final LoginAccount loggedUser	= (LoginAccount)session.getAttribute(LOGGED_USER);
		ResultUtil result	= new ResultUtil();
		if (null==loggedUser)	{
			msg	= "无法在会话中找到你的登录账号，请先登录后再退出！本次退出操作来源IP地址为"+ip;
			result.setSuccess(false);
			result.setMsg(msg);
			return result.getResult();
		}
		final String loginMail	= loggedUser.getLoginMail();
		boolean b	= adServ.logout(loginMail);
		if (b)	{
			session.removeAttribute(LOGGED_USER);
			session.invalidate();
			msg	= "你的账号"+loginMail+"已成功退出！本次退出操作来源IP地址为"+ip+"，你上次登录的时间是"+SDF.format(loggedUser.getLoggedTime())+"，登录IP是"+loggedUser.getIp();
			result.setSuccess(true);
		} else {
			msg	= "你的账号"+loginMail+"尚未登录，请先登录后再退出！本次退出操作来源IP地址为"+ip;
			result.setSuccess(false);
		}
		result.setMsg(msg);

		return result.getResult();
	}

	/*
	 * 检查登录账号和密码。
	 */
	/*@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(
			@RequestParam("loginMail")String loginMail,
			@RequestParam("loginPasswd")String loginPasswd,
			HttpSession session
	) {
		final String msg0	= "邮箱、密码已匹配，登录成功！";		
		final String msg1	= "邮箱、密码不匹配，无法登录！";
		final String msg2	= "账号已被锁定，请3小时后再尝试登录！";
		final String msg3	= "你已经登录了，无法同时进行第2次登录！";
		String retMsg= null;
		final String lowercase	= loginMail.toLowerCase();
		final String ip	= getIpAddr(request);
		ResultUtil result	= new ResultUtil();
		result.setSuccess(false);
		int loginResult	= adServ.login(lowercase, loginPasswd, ip);
		//0通过验证；1验证失败；2账号被锁定。
		if (0==loginResult)	{
			Date now = new Date(System.currentTimeMillis());
			LoginAccount la	= new LoginAccount();
			la.setLoginMail(lowercase);
			la.setIsLocked(false);
			la.setLoggedTime(now);
			la.setIp(ip);
			session.setAttribute(LOGGED_USER, la);
			retMsg = msg0 + "你本次登录IP地址是："+ip;
			result.setSuccess(true);
			
			PUser u	= userServ.selectByEmail(lowercase);
			u.setPassword("");
			u.setEmail(lowercase);
			session.setAttribute(SESSION_USER, u);
			session.setAttribute(SESSION_FEATURES, featureServ.selectByEmail(lowercase));
		} else if (1==loginResult)	{
			retMsg = msg1 + "你本次登录IP地址是："+ip;
		} else if (2==loginResult)	{
			retMsg = msg2 + "你本次登录IP地址是："+ip;
		} else {
			retMsg = msg3 + "你上次登录IP地址是："+adServ.getLastLoginIp(lowercase);			
		}
		result.setMsg(retMsg);
		
		return result.getResult();
	} */

	private static boolean checkSession(HttpSession session)	{
		boolean result	= false;
		if (null==session)	return result;
		
		Object obj	= session.getAttribute(SESSION_USER);
		if (null==obj)	return result;
		if (!(obj instanceof PUser))	return result;
		
		result	= true;
		
		return result;
	}
	
	/*
	 * 检查登录账号和密码。
	 */
	/*@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePassword(
			@RequestParam("loginMail")String loginMail,
			@RequestParam("oldPassword")String oldPassword,
			@RequestParam("newPassword")String newPassword,
			HttpSession session
	) {
		final String msg1	= "登录邮箱和发送邮箱参数不同，没有权限修改密码！";
		final String msg2	= "原密码输入错误，请重新输入！";
		final String msg3	= "新密码不能为空，请重新输入！";
		final String msg4	= "修改密码成功，请退出系统后使用新密码登录！";
		final String msg5	= "修改密码失败，请联系管理人员！";
		final String lowercase	= loginMail.toLowerCase();
		ResultUtil result	= new ResultUtil();
		result.setSuccess(false);
		//check session.
		boolean b	= checkSession(session);
		if (!b)	{
			result.setMsg(SESSION_INVALID);
		} else {
			//check email.
			PUser me	= (PUser)session.getAttribute(SESSION_USER);
			if (!me.getEmail().equals(lowercase))	{
				result.setMsg(msg1);
			} else if (newPassword.isEmpty())	{
				result.setMsg(msg3);				
			} else {
				final String md5= getMD5(oldPassword);
				PUser u	= userServ.selectByPrimaryKey(me.getUserid());
				if (!u.getPassword().equals(md5))	{
					result.setMsg(msg2);
				} else {
					PUser change	= new PUser();
					change.setEmail(lowercase);
					change.setPassword(getMD5(newPassword));
					if (1==userServ.updatePasswordByEmail(change))	{
						result.setMsg(msg4);
					} else {
						result.setMsg(msg5);
					}
				}
			}
		}
		
		return result.getResult();
	}*/
	
}