package com.huang.utils

import org.springframework.stereotype.Component
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class CookieUtil(
    val request: HttpServletRequest,
    val response: HttpServletResponse
) {

    fun toMap(cookies: Array<Cookie>): Map<String, String> {
        return cookies.toList().map { it.name to it.value }.toMap()
    }

    fun createCookie(name: String, value: String?, maxAge: Int): Cookie {
        val cookie = Cookie(name, value)
        cookie.maxAge = maxAge
        cookie.path = "${request.contextPath}/"
        return cookie
    }

    fun addCookie(name: String, value: String, maxAge: Int) {
        val cookie = createCookie(name, value, maxAge)
        response.addCookie(cookie)
    }

    fun removeCookie(name: String) {
        val cookie = createCookie(name, null, 0)
        response.addCookie(cookie)
    }
}
