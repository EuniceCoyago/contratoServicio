package com.banquito.fullpay.contract.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComisionDTO {
    private Long codComision;
    private String tipo;
    private BigDecimal valor;
}
