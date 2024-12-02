package com.test.echoandrich.web.api;

import com.test.echoandrich.config.ApiResponse;
import com.test.echoandrich.config.SuccessResponse;
import com.test.echoandrich.web.api.out.DentistResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class OpenApiController {

    private final OpenApiService openApiService;

    /**
     * 주어진 페이지 번호와 지역에 따라 치과 의사 목록을 검색합니다.
     *
     * @param pageNo 페이지 번호
     * @param pageNum 페이지 크기
     * @param region 치과 의사 지역
     * @return ApiResponse 객체를 포함한 ResponseEntity
     */
    @GetMapping("/dentist/search")
    public ResponseEntity<ApiResponse> getDentistList(@RequestParam String pageNo,
                                                      @RequestParam String pageNum,
                                                      @RequestParam DentistRegion region) {

        List<DentistResponseDto> dto = openApiService.getDentistList(pageNo, pageNum, region);

        SuccessResponse<List<DentistResponseDto>> res = SuccessResponse.of("200 조회 완료", dto);

        return ResponseEntity.ok(res);
    }

}
