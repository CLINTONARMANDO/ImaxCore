package com.imax.backend.ImaxCore.modules.planillas.roles;

import com.imax.backend.ImaxCore.modules.planillas.roles.dtos.RolRequest;
import com.imax.backend.ImaxCore.modules.planillas.roles.dtos.RolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @Autowired
    private RolService rolService;


    @GetMapping
    public List<RolResponse> obtenerTodos() {
        return rolService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolResponse> obtenerPorId(@PathVariable Long id) {
        RolResponse rolResponse = rolService.buscarPorId(id);
        return ResponseEntity.ok(rolResponse);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody RolRequest rolRequest) {
        RolResponse rolResponse = rolService.guardar(rolRequest);
        return ResponseEntity.ok(rolResponse);

    }

    @PutMapping
    public ResponseEntity<RolResponse> actualizar(@PathVariable Long id, @RequestBody RolRequest rolRequest) {

        RolResponse rolActualizado = rolService.actualizar(id, rolRequest);
        return ResponseEntity.ok(rolActualizado);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}
