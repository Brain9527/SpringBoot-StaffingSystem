package com.huang.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class MyApplicationRunner : ApplicationRunner {
    @Value("\${server.port}")
    lateinit var port: String

    @Value("\${server.servlet.context-path}")
    lateinit var contextPath: String

    override fun run(args: ApplicationArguments) {
        println("http://localhost:${this.port}${contextPath}")
        println("程序已就绪")
    }
}
