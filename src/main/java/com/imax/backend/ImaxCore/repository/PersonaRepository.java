package com.imax.backend.ImaxCore.repository;

import com.imax.backend.ImaxCore.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long>  {
    List<Persona> findAllByVigenteTrue();
}
