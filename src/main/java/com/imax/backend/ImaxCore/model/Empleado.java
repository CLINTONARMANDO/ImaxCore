package com.imax.backend.ImaxCore.model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "empleados")
public class Empleado extends BaseEntity {
    @Id
    @Column(name = "id_empleado")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_puesto", referencedColumnName = "id_puesto")
    private Puesto puesto;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    // Getters y Setters


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Persona getPersona() {
        return persona;
    }
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Area getArea() {
        return area;
    }
    public void setArea(Area area) {
        this.area = area;
    }
    public Puesto getPuesto() {
        return puesto;
    }
    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }
    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
}
