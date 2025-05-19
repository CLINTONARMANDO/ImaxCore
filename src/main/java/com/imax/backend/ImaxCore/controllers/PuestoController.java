package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.dto.request.PuestoRequest;
import com.imax.backend.ImaxCore.dto.response.PuestoResponse;
import com.imax.backend.ImaxCore.model.Puesto;
import com.imax.backend.ImaxCore.services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

    @GetMapping
    public List<PuestoResponse> obtenerTodos() {
        return puestoService.listarTodas();
    }

    @GetMapping("/{id}")
    public PuestoResponse obtenerPorId(@PathVariable Long id) {
        return puestoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PuestoRequest puestoRequest) {
        PuestoResponse puestoResponse = puestoService.guardar(puestoRequest);
        return ResponseEntity.ok(puestoResponse);
    }

    @PutMapping
    public ResponseEntity<PuestoResponse> actualizar(@PathVariable Long id, @RequestBody PuestoRequest puestoRequest) {

        PuestoResponse puestoActualizado = puestoService.actualizar(id,puestoRequest);
        return ResponseEntity.ok(puestoActualizado);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        puestoService.eliminar(id);
    }
}
