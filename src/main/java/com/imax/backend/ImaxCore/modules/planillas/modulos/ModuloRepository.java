package com.imax.backend.ImaxCore.modules.planillas.modulos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuloRepository extends JpaRepository<Modulo, Long> {
    List<Modulo> findByModuloPadreIsNull(); // módulos sin padre
    List<Modulo> findByModuloPadre_IdModulo(Long idModuloPadre); // hijos
}
