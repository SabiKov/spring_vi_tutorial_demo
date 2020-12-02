package com360Training.employee.service;

import com360Training.employee.config.EmployeesConfig;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@EnableConfigurationProperties(EmployeesConfig.class)
@AllArgsConstructor
public class DemoService {

    private EmployeesConfig employeesConfig;

    //private String welcome;

    // SPEL = Spring Expression Language
//    public HelloService(@Value("${employees.welcome.message}") String welcome) {
//        this.welcome = welcome;
//    }

    public String sayHello() {
       return "Spring Boot Hello from service: " + Instant.now();
    }
}
