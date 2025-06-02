package com.imax.backend.ImaxCore.modules.planillas.areas;

import com.imax.backend.ImaxCore.modules.planillas.areas.dtos.AreaRequest;
import com.imax.backend.ImaxCore.modules.planillas.areas.dtos.AreaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    AreaRepository areaRepository;

    public List<AreaResponse> listarTodas() {
        List<Area> areas = areaRepository.findAll();
        return areas
                .stream()
                .map(AreaMapper::toResponse)
                .toList();
    }
    public AreaResponse buscarPorId(Long id) {
        Area area = areaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Area no encontrada"));

        return AreaMapper.toResponse(area);
    }
    public AreaResponse guardar(AreaRequest areaRequest) {
        Area area = AreaMapper.toRentity(areaRequest);
        Area areaGuardada = areaRepository.save(area);
        return AreaMapper.toResponse(areaGuardada);
    }
}
