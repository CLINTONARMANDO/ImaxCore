package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.PersonaRequest;
import com.imax.backend.ImaxCore.dto.response.PersonaResponse;
import com.imax.backend.ImaxCore.model.Persona;

public class PersonaMapper {
    public static PersonaResponse toResponse(Persona persona) {
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setId_persona(persona.getId_persona());
        personaResponse.setNombre(persona.getNombre());
        personaResponse.setApellido(persona.getApellido());
        personaResponse.setDni(persona.getDni());
        personaResponse.setDireccion(persona.getDireccion());
        personaResponse.setEmail(persona.getEmail());
        personaResponse.setTelefono(persona.getTelefono());
        personaResponse.setFecha_nacimiento(persona.getFecha_nacimiento());
        return personaResponse;

    }
    public static Persona toEntity(PersonaRequest personaRequest) {
        Persona persona = new Persona();
        persona.setNombre(personaRequest.getNombre());
        persona.setApellido(personaRequest.getApellido());
        persona.setDni(personaRequest.getDni());
        persona.setDireccion(personaRequest.getDireccion());
        persona.setEmail(personaRequest.getEmail());
        persona.setTelefono(personaRequest.getTelefono());
        persona.setFecha_nacimiento(personaRequest.getFecha_nacimiento());
        return persona;
    }
    public static void updateEntityFromRequest(Persona persona, PersonaRequest request) {
        persona.setNombre(request.getNombre());
        persona.setApellido(request.getApellido());
        persona.setDni(request.getDni());
        persona.setDireccion(request.getDireccion());
        persona.setEmail(request.getEmail());
        persona.setTelefono(request.getTelefono());
        persona.setFecha_nacimiento(request.getFecha_nacimiento());
    }

}
