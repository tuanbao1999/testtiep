package com.example.demo.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Cho phép tất cả origin
                        .allowedMethods("*") // Cho phép tất cả method: GET, POST, PUT, DELETE, etc.
                        .allowedHeaders("*") // Cho phép tất cả headers
                        .allowCredentials(false) // Nếu để true thì không được dùng allowedOrigins("*")
                        .maxAge(3600);
            }
        };
    }
}