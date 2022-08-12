package com.example.employeecircuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class EmployeeCircuitApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeCircuitApplication.class, args);
    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

}
