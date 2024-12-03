package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.domain.Department;
import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.Job;
import com.test.echoandrich.domain.repository.DepartmentRepository;
import com.test.echoandrich.domain.repository.EmployeeRepository;
import com.test.echoandrich.domain.repository.JobRepository;
import com.test.echoandrich.web.empolyee.out.EmployeeUpdateDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class EmployeeUpdateMapper {
    private final JobRepository jobRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public Employee updateEmployeeFromDto(EmployeeUpdateDto dto, Employee employee, Job newJob) {
        LocalDate hireDate = LocalDate.parse(dto.getHireDate());

        Employee manager = null;
        Long managerId = dto.getManagerId();

        if(managerId != null) {
            manager = employeeRepository.findById(managerId)
                    .orElseThrow(() -> new EntityNotFoundException("해당하는 매니저가 없습니다. : " + managerId));
        }

        Department department = departmentRepository.findById(Long.parseLong(dto.getDepartmentId()))
                .orElseThrow(() -> new EntityNotFoundException("해당하는 부서가 없습니다."));

        employee.update(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getPhoneNumber(),
                hireDate,
                newJob,
                dto.getSalary().doubleValue(),
                dto.getCommissionPct().doubleValue(),
                manager,
                department
        );
        return employee;
    }
}
