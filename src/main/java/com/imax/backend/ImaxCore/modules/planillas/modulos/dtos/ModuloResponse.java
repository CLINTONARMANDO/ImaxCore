package com.imax.backend.ImaxCore.modules.planillas.modulos.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModuloResponse {
    private String nombre;
    private String ruta;
    private List<ModuloResponse> submodulos;
}
