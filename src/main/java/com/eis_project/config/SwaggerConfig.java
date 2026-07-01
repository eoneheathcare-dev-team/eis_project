package com.eis_project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName   : com.eis_project.config
 * fileName      : SwaggerConfig
 * description   :
 * ====================================================
 * DATE             AUTHOR              NOTE
 * ----------------------------------------------------
 * 26. 6. 23.       어 진              최초생성
 */

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
            String jwtSchemeName = "jwtAuth";

            SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwtSchemeName);

            Components components = new Components()
                    .addSecuritySchemes(jwtSchemeName, new SecurityScheme()
                            .name(jwtSchemeName)
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT"));

            return new OpenAPI()
                    .info(new Info().title("EIS 앱 API 문서").version("1.0"))
                    .addSecurityItem(securityRequirement)
                    .components(components);


        }
}
