package com.banquito.fullpay.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor

public class ServicioComisionDTO {
    private Long codServicio;
    private Long codComision;
}
