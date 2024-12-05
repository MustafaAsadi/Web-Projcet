package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    // Define CommandLineRunner bean
    @Bean
    CommandLineRunner commandLineRunner(CarRepository repo) {
        return args -> {
            Cars x = new Cars("abdallah", "GB",55L, "BYD", 11234.0);
            repo.save(x);
        };
    }
}