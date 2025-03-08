package com.mmt.tracker.maple.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("메이플스토리 캐릭터 정보 API")
                                .description("메이플스토리 캐릭터의 장비 정보를 조회하는 API")
                                .version("v1.0.0"));
    }
}
