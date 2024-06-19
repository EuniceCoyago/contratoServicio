package com.banquito.fullpay.contract.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.banquito.fullpay.contract.model.Contrato;
import com.banquito.fullpay.contract.repository.ContratoRepository;

import jakarta.transaction.Transactional;

@Service
public class ContratoService {

    private ContratoRepository contratoRepository;

    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public List<Contrato> getAllContratos() {
        return contratoRepository.findAll();
    }

    @Transactional(Transactional.TxType.NEVER)
    public Contrato obtaiContratoById(Long id) {
        Optional<Contrato> contrato = this.contratoRepository.findById(id);
        if(contrato.isPresent()) {
            return contrato.get();
        }else {
            throw new RuntimeException("Contrato no encontrado");
        }
    }


    public Contrato saveContrato(Contrato contrato) {
        return contratoRepository.save(contrato);
    }

    public void deleteContrato(Long id) {
        contratoRepository.deleteById(id);
    }
}
