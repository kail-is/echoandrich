package com.test.echoandrich.web.api.out;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DjDentistResponseData {

    @JsonProperty("rn_adrs")
    private String roadAddress;

    @JsonProperty("mdlc_instt_nm")
    private String name;

    @JsonProperty("mdlc_instt_asort_nm")
    private String type;

    @JsonProperty("sn")
    private int serialNumber;

    @JsonProperty("lnm_adrs")
    private String lotAddress;

    @JsonProperty("telno")
    private String telNo;

}
