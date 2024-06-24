package com.banquito.fullpay.contract.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class ServicioComisionPK implements Serializable {

    @Column(name = "COD_SERVICIO")
    private Long codServicio;

    @Column(name = "COD_COMISION")
    private Long codComision;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codServicio == null) ? 0 : codServicio.hashCode());
        result = prime * result + ((codComision == null) ? 0 : codComision.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ServicioComisionPK other = (ServicioComisionPK) obj;
        if (codServicio == null) {
            if (other.codServicio != null)
                return false;
        } else if (!codServicio.equals(other.codServicio))
            return false;
        if (codComision == null) {
            if (other.codComision != null)
                return false;
        } else if (!codComision.equals(other.codComision))
            return false;
        return true;
    }
}
