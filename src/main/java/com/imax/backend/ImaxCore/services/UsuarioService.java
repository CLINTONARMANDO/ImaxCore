package com.imax.backend.ImaxCore.services;

import com.imax.backend.ImaxCore.dto.request.UsuarioRequest;
import com.imax.backend.ImaxCore.dto.response.UsuarioResponse;
import com.imax.backend.ImaxCore.mapper.UsuarioMapper;
import com.imax.backend.ImaxCore.model.Persona;
import com.imax.backend.ImaxCore.model.Rol;
import com.imax.backend.ImaxCore.model.Usuario;
import com.imax.backend.ImaxCore.repository.PersonaRepository;
import com.imax.backend.ImaxCore.repository.RolRepository;
import com.imax.backend.ImaxCore.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
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

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public List<UsuarioResponse> listarTodos() {
        List<Usuario> usuarios = usuarioRepository.findAll();
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
        if (!usuarioRequest.getPassword().startsWith("$2a$")) {
            String hashedPassword = passwordEncoder.encode(usuarioRequest.getPassword());
            usuarioRequest.setPassword(hashedPassword);
        }
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
