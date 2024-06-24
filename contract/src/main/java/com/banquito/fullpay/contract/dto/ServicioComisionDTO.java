package com.banquito.fullpay.contract.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ServicioComisionDTO {
    private Long codServicio;
    private Long codComision;

}
