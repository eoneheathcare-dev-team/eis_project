package com.eis_project;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "EIS API 문서"))
@SpringBootApplication
public class EisProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EisProjectApplication.class, args);
    }

}
