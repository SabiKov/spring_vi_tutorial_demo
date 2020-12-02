package com360Training.employee.controller;

import com360Training.employee.dto.CreateEmployeeCommand;
import com360Training.employee.dto.EmployeeDto;
import com360Training.employee.dto.UpdateEmployeeCommand;
import com360Training.employee.exception.EmployeeNotFoundException;
import com360Training.employee.service.EmployeesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeesController {

    private final EmployeesService employeesService;

    @GetMapping
    public List<EmployeeDto> findAll(@RequestParam Optional<String> prefix) {
        return employeesService.findAll(prefix);
    }


    @Operation(summary = "Find employee by id",
            description = "Find employee by id.")
    @ApiResponse(responseCode = "200",
            description = "Employee has been found")
    @ApiResponse(responseCode = "404",
            description = "Employee not found")
    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable long id) {
        return employeesService.findById(id);
    }

    @PostMapping
    public EmployeeDto create(@Valid @RequestBody CreateEmployeeCommand command) {
        return employeesService.create(command);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable long id, @RequestBody UpdateEmployeeCommand command) {
        return employeesService.update(id, command);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        employeesService.delete(id);
    }

 //   @ExceptionHandler(EmployeeNotFoundException.class)
 //   @ResponseStatus(HttpStatus.NOT_FOUND)
 //   public void handleIllegalArgumentException(EmployeeNotFoundException e) {
 //       System.out.println("Error");
//    }
}