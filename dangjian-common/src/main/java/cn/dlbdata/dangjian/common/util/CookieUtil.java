package cn.dlbdata.dangjian.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void setCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        // 保存时间一个月
        cookie.setMaxAge(3600 * 24 * 30);
        cookie.setPath("/");

        response.addCookie(cookie);
    }
}
