package com.banquito.fullpay.contract.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ComisionDTO {
    private Long codComision;
    private String tipo;
    private BigDecimal valor;

}
