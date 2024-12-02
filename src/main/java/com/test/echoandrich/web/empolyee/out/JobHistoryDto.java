package com.test.echoandrich.web.empolyee.out;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class JobHistoryDto {
    private Long employeeId;
    private String jobTitle;
    private String departmentName;
}
