package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.JobHistory;
import com.test.echoandrich.web.empolyee.out.EmployeeCurrentInfoDto;
import com.test.echoandrich.web.empolyee.out.EmployeeUpdateDto;
import com.test.echoandrich.web.empolyee.out.JobHistoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "department.departmentName", target = "departmentName")
    @Mapping(source = "job.jobTitle", target = "jobTitle")
    EmployeeCurrentInfoDto toCurrentInfoDto(Employee employee);

    @Mapping(source = "jobHistoryId.employeeId", target = "employeeId")
    @Mapping(source = "job.jobTitle", target = "jobTitle")
    @Mapping(source = "department.departmentName", target = "departmentName")
    JobHistoryDto toJobHistoryDto(JobHistory jobHistory);

    List<JobHistoryDto> toJobHistoryDtoList(List<JobHistory> jobHistories);

    default Employee updateEmployeeFromDto(EmployeeUpdateDto dto, Employee existingEmployee) {
        return Employee.of(
                existingEmployee.getEmployeeId(),
                dto.getFirstName() != null ? dto.getFirstName() : existingEmployee.getFirstName(),
                dto.getLastName() != null ? dto.getLastName() : existingEmployee.getLastName(),
                dto.getEmail() != null ? dto.getEmail() : existingEmployee.getEmail(),
                dto.getPhoneNumber() != null ? dto.getPhoneNumber() : existingEmployee.getPhoneNumber(),
                existingEmployee.getHireDate(),
                existingEmployee.getJob(),
                dto.getSalary() != null ? dto.getSalary().doubleValue() : existingEmployee.getSalary(),
                existingEmployee.getCommissionPct(),
                existingEmployee.getManager(),
                existingEmployee.getDepartment()
        );
    }
}