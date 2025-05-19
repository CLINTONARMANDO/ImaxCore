package com.imax.backend.ImaxCore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "puestos")
public class Puesto extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_puesto;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    private Area area;

    public Long getId_puesto() {
        return id_puesto;
    }
    public void setId_puesto(Long id_puesto) {
        this.id_puesto = id_puesto;
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

    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }

}
