package com.imax.backend.ImaxCore.modules.planillas.puestos;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import com.imax.backend.ImaxCore.modules.planillas.areas.AreaRepository;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoRequest;
import com.imax.backend.ImaxCore.modules.planillas.puestos.dtos.PuestoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;
    @Autowired
    private AreaRepository areaRepository;

    public List<PuestoResponse> listarTodas() {
        List<Puesto> puestos = puestoRepository.findAllByVigenteTrue();
        return puestos
                .stream()
                .map(PuestoMapper::toResponse)
                .toList();
    }

    public PuestoResponse buscarPorId(long id) {
        Puesto puesto = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("puesto no encontrado"));
        return PuestoMapper.toResponse(puesto);
    }

    public PuestoResponse guardar(PuestoRequest puestoRequest) {
        Area area = areaRepository.findById(puestoRequest.getId_area())
                .orElseThrow(() -> new RuntimeException("area no encontrado"));
        Puesto puesto = PuestoMapper.toEntity(puestoRequest, area);
        Puesto puestoGuardado = puestoRepository.save(puesto);
        return PuestoMapper.toResponse(puestoGuardado);
    }

    public PuestoResponse actualizar(Long id, PuestoRequest puestoRequest) {
        Puesto puestoExistente = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("puesto no encontrado"));
        Area area = areaRepository.findById(puestoRequest.getId_area())
                .orElseThrow(() -> new RuntimeException("area no encontrado"));
        PuestoMapper.updateFromRequest(puestoExistente, puestoRequest, area);

        Puesto puestoActualizado = puestoRepository.save(puestoExistente);
        return PuestoMapper.toResponse(puestoActualizado);
    }

    public void eliminar(Long id) {
        Optional<Puesto> puestoOpt = puestoRepository.findById(id);
        puestoOpt.ifPresent(puesto -> {
            puesto.setVigente(false);
            puestoRepository.save(puesto);
        });
    }
}
