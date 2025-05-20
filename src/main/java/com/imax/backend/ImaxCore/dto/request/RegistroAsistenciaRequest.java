package com.imax.backend.ImaxCore.dto.request;

import com.imax.backend.ImaxCore.model.Empleado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class RegistroAsistenciaRequest {
    private long idTRegistro;
    private Empleado empleado;
    private LocalDate fechaRegistro;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
}
