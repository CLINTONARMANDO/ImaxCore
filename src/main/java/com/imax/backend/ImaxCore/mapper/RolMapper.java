package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.RolRequest;
import com.imax.backend.ImaxCore.dto.response.RolResponse;
import com.imax.backend.ImaxCore.model.Rol;

public class RolMapper {

    public static RolResponse toResponse(Rol rol) {
        RolResponse rolResponse = new RolResponse();
        rolResponse.setId_rol(rol.getId_rol());
        rolResponse.setNombre(rol.getNombre());
        rolResponse.setDescripcion(rol.getDescripcion());
        return rolResponse;
    }
    public static Rol toEntity(RolRequest rolRequest) {
        Rol rol = new Rol();
        rol.setId_rol(rolRequest.getId_rol());
        rol.setNombre(rolRequest.getNombre());
        rol.setDescripcion(rolRequest.getDescripcion());
        return rol;
    }
    public static void updateEntityFromRequest(Rol rol, RolRequest rolRequest) {
        rol.setNombre(rolRequest.getNombre());
        rol.setDescripcion(rolRequest.getDescripcion());
    }

}
