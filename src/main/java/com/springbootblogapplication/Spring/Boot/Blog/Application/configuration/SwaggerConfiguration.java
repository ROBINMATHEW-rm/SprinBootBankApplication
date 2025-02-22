//package com.springbootblogapplication.Spring.Boot.Blog.Application.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//    @Bean
//    public Docket studentApi(){
//        return new Docket(DocumentationType.SWAGGER_2).select().
//                apis(RequestHandlerSelectors.basePackage("com.springbootblogapplication.Spring.Boot.Blog.Application")).
//                build().apiInfo(getApiInfo());
//    }
//    private ApiInfo getApiInfo(){
//        return  new ApiInfoBuilder()
//                .title("Bank-Application-System")
//                .description("Bank Application Api")
//                .version("V1.2")
//                .termsOfServiceUrl("http://terms-of-services.url")
//                .license("LICENSE")
//                .licenseUrl("http://url-to-license.com")
//                .build();
//    }
//}
