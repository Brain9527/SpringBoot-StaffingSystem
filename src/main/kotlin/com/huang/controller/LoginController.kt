package com.huang.controller

import com.huang.dao.ConsumerMapper
import com.huang.pojo.Consumer
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import javax.servlet.http.HttpServletRequest

@Controller
@Api(tags = ["登录控制器"])
class LoginController(
    val consumerMapper: ConsumerMapper
) {
    @ApiOperation("用户登录")
    @GetMapping(value = ["/index.html", "/user/login"])
    fun login(
        request: HttpServletRequest,
        model: Model,
        @RequestParam("lang", required = false, defaultValue = "") lang: String
    ): String {
        val msg = (request.session.getAttribute("msg") as String?) ?: ""
        request.session.removeAttribute("msg")
        model.addAttribute("msg", msg)

        if (lang.isNotBlank()) {
            request.session.setAttribute("lang", lang)
        }

        return "user/login"
    }

    @ApiOperation("用户注册页面")
    @GetMapping("/user/reg")
    fun reg(model: Model): String {
        return "user/reg"
    }

    @ApiOperation("用户注册接口")
    @PostMapping("/user/reg")
    fun reg(consumer: Consumer): String {
        consumerMapper.insert(consumer)
        return "redirect:/main.html"
    }
}
