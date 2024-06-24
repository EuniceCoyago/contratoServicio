package com.banquito.fullpay.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor

public class ServicioDTO {
    private Long codServicio;
    private String tipoServicio;
    private Long codContrato;
}
