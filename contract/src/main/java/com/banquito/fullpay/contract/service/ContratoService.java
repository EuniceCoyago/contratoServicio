package com.banquito.fullpay.contract.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.dto.ContratoDTO;
import com.banquito.fullpay.contract.dto.ServicioComisionDTO;
import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.util.mapper.ComisionMapper;
import com.banquito.fullpay.contract.util.mapper.ContratoMapper;
import com.banquito.fullpay.contract.util.mapper.ServicioComisionMapper;
import com.banquito.fullpay.contract.util.mapper.ServicioMapper;
import com.banquito.fullpay.contract.model.Comision;
import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.model.ServicioComision;
import com.banquito.fullpay.contract.repository.ComisionRepository;
import com.banquito.fullpay.contract.repository.ContratoRepository;
import com.banquito.fullpay.contract.repository.ServicioComisionRepository;
import com.banquito.fullpay.contract.repository.ServicioRepository;

@Service
public class ContratoService {

    private final ContratoRepository contratoRepository;
    private final ComisionRepository comisionRepository;
    private final ServicioComisionRepository servComRepository;
    private final ServicioRepository servicioRepository;
    private final ContratoMapper contratoMapper;
    private final ComisionMapper comisionMapper;
    private final ServicioMapper servicioMapper;
    private final ServicioComisionMapper servicioComisionMapper;

    public ContratoService(ContratoRepository contratoRepository, ComisionRepository comisionRepository,
            ServicioComisionRepository servComRepository, ServicioRepository servicioRepository,
            ContratoMapper contratoMapper, ComisionMapper comisionMapper,
            ServicioMapper servicioMapper, ServicioComisionMapper servicioComisionMapper) {
        this.contratoRepository = contratoRepository;
        this.comisionRepository = comisionRepository;
        this.servComRepository = servComRepository;
        this.servicioRepository = servicioRepository;
        this.contratoMapper = contratoMapper;
        this.comisionMapper = comisionMapper;
        this.servicioMapper = servicioMapper;
        this.servicioComisionMapper = servicioComisionMapper;
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public List<ContratoDTO> getContratosByDateRange(Date fechaInicio, Date fechaFin) {
        try {
            List<Contrato> contratos = contratoRepository.findByFechaInicioBetween(fechaInicio, fechaFin);
            return contratos.stream().map(contratoMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener contratos por rango de fechas", e);
        }
    }

    @Transactional(readOnly = true)
    public List<ServicioComisionDTO> getComisionesByServicio(Long codServicio) {
        try {
            List<ServicioComision> servicioComisiones = this.servComRepository.findByIdCodServicio(codServicio);
            return servicioComisiones.stream().map(servicioComisionMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por servicio", e);
        }
    }

    @Transactional(readOnly = true)
    public List<ServicioComisionDTO> getServiciosByComision(Long codComision) {
        try {
            List<ServicioComision> servicioComisiones = this.servComRepository.findByIdCodComision(codComision);
            return servicioComisiones.stream().map(servicioComisionMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener servicios por comision", e);
        }
    }

    @Transactional(readOnly = true)
    public List<ComisionDTO> getAllComisiones() {
        try {
            List<Comision> comisiones = comisionRepository.findAll();
            return comisiones.stream().map(comisionMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener todas las comisiones", e);
        }
    }

    @Transactional(readOnly = true)
    public List<ComisionDTO> getComisionesByTipo(String tipo) {
        try {
            List<Comision> comisiones = comisionRepository.findByTipo(tipo);
            return comisiones.stream().map(comisionMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por tipo", e);
        }
    }

    @Transactional(readOnly = true)
    public List<ServicioDTO> getServiciosByTipo(String tipoServicio) {
        try {
            List<Servicio> servicios = this.servicioRepository.findByTipoServicio(tipoServicio);
            return servicios.stream().map(servicioMapper::toDTO).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los servicios por tipo", e);
        }
    }
}
