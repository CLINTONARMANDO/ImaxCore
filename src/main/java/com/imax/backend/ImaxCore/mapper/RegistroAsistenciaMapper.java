package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.RegistroAsistenciaRequest;
import com.imax.backend.ImaxCore.dto.response.RegistroAsistenciaResponse;
import com.imax.backend.ImaxCore.model.RegistroAsistencia;

public class RegistroAsistenciaMapper {
    public static RegistroAsistenciaResponse toResponse(RegistroAsistencia registroAsistencia) {
        RegistroAsistenciaResponse registroAsistenciaResponse = new RegistroAsistenciaResponse();
        registroAsistenciaResponse.setIdTRegistro(registroAsistencia.getIdTRegistro());
        registroAsistenciaResponse.setFechaRegistro(registroAsistencia.getFechaRegistro());
        registroAsistenciaResponse.setEmpleado(registroAsistencia.getEmpleado());
        registroAsistenciaResponse.setHoraEntrada(registroAsistencia.getHoraEntrada());
        registroAsistenciaResponse.setHoraSalida(registroAsistencia.getHoraSalida());
        return registroAsistenciaResponse;
    }
    public static RegistroAsistencia toEntity(RegistroAsistenciaRequest registroAsistenciaRequest) {
        RegistroAsistencia registroAsistencia = new RegistroAsistencia();
        registroAsistencia.setIdTRegistro(registroAsistenciaRequest.getIdTRegistro());
        registroAsistencia.setEmpleado(registroAsistenciaRequest.getEmpleado());
        registroAsistencia.setFechaRegistro(registroAsistenciaRequest.getFechaRegistro());
        registroAsistencia.setHoraEntrada(registroAsistenciaRequest.getHoraEntrada());
        registroAsistencia.setHoraSalida(registroAsistenciaRequest.getHoraSalida());
        return registroAsistencia;
    }
    public static void updateEntityFromRequest(RegistroAsistenciaRequest registroAsistenciaRequest, RegistroAsistencia registroAsistencia){
        registroAsistencia.setEmpleado(registroAsistenciaRequest.getEmpleado());
        registroAsistencia.setFechaRegistro(registroAsistenciaRequest.getFechaRegistro());
        registroAsistencia.setHoraEntrada(registroAsistenciaRequest.getHoraEntrada());
        registroAsistencia.setHoraSalida(registroAsistenciaRequest.getHoraSalida());
    }
}
