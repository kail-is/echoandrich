package com.test.echoandrich.web.empolyee.out;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class EmployeeCurrentInfoDto {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private String salary;
    private String commissionPct;
    private String managerName;
    private String departmentName;
    private String jobTitle;
}

