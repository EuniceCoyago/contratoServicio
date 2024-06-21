package com.banquito.fullpay.contract.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.service.ContratoService;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    private ContratoService contratoService;

    @GetMapping("/{id}")
    public Contrato getContratoById(@PathVariable Long id) {
        return contratoService.obtainContratoById(id);
    }

    @PostMapping
    public ResponseEntity<Contrato> createContrato(@RequestBody Contrato contrato) {
        try {
            Contrato createdContrato = contratoService.createContrato(contrato);
            return ResponseEntity.ok(createdContrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> updateContrato(@PathVariable Long id, @RequestBody Contrato contratoDetails) {
        try {
            Contrato updatedContrato = contratoService.updateContrato(id, contratoDetails);
            return ResponseEntity.ok(updatedContrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/finalize")
    public ResponseEntity<Contrato> finalizeContrato(@PathVariable Long id) {
        try {
            Contrato finalContrato = contratoService.finalizeContrato(id);
            return ResponseEntity.ok(finalContrato);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Contrato>> getContratosByDateRange(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        try {
            List<Contrato> contratos = contratoService.getContratosByDateRange(startDate, endDate);
            return ResponseEntity.ok(contratos);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public void deleteContrato(@PathVariable Long id) {
        contratoService.deleteContrato(id);
    }
}
