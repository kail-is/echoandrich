package com.test.echoandrich.web.empolyee;

import com.test.echoandrich.config.ApiResponse;
import com.test.echoandrich.config.SuccessResponse;
import com.test.echoandrich.web.empolyee.out.EmployeeCurrentInfoDto;
import com.test.echoandrich.web.empolyee.out.EmployeeUpdateDto;
import com.test.echoandrich.web.empolyee.out.JobHistoryDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    /**
     * 특정 사원의 현재 정보를 조회합니다.
     *
     * @param employeeId 사원의 ID
     * @return 사원의 현재 정보를 포함하는 ResponseEntity
     */
    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse> getEmployeeCurrentInfo(@PathVariable Long employeeId) {

        EmployeeCurrentInfoDto employeeInfo = employeeService.getCurrentEmployeeInfo(employeeId);

        SuccessResponse<EmployeeCurrentInfoDto> successResponse = SuccessResponse.of("200 조회 완료", employeeInfo);

        return ResponseEntity.ok(successResponse);
    }

    /**
     * 특정 사원의 이력 정보를 조회합니다.
     *
     * @param employeeId 사원의 ID
     * @return 사원의 이력 정보를 포함하는 ResponseEntity
     */
    @GetMapping("/{employeeId}/history")
    public ResponseEntity<ApiResponse> getEmployeeJobHistory(
            @PathVariable Long employeeId) {

        List<JobHistoryDto> jobHistories = employeeService.getEmployeeJobHistory(employeeId);

        SuccessResponse<List<JobHistoryDto>> successResponse = SuccessResponse.of("200 조회 완료", jobHistories);

        return ResponseEntity.ok(successResponse);
    }

    /**
     * 특정 사원의 정보를 업데이트합니다.
     *
     * @param employeeId 사원의 ID
     * @param updateDto 업데이트할 사원 정보
     * @return 업데이트된 사원 정보를 포함하는 ResponseEntity
     */
    @PutMapping("/{employeeId}")
    public ResponseEntity<ApiResponse> updateEmployee(
            @PathVariable Long employeeId,
            @RequestBody @Valid EmployeeUpdateDto updateDto) {

        EmployeeCurrentInfoDto updatedEmployee = employeeService.updateEmployee(employeeId, updateDto);
        SuccessResponse<EmployeeCurrentInfoDto> res = SuccessResponse.of("200 업데이트 완료", updatedEmployee);

        return ResponseEntity.ok(res);
    }

    private final EmployeeService employeeService;

}