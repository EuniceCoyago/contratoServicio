package com.banquito.fullpay.contract.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.model.Comision;
import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.model.ServicioComision;
import com.banquito.fullpay.contract.repository.ComisionRepository;
import com.banquito.fullpay.contract.repository.ContratoRepository;
import com.banquito.fullpay.contract.repository.ServicioComisionRepository;
import com.banquito.fullpay.contract.repository.ServicioRepository;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ComisionRepository comisionRepository;
    private final ServicioComisionRepository servComRepository;
    private final ServicioRepository servicioRepository;

    public ContratoService(ContratoRepository contratoRepository, ComisionRepository comisionRepository,
            ServicioComisionRepository servComRepository, ServicioRepository servicioRepository) {
        this.contratoRepository = contratoRepository;
        this.comisionRepository = comisionRepository;
        this.servComRepository = servComRepository;
        this.servicioRepository = servicioRepository;
    }

    @Transactional(Transactional.TxType.NEVER)
    public Contrato obtainContratoById(Long id) {
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        if (contrato.isPresent()) {
            return contrato.get();
        } else {
            throw new RuntimeException("Contrato no encontrado");
        }
    }

    @Transactional
    public Contrato inactivateContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("INA");
        return contratoRepository.save(contrato);
    }

    @Transactional
    public Contrato activateContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ContrFato no encontrado"));
        contrato.setEstado("ACT");
        return contratoRepository.save(contrato);
    }

    public List<Contrato> getContratosByDateRange(Date fechaInicio, Date fechaFin) {
        try {
            return contratoRepository.findByFechaRango(fechaInicio, fechaFin);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener contratos por rango de fechas", e);
        }
    }

    public List<ServicioComision> getComisionesByServicio(Long codServicio) {
        try {
            return this.servComRepository.findByIdCodServicio(codServicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por servicio", e);
        }
    }

    public List<ServicioComision> getServiciosByComision(Long codComision) {
        try {
            return this.servComRepository.findByIdCodComision(codComision);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener servicios por comision", e);
        }
    }

    public List<Comision> getAllComisiones() {
        try {
            return comisionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las comisiones", e);
        }
    }

    public List<Comision> getComisionesByTipo(String tipo) {
        try {
            return comisionRepository.findByTipo(tipo);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por tipo", e);
        }
    }

    public List<Servicio> getServiciosByTipo(String tipoServicio) {
        try {
            return this.servicioRepository.findByTipoServicio(tipoServicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los servicios por tipo", e);
        }
    }
}
