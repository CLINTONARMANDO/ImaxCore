package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.PuestoRequest;
import com.imax.backend.ImaxCore.dto.response.PuestoResponse;
import com.imax.backend.ImaxCore.model.Puesto;

public class PuestoMapper {

    public static PuestoResponse toResponse(Puesto puesto) {
        PuestoResponse puestoResponse = new PuestoResponse();
        puestoResponse.setId_puesto(puesto.getId_puesto());
        puestoResponse.setNombre(puesto.getNombre());
        puestoResponse.setDescripcion(puesto.getDescripcion());
        puestoResponse.setAreaDefault(puesto.getAreaDefault());

        return puestoResponse;
    }
    public static Puesto toEntity(PuestoResponse puestoResponse) {
        Puesto puesto = new Puesto();
        puesto.setId_puesto(puestoResponse.getId_puesto());
        puesto.setNombre(puestoResponse.getNombre());
        puesto.setDescripcion(puestoResponse.getDescripcion());
        puesto.setAreaDefault(puestoResponse.getAreaDefault());
        return puesto;
    }
    public static void updateFromRequest(Puesto puesto, PuestoRequest puestoRequest) {
        puesto.setNombre(puestoRequest.getNombre());
        puesto.setDescripcion(puestoRequest.getDescripcion());
        puesto.setAreaDefault(puestoRequest.getAreaDefault());
    }

}
