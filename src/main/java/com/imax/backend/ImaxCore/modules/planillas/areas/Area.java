package com.imax.backend.ImaxCore.modules.planillas.areas;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import com.imax.backend.ImaxCore.modules.planillas.empleados.Empleado;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "areas")
public class Area extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "area",fetch = FetchType.LAZY)
    private List<Empleado> empleados;

    // Getters y Setters
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
