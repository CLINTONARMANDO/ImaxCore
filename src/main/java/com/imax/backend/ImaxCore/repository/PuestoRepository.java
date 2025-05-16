package com.imax.backend.ImaxCore.repository;

import com.imax.backend.ImaxCore.model.Puesto;
import com.imax.backend.ImaxCore.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuestoRepository extends JpaRepository<Puesto, Long>{
    List<Puesto> findAllByVigenteTrue();
}
