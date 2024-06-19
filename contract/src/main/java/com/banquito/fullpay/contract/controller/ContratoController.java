package com.banquito.fullpay.contract.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.service.ContratoService;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

     private ContratoService contratoService;

    @GetMapping
    public List<Contrato> getAllContratos() {
        return contratoService.getAllContratos();
    }

    @GetMapping("/{id}")
    public Contrato getContratoById(@PathVariable Long id) {
        return contratoService.getContratoById(id);
    }

    @PostMapping
    public Contrato saveContrato(@RequestBody Contrato contrato) {
        return contratoService.saveContrato(contrato);
    }

    @DeleteMapping("/{id}")
    public void deleteContrato(@PathVariable Long id) {
        contratoService.deleteContrato(id);
    }
}
