package com.huang

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@SpringBootTest
class SpringSecurityTests {

    @Test
    fun contextLoads() {
        val encoder = BCryptPasswordEncoder()
        val encode = encoder.encode("hello");
        println(encode)

        println(encoder.matches("hello", encode))
    }
}