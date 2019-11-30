package com.team.bloom.favoriz.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.RequestHandlerSelectors.any
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux

@Configuration
@EnableSwagger2WebFlux
class SwaggerConfig {

    @Bean
    fun swagger(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(any())
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)
        .apiInfo(this.apiInfo())
        .enable(true)

    private fun apiInfo(): ApiInfo = ApiInfoBuilder()
        .title("Favoriz")
        .description("")
        .version("1.0.0")
        .build()
}