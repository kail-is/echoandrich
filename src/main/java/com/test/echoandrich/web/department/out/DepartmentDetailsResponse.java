package com.test.echoandrich.web.department.out;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DepartmentDetailsResponse {
    private Long id;
    private String name;
    private String location;
}
