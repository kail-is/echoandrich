package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.domain.Employee;
import com.test.echoandrich.domain.JobHistory;
import com.test.echoandrich.web.empolyee.out.EmployeeCurrentInfoDto;
import com.test.echoandrich.web.empolyee.out.JobHistoryDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(source = "department.departmentName", target = "departmentName")
    @Mapping(source = "job.jobTitle", target = "jobTitle")
    @Mapping(source = "manager.lastName", target = "managerName")
    EmployeeCurrentInfoDto toCurrentInfoDto(Employee employee);

    @Mapping(source = "jobHistoryId.employeeId", target = "employeeId")
    @Mapping(source = "job.jobTitle", target = "jobTitle")
    @Mapping(source = "department.departmentName", target = "departmentName")
    JobHistoryDto toJobHistoryDto(JobHistory jobHistory);

    List<JobHistoryDto> toJobHistoryDtoList(List<JobHistory> jobHistories);

}