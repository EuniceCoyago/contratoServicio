package com.banquito.fullpay.contract.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.contract.dto.ServicioComisionDTO;
import com.banquito.fullpay.contract.model.ServicioComision;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)public interface ServicioComisionMapper {
    ServicioComisionDTO toDTO(ServicioComision servicioComision);
    ServicioComision toEntity(ServicioComisionDTO servicioComisionDTO);
}
