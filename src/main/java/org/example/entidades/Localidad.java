package org.example.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "localidad")
public class Localidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    // Relaciones

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_provincia")
    private Provincia provincia;

    // Constructores

    public Localidad() {
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Localidad(String nombre, Provincia provincia) {
        this.nombre = nombre;
        this.provincia = provincia;
    }

    // Getters and setters

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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}
