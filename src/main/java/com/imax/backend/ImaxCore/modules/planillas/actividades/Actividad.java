package com.imax.backend.ImaxCore.modules.planillas.actividades;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import com.imax.backend.ImaxCore.modules.planillas.turnos.Turno;
import com.imax.backend.ImaxCore.modules.planillas.empleados.Empleado;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "actividades")
public class Actividad extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long idActividad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "fecha_actividad")
    private LocalDate fechaActividad;

    @Column(name = "horaActividad")
    private LocalTime horaActividad;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "observaciones")
    private String observaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turno")
    private Turno turno;

    public Long getIdActividad() {
        return idActividad;
    }
    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
    }
    public Empleado getEmpleado() {
        return empleado;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public LocalDate getFechaActividad() {
        return fechaActividad;
    }
    public void setFechaActividad(LocalDate fechaActividad) {
        this.fechaActividad = fechaActividad;
    }
    public LocalTime getHoraActividad() {
        return horaActividad;
    }
    public void setHoraActividad(LocalTime horaActividad) {
        this.horaActividad = horaActividad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public Turno getTurno() {
        return turno;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
}
