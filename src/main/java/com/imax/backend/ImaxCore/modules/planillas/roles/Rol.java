package com.imax.backend.ImaxCore.modules.planillas.roles;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import com.imax.backend.ImaxCore.modules.planillas.modulos.Modulo;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class Rol extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "rol_modulo",
            joinColumns = @JoinColumn(name = "id_rol"),
            inverseJoinColumns = @JoinColumn(name = "id_modulo")
    )
    private List<Modulo> modulos;

// + su getter y setter


    public Long getId_rol() {
        return id_rol;
    }
    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }
    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }
}
