package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Configurations {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          //.paths(PathSelectors.any())
          .paths(PathSelectors.ant("/api/**"))
          //.apis(RequestHandlerSelectors.basePackage("com.example"))
          .build()
          .apiInfo( metadata() );
    }
	
	private ApiInfo metadata() {
	    return new ApiInfoBuilder()
	            .title( "SpringBoot REST API" )
	            .description( "Demonstration of REST services using spring boot by Dibas Nag." )
	            .contact(new Contact("Dibas Nag", "dibasnag.com", "dibasnag@gmail.com"))
	            .version( "1.0.0" )
	            .build();
	}
	
}
