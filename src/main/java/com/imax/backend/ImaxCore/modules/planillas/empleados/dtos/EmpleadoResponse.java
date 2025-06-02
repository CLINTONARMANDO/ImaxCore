package com.imax.backend.ImaxCore.modules.planillas.empleados.dtos;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import com.imax.backend.ImaxCore.modules.planillas.areas.dtos.AreaResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.personas.dtos.PersonaResponse;
import com.imax.backend.ImaxCore.modules.planillas.puestos.Puesto;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoResponse;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpleadoResponse {
    private Long id;
    private PersonaResponse personaResponse;
    private AreaResponse areaResponse;
    private PuestoResponse puestoResponse;
    private LocalDate fechaContratacion;

}
