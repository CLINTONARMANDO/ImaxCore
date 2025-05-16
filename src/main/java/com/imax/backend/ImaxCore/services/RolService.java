package com.imax.backend.ImaxCore.services;

import com.imax.backend.ImaxCore.model.Rol;
import com.imax.backend.ImaxCore.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodas() {
        return rolRepository.findAllByVigenteTrue();
    }

    public Optional<Rol> buscarPorId(long id) {
        return rolRepository.findById(id);
    }

    public Rol guardar(Rol r) {
        return rolRepository.save(r);
    }

    public void eliminar(Long id) {
        Optional<Rol> rolOpt = rolRepository.findById(id);
        rolOpt.ifPresent(rol -> {
            rol.setVigente(false);
            rolRepository.save(rol);
        });
    }
}
