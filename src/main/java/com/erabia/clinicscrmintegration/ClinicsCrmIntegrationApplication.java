package com.erabia.clinicscrmintegration;

import java.util.Collections;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ClinicsCrmIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicsCrmIntegrationApplication.class, args);
	}
	
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.erabia.clinicscrmintegration")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Clinics Client Integration ", " backend api.", null, null, null, "Author :Omar Hisham", "  ",
				Collections.emptyList());
	}

	

}
