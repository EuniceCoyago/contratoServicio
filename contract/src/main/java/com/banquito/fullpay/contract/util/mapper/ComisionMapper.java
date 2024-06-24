package com.banquito.fullpay.contract.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.model.Comision;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface ComisionMapper {
    ComisionDTO toDTO(Comision comision);

    Comision toEntity(ComisionDTO comisionDTO);
}
