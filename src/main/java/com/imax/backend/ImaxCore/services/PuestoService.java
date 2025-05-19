package com.imax.backend.ImaxCore.services;

import com.imax.backend.ImaxCore.dto.request.PuestoRequest;
import com.imax.backend.ImaxCore.dto.response.PuestoResponse;
import com.imax.backend.ImaxCore.mapper.PuestoMapper;
import com.imax.backend.ImaxCore.model.Puesto;
import com.imax.backend.ImaxCore.repository.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoService {

    @Autowired
    private PuestoRepository puestoRepository;

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
        Puesto puesto = PuestoMapper.toEntity(puestoRequest);
        Puesto puestoGuardado = puestoRepository.save(puesto);
        return PuestoMapper.toResponse(puestoGuardado);
    }

    public PuestoResponse actualizar(Long id, PuestoRequest puestoRequest) {
        Puesto puestoExistente = puestoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("puesto no encontrado"));
        PuestoMapper.updateFromRequest(puestoExistente, puestoRequest);

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
