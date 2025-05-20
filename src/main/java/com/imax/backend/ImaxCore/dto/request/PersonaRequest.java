package com.imax.backend.ImaxCore.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class PersonaRequest {

    private Long id_persona;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String email;

}
