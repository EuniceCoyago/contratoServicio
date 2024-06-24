package com.banquito.fullpay.contract.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.model.Comision;
import com.banquito.fullpay.contract.model.Servicio;
import com.banquito.fullpay.contract.model.ServicioComision;
import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> getContratoById(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.obtainContratoById(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Contrato>> getContratosByDateRange(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<Contrato> contratos = contratoService.getContratosByDateRange(fechaInicio, fechaFin);
            return ResponseEntity.ok(contratos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/inactivate")
    public ResponseEntity<Contrato> inactivateContrato(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.inactivateContrato(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Contrato> activateContrato(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.activateContrato(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comisiones")
    public ResponseEntity<List<Comision>> getAllComisiones() {
        try {
            List<Comision> comisiones = contratoService.getAllComisiones();
            return ResponseEntity.ok(comisiones);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comisiones/tipo/{tipo}")
    public ResponseEntity<List<Comision>> getComisionesByTipo(@PathVariable String tipo) {
        try {
            List<Comision> comisiones = contratoService.getComisionesByTipo(tipo);
            return ResponseEntity.ok(comisiones);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/servicio-comision/servicio/{codServicio}")
    public ResponseEntity<List<ServicioComision>> getComisionesByServicio(@PathVariable Long codServicio) {
        try {
            List<ServicioComision> comisiones = contratoService.getComisionesByServicio(codServicio);
            return ResponseEntity.ok(comisiones);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/servicio-comision/comision/{codComision}")
    public ResponseEntity<List<ServicioComision>> getServiciosByComision(@PathVariable Long codComision) {
        try {
            List<ServicioComision> servicios = contratoService.getServiciosByComision(codComision);
            return ResponseEntity.ok(servicios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/servicios/tipo/{tipoServicio}")
    public ResponseEntity<List<Servicio>> getServiciosByTipo(@PathVariable String tipoServicio) {
        try {
            List<Servicio> servicios = contratoService.getServiciosByTipo(tipoServicio);
            return ResponseEntity.ok(servicios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
