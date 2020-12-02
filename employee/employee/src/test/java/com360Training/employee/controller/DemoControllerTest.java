package com360Training.employee.controller;

import com360Training.employee.service.DemoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DemoControllerTest {

    @Mock
    DemoService demoService;

    @InjectMocks
    DemoController demoController;

    @Test
    void sayHelloTest() {
        //Given
        when(demoService.sayHello()).thenReturn("hello");

        //When
        String message = demoController.hello();

        //Then
        assertEquals("HELLO", message);
    }

    @Test
    void sayHelloWithNullTest() {
        when(demoService.sayHello()).thenReturn(null);

        //When
        String message = demoController.hello();

        assertEquals("", message);
    }
}
