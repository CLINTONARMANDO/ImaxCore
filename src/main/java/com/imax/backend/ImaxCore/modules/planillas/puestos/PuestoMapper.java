package com.imax.backend.ImaxCore.modules.planillas.puestos;

import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoRequest;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoResponse;

public class PuestoMapper {

    public static PuestoResponse toResponse(Puesto puesto) {
        PuestoResponse puestoResponse = new PuestoResponse();
        puestoResponse.setId_puesto(puesto.getId_puesto());
        puestoResponse.setNombre(puesto.getNombre());
        puestoResponse.setDescripcion(puesto.getDescripcion());
        puestoResponse.setArea(puesto.getArea());

        return puestoResponse;
    }
    public static Puesto toEntity(PuestoRequest puestoRequest) {
        Puesto puesto = new Puesto();
        puesto.setId_puesto(puestoRequest.getId_puesto());
        puesto.setNombre(puestoRequest.getNombre());
        puesto.setDescripcion(puestoRequest.getDescripcion());
        puesto.setArea(puestoRequest.getArea());
        return puesto;
    }
    public static void updateFromRequest(Puesto puesto, PuestoRequest puestoRequest) {
        puesto.setNombre(puestoRequest.getNombre());
        puesto.setDescripcion(puestoRequest.getDescripcion());
        puesto.setArea(puestoRequest.getArea());
    }
}
