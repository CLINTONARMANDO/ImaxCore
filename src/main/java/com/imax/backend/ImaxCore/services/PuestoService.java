package com.imax.backend.ImaxCore.services;

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

    public List<Puesto> listarTodas() {
        return puestoRepository.findAllByVigenteTrue();
    }

    public Optional<Puesto> buscarPorId(long id) {
        return puestoRepository.findById(id);
    }

    public Puesto guardar(Puesto p) {
        return puestoRepository.save(p);
    }

    public void eliminar(Long id) {
        Optional<Puesto> puestoOpt = puestoRepository.findById(id);
        puestoOpt.ifPresent(puesto -> {
            puesto.setVigente(false);
            puestoRepository.save(puesto);
        });
    }
}
