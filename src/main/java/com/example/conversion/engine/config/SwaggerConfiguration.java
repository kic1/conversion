package com.example.conversion.engine.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket swagger() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				                           .select ()
				                           .apis   (RequestHandlerSelectors.any())
				                           .paths  (PathSelectors.ant("/api/**"))
				                           .build  ()
				                           .useDefaultResponseMessages(false)
				                           .globalResponseMessage(RequestMethod.GET,    responseMessages)
				                           .globalResponseMessage(RequestMethod.POST,   responseMessages)
				                           .globalResponseMessage(RequestMethod.DELETE, responseMessages)
				                           .globalResponseMessage(RequestMethod.PUT,    responseMessages)
				                           .globalResponseMessage(RequestMethod.PATCH,  responseMessages)
				                           .apiInfo(metaData());
	}
    
	private ApiInfo metaData() {
        return new ApiInfoBuilder().title  ("conversion API specification")
        		                   .version("1.0")
                                   .build  ();
    }
	
	List<ResponseMessage> responseMessages = Arrays.asList(
		new ResponseMessageBuilder().code(          HttpStatus.OK.value()).message(          HttpStatus.OK.getReasonPhrase()).build(), // 200
		new ResponseMessageBuilder().code(  HttpStatus.NO_CONTENT.value()).message(  HttpStatus.NO_CONTENT.getReasonPhrase()).build(), // 204
		new ResponseMessageBuilder().code( HttpStatus.BAD_REQUEST.value()).message( HttpStatus.BAD_REQUEST.getReasonPhrase()).build(), // 400
		new ResponseMessageBuilder().code(HttpStatus.UNAUTHORIZED.value()).message(HttpStatus.UNAUTHORIZED.getReasonPhrase()).build(), // 401
		new ResponseMessageBuilder().code(        HttpStatus.GONE.value()).message(        HttpStatus.GONE.getReasonPhrase()).build()  // 410
    );
}
