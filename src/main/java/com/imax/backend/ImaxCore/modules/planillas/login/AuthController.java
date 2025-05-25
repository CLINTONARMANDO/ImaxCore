package com.imax.backend.ImaxCore.modules.planillas.login;

import com.imax.backend.ImaxCore.modules.planillas.login.dtos.AuthRequest;
import com.imax.backend.ImaxCore.modules.planillas.login.dtos.AuthResponse;
import com.imax.backend.ImaxCore.shared.ErrorResponse;
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
            return ResponseEntity.status(401).body(new ErrorResponse("Credenciales inválidas"));

        } catch (AuthenticationException ex) {
            return ResponseEntity.status(402).body(new ErrorResponse("Error al Autenticar"));
        }
    }
}
