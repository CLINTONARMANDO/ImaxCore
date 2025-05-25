package com.imax.backend.ImaxCore.modules.planillas.usuarios;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import com.imax.backend.ImaxCore.modules.planillas.personas.Persona;
import com.imax.backend.ImaxCore.modules.planillas.roles.Rol;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personaid", nullable = false)
    private Persona persona;

    @Column(name = "nombreusuario", nullable = false, unique = true)
    private String nombreusuario;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "passwordhash", nullable = false)
    private String passwordHash;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolid", nullable = false)
    private Rol rol;

    //Getters y Setters
    public Long getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getNombreusuario() {
        return nombreusuario;
    }
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
