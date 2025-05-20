package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.AreaRequest;
import com.imax.backend.ImaxCore.dto.response.AreaResponse;
import com.imax.backend.ImaxCore.model.Area;

public class AreaMapper {
    public static AreaResponse toResponse(Area area) {
        AreaResponse areaResponse = new AreaResponse();
        areaResponse.setId(area.getId());
        areaResponse.setDescripcion(area.getDescripcion());
        areaResponse.setNombre(area.getNombre());
        return areaResponse;
    }
    public static Area toRentity(AreaRequest areaRequest) {
        Area area = new Area();
        area.setId(areaRequest.getId());
        area.setDescripcion(areaRequest.getDescripcion());
        area.setNombre(areaRequest.getNombre());
        return area;
    }
    public static void updateEntityFromRequest(AreaRequest areaRequest, Area area) {
        area.setDescripcion(areaRequest.getDescripcion());
        area.setNombre(areaRequest.getNombre());
    }
}
