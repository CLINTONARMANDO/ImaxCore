package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.ActividadRequest;
import com.imax.backend.ImaxCore.dto.response.ActividadResponse;
import com.imax.backend.ImaxCore.model.Actividad;

public class ActividadMapper {
    public static ActividadResponse toResponse(Actividad actividad) {
        ActividadResponse actividadResponse = new ActividadResponse();
        actividadResponse.setIdActividad(actividad.getIdActividad());
        actividadResponse.setEmpleado(actividad.getEmpleado());
        actividadResponse.setFechaActividad(actividad.getFechaActividad());
        actividadResponse.setDescripcion(actividad.getDescripcion());
        actividadResponse.setHoraActividad(actividad.getHoraActividad());
        actividadResponse.setObservaciones(actividad.getObservaciones());
        actividadResponse.setTurno(actividad.getTurno());
        return actividadResponse;
    }
    public static Actividad toEntity(ActividadRequest actividadRequest) {
        Actividad actividad = new Actividad();
        actividad.setIdActividad(actividadRequest.getIdActividad());
        actividad.setEmpleado(actividadRequest.getEmpleado());
        actividad.setFechaActividad(actividadRequest.getFechaActividad());
        actividad.setDescripcion(actividadRequest.getDescripcion());
        actividad.setHoraActividad(actividadRequest.getHoraActividad());
        actividad.setObservaciones(actividadRequest.getObservaciones());
        actividad.setTurno(actividadRequest.getTurno());
        return actividad;
    }
    public static void updateEntityFromRequest(ActividadRequest actividadRequest, Actividad actividad) {
        actividad.setEmpleado(actividadRequest.getEmpleado());
        actividad.setFechaActividad(actividadRequest.getFechaActividad());
        actividad.setDescripcion(actividadRequest.getDescripcion());
        actividad.setHoraActividad(actividadRequest.getHoraActividad());
        actividad.setObservaciones(actividadRequest.getObservaciones());
        actividad.setTurno(actividadRequest.getTurno());

    }
}
