package com.store.app;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ComputerStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerStoreApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.paths(PathSelectors.ant("/*"))
//				.apis(RequestHandlerSelectors.basePackage("src/main/java"))
				.build()
				.apiInfo(ApiDetails());
	}
	
	private ApiInfo ApiDetails() {
		return new ApiInfo(
				"Computer Store App",
				"Revature P2 Project",
				"1.0",
				"Free to use",
				new springfox.documentation.service.Contact("Revature", "https://revature.com", "info@revature.com"),
				"API License",
				"https://revature.com",
				Collections.emptyList());
	}

}
