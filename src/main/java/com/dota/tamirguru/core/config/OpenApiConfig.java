/*
 * @author : Oguz Kahraman
 * @since : 10.12.2020
 * <p>
 * Copyright - analytics
 **/
package com.dota.tamirguru.core.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

@Configuration
public class OpenApiConfig {

    private static final String API_KEY = "apiKey";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(API_KEY, apiKeySecuritySchema())) // define the apiKey SecuritySchema
                .info(new Info().title("Tamir Guru APP").description(
                        "Tamir Guru App Java API Swagger Document"))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY))); // then apply it. If you don't apply it will not be added to the header in cURL
    }

    @Bean
    @Profile("test")
    public OpenAPI customTestOpenAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("https://api.tamirguru.com"))
                .components(new Components()
                        .addSecuritySchemes(API_KEY, apiKeySecuritySchema())) // define the apiKey SecuritySchema
                .info(new Info().title("Tamir Guru APP").description(
                        "Tamir Guru App Java API Swagger Document"))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY))); // then apply it. If you don't apply it will not be added to the header in cURL
    }

    public SecurityScheme apiKeySecuritySchema() {
        return new SecurityScheme()
                .name("Authorization") // authorisation-token
                .description("Jwt value")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.APIKEY);
    }


}
