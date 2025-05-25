package com.imax.backend.ImaxCore.modules.planillas.personas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long>  {
    List<Persona> findAllByVigenteTrue();
}
