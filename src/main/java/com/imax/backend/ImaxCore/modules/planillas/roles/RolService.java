package com.imax.backend.ImaxCore.modules.planillas.roles;

import com.imax.backend.ImaxCore.modules.planillas.roles.dtos.RolRequest;
import com.imax.backend.ImaxCore.modules.planillas.roles.dtos.RolResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<RolResponse> listarTodas() {
        List<Rol> rols = rolRepository.findAllByVigenteTrue();

        return rols
                .stream()
                .map(RolMapper::toResponse)
                .toList();
    }

    public RolResponse buscarPorId(long id) {
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        return RolMapper.toResponse(rol);
    }

    public RolResponse guardar(RolRequest rolRequest) {
        Rol rol = RolMapper.toEntity(rolRequest);
        Rol rolGuarado = rolRepository.save(rol);
        return RolMapper.toResponse(rolGuarado);
    }
    public RolResponse actualizar(Long id, RolRequest rolRequest) {
        Rol rolExistente = rolRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        RolMapper.updateEntityFromRequest(rolExistente, rolRequest);

        Rol rolActualizado = rolRepository.save(rolExistente);
        return RolMapper.toResponse(rolActualizado);
    }

    public void eliminar(Long id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        rolOpt.ifPresent(rol -> {
            rol.setVigente(false);
            rolRepository.save(rol);
        });
    }
}
