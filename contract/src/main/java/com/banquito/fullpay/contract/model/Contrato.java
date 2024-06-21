package com.banquito.fullpay.contract.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "COR_CONTRATO")
public class Contrato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_CONTRATO", nullable = false)
    private Long codContrato;
    @Column(name = "COD_EMPRESA", nullable = false)
    private Long codEmpresa;
    @Column(name = "ESTADO", nullable = false, length = 3)
    private String estado;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO")
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_FIN")
    private Date fechaFin;

    @OneToMany(mappedBy = "contrato")
    private List<Servicio> servicios;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codContrato == null) ? 0 : codContrato.hashCode());
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
        Contrato other = (Contrato) obj;
        if (codContrato == null) {
            if (other.codContrato != null)
                return false;
        } else if (!codContrato.equals(other.codContrato))
            return false;
        return true;
    }

}
