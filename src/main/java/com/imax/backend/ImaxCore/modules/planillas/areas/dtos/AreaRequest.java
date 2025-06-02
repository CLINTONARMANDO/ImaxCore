package com.imax.backend.ImaxCore.modules.planillas.areas.dtos;

import com.imax.backend.ImaxCore.modules.planillas.empleados.Empleado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreaRequest {
    private String nombre;
    private String descripcion;
}
