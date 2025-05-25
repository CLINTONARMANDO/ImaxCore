package com.imax.backend.ImaxCore.modules.planillas.puestos.dtos;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuestoResponse {

    private Long id_puesto;
    private String nombre;
    private String descripcion;
    private Area area;

}
