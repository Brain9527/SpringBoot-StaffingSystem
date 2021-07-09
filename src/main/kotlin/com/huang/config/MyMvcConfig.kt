package com.huang.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class MyMvcConfig : WebMvcConfigurer {
    @Bean
    fun localeResolver(): LocaleResolver = MyLocaleResolver()
}
