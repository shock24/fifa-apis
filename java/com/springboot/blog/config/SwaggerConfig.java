package com.springboot.blog.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import springfox.documentation.service.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	
	public static final String AUTHORIZATION_HEADER = "Authorization";
	
	private ApiKey apiKeys()
	{
		return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	}
	
	private List<SecurityContext> securityContextsList()
	{
		return Arrays.asList(SecurityContext.builder().securityReferences(securityReferenceList()).build());
	}
	
	private List<SecurityReference> securityReferenceList()
	{
		AuthorizationScope scope = new AuthorizationScope("global", "Access Everything");
		
		return Arrays.asList(new SecurityReference("JWT", new AuthorizationScope[] {scope}));
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.securityContexts(securityContextsList())
				.securitySchemes(Arrays.asList(apiKeys()))
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@SuppressWarnings("deprecation")
	private ApiInfo getInfo() {
		return new ApiInfo("Blogging Application: Backend Course", "This project contains blogging APIs for backend management", "1.0", "terms of service", new Contact("Arpit Awasthi", "https://backendApi.com", "arpitawasthi.14@gmail.com"), "License of APIs", "API license URL", Collections.emptyList());
	}

}
