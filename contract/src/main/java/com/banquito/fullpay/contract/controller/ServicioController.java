package com.banquito.fullpay.contract.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.service.ServicioService;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/contrato/{codContrato}")
    public ResponseEntity<List<Servicio>> getServiciosByContrato(@PathVariable Long codContrato) {
        try {
            List<Servicio> servicios = servicioService.getServiciosByContrato(codContrato);
            return ResponseEntity.ok(servicios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
