package com.imax.backend.ImaxCore.modules.planillas.personas.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonaResponse {

    private Long id_persona;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_nacimiento;
    private String direccion;
    private String telefono;
    private String email;

}
