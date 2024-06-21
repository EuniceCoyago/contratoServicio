package com.banquito.fullpay.contract.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.repository.ServicioRepository;

@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public List<Servicio> getServiciosByContrato(Long codContrato) {
        try {
            return servicioRepository.findByCodContrato(codContrato);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener los servicios por contrato", e);
        }
    }

}
