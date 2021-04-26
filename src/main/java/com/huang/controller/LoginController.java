package com.huang.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.huang.dao.ConsumerMapper;
import com.huang.pojo.Consumer;
import com.huang.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/user")
@Controller
public class LoginController {
    @Autowired
    ConsumerMapper consumerMapper;

    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam(value = "rememberMe", required = false, defaultValue = "") String rememberMe,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        QueryWrapper<Consumer> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        wrapper.eq("password", password);
        Consumer consumer = consumerMapper.selectOne(wrapper);
        if (consumer == null) {
            //告诉用户，你登录失败了
            model.addAttribute("msg", "用户名或者密码错误！");
            return "index";
        }

        CookieUtil.addCookie(username, password, "1".equals(rememberMe), request, response);
        return "redirect:/main.html";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
        CookieUtil.removeCookie(request, response);
        return "redirect:/index.html";

    }

    @GetMapping("/reg")
    public String reg(Model model) {
        List<Consumer> consumers = consumerMapper.selectList(null);
        model.addAttribute("Consumer", consumers);
        return "login/reg";
    }

    @PostMapping("/reg")
    public String reg(Consumer consumer) {
        consumerMapper.insert(consumer);
        return "redirect:/main.html";
    }
}
