package com.imax.backend.ImaxCore.dto.request;

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
