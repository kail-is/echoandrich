package com.test.echoandrich.web.api;

import com.test.echoandrich.web.api.list.DgDentistApi;
import com.test.echoandrich.web.api.list.DjDentistApi;
import com.test.echoandrich.web.api.list.KgDentistApi;
import com.test.echoandrich.web.api.out.DentistResponseDto;
import com.test.echoandrich.web.api.out.DgDentistResponseData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OpenApiService {

    @Value("${dg.api.key}")
    private String dgApiKey;

    @Value("${kg.api.key}")
    private String kgApiKey;

    public List<DentistResponseDto> getDentistList(String pageNo, String pageNum, DentistRegion dentistRegion) {
        return switch (dentistRegion) {
            case DG -> filterAndPaginateDentist(dgDentistApi.getDentistList("1", "1000", dgApiKey).getData(), pageNo, pageNum);
//           // TODO KG text/html 반환 처리 필요
            case KG -> mapToDto(kgDentistApi.getDentistList(pageNo, pageNum, kgApiKey, "json").getDentistryPrivateHospital().get(0).getRow(), dentistMapper::kgToDto);
            case DJ -> mapToDto(djDentistApi.getDentistList(pageNo, pageNum).getResponse().getBody().getItems(), dentistMapper::djToDto);
            default -> throw new IllegalArgumentException("Invalid region: " + dentistRegion);
        };
    }

    private <T> List<DentistResponseDto> mapToDto(List<T> responses, Function<T, DentistResponseDto> mapper) {
        return responses.stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

    private List<DentistResponseDto> filterAndPaginateDentist(List<DgDentistResponseData> data, String pageNo, String pageNum) {
        return data.stream()
                .filter(d -> "치과의원".equals(d.getType()))
                .skip((Long.parseLong(pageNo) - 1) * Long.parseLong(pageNum))
                .limit(Long.parseLong(pageNum))
                .map(dentistMapper::dgToDto)
                .collect(Collectors.toList());
    }


    private final DgDentistApi dgDentistApi;
    private final DjDentistApi djDentistApi;
    private final KgDentistApi kgDentistApi;
    private final DentistMapper dentistMapper = DentistMapper.INSTANCE;


    public OpenApiService(DgDentistApi dgDentistApi, DjDentistApi djDentistApi, KgDentistApi kgDentistApi) {
        this.dgDentistApi = dgDentistApi;
        this.djDentistApi = djDentistApi;
        this.kgDentistApi = kgDentistApi;
    }


}
