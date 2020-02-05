package com.example.unittesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UnitTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingApplication.class, args);
	}

	/**
	 * 
	 * @param docket
	 */

	ResponseMessage getResponseBuilder(HttpStatus httpStatus){
		ResponseMessageBuilder responseMessageBuilder = new ResponseMessageBuilder();
		responseMessageBuilder.code(httpStatus.value())
			.message(httpStatus.getReasonPhrase())
			.build();
		return responseMessageBuilder.build();
	}

   void buildGlobalResponseMessage(Docket docket){
	   List<ResponseMessage> postResponseMessages = new ArrayList<>();
	   postResponseMessages.add(getResponseBuilder(HttpStatus.OK));
	   postResponseMessages.add(getResponseBuilder(HttpStatus.BAD_REQUEST));
   }

	@Bean
	public Docket debitAPI(){
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.unittesting.controller"))
			.paths(PathSelectors.any())
			.build()
			.apiInfo(apiInfo());
		// buildGlobalParameter(docket);
		buildGlobalResponseMessage(docket);
		return docket;
	}

	ApiInfo apiInfo(){
		return new ApiInfo(
			"Unit Testing Service Project",
			"learning junit",
			"v0.1",
			"termsOfServiceUrl",
			new Contact("Me","mySite","myMail"),
			"license",
			"license-url",
			Collections.emptyList()
		);
	}

}
