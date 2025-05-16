package com.imax.backend.ImaxCore.mapper;

import com.imax.backend.ImaxCore.dto.request.UsuarioRequest;
import com.imax.backend.ImaxCore.dto.response.UsuarioResponse;
import com.imax.backend.ImaxCore.model.Persona;
import com.imax.backend.ImaxCore.model.Rol;
import com.imax.backend.ImaxCore.model.Usuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioMapper {

    private static BCryptPasswordEncoder encoder;

    public static UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse();
        usuarioResponse.setIdUsuario(usuario.getId_usuario());
        usuarioResponse.setNombreusuario(usuario.getNombreusuario());
        usuarioResponse.setNombreRol(usuario.getRol().getNombre());
        usuarioResponse.setEmail(usuario.getEmail());
        return usuarioResponse;
    }
    public static Usuario toEntity(UsuarioRequest usuarioRequest, Persona persona, Rol rol) {
        Usuario usuario = new Usuario();
        usuario.setPersona(persona);
        usuario.setRol(rol);
        usuario.setNombreusuario(usuarioRequest.getNombreusuario());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPasswordHash(encoder.encode(usuarioRequest.getPassword()));
        usuario.setVigente(true);
        return usuario;
    }
}
