package com.imax.backend.ImaxCore.modules.planillas.usuarios;

import com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos.UsuarioRequest;
import com.imax.backend.ImaxCore.modules.planillas.usuarios.dtos.UsuarioResponse;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.roles.Rol;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {


    private static BCryptPasswordEncoder encoder;

    public UsuarioMapper(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

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

    public static void updateEntityFromRequest(UsuarioRequest usuarioRequest,Usuario usuario, Persona persona, Rol rol) {
        usuario.setNombreusuario(usuarioRequest.getNombreusuario());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setPasswordHash(encoder.encode(usuarioRequest.getPassword()));
        usuario.setVigente(true);
        usuario.setRol(rol);

    }
}
