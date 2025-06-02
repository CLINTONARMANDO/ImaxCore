package com.imax.backend.ImaxCore.modules.planillas.login;

import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloResponse;
import com.imax.backend.ImaxCore.modules.planillas.modulos.ModuloMapper;
import com.imax.backend.ImaxCore.modules.planillas.usuarios.Usuario;
import com.imax.backend.ImaxCore.modules.planillas.usuarios.UsuarioRepository;
import com.imax.backend.ImaxCore.security.JwtUtil;
import com.imax.backend.ImaxCore.modules.planillas.login.dtos.AuthRequest;
import com.imax.backend.ImaxCore.modules.planillas.login.dtos.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioRepository usuarioRepo;

    public AuthResponse login(AuthRequest request) {
        // Autenticar
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // Obtener usuario
        Usuario usuario = usuarioRepo.findByNombreusuario(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!usuario.getVigente()) {
            throw new DisabledException("Usuario deshabilitado");
        }

        // Generar token
        String token = jwtUtil.generateToken(
                usuario.getNombreusuario(),
                usuario.getRol().getNombre()
        );

        // Construir árbol de módulos desde los padres
        List<ModuloResponse> modulosJerarquicos = usuario.getRol()
                .getModulos()
                .stream()
                .filter(modulo -> modulo.getModuloPadre() == null)
                .map(ModuloMapper::toResponseRecursivo)
                .collect(Collectors.toList());

        return new AuthResponse(token, modulosJerarquicos);
    }

}
