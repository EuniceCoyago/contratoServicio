package com.banquito.fullpay.contract.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.dto.ContratoDTO;
import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.service.ContratoService;

@RestController
@RequestMapping("/contrato")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContratoDTO> getContratoById(@PathVariable Long id) {
        try {
            ContratoDTO contrato = contratoService.obtainContratoById(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<ContratoDTO>> getContratosByDateRange(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<ContratoDTO> contratos = contratoService.getContratosByDateRange(fechaInicio, fechaFin);
            return ResponseEntity.ok(contratos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/inactivate")
    public ResponseEntity<ContratoDTO> inactivateContrato(@PathVariable Long id) {
        try {
            ContratoDTO contrato = contratoService.inactivateContrato(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<ContratoDTO> activateContrato(@PathVariable Long id) {
        try {
            ContratoDTO contrato = contratoService.activateContrato(id);
            return ResponseEntity.ok(contrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comisiones")
    public ResponseEntity<List<ComisionDTO>> getAllComisiones() {
        try {
            List<ComisionDTO> comisiones = contratoService.getAllComisiones();
            return ResponseEntity.ok(comisiones);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comisiones/tipo/{tipo}")
    public ResponseEntity<List<ComisionDTO>> getComisionesByTipo(@PathVariable String tipo) {
        try {
            List<ComisionDTO> comisiones = contratoService.getComisionesByTipo(tipo);
            return ResponseEntity.ok(comisiones);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/servicios/tipo/{tipoServicio}")
    public ResponseEntity<List<ServicioDTO>> getServiciosByTipo(@PathVariable String tipoServicio) {
        try {
            List<ServicioDTO> servicios = contratoService.getServiciosByTipo(tipoServicio);
            return ResponseEntity.ok(servicios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
