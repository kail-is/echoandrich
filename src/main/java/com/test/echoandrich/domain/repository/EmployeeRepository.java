package com.test.echoandrich.domain.repository;

import com.test.echoandrich.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentDepartmentId(Long departmentId);

}

