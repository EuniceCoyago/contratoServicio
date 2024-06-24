package com.banquito.fullpay.contract.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.dto.ContratoDTO;
import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.util.mapper.ComisionMapper;
import com.banquito.fullpay.contract.util.mapper.ContratoMapper;
import com.banquito.fullpay.contract.util.mapper.ServicioMapper;
import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.repository.ComisionRepository;
import com.banquito.fullpay.contract.repository.ContratoRepository;
import com.banquito.fullpay.contract.repository.ServicioRepository;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ComisionRepository comisionRepository;
    private final ServicioRepository servicioRepository;

    private final ContratoMapper contratoMapper;
    private final ComisionMapper comisionMapper;
    private final ServicioMapper servicioMapper;

    public ContratoService(ContratoRepository contratoRepository, ComisionRepository comisionRepository,
            ServicioRepository servicioRepository, ContratoMapper contratoMapper, ComisionMapper comisionMapper,
            ServicioMapper servicioMapper) {
        this.contratoRepository = contratoRepository;
        this.comisionRepository = comisionRepository;
        this.servicioRepository = servicioRepository;
        this.contratoMapper = contratoMapper;
        this.comisionMapper = comisionMapper;
        this.servicioMapper = servicioMapper;
    }

    @Transactional(Transactional.TxType.NEVER)
    public ContratoDTO obtainContratoById(Long id) {
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        if (contrato.isPresent()) {
            return contratoMapper.toDTO(contrato.get());
        } else {
            throw new RuntimeException("Contrato no encontrado");
        }
    }

    @Transactional
    public ContratoDTO inactivateContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("INA");
        return contratoMapper.toDTO(contratoRepository.save(contrato));
    }

    @Transactional
    public ContratoDTO activateContrato(Long id) {
        Contrato contrato = contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado"));
        contrato.setEstado("ACT");
        return contratoMapper.toDTO(contratoRepository.save(contrato));
    }

    public List<ContratoDTO> getContratosByDateRange(Date fechaInicio, Date fechaFin) {
        try {
            return contratoRepository.findByFechaInicioBetween(fechaInicio, fechaFin).stream()
                    .map(contratoMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener contratos por rango de fechas", e);
        }
    }

    public List<ComisionDTO> getAllComisiones() {
        try {
            return comisionRepository.findAll().stream()
                    .map(comisionMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las comisiones", e);
        }
    }

    public List<ComisionDTO> getComisionesByTipo(String tipo) {
        try {
            return comisionRepository.findByTipo(tipo).stream()
                    .map(comisionMapper::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por tipo", e);
        }
    }

    public List<ServicioDTO> getServiciosByTipo(String tipoServicio) {
        try {
            List<Servicio> servicios = this.servicioRepository.findByTipoServicio(tipoServicio);
            return servicios.stream().map(servicioMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los servicios por tipo", e);
        }
    }
}
