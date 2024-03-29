package com.cde.rest.services.restservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	public static final Contact DEFAULT_CONTACT = new Contact("CDE", "CDE", "CDE@CDE.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
			"Rest Api Title", "Rest Api Documentation", "1.0",
			"urn:tos",
	        DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", 
	        new ArrayList<VendorExtension>());
	public static final HashSet<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
	
	@Bean
	public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .apiInfo(DEFAULT_API_INFO)
          .produces(DEFAULT_PRODUCES_AND_CONSUMES)
          .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())
          .build();                                           
    }
}
