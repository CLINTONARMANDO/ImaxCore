package com.imax.backend.ImaxCore.modules.planillas.roles.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RolResponse {
    private Long id_rol;
    private String nombre;
    private String descripcion;

}
