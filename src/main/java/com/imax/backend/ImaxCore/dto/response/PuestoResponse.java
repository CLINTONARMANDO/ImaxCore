package com.imax.backend.ImaxCore.dto.response;

import com.imax.backend.ImaxCore.model.Area;

public class PuestoResponse {

    private Long id_puesto;
    private String nombre;
    private String descripcion;
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
