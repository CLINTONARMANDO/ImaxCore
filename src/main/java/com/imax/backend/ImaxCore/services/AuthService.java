package com.imax.backend.ImaxCore.services;

import com.imax.backend.ImaxCore.model.Usuario;
import com.imax.backend.ImaxCore.repository.UsuarioRepository;
import com.imax.backend.ImaxCore.security.JwtUtil;
import com.imax.backend.ImaxCore.dto.request.AuthRequest;
import com.imax.backend.ImaxCore.dto.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Usuario usuario = usuarioRepo.findByNombreusuario(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!usuario.getVigente()) {
            throw new DisabledException("Usuario deshabilitado");
        }

        String token = jwtUtil.generateToken(
                usuario.getNombreusuario(),
                usuario.getRol().getNombre()
        );

        return new AuthResponse(token);
    }

}