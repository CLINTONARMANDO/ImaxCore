package com.imax.backend.ImaxCore.dto.request;

import com.imax.backend.ImaxCore.model.Empleado;
import com.imax.backend.ImaxCore.model.Turno;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class ActividadRequest {
    private Long idActividad;
    private Empleado empleado;
    private LocalDate fechaActividad;
    private LocalTime horaActividad;
    private String descripcion;
    private String observaciones;
    private Turno turno;
}
