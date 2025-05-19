package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.dto.request.RolRequest;
import com.imax.backend.ImaxCore.dto.response.RolResponse;
import com.imax.backend.ImaxCore.model.Rol;
import com.imax.backend.ImaxCore.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
