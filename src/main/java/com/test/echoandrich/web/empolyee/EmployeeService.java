package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.JobHistory;
import com.test.echoandrich.domain.repository.DepartmentRepository;
import com.test.echoandrich.domain.repository.EmployeeRepository;
import com.test.echoandrich.domain.repository.JobHistoryRepository;
import com.test.echoandrich.domain.repository.JobRepository;
import com.test.echoandrich.web.empolyee.out.EmployeeCurrentInfoDto;
import com.test.echoandrich.web.empolyee.out.EmployeeUpdateDto;
import com.test.echoandrich.web.empolyee.out.JobHistoryDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeesRepository;
    private final JobHistoryRepository jobHistoryRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;


    public EmployeeCurrentInfoDto getCurrentEmployeeInfo(Long employeeId) {
        Employee employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 직원이 없습니다. : " + employeeId));

        return employeeMapper.toCurrentInfoDto(employee);
    }


    public List<JobHistoryDto> getEmployeeJobHistory(Long employeeId) {
        List<JobHistory> jobHistories = jobHistoryRepository.findByJobHistoryId_EmployeeId(employeeId);

        return employeeMapper.toJobHistoryDtoList(jobHistories);
    }

    public EmployeeCurrentInfoDto updateEmployee(Long employeeId, EmployeeUpdateDto updateDto) {

        Employee employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 직원이 없습니다. : " + employeeId));


        if (updateDto.getDepartmentId() != null) {
            Long lo = Long.parseLong(updateDto.getDepartmentId());
            departmentRepository.findById(lo)
                    .orElseThrow(() -> new EntityNotFoundException("해당하는 부서가 없습니다."));
        }


        if (updateDto.getJobId() != null) {
            jobRepository.findById(updateDto.getJobId())
                    .orElseThrow(() -> new EntityNotFoundException("해당하는 직무가 없습니다."));
        }

        Employee updatedEmployee = employeeMapper.updateEmployeeFromDto(updateDto, employee);

        employeesRepository.save(updatedEmployee);

        return employeeMapper.toCurrentInfoDto(updatedEmployee);
    }


}
