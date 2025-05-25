package com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private Long personaId;
    private String nombreusuario;
    private String email;
    private String password;
    private Long rolId;

}
