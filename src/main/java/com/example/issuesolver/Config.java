//package com.example.issuesolver;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//@Configuration
//public class Config {
//
//    @Bean
//    public CorsWebFilter corsWebFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedOrigins(Collections.singletonList("*"));
//        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
//        config.setAllowedHeaders(Arrays.asList(
//                "Authorization", "x-xsrf-token", "Accept-language", "Access-Control-Allow-Headers",
//                "Origin", "Accept", "X-Requested-With", "userId",
//                "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
//                "Access-Control-Expose-Headers", "X-Session-Id", "X-Platform"));
//        config.setMaxAge(3600L);
//        source.registerCorsConfiguration("/**", config);
//        return new CorsWebFilter(source);
//    }
//}
