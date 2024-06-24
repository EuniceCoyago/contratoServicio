package com.banquito.fullpay.contract.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.model.Servicio;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ServicioMapper {
    @Mapping(source = "contrato.codContrato", target = "codContrato")
    ServicioDTO toDTO(Servicio servicio);

    @Mapping(source = "codContrato", target = "contrato.codContrato")
    Servicio toEntity(ServicioDTO servicioDTO);
}
