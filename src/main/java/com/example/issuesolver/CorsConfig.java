package com.example.issuesolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "PATCH"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedHeaders(Arrays.asList(
                "Authorization", "x-xsrf-token", "Accept-language", "Access-Control-Allow-Headers",
                "Origin", "Accept", "X-Requested-With", "userId",
                "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                "Access-Control-Expose-Headers", "X-Session-Id", "X-Platform"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
    }
}
