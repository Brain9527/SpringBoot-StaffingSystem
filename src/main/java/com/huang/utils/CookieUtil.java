package com.huang.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 记住我
 */
public class CookieUtil {
    //加入cookie中
    public static void addCookie(String name, String password, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(name) && StringUtils.isNotBlank(password)) {
            //创建Cookie
            Cookie nameCookie = new Cookie("name", java.net.URLEncoder.encode(name, "utf-8"));
            Cookie passwordCookie = new Cookie("password", password);


            //设置Cookie的父路径
            nameCookie.setPath(request.getContextPath() + "/");
            passwordCookie.setPath(request.getContextPath() + "/");
            //设置cookie的有效时间（天数*24小时*分*秒）
            nameCookie.setMaxAge(7 * 24 * 60 * 60);
            passwordCookie.setMaxAge(7 * 24 * 60 * 60);
            //加入Cookie到响应头
            response.addCookie(nameCookie);
            response.addCookie(passwordCookie);
        }
    }
}
