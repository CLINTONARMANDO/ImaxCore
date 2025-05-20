package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.response.TurnoResponse;
import com.imax.backend.ImaxCore.model.Turno;

public class TurnoMapper {
    public static TurnoResponse toResponse(Turno turno) {
        TurnoResponse turnoResponse = new TurnoResponse();
        turnoResponse.setId(turno.getId());
        turnoResponse.setNombre(turno.getNombre());
        return turnoResponse;
    }
    public static Turno toEntity(TurnoResponse turnoResponse) {
        Turno turno = new Turno();
        turno.setId(turnoResponse.getId());
        turno.setNombre(turnoResponse.getNombre());
        return turno;
    }
    public static void RegistroAsistenciaRequest(Turno turno, TurnoResponse turnoResponse) {
        turno.setNombre(turnoResponse.getNombre());
    }
}
