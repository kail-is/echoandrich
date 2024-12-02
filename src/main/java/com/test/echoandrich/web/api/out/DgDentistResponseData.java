package com.test.echoandrich.web.api.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DgDentistResponseData {

    @JsonProperty("기준일자")
    private String baseDate;

    @JsonProperty("연번")
    private int serialNumber;

    @JsonProperty("의료기관명")
    private String name;

    @JsonProperty("의료기관전화번호")
    private String telNo;

    @JsonProperty("의료기관종별")
    private String type;

    @JsonProperty("의료기관주소(도로명)")
    private String address;

}
