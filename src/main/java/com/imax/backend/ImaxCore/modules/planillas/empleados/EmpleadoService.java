package com.imax.backend.ImaxCore.modules.planillas.empleados;

import com.imax.backend.ImaxCore.modules.planillas.areas.Area;
import com.imax.backend.ImaxCore.modules.planillas.areas.AreaRepository;
import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoRequest;
import com.imax.backend.ImaxCore.modules.planillas.empleados.dtos.EmpleadoResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.personas.PersonaRepository;
import com.imax.backend.ImaxCore.modules.planillas.puestos.Puesto;
import com.imax.backend.ImaxCore.modules.planillas.puestos.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private AreaRepository areaRepository;
    @Autowired
    private PersonaRepository personaRepository;
    @Autowired
    private PuestoRepository puestoRepository;

    public List<EmpleadoResponse> listarTodas() {
        List<Empleado> empleados = empleadoRepository.findAll();

        return empleados
                .stream()
                .map(EmpleadoMapper::toResponse)
                .toList();
    }
    public EmpleadoResponse guardar(EmpleadoRequest empleadoRequest) {
        Area area = areaRepository.findById(empleadoRequest.getIdArea())
                .orElseThrow(() -> new RuntimeException("No existe el area"));
        Persona persona = personaRepository.findById(empleadoRequest.getIdPersona())
                .orElseThrow(() -> new RuntimeException("No existe el persona"));
        Puesto puesto = puestoRepository.findById(empleadoRequest.getIdPuesto())
                .orElseThrow(() -> new RuntimeException("No existe el puesto"));


        Empleado empleado = EmpleadoMapper.toEntity(empleadoRequest, area, persona, puesto) ;
        empleado = empleadoRepository.save(empleado);

        return EmpleadoMapper.toResponse(empleado);
    }

}
