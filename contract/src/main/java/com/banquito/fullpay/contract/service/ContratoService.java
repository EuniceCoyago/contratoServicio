package com.banquito.fullpay.contract.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.util.mapper.ComisionMapper;
import com.banquito.fullpay.contract.util.mapper.ServicioMapper;
import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.repository.ComisionRepository;
import com.banquito.fullpay.contract.repository.ServicioRepository;


@Service
public class ContratoService {

    private final ComisionRepository comisionRepository;
    private final ServicioRepository servicioRepository;

    private final ComisionMapper comisionMapper;
    private final ServicioMapper servicioMapper;

  

    public ContratoService(ComisionRepository comisionRepository, ServicioRepository servicioRepository,
            ComisionMapper comisionMapper, ServicioMapper servicioMapper) {
        this.comisionRepository = comisionRepository;
        this.servicioRepository = servicioRepository;
        this.comisionMapper = comisionMapper;
        this.servicioMapper = servicioMapper;
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
