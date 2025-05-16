package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.model.Rol;
import com.imax.backend.ImaxCore.services.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/roles")
public class RolController {

    @Autowired
    private RolService rolService;


    @GetMapping
    public List<Rol> obtenerTodos() {
        return rolService.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Rol> obtenerPorId(@PathVariable Long id) {
        return rolService.buscarPorId(id);
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.guardar(rol);
    }

    @PutMapping
    public Rol actualizar(@PathVariable Long id, @RequestBody Rol rol) {
        rol.setId_rol(id);
        return rolService.guardar(rol);
    }

    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        rolService.eliminar(id);
    }
}
