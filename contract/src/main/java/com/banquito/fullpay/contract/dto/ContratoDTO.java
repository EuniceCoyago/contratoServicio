package com.banquito.fullpay.contract.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO {
    private Long codContrato;
    private Integer codEmpresa;
    private String estado;
    private Date fechaInicio;
    private Date fechaFin;
}
