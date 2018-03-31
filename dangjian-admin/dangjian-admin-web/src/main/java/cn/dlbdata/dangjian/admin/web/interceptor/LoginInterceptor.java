package cn.dlbdata.dangjian.admin.web.interceptor;

import cn.dlbdata.dangjian.common.util.CookieUtil;
import cn.dlbdata.dangjian.common.util.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor{
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    private final String PTOKEN = "ptoken";
    private final String USER_ID = "userId";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ptoken;
        String userId;

        // 按照 cookie -> header 的顺序获取
        Cookie ptokenCookie = CookieUtil.getCookie(httpServletRequest, PTOKEN);
        if (null != ptokenCookie) {
            ptoken = ptokenCookie.getValue();
        } else {
            ptoken = httpServletRequest.getHeader(PTOKEN);
        }

        Cookie userIdCookie = CookieUtil.getCookie(httpServletRequest, USER_ID);
        if (null != userIdCookie) {
            userId = userIdCookie.getValue();
        } else {
            userId = httpServletRequest.getHeader(USER_ID);
        }

        if (null == ptoken || ptoken.length() <= 0 || null == userId || userId.length() <= 0) {
            sendNeedLoginResponse(httpServletResponse);
            logger.warn("ptoken or userId is illegal. ptoken=" + ptoken + ",userId=" + userId);

            return false;
        }

        if (!TokenUtil.checkToken(ptoken, userId)) {
            sendNeedLoginResponse(httpServletResponse);
            logger.warn("token check error. ptoken=" + ptoken + ",userId=" + userId);

            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    private void sendNeedLoginResponse(HttpServletResponse response) {
        String rsp = "{\"responseCode\":10212,\"message\":\"您还没有登录\",\"status\":false}";

        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(rsp);
            response.getWriter().flush();
        } catch (IOException e) {
            logger.warn("failed to write response " + rsp, e);
        }
    }
}
