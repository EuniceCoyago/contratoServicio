package com.banquito.fullpay.contract.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.model.Servicio;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)public interface ServicioMapper {
    ServicioDTO toDTO(Servicio servicio);
    Servicio toEntity(ServicioDTO servicioDTO);
}
