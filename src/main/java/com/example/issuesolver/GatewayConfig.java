package com.example.issuesolver;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.GatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.pattern.PathPatternParser;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-ms-auths", r -> r.path("/api/Auths/**")
                        .filters(f -> f.stripPrefix(1).filter(corsFilter()))
                        .uri("https://govermentauthapi20240708181106.azurewebsites.net/"))
                .route("auth-ms-roles", r -> r.path("/api/Roles/**")
                        .filters(f -> f.stripPrefix(1).filter(corsFilter()))
                        .uri("https://govermentauthapi20240708181106.azurewebsites.net/"))
                .route("auth-ms-users", r -> r.path("/api/Users/**")
                        .filters(f -> f.stripPrefix(1).filter(corsFilter()))
                        .uri("https://govermentauthapi20240708181106.azurewebsites.net/"))
                .route("admin-ms-organizations", r -> r.path("/api/Organizations/**")
                        .filters(f -> f.stripPrefix(1).filter(corsFilter()))
                        .uri("https://adminapi20240708182629.azurewebsites.net/"))
                .route("admin-ms-staffs", r -> r.path("/api/Staffs/**")
                        .filters(f -> f.stripPrefix(1).filter(corsFilter()))
                        .uri("https://adminapi20240708182629.azurewebsites.net/"))
                .route("request-ms-requests", r -> r.path("/request/**")
                        .filters(f -> f.stripPrefix(0).filter(corsFilter()))
                        .uri("https://request-ms-d25203bd24ff.herokuapp.com/"))
                .route("request-ms-categories", r -> r.path("/category/**")
                        .filters(f -> f.stripPrefix(0).filter(corsFilter()))
                        .uri("https://request-ms-d25203bd24ff.herokuapp.com/"))
                .route("request-ms-likes", r -> r.path("/api/v1/likes/**")
                        .filters(f -> f.stripPrefix(2).filter(corsFilter()))
                        .uri("https://request-ms-d25203bd24ff.herokuapp.com/"))
                .route("request-ms-comments", r -> r.path("/api/v1/comments/**")
                        .filters(f -> f.stripPrefix(2).filter(corsFilter()))
                        .uri("https://request-ms-d25203bd24ff.herokuapp.com/"))
                .build();
    }

    @Bean
    public GatewayFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Collections.singletonList("*"));
        corsConfig.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "PATCH"));
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedHeaders(Arrays.asList(
                "Authorization", "x-xsrf-token", "Accept-language", "Access-Control-Allow-Headers",
                "Origin", "Accept", "X-Requested-With", "userId",
                "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                "Access-Control-Expose-Headers", "X-Session-Id", "X-Platform"));

        return (exchange, chain) -> {
            exchange.getResponse().getHeaders().add("Access-Control-Allow-Origin", "*");
            exchange.getResponse().getHeaders().addAll("Access-Control-Allow-Methods", Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS", "PATCH"));
            exchange.getResponse().getHeaders().add("Access-Control-Max-Age", "3600");
            exchange.getResponse().getHeaders().addAll("Access-Control-Allow-Headers", Arrays.asList(
                    "Authorization", "x-xsrf-token", "Accept-language", "Access-Control-Allow-Headers",
                    "Origin", "Accept", "X-Requested-With", "userId",
                    "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                    "Access-Control-Expose-Headers", "X-Session-Id", "X-Platform"
            ));
            return chain.filter(exchange);
        };
    }
}
