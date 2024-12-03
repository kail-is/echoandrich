package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.Job;
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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeUpdateMapper employeeUpdateMapper;
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

    @Transactional
    public EmployeeCurrentInfoDto updateEmployee(Long employeeId, EmployeeUpdateDto updateDto) {

        Employee employee = employeesRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 직원이 없습니다. : " + employeeId));


        Long lo = Long.parseLong(updateDto.getDepartmentId());
        departmentRepository.findById(lo)
                .orElseThrow(() -> new EntityNotFoundException("해당하는 부서가 없습니다."));


        Job newJob = jobRepository.findById(updateDto.getJobId())
                .orElseThrow(() -> new EntityNotFoundException("해당하는 직무가 없습니다."));

        updateJobHistory(employee, updateDto, newJob);

        Employee updatedEmployee = employeeUpdateMapper.updateEmployeeFromDto(updateDto, employee, newJob);

        employeesRepository.save(updatedEmployee);

        return employeeMapper.toCurrentInfoDto(updatedEmployee);
    }

    @Transactional
    private void updateJobHistory(Employee employee, EmployeeUpdateDto updateDto, Job newJob) {

        if(employee.getJob() == newJob) {
            return;
        }

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate endOfTime = LocalDate.of(2999, 12, 31);

        jobHistoryRepository.findFirstByJobHistoryId_EmployeeIdOrderByJobHistoryId_StartDateDesc(
                employee.getEmployeeId()
        ).ifPresent(currentJobHistory -> {
            JobHistory updatedJobHistory = JobHistory.of(
                    employee,
                    currentJobHistory.getJobHistoryId().getStartDate(),
                    yesterday,
                    currentJobHistory.getJob(),
                    currentJobHistory.getDepartment()
            );

            jobHistoryRepository.save(updatedJobHistory);
        });


        JobHistory newJobHistory = JobHistory.of(
                employee,
                today,
                endOfTime,
                newJob,
                updateDto.getDepartmentId() != null ?
                        departmentRepository.findById(Long.parseLong(updateDto.getDepartmentId())).orElse(employee.getDepartment())
                        : employee.getDepartment()
        );

        log.info("새로 생성된 JobHistory ID: employeeId={}, startDate={}",
                newJobHistory.getJobHistoryId().getEmployeeId(),
                newJobHistory.getJobHistoryId().getStartDate());

        jobHistoryRepository.save(newJobHistory);
    }
}