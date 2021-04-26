package com.huang.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 记住我
 */
public class CookieUtil {
    public static Cookie buildCookie(String name, String value, int maxAge, HttpServletRequest request) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAge);
        cookie.setPath(request.getContextPath() + "/");
        return cookie;
    }

    //加入cookie中
    public static void addCookie(
            String name,
            String password,
            boolean rememberMe,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
            int maxAge = rememberMe ? 7 * (24 * 60 * 60) : (24 * 60 * 60);

            Cookie usernameCookie = buildCookie("username", name, maxAge, request);
            Cookie passwordCookie = buildCookie("password", password, maxAge, request);

            response.addCookie(usernameCookie);
            response.addCookie(passwordCookie);
        }
    }

    public static void removeCookie(HttpServletRequest request,
                                    HttpServletResponse response) {
        Cookie usernameCookie = buildCookie("username", null, 0, request);
        Cookie passwordCookie = buildCookie("password", null, 0, request);
        response.addCookie(usernameCookie);
        response.addCookie(passwordCookie);
    }
}
