package com.banquito.fullpay.contract.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioComisionDTO {
    private Long codServicio;
    private Long codComision;
}
