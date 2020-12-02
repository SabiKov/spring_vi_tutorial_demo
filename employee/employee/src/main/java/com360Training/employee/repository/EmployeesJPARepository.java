package com360Training.employee.repository;

import com360Training.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesJPARepository extends
        JpaRepository<Employee, Long> {

    //@Query(nativeQuery = true, "")
//    @Query("select e from Employee e where e.name like :prefix")
    //@Query("select distinct e from Employee e left join fetch e.addresses")
//    List<Employee> findAllByNameIsStartingWith(String prefix);
    // select e from Employee e where e.name like %?
}
