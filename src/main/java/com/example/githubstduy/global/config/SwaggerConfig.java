package com.example.githubstduy.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    SecurityScheme basicAuth = new SecurityScheme()
            .type(SecurityScheme.Type.HTTP).scheme("basic");
    SecurityRequirement securityItem = new SecurityRequirement().addList("basicAuth");

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.version}") String appVersion) {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("basicAuth",basicAuth))
                .addSecurityItem(securityItem)
                .info(new Info()
                        .title("그룹스터디 1조 API")
                        .version(appVersion)
                        .description("사이드 프로젝트 API 명세서"));
    }
}