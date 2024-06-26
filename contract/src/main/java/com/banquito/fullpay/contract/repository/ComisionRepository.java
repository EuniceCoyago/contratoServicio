package com.banquito.fullpay.contract.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.contract.model.Comision;

@Repository
public interface ComisionRepository extends JpaRepository<Comision, Long> {

    List<Comision> findByTipo(String tipo);
}
