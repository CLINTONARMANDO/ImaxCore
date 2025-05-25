package com.imax.backend.ImaxCore.modules.planillas.modulos.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ModuloRequest {
    private String nombre;
    private String ruta;
    private String descripcion;
    private List<ModuloRequest> submodulos;
    private Long idModuloPadre;
}
