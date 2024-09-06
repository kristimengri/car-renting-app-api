package com.car.CarRenting.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket


@Configuration
class SwaggerConfig {

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.car.CarRenting"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfoMetaData())
    }

    private fun apiInfoMetaData(): ApiInfo {
        return ApiInfoBuilder()
            .title("Car Renting Application")
            .description("Backend APIs of the CarRenting Application")
            .contact(Contact("Kent", "www.kent.com", "kent@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build()
    }
}