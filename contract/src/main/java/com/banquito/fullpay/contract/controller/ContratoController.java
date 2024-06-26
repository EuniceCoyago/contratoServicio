package com.banquito.fullpay.contract.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.dto.ComisionDTO;
import com.banquito.fullpay.contract.dto.ServicioDTO;
import com.banquito.fullpay.contract.service.ContratoService;

@RestController
@RequestMapping("/servicio")
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
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
