package com360Training.employee.controller;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com360Training.employee.dto.EmployeeDto;
import com360Training.employee.service.EmployeesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@WebMvcTest(controllers = EmployeesController.class)
public class EmployeesControllerIT {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmployeesService employeesService;

    @Test
    void testFindAll() throws Exception {
        when(employeesService.findAll(any()))
                .thenReturn(List.of(new EmployeeDto(1L, "Test Doe"),
                        new EmployeeDto(2L, "Jack Test")));

        mockMvc.perform(get("/api/employees"))
                //        .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("[1].name", equalTo("Jack Test")));
    }
}
