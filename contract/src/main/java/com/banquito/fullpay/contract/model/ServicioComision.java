package com.banquito.fullpay.contract.model;

import java.io.Serializable;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "COR_SERVICIO_COMISION")
public class ServicioComision implements Serializable {

    @EmbeddedId
    private ServicioComisionPK servicioComisionPK;

    @ManyToOne
    @MapsId("codComision")
    @JoinColumn(name = "COD_COMISION", nullable = false)
    private Comision comision;

    @ManyToOne
    @MapsId("codServicio")
    @JoinColumn(name = "COD_SERVICIO", nullable = false)
    private Servicio servicio;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((servicioComisionPK == null) ? 0 : servicioComisionPK.hashCode());
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
        ServicioComision other = (ServicioComision) obj;
        if (servicioComisionPK == null) {
            if (other.servicioComisionPK != null)
                return false;
        } else if (!servicioComisionPK.equals(other.servicioComisionPK))
            return false;
        return true;
    }

}
