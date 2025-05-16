package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.dto.request.UsuarioRequest;
import com.imax.backend.ImaxCore.dto.response.UsuarioResponse;
import com.imax.backend.ImaxCore.repository.RolRepository;
import com.imax.backend.ImaxCore.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @Autowired
    private RolRepository rolRepository;

    @GetMapping
    public List<UsuarioResponse> obtenerTodos() {
        return usuarioService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> obtenerPorId(@PathVariable Long id) {
        UsuarioResponse usuarioResponse = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuarioResponse);
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuarioResponse = usuarioService.guardar(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }
    @DeleteMapping
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }

}
