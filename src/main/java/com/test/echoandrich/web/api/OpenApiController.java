package com.test.echoandrich.web.api;

import com.test.echoandrich.config.ApiResponse;
import com.test.echoandrich.config.SuccessResponse;
import com.test.echoandrich.web.api.out.DentistResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name = "OpenAPI", description = "외부 API 연동")
@AllArgsConstructor
@RestController
public class OpenApiController {

    private final OpenApiService openApiService;

    /**
     * 주어진 페이지 번호와 지역에 따라 치과 목록을 검색합니다.
     *
     * @param pageNo 페이지 번호
     * @param pageNum 페이지 크기
     * @param region 치과 지역
     * @return ApiResponse 객체를 포함한 ResponseEntity
     */

    @Operation(summary = "치과 검색", description = "페이지 번호와 지역으로 치과를 검색합니다")
    @Parameters({
        @Parameter(name = "pageNo", description = "페이지 번호", required = true),
        @Parameter(name = "pageNum", description = "페이지당 결과 수", required = true),
        @Parameter(name = "region", description = "검색할 지역 코드", required = true)
    })
    @GetMapping("/dentist/search")
    public ResponseEntity<ApiResponse> getDentistList(
            @RequestParam @Positive(message = "페이지 번호는 양수여야 합니다") String pageNo,
            @RequestParam @Positive(message = "페이지 크기는 양수여야 합니다") String pageNum,
            @RequestParam @NotNull(message = "지역 코드는 필수입니다") DentistRegion region
    ) {
        List<DentistResponseDto> dto = openApiService.getDentistList(pageNo, pageNum, region);

        SuccessResponse<List<DentistResponseDto>> res = SuccessResponse.of("조회 완료", dto);

        return ResponseEntity.ok(res);
    }

}
