package com.imax.backend.ImaxCore.modules.planillas.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RolRepository extends JpaRepository<Rol, Long> {
    List<Rol> findAllByVigenteTrue();
}
