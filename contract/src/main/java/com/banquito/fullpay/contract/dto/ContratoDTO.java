package com.banquito.fullpay.contract.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Value;

@Value
@Builder

public class ContratoDTO {
    private Long codContrato;
    private Long codEmpresa;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
}
