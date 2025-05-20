package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.EmpleadoRequest;
import com.imax.backend.ImaxCore.dto.response.EmpleadoResponse;
import com.imax.backend.ImaxCore.model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoResponse toResponse(Empleado empleado) {
        EmpleadoResponse empleadoResponse = new EmpleadoResponse();
        empleadoResponse.setId(empleado.getId());
        empleadoResponse.setArea(empleado.getArea());
        empleadoResponse.setPersona(empleado.getPersona());
        empleadoResponse.setPuesto(empleado.getPuesto());
        empleadoResponse.setFechaContratacion(empleado.getFechaContratacion());
        return empleadoResponse;
    }
    public static Empleado toEntity(EmpleadoRequest empleadoRequest) {
        Empleado empleado = new Empleado();
        empleado.setId(empleadoRequest.getId());
        empleado.setArea(empleadoRequest.getArea());
        empleado.setPersona(empleadoRequest.getPersona());
        empleado.setPuesto(empleadoRequest.getPuesto());
        empleado.setFechaContratacion(empleadoRequest.getFechaContratacion());
        return empleado;
    }
    public static void updateEntityFromRequest (EmpleadoRequest empleadoRequest, Empleado empleado) {
        empleado.setArea(empleadoRequest.getArea());
        empleado.setPersona(empleadoRequest.getPersona());
        empleado.setPuesto(empleadoRequest.getPuesto());
        empleado.setFechaContratacion(empleadoRequest.getFechaContratacion());
    }
}
