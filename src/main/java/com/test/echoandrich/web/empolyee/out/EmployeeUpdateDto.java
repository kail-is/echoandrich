package com.test.echoandrich.web.empolyee.out;

import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeUpdateDto {
    @NotBlank(message = "이름은 필수입니다")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "성은 필수입니다")
    @Size(min = 2, max = 50)
    private String lastName;

    @Email(message = "유효한 이메일 형식이어야 합니다")
    private String email;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "날짜는 YYYY-MM-DD 형식이어야 합니다")
    private String hireDate;

    @Pattern(regexp = "^\\d{3}.\\d{3,4}.\\d{4}$", message = "올바른 전화번호 형식이 아닙니다")
    private String phoneNumber;

    @Positive(message = "급여는 양수여야 합니다")
    private BigDecimal salary;

    @NotBlank(message = "부서 ID는 필수입니다")
    private String departmentId;

    @NotBlank(message = "직무 ID는 필수입니다")
    private String jobId;

    @DecimalMin(value = "0.0", message = "커미션은 0 이상이어야 합니다")
    @DecimalMax(value = "1.0", message = "커미션은 1 이하여야 합니다")
    private BigDecimal commissionPct;

    private Long managerId;
}