package com.banquito.fullpay.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {
    private Long codServicio;
    private String tipoServicio;
    private Long codContrato;
}
