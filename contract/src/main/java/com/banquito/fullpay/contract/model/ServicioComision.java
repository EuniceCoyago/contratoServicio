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
    private ServicioComisionPK id;

    @ManyToOne
    @MapsId("codServicio")
    @JoinColumn(name = "COD_SERVICIO", insertable = false, updatable = false, nullable = false)
    private Servicio servicio;

    @ManyToOne
    @MapsId("codComision")
    @JoinColumn(name = "COD_COMISION", insertable = false, updatable = false, nullable = false)
    private Comision comision;
}
