package com.imax.backend.ImaxCore.modules.planillas.empleados.dtos;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.puestos.Puesto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpleadoRequest {

    private Long id;
    private Long idPersona;
    private Long idArea;
    private Long idPuesto;
    private LocalDate fechaContratacion;
}
