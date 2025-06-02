package com.imax.backend.ImaxCore.modules.planillas.empleados;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import com.imax.backend.ImaxCore.modules.planillas.areas.AreaMapper;
import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoRequest;
import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.personas.PersonaMapper;
import com.imax.backend.ImaxCore.modules.planillas.puestos.Puesto;
import com.imax.backend.ImaxCore.modules.planillas.puestos.PuestoMapper;

public class EmpleadoMapper {
    public static EmpleadoResponse toResponse(Empleado empleado) {
        EmpleadoResponse empleadoResponse = new EmpleadoResponse();
        empleadoResponse.setId(empleado.getId());
        empleadoResponse.setAreaResponse(AreaMapper.toResponse(empleado.getArea()));
        empleadoResponse.setPersonaResponse(PersonaMapper.toResponse(empleado.getPersona()));
        empleadoResponse.setPuestoResponse(PuestoMapper.toResponse(empleado.getPuesto()));
        empleadoResponse.setFechaContratacion(empleado.getFechaContratacion());
        return empleadoResponse;
    }
    public static Empleado toEntity(EmpleadoRequest empleadoRequest, Area area, Persona persona, Puesto puesto) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoRequest.getId());
        empleado.setArea(area);
        empleado.setPersona(persona);
        empleado.setPuesto(puesto);
        empleado.setFechaContratacion(empleadoRequest.getFechaContratacion());
        return empleado;
    }
    public static void updateEntityFromRequest (EmpleadoRequest empleadoRequest, Empleado empleado, Area area, Persona persona, Puesto puesto) {
        empleado.setArea(area);
        empleado.setPersona(persona);
        empleado.setPuesto(puesto);
        empleado.setFechaContratacion(empleadoRequest.getFechaContratacion());
    }
}
