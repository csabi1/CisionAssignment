package com.cision.assignment.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger configuration class.
 *
 */

@EnableWebMvc
@Configuration 
public class SwaggerConfig implements WebMvcConfigurer {
  /**
   * Returns docket for springfox framework.
   *
   * @return docket
   */
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
    	.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .build();
  }

  /**
   * Add every route to corse mapping.
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**");
  }

}
