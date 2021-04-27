package com.huang.controller;

import com.huang.dao.ConsumerMapper;
import com.huang.pojo.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    ConsumerMapper consumerMapper;

    @RequestMapping("/user/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model, HttpSession session) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        List<Consumer> consumers = consumerMapper.selectByMap(map);
//        System.out.println(consumers);
        boolean empty = CollectionUtils.isEmpty(consumers);
//        System.out.println(empty);
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


    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";

    }

    @GetMapping("/regs")
    public String add(Model model) {
        List<Consumer> consumers = consumerMapper.selectList(null);
        model.addAttribute("Consumer", consumers);
        return "login/reg";
    }

    @RequestMapping("/user/login/zc")
    public String zc(Consumer consumer) {
        consumerMapper.insert(consumer);
//        System.out.println(consumers);
        return "redirect:/index.html";
    }

//    @GetMapping("/new")
//    public String dda(Model model){
//        return "reg/new";
//
//    }


}
