    package com.imax.backend.ImaxCore.controllers;

    import com.imax.backend.ImaxCore.dto.request.PersonaRequest;
    import com.imax.backend.ImaxCore.dto.response.PersonaResponse;
    import com.imax.backend.ImaxCore.dto.response.UsuarioResponse;
    import com.imax.backend.ImaxCore.model.Persona;
    import com.imax.backend.ImaxCore.services.PersonaService;
    import com.imax.backend.ImaxCore.services.UsuarioService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @RestController
    @RequestMapping("/api/personas")
    public class PersonaController {

        @Autowired
        private PersonaService personaService;

        @GetMapping
        public List<PersonaResponse> obtenerTodas() {
            return personaService.listarTodas();
        }

        @GetMapping("/{id}")
        public ResponseEntity<PersonaResponse> obtenerPorId(@PathVariable Long id) {
            PersonaResponse personaResponse = personaService.buscarPorId(id);
            return ResponseEntity.ok(personaResponse);
        }

        @PostMapping
        public ResponseEntity<?> crear(@RequestBody PersonaRequest personaRequest) {
            PersonaResponse personaResponse = personaService.guardar(personaRequest);
            return ResponseEntity.ok(personaResponse);
        }

        @PutMapping("/{id}")
        public ResponseEntity<PersonaResponse> actualizar(@PathVariable Long id, @RequestBody Persona persona) {
            PersonaResponse personaActualizada = personaService.actualizar(id, personaRequest);
            return ResponseEntity.ok(personaActualizada);
        }

        @DeleteMapping("/{id}")
        public void eliminar(@PathVariable Long id) {
            personaService.eliminar(id);
        }
    }
