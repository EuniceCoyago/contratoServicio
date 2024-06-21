package com.banquito.fullpay.contract.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.model.ServicioComision;
import com.banquito.fullpay.contract.repository.ServicioComisionRepository;

@Service
public class ServicioComisionService {
    private final ServicioComisionRepository servirepository;

    public ServicioComisionService(ServicioComisionRepository servirepository) {
        this.servirepository = servirepository;
    }
    

    public List<ServicioComision> getComisionesByServicio(Long codServicio) {
        try {
            return servirepository.findByServicioCodServicio(codServicio);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener comisiones por servicio", e);
        }
    }

    public List<ServicioComision> getServiciosByComision(Long codComision) {
        try {
            return servirepository.findByComisionCodComision(codComision);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener servicios por comision", e);
        }
    }

}
