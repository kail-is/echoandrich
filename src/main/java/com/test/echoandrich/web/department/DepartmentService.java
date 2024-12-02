package com.test.echoandrich.web.department;

import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.repository.DepartmentRepository;
import com.test.echoandrich.domain.repository.EmployeeRepository;
import com.test.echoandrich.web.department.out.DepartmentDetailsResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public List<DepartmentDetailsResponse> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(d -> new DepartmentDetailsResponse(d.getDepartmentId(), d.getDepartmentName(), d.getLocation().getCity()))
                .collect(Collectors.toList());
    }

    public void updateSalary(Long departmentId, Double percentage) {

        departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 부서가 없습니다."));

        List<Employee> employees = employeeRepository.findByDepartmentDepartmentId(departmentId);
        for (Employee employee : employees) {
            Double newSalary = employee.getSalary() * (1 + percentage / 100);
            employee.updateSalary(newSalary);
            employeeRepository.save(employee);
        }
    }

}
