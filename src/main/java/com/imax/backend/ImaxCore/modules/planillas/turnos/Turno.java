package com.imax.backend.ImaxCore.modules.planillas.turnos;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "turnos")
public class Turno extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
