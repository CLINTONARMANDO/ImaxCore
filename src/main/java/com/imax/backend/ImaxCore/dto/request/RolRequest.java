package com.imax.backend.ImaxCore.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolRequest {
    private Long id_rol;
    private String nombre;
    private String descripcion;
}
