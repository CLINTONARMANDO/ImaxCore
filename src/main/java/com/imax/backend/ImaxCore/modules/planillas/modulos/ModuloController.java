package com.imax.backend.ImaxCore.modules.planillas.modulos;

import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloRequest;
import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @GetMapping("/padres")
    public List<ModuloResponse> obtenerModulosPadre() {
        return moduloService.obtenerModulosPadre();
    }

    @GetMapping("/{id}/hijos")
    public List<ModuloResponse> obtenerSubmodulos(@PathVariable Long id) {
        return moduloService.obtenerSubmodulosPorPadre(id);
    }
    @PostMapping
    public ResponseEntity<ModuloResponse> crearModulo(@RequestBody ModuloRequest request) {
        ModuloResponse creado = moduloService.crearModulo(request);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

}
