package com.huang.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //登入成功之后，应该有用户的Session
//        Object loginUser = request.getSession().getAttribute("loginUser");
//
//        //没登录
//        if (loginUser == null){
//            request.setAttribute("msg", "没有权限，请先登录");
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//
//        }else {
//            return true;
//        }
//
//    }
}
