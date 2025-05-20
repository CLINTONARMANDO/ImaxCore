package com.imax.backend.ImaxCore.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UsuarioResponse {
    private Long idUsuario;
    private String nombreusuario;
    private String email;
    private String nombreRol;
    // Getters y Setters
}
