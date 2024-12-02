package com.test.echoandrich.web.department;

import com.test.echoandrich.config.ApiResponse;
import com.test.echoandrich.config.SuccessResponse;
import com.test.echoandrich.web.department.out.DepartmentDetailsResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Department", description = "부서 관리")
@AllArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    /**
     * 모든 부서의 정보를 조회합니다.
     *
     * @return 부서 정보를 포함하는 ResponseEntity
     */
    @Operation(summary = "부서 목록 조회", description = "모든 부서 정보를 조회합니다")
    @GetMapping
    public ResponseEntity<ApiResponse> getDepartments() {
        List<DepartmentDetailsResponse> departments = departmentService.getAllDepartments();
        SuccessResponse<List<DepartmentDetailsResponse>> successResponse
                = SuccessResponse.of("조회 완료", departments);

        return ResponseEntity.ok(successResponse);
    }

    /**
     * 특정 부서의 급여를 특정 비율로 인상합니다.
     *
     * @param departmentId 부서의 ID
     * @param percentage 인상 비율
     * @return 성공 여부를 나타내는 ResponseEntity
     */
    @Operation(summary = "부서 급여 인상", description = "특정 부서의 급여를 인상합니다")
    @Parameter(name = "departmentId", description = "부서 ID")
    @Parameter(name = "percentage", description = "인상 비율(%)")
    @PostMapping("/salary")
    public ResponseEntity<ApiResponse> updateSalary(
            @RequestParam @Positive(message = "부서 ID는 양수여야 합니다.") Long departmentId,
            @RequestParam @Positive(message = "인상률은 양수여야 합니다.") Double percentage
    ) {
        departmentService.updateSalary(departmentId, percentage);
        SuccessResponse<String> successResponse = SuccessResponse.of("급여 인상이 완료되었습니다.");

        return ResponseEntity.ok(successResponse);
    }
}
