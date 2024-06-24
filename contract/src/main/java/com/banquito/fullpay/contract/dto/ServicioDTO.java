package com.banquito.fullpay.contract.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ServicioDTO {
    private Long codServicio;
    private String tipoServicio;
    private Long codContrato;

}
