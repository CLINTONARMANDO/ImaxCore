package com.imax.backend.ImaxCore.modules.planillas.areas;

import com.imax.backend.ImaxCore.modules.planillas.areas.dtos.AreaRequest;
import com.imax.backend.ImaxCore.modules.planillas.areas.dtos.AreaResponse;
import com.imax.backend.ImaxCore.modules.planillas.puestos.PuestoService;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoResponse;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    @Autowired
    AreaService areaService;

    @GetMapping
    public List<AreaResponse> obtenerTodas() {
        return areaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaResponse> obtenerPorId(@PathVariable Long id) {
        AreaResponse areaResponse = areaService.buscarPorId(id);
        return ResponseEntity.ok(areaResponse);
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody AreaRequest areaRequest) {
        AreaResponse areaResponse = areaService.guardar(areaRequest);
        return ResponseEntity.ok(areaResponse);
    }

}
