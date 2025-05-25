package com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {
    private Long idUsuario;
    private String nombreusuario;
    private String email;
    private String nombreRol;
    // Getters y Setters
}
