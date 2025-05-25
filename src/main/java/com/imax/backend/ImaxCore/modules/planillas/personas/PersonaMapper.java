package com.imax.backend.ImaxCore.modules.planillas.personas;

import com.imax.backend.ImaxCore.modules.planillas.personas.dtos.PersonaRequest;
import com.imax.backend.ImaxCore.modules.planillas.personas.dtos.PersonaResponse;

public class PersonaMapper {
    public static PersonaResponse toResponse(Persona persona) {
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setId_persona(persona.getId());
        personaResponse.setNombre(persona.getNombre());
        personaResponse.setApellido(persona.getApellido());
        personaResponse.setDni(persona.getDni());
        personaResponse.setDireccion(persona.getDireccion());
        personaResponse.setEmail(persona.getEmail());
        personaResponse.setTelefono(persona.getTelefono());
        personaResponse.setFecha_nacimiento(persona.getFechaNacimiento());
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
        persona.setFechaNacimiento(personaRequest.getFecha_nacimiento());
        return persona;
    }
    public static void updateEntityFromRequest(Persona persona, PersonaRequest request) {
        persona.setNombre(request.getNombre());
        persona.setApellido(request.getApellido());
        persona.setDni(request.getDni());
        persona.setDireccion(request.getDireccion());
        persona.setEmail(request.getEmail());
        persona.setTelefono(request.getTelefono());
        persona.setFechaNacimiento(request.getFecha_nacimiento());
    }

}
