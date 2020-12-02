package com360Training.employee.service;

import com360Training.employee.dto.CreateEmployeeCommand;
import com360Training.employee.dto.EmployeeDto;
import com360Training.employee.dto.UpdateEmployeeCommand;
import com360Training.employee.exception.EmployeeNotFoundException;
import com360Training.employee.gateway.AddressesGateway;
import com360Training.employee.repository.EmployeesJPARepository;
import lombok.AllArgsConstructor;
import com360Training.employee.entity.*;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeesService {

 //   private final EmployeesJDBCRepository employeesJDBCRepository;
    private final EmployeesJPARepository employeesJPARepository;

//    private static final AtomicLong idGenerator = new AtomicLong();
//
//    private static final List<Employee> employees =
//            new ArrayList<>(List.of(new Employee(idGenerator.incrementAndGet(), "John Doe"),
//                    new Employee(idGenerator.incrementAndGet(), "Jane Doe")));
//
    private AddressesGateway addressesGateway;
    private final ModelMapper modelMapper;
//
//    public List<EmployeeDto> findAll(Optional<String> prefix) {
//        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
//        return modelMapper.map(employees.stream()
//                        .filter(e -> prefix.isEmpty() || e.getName().startsWith(prefix.get()))
//                        .collect(Collectors.toList())
//                , targetListType);
//    }
//
//    public EmployeeDto findById(long id) {
//        return employees.stream()
//                .filter(e -> e.getId() == id)
//                .map(e -> modelMapper.map(e, EmployeeDto.class))
//                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
//    }
//
//    public EmployeeDto create(CreateEmployeeCommand command) {
//        Employee employee = new Employee(idGenerator.incrementAndGet(), command.getName());
//        employees.add(employee);
//        return modelMapper.map(employee, EmployeeDto.class);
//    }
//
//    public EmployeeDto update(long id, UpdateEmployeeCommand command) {
//        Employee employee = employees.stream()
//                .filter(e -> e.getId() == id)
//                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
//        employee.setName(command.getName());
//        return modelMapper.map(employee, EmployeeDto.class);
//    }
//
//    public void delete(long id) {
//        Employee employee = employees.stream()
//                .filter(e -> e.getId() == id)
//                .findAny().orElseThrow(() -> new EmployeeNotFoundException(id));
//        employees.remove(employee);
//    }
//
//    public void clear() {
//        employees.clear();
//    }
//    public List<EmployeeDto> findAll(Optional<String> prefix) {
//        java.lang.reflect.Type targetListType = new TypeToken<List<EmployeeDto>>() {}.getType();
//        return modelMapper.map(employeesJDBCRepository.findAll(), targetListType);
//    }
//
//    public EmployeeDto findById(long id) {
//        return modelMapper.map(employeesJDBCRepository.findById(id), EmployeeDto.class);
//    }
//
//    public EmployeeDto create(CreateEmployeeCommand command) {
//        log.info("Create employee");
//        log.debug("Create employee with name" + command.getName());
//        log.debug("Create employee with name" + command.getName());
//        Employee employee = new Employee(command.getName());
//        employeesJDBCRepository.create(employee);
//        return modelMapper.map(employee, EmployeeDto.class);
//    }
//
//    public EmployeeDto update(long id, UpdateEmployeeCommand command) {
//        employeesJDBCRepository.update(id, command.getName());
//
//        Employee employee = new Employee(id, command.getName());
//
//        return modelMapper.map(employee, EmployeeDto.class);
//    }
//
//    public void delete(long id) {
//        employeesJDBCRepository.delete(id);
//    }
//
//    public void clear() {
//        //TODO Teszthez kell
//    }

    public List<EmployeeDto> findAll(Optional<String> prefix) {
        java.lang.reflect.Type targetListType =
                new TypeToken<List<EmployeeDto>>() {}.getType();
        return modelMapper.map(employeesJPARepository.findAll(), targetListType);
    }

//    public EmployeeDto findById(long id) {
//        return modelMapper.map(employeesJPARepository.findById(id)
//                        .orElseThrow(() -> new EmployeeNotFoundException(id))
//                , EmployeeDto.class);
//    }

    public EmployeeDto findById(long id) {
                EmployeeDto result =  modelMapper
                        .map(employeesJPARepository.findById(id)
                                        .orElseThrow(() -> new EmployeeNotFoundException(id)),
                                EmployeeDto.class);

        result.setAddressDto(addressesGateway.getAddress(result.getName()));

        return result;
    }

    public EmployeeDto create(CreateEmployeeCommand command) {
        log.info("Create employee");
        log.debug("Create employee with name" + command.getName());
        log.debug("Create employee with name" + command.getName());
        Employee employee = new Employee(command.getName());
        employeesJPARepository.save(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Transactional
    public EmployeeDto update(long id, UpdateEmployeeCommand command) {
        Employee employee = employeesJPARepository
                .findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(id));
        employee.setName(command.getName());
        return modelMapper.map(employee, EmployeeDto.class);
    }

    public void delete(long id) {
        employeesJPARepository.deleteById(id);
    }

    public void clear() {
        //TODO Teszthez kell
    }
}