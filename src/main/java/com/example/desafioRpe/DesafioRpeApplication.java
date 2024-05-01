package com.example.desafioRpe;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Desafio RPE", version = "1", description = "API desenvolvida para testes do processo seletivo da RPE."))
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		scheme = "bearer"
)
public class DesafioRpeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioRpeApplication.class, args);
	}

}
