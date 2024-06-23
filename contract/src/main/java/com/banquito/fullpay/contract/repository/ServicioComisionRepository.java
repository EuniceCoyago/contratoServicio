package com.banquito.fullpay.contract.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banquito.fullpay.contract.model.ServicioComision;
import com.banquito.fullpay.contract.model.ServicioComisionPK;

@Repository
public interface ServicioComisionRepository extends JpaRepository<ServicioComision, ServicioComisionPK> {

    List<ServicioComision> findByIdCodServicio(Long codServicio);

    List<ServicioComision> findByIdCodComision(Long codComision);
}
