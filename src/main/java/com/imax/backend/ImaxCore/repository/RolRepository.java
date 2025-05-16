package com.imax.backend.ImaxCore.repository;

import com.imax.backend.ImaxCore.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findAllByVigenteTrue();
}
