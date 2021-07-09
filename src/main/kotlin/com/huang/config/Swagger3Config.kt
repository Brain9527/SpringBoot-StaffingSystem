package com.huang.config

import io.swagger.annotations.Api
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@EnableOpenApi
@Configuration
class Swagger3Config {
    @Bean
    fun createRestApi(): Docket? {
        //返回文档摘要信息
        return Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.withClassAnnotation(Api::class.java))
            .paths(PathSelectors.any())
            .build()
    }

    //生成接口信息，包括标题、联系人等
    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
            .title("Swagger3 接口文档")
            .description("Swagger3 接口文档。")
            .contact(Contact("Kevin", "https://sxzz.moe/", "sxzz@sxzz.moe"))
            .version("1.0")
            .build()
    }
}
