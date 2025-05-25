package com.imax.backend.ImaxCore.modules.planillas.modulos;

import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloRequest;
import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ModuloMapper {
    public static ModuloResponse toResponse(Modulo modulo) {
        ModuloResponse moduloResponse = new ModuloResponse();
        moduloResponse.setNombre(modulo.getNombre());
        moduloResponse.setRuta(modulo.getRuta());
        if (modulo.getSubmodulos() != null && !modulo.getSubmodulos().isEmpty()) {
            moduloResponse.setSubmodulos(
                    modulo.getSubmodulos()
                            .stream()
                            .map(ModuloMapper::toResponse)
                            .collect(Collectors.toList())
            );
        }
        return moduloResponse;
    }
    public static Modulo toEntity(ModuloRequest moduloRequest) {
        Modulo modulo = new Modulo();
        modulo.setNombre(moduloRequest.getNombre());
        modulo.setRuta(moduloRequest.getRuta());
        modulo.setDescripcion(moduloRequest.getDescripcion());
        if (moduloRequest.getSubmodulos() != null && !moduloRequest.getSubmodulos().isEmpty()) {
            List<Modulo> submodulos = moduloRequest.getSubmodulos()
                    .stream()
                    .map(subRequest -> {
                        Modulo subModulo = toEntity(subRequest);
                        subModulo.setModuloPadre(modulo); // Asigna el padre al submódulo
                        return subModulo;
                    })
                    .collect(Collectors.toList());

            modulo.setSubmodulos(submodulos);
        }
        return modulo;
    }
}
