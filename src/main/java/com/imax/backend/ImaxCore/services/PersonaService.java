package com.imax.backend.ImaxCore.services;

import com.imax.backend.ImaxCore.dto.request.PersonaRequest;
import com.imax.backend.ImaxCore.dto.response.PersonaResponse;
import com.imax.backend.ImaxCore.mapper.PersonaMapper;
import com.imax.backend.ImaxCore.model.Persona;
import com.imax.backend.ImaxCore.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaResponse> listarTodas() {
        List<Persona> personas = personaRepository.findAllByVigenteTrue();
        return personas
                .stream()
                .map(PersonaMapper::toResponse)
                .toList();
    }

    public PersonaResponse buscarPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        return PersonaMapper.toResponse(persona);
    }

    public PersonaResponse guardar(PersonaRequest personaRequest) {
        Persona persona = PersonaMapper.toEntity(personaRequest);
        Persona personaGuardada = personaRepository.save(persona);
        return PersonaMapper.toResponse(personaGuardada);
    }

    public PersonaResponse actualizar(Long id, PersonaRequest personaRequest) {
        Persona personaExistente = personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));


        PersonaMapper.updateEntityFromRequest(personaExistente, personaRequest);

        Persona personaActualizado = personaRepository.save(personaExistente);
        return PersonaMapper.toResponse(personaActualizado);
    }

    public void eliminar(Long id) {
        Optional<Persona> personaOpt = personaRepository.findById(id);
        personaOpt.ifPresent(persona -> {
            persona.setVigente(false);
            personaRepository.save(persona);
        });
    }
}
