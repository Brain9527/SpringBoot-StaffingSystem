package com.huang.controller;

import com.huang.dao.ConsumerMapper;
import com.huang.error.HttpException;
import com.huang.pojo.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.List;

@Controller
@Validated
public class LoginController {
    @Autowired
    ConsumerMapper consumerMapper;

    //登入页面
    @PostMapping("/user/login")
    public String login(
            @RequestParam(value = "username", required = false) @NotBlank(message = "用户名不能为空") String username,
            @RequestParam(value = "password", required = false) @NotBlank(message = "密码不能为空") String password,
            Model model,
            HttpSession session
    ) {
        System.out.println(username);
        List<Consumer> consumers;
        try {
            HashMap<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("password", password);
            consumers = consumerMapper.selectByMap(map);
        } catch (NullPointerException exception) {
            throw new HttpException("空指针异常", -200);
        }

        boolean empty = CollectionUtils.isEmpty(consumers);
        if (empty) {
            //告诉用户，你登录失败了
            model.addAttribute("msg", "用户名或者密码错误！");
            return "index";
        } else {
            session.setAttribute("loginUser", username);
            System.out.println(session);
            return "redirect:/main.html";
        }
    }

    //注销页面
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }

    //注册成功页面
    @RequestMapping("/login/regsa")
    public String regs() {
        return "login/regRemind";
    }

    //跳转到登录
    @RequestMapping("/jump")
    public String jump() {
        return "redirect:/index.html";
    }

    //注册页面
    @GetMapping("/regs")
    public String add() {
        return "login/reg";
    }

    //注册页面接口
    @RequestMapping("/user/login/zc")
    public String zc(Consumer consumer) {
        consumerMapper.insert(consumer);
        return "redirect:/index.html";
    }

}
