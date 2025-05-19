package com.imax.backend.ImaxCore.dto.request;

public class PuestoRequest {

    private Long id_puesto;
    private String nombre;
    private String descripcion;
    private String areaDefault;

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
    public String getAreaDefault() {
        return areaDefault;
    }
    public void setAreaDefault(String areaDefault) {
        this.areaDefault = areaDefault;
    }
}
