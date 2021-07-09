package com.huang.config

import org.springframework.web.servlet.LocaleResolver
import org.thymeleaf.util.StringUtils
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MyLocaleResolver : LocaleResolver {
    //解析请求
    override fun resolveLocale(request: HttpServletRequest): Locale {
        // 如果没有就使用默认的
        var locale = Locale.getDefault()

        // 获取请求的语言参数
        val language = (request.session.getAttribute("lang") as String?) ?: return locale

        // 如果请求的连接携带了国际化的参数
        val split = language.split("_".toRegex())
        if (!StringUtils.isEmpty(language) && split.count() == 2) {
            locale = Locale(split[0], split[1])
        }

        return locale
    }

    override fun setLocale(request: HttpServletRequest, response: HttpServletResponse?, locale: Locale?) {}
}