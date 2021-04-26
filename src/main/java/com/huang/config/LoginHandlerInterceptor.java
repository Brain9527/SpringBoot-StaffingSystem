package com.huang.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huang.dao.ConsumerMapper;
import com.huang.pojo.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Autowired
    ConsumerMapper consumerMapper;

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {
        //登入成功之后，应该有用户的Session
        Cookie[] cookies = request.getCookies();
        Map<String, String> cookieMap = Arrays.stream(cookies).collect(Collectors.toMap(Cookie::getName, Cookie::getValue));
        String username = cookieMap.get("username");
        String password = cookieMap.get("password");
        System.out.println(username + password);
        if (!"".equals(username) && !"".equals(password)) {
            QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
            wrapper.eq("username", username);
            wrapper.eq("password", password);
            Consumer consumer = consumerMapper.selectOne(wrapper);
            if (consumer != null) {
                return true;
            }
        }

        // 没登录
        request.setAttribute("msg", "没有权限，请先登录");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}
