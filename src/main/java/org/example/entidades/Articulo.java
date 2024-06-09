package org.example.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Articulo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "Articulo")
    protected String articulo;

    @Column(name = "precio_venta")
    protected Double precioVenta;

    // Relaciones
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imagen_promocion")
    private Imagen imagenPromocion;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_unidad_medida")
    private UnidadMedida unidadmedida;

    // Constructores

    public Articulo() {
    }

    public Articulo(String articulo, Double precioVenta) {
        this.articulo = articulo;
        this.precioVenta = precioVenta;
    }

    public Articulo(String articulo, Double precioVenta, Imagen imagenPromocion) {
        this.articulo = articulo;
        this.precioVenta = precioVenta;
        this.imagenPromocion = imagenPromocion;
    }

    public Articulo(String articulo, Double precioVenta, Imagen imagenPromocion, UnidadMedida unidadmedida) {
        this.articulo = articulo;
        this.precioVenta = precioVenta;
        this.imagenPromocion = imagenPromocion;
        this.unidadmedida = unidadmedida;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Imagen getImagenPromocion() {
        return imagenPromocion;
    }

    public void setImagenPromocion(Imagen imagenPromocion) {
        this.imagenPromocion = imagenPromocion;
    }

    public UnidadMedida getUnidadmedida() {
        return unidadmedida;
    }

    public void setUnidadmedida(UnidadMedida unidadmedida) {
        this.unidadmedida = unidadmedida;
    }
}
