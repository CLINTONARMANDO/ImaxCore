package com.imax.backend.ImaxCore.modules.planillas.puestos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuestoRepository extends JpaRepository<Puesto, Long>{
    List<Puesto> findAllByVigenteTrue();
}
