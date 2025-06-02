package com.imax.backend.ImaxCore.modules.planillas.empleados;

import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoRequest;
import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.PersonaService;
import com.imax.backend.ImaxCore.modules.planillas.personas.dtos.PersonaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public List<EmpleadoResponse> obtenerTodas() {
        return empleadoService.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody EmpleadoRequest empleadoRequest) {
        EmpleadoResponse empleadoResponse = empleadoService.guardar(empleadoRequest);
        return ResponseEntity.ok(empleadoResponse);
    }
}
