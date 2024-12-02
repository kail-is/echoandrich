package com.test.echoandrich.web.empolyee.out;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeUpdateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private BigDecimal salary;
    private String departmentId;
    private String jobId;
}
