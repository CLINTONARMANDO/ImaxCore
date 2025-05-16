package com.imax.backend.ImaxCore.repository;

import com.imax.backend.ImaxCore.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNombreusuario(String nombreusuario);
}
