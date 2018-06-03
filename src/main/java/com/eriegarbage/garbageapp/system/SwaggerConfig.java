package com.eriegarbage.garbageapp.system;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api1() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("user-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                //exclude html pages and /error path from api
                .paths(Predicates.not(PathSelectors.regex("^.*\\.html$|^.*\\/error$|^.*\\/admin.*")))
                .build()
                .apiInfo(new ApiInfoBuilder().version("0.1").title("Garbage API")
                        .description("Documentation Garbage API User").build());
    }

    @Bean
    public Docket api2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                //exclude html pages and /error path from api
                .paths(PathSelectors.regex("^.*\\/admin.*"))
                .build()
                .apiInfo(new ApiInfoBuilder().version("0.1").title("Garbage API")
                        .description("Documentation Garbage API Admin").build());
    }
}
