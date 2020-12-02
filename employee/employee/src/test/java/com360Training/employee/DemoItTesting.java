package com360Training.employee;

import com360Training.employee.controller.DemoController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DemoItTesting {


    @Autowired
    DemoController demoController;

    @Test
    void sayHelloTest() {
        String msg = demoController.hello();
        assertThat(msg).startsWith("SPRING BOOT HELLO");
    }
}
