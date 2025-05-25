package com.imax.backend.ImaxCore.modules.planillas.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreusuario(String nombreusuario);
    List<Usuario> findAllByVigenteTrue();
}
