package com.imax.backend.ImaxCore.controllers;

import com.imax.backend.ImaxCore.dto.request.AuthRequest;
import com.imax.backend.ImaxCore.dto.response.AuthResponse;
import com.imax.backend.ImaxCore.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            AuthResponse response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        } catch (AuthenticationException ex) {
            return ResponseEntity.status(500).body("Error al autenticar");
        }
    }
}
