package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.model.Puesto;
import com.imax.backend.ImaxCore.services.PuestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {

    @Autowired
    private PuestoService puestoService;

    @GetMapping
    public List<Puesto> obtenerTodos() {
        return puestoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Puesto> obtenerPorId(@PathVariable Long id) {
        return puestoService.buscarPorId(id);
    }

    @PostMapping
    public Puesto crear(@RequestBody Puesto puesto) {
        return puestoService.guardar(puesto);
    }

    @PutMapping
    public Puesto actualizar(@PathVariable Long id, @RequestBody Puesto puesto) {
        puesto.setId_puesto(id);
        return puestoService.guardar(puesto);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        puestoService.eliminar(id);
    }
}
