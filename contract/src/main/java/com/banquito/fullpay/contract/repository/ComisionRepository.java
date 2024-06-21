package com.banquito.fullpay.contract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.contract.model.Comision;

@Repository
public interface ComisionRepository extends JpaRepository<Comision, Long>  {

}
