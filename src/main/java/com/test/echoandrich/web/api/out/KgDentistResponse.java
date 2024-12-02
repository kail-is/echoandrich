package com.test.echoandrich.web.api.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class KgDentistResponse {

    @JsonProperty("DentistryPrivateHospital")
    private List<Head> DentistryPrivateHospital;

    @Getter
    @NoArgsConstructor
    public static class Head {
        @JsonProperty("head")
        private List<HeadInfo> head;

        @JsonProperty("row")
        private List<KgDentistResponseData> row;
    }

    @Getter
    @NoArgsConstructor
    public static class HeadInfo {
        @JsonProperty("list_total_count")
        private int listTotalCount;

        @JsonProperty("result")
        private Result result;
    }

    @Getter
    @NoArgsConstructor
    public static class ListTotalCount {
        @JsonProperty("list_total_count")
        private int listTotalCount;
    }

    @Getter
    @NoArgsConstructor
    public static class Result {

        @JsonProperty("CODE")
        private String code;
        @JsonProperty("MESSAGE")
        private String message;

    }

}
