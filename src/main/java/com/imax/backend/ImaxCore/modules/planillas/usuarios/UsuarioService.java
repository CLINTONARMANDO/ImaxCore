package com.imax.backend.ImaxCore.modules.planillas.usuarios;

import com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos.UsuarioRequest;
import com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos.UsuarioResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.roles.Rol;
import com.imax.backend.ImaxCore.modules.planillas.personas.PersonaRepository;
import com.imax.backend.ImaxCore.modules.planillas.roles.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;



    public List<UsuarioResponse> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAllByVigenteTrue();
        return usuarios
                .stream()
                .map(UsuarioMapper::toResponse)
                .toList();
    }
    public UsuarioResponse buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return UsuarioMapper.toResponse(usuario);
    }

    public UsuarioResponse guardar(UsuarioRequest usuarioRequest) {
        Persona persona = personaRepository.findById(usuarioRequest.getPersonaId())
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
        Rol rol = rolRepository.findById(usuarioRequest.getRolId())
                .orElseThrow(() -> new RuntimeException("No se encontro el rol"));

        Usuario usuario = UsuarioMapper.toEntity(usuarioRequest, persona, rol);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponse(usuarioGuardado);
    }

    public void eliminar(Long id) {
        Optional<Usuario> usuarOpt = usuarioRepository.findById(id);
        usuarOpt.ifPresent(usuario -> {
            usuario.setVigente(false);
            usuarioRepository.save(usuario);
        });
    }

}
