package com.test.echoandrich.web.api;

import com.test.echoandrich.web.api.out.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DentistMapper {
    DentistMapper INSTANCE = Mappers.getMapper(DentistMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "telNo", target = "tel")
    @Mapping(source = "address", target = "address")
    DentistResponseDto dgToDto(DgDentistResponseData data);

    @Mapping(source = "businessPlaceName", target = "name")
    @Mapping(source = "refineLotNumberAddress", target = "address")
    DentistResponseDto kgToDto(KgDentistResponseData kmResponse);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "lotAddress", target = "address")
    @Mapping(source = "telNo", target = "tel")
    DentistResponseDto djToDto(DjDentistResponseData kmResponse);
}
