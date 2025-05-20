package com.imax.backend.ImaxCore.dto.response;

import com.imax.backend.ImaxCore.model.Empleado;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AreaResponse {

    private Long id;
    private String nombre;
    private String descripcion;
    private List<Empleado> empleados;
}
