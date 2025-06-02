package com.imax.backend.ImaxCore.modules.planillas.puestos.dtos;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PuestoRequest {

    private Long id_puesto;
    private String nombre;
    private String descripcion;
    private Long id_area;
}
