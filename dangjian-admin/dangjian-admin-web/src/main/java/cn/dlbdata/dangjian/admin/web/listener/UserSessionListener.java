package cn.dlbdata.dangjian.admin.web.listener;

import cn.dlbdata.dangjian.admin.service.ADService;
import cn.dlbdata.dangjian.admin.service.model.LoginAccount;
import cn.dlbdata.dangjian.admin.web.controller.AdController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

@WebListener
public class UserSessionListener implements HttpSessionListener	{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserSessionListener.class);
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		//do nothing.
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvt) {
		LOGGER.info("latform: user session is timeout or invalidate, begin to run sessionDestroyed method.");
		
		HttpSession session	= sessionEvt.getSession();
		LoginAccount loggedUser	= (LoginAccount)session.getAttribute(AdController.LOGGED_USER);
		if (null==loggedUser)	{
			//this session has been logout.
		} else {
			//this session is timeout, 执行logout操作。
			LOGGER.info("latform: user session is timeout, begin to do logout operations.");
			ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
			ADService adServ	= (ADService)ctx.getBean("ADService");
			final String loginMail	= loggedUser.getLoginMail();
			boolean b	= adServ.logout(loginMail);
			if (b)	{
				Date now	= new Date(System.currentTimeMillis());				
				session.removeAttribute(AdController.LOGGED_USER);
				String msg	= "latform: succeed to logout, 你的账号"+loginMail+"已成功退出！";
				msg += "你上次登录的时间是" + AdController.SDF.format(loggedUser.getLoggedTime())+"，登录IP是"+loggedUser.getIp()+"。";
				msg += "你本次会话超时退出时间是" + AdController.SDF.format(now) + "。";
				LOGGER.info(msg);
			} else {
				LOGGER.error("latform: fail to logout!");
			}
			loggedUser	= null;
		}

		LOGGER.info("latform: end to run sessionDestroyed method, return now.");
	}
}