package com.test.echoandrich.web.api.out;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KgDentistResponseData {

    @JsonProperty("BIZPLC_NM")
    private String businessPlaceName;

    @JsonProperty("REFINE_WGS84_LOGT")
    private String refineWgs84Longitude;

    @JsonProperty("REFINE_ZIP_CD")
    private String refineZipCode;

    @JsonProperty("REFINE_ROADNM_ADDR")
    private String refineRoadNameAddress;

    @JsonProperty("REFINE_LOTNO_ADDR")
    private String refineLotNumberAddress;

    @JsonProperty("TOT_PSN_CNT")
    private int totalPersonCount;

    @JsonProperty("TOT_AR")
    private double totalArea;

    @JsonProperty("TREAT_SBJECT_CONT")
    private String treatmentSubjectContent;

    @JsonProperty("HOSPTLRM_CNT")
    private int hospitalRoomCount;

    @JsonProperty("MEDSTAF_CNT")
    private int medicalStaffCount;

    @JsonProperty("MEDCARE_INST_ASORTMT_NM")
    private String medicalCareInstitutionTypeName;

    @JsonProperty("SICKBD_CNT")
    private int sickbedCount;

    @JsonProperty("LOCPLC_AR")
    private double locationArea;

    @JsonProperty("CLSBIZ_DE")
    private String closureDate;

    @JsonProperty("BSN_STATE_NM")
    private String businessStateName;

    @JsonProperty("LICENSG_DE")
    private String licensingDate;

    @JsonProperty("REFINE_WGS84_LAT")
    private String refineWgs84Latitude;

}
