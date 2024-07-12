package com.example.issuesolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class IssueSolverApplication {

    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(IssueSolverApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("PORT")));
//        app.run(args);
        SpringApplication.run(IssueSolverApplication.class, args);
    }

}
