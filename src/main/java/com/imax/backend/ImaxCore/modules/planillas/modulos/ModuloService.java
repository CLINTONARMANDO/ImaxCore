package com.imax.backend.ImaxCore.modules.planillas.modulos;

import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloRequest;
import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    public List<ModuloResponse> obtenerModulosPadre() {
        List<Modulo> modulosPadre = moduloRepository.findByModuloPadreIsNull();
        return modulosPadre.stream()
                .map(ModuloMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ModuloResponse> obtenerSubmodulosPorPadre(Long idPadre) {
        List<Modulo> submodulos = moduloRepository.findByModuloPadre_IdModulo(idPadre);
        return submodulos.stream()
                .map(ModuloMapper::toResponse)
                .collect(Collectors.toList());
    }
    public ModuloResponse crearModulo(ModuloRequest moduloRequest) {
        Modulo modulo = ModuloMapper.toEntity(moduloRequest);

        if (moduloRequest.getModuloPadreId() != null) {
            Modulo padre = moduloRepository.findById(moduloRequest.getModuloPadreId())
                    .orElseThrow(() -> new RuntimeException("Módulo padre no encontrado"));
            modulo.setModuloPadre(padre);
        }

        Modulo guardado = moduloRepository.save(modulo);
        return ModuloMapper.toResponse(guardado);
    }
    public List<ModuloResponse> obtenerJerarquiaDeModulos() {
        List<Modulo> modulosPadre = moduloRepository.findByModuloPadreIsNull();
        return modulosPadre.stream()
                .map(ModuloMapper::toResponseRecursivo)
                .collect(Collectors.toList());
    }


}
