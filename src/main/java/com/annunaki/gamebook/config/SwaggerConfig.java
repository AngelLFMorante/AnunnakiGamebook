package com.annunaki.gamebook.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Anunnaki 2 API")
                        .description("Documentacion de la API para el juego de libro interactivo Anunnaki 2")
                        .version("OPENAPI_3_0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }

     @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/api/")
                .build();
    }

}
