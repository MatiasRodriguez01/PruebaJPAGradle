package org.example.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "promocion_detalle")
public class PromocionDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    // Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_promocion")
    private Promocion promocion;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_articulo")
    private Articulo articulo;
    // Constructores;

    public PromocionDetalle() {
    }

    public PromocionDetalle(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public PromocionDetalle(Integer cantidad, Promocion promocion) {
        this.cantidad = cantidad;
        this.promocion = promocion;
    }

    public PromocionDetalle(Integer cantidad, Promocion promocion, Articulo articulo) {
        this.cantidad = cantidad;
        this.promocion = promocion;
        this.articulo = articulo;
    }



    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}
