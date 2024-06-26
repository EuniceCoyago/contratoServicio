package com.banquito.fullpay.contract.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "COR_COMISION", schema = "cobrosrecaudos")
public class Comision implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_COMISION", nullable = false)
    private Long codComision;
    @Column(name = "TIPO", nullable = false, length = 3)
    private String tipo;
    @Column(name = "VALOR", nullable = false, precision = 18, scale = 2)
    private BigDecimal valor;

    @OneToMany(mappedBy = "comision")
    private List<ServicioComision> servicioComisiones;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Comision other = (Comision) obj;
        if (codComision == null) {
            if (other.codComision != null)
                return false;
        } else if (!codComision.equals(other.codComision))
            return false;
        return true;
    }

}
