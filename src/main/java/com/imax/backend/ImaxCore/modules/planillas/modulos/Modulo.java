package com.imax.backend.ImaxCore.modules.planillas.modulos;

import com.imax.backend.ImaxCore.shared.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "modulos")
public class Modulo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_modulo")
    private Long idModulo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "modulo_padre_id") // clave foránea
    private Modulo moduloPadre;

    @OneToMany(mappedBy = "moduloPadre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Modulo> submodulos = new ArrayList<>();

}
