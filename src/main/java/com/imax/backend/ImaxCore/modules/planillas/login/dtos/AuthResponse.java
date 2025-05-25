package com.imax.backend.ImaxCore.modules.planillas.login.dtos;

import com.imax.backend.ImaxCore.modules.planillas.modulos.dtos.ModuloResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthResponse {
    private String token;
    private List<ModuloResponse> modulos;

    public AuthResponse(String token, List<ModuloResponse> modulos) {
        this.token = token;
        this.modulos = modulos;
    }
}
