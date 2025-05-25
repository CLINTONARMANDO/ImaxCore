package com.imax.backend.ImaxCore.modules.planillas.puestos;

import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoRequest;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
