package com.banquito.fullpay.contract.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.repository.ContratoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
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
    public Contrato updateContrato(Long id, Contrato contratoDetails) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setCodEmpresa(contratoDetails.getCodEmpresa());
        contrato.setEstado(contratoDetails.getEstado());
        contrato.setFechaInicio(contratoDetails.getFechaInicio());
        contrato.setFechaFin(contratoDetails.getFechaFin());
        return contratoRepository.save(contrato);
    }

    @Transactional
    public Contrato finalizeContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("FIN");
        return contratoRepository.save(contrato);
    }

    public Optional<Contrato> getContratoById(Long id) {
        try {
            return contratoRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener el contrato por ID", e);
        }
    }

    @Transactional
    public Contrato createContrato(Contrato contrato) {
        try {
            return contratoRepository.save(contrato);
        } catch (Exception e) {
            throw new RuntimeException("Error al crear el contrato", e);
        }
    }

    public List<Contrato> getContratosByDateRange(Date startDate, Date endDate) {
        try {
            return contratoRepository.findByFechaRango(startDate, endDate);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener contratos por rango de fechas", e);
        }
    }

    @Transactional
    public void deleteContrato(Long id) {
        try {
            contratoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el contrato", e);
        }
    }
}
