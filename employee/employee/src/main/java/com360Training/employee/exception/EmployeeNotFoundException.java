package com360Training.employee.exception;


import lombok.Getter;

public class EmployeeNotFoundException extends RuntimeException {

    @Getter
    private long id;

    public EmployeeNotFoundException(long id) {
        super("Employee not found with id " + id);
        this.id = id;
    }
}
