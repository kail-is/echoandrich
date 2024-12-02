package com.test.echoandrich.web.api.out;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class DgDentistResponse {

    private String currentCount;
    private List<DgDentistResponseData> data;
    private String matchCount;
    private String page;
    private String perPage;
    private String totalCount;
}
