package com.banquito.fullpay.contract.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.contract.dto.ServicioComisionDTO;
import com.banquito.fullpay.contract.model.ServicioComision;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServicioComisionMapper {

    @Mapping(source = "id.codServicio", target = "codServicio")
    @Mapping(source = "id.codComision", target = "codComision")
    ServicioComisionDTO toDTO(ServicioComision servicioComision);

    @Mapping(source = "codServicio", target = "id.codServicio")
    @Mapping(source = "codComision", target = "id.codComision")
    ServicioComision toEntity(ServicioComisionDTO servicioComisionDTO);
}