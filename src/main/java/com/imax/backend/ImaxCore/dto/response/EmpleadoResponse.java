package com.imax.backend.ImaxCore.dto.response;

import com.imax.backend.ImaxCore.model.Area;
import com.imax.backend.ImaxCore.model.Persona;
import com.imax.backend.ImaxCore.model.Puesto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmpleadoResponse {
    private Long id;
    private Persona persona;
    private Area area;
    private Puesto puesto;
    private LocalDate fechaContratacion;

}
