package com.imax.backend.ImaxCore.dto.response;

import com.imax.backend.ImaxCore.model.Area;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PuestoResponse {

    private Long id_puesto;
    private String nombre;
    private String descripcion;
    private Area area;

}
