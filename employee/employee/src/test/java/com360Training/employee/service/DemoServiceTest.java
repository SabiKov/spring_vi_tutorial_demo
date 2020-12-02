package com360Training.employee.service;

import com360Training.employee.config.EmployeesConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoServiceTest {

    @Test
    void sayHelloTest() {
        //Given
        EmployeesConfig employeesConfig = new EmployeesConfig();
        employeesConfig.setMessage("Hello Spring Boot");
        DemoService demoService = new DemoService(employeesConfig);
        //When
        String message = demoService.sayHello();
        //Then
        assertTrue(message.startsWith("Spring Boot Hello from service"));
    }
}
