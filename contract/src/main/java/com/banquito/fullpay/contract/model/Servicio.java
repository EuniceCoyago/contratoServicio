package com.banquito.fullpay.contract.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "COR_SERVICIO")
public class Servicio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_SERVICIO", nullable = false)
    private Long codServicio;

    @Column(name = "TIPO_SERVICIO", nullable = false, length = 3)
    private String tipoServicio;

    @OneToMany(mappedBy = "servicio")
    private List<ServicioComision> servicioComisiones;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codServicio == null) ? 0 : codServicio.hashCode());
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
        Servicio other = (Servicio) obj;
        if (codServicio == null) {
            if (other.codServicio != null)
                return false;
        } else if (!codServicio.equals(other.codServicio))
            return false;
        return true;
    }
}
