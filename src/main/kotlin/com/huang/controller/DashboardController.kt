package com.huang.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class DashboardController {
    @RequestMapping("/")
    fun index(): String {
        return "redirect:/main.html"

    }

    @GetMapping("/main.html")
    fun dashboard(): String {
        return "dashboard"
    }
}