package com.banquito.fullpay.contract.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor

public class ContratoDTO {
    private Long codContrato;
    private Long codEmpresa;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
}
