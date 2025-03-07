package com.ms.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoappApplication {

  public static void main(String[] args) {
    SpringApplication.run(TodoappApplication.class, args);
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      public void addCorsMappings(CorsRegistry registry) {
        registry
          .addMapping("/**")
          .allowedMethods("*")
          .allowedHeaders("*")
          // .allowedOrigins("http://localhost:5173")
          .allowedOrigins("*");
      }
    };
  }
}
