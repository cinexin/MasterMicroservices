package org.microservices.master.restfulwebservices.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * To access API swagger docu:
 *
 * - <ip>:<port>/v2/api-docs
 * - <ip>:<port>/swagger-ui.html
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {

    private val DEFAULT_CONTACT = Contact(
            "Migue Guillamón",
            "https://github.com/cinexin",
            "migueguillamon@gmail.com"
    )
    private val DEFAULT_API_INFO =
            ApiInfoBuilder()
                    .title("Api Documentation for Master Microservices Demo")
                    .description("Api Documentation")
                    .contact(DEFAULT_CONTACT)
                    .license("Apache 2.0")
                    .termsOfServiceUrl("http://www.apache.org/licenses/LICENSE-2.0")
                    .version("1.0")
                    .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                    .build()

    private val DEFAULT_PRODUCES_AND_CONSUMES = hashSetOf(
            "application/json",
            "application/xml"
    )

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }
}