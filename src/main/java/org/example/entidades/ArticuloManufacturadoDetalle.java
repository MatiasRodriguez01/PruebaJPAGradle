package org.example.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articulo_manufacturado_detalle")
public class ArticuloManufacturadoDetalle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cantidad")
    private Integer cantidad;

    // Relaciones
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "articulo_manufacturado")
    private ArticuloManufacturado articuloManufacturado;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    // constructores
    public ArticuloManufacturadoDetalle() {
    }

    public ArticuloManufacturadoDetalle(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public ArticuloManufacturadoDetalle(Integer cantidad, ArticuloManufacturado articuloManufacturado) {
        this.cantidad = cantidad;
        this.articuloManufacturado = articuloManufacturado;
    }


    public ArticuloManufacturadoDetalle(Integer cantidad, ArticuloManufacturado articuloManufacturado, ArticuloInsumo articuloInsumo) {
        this.cantidad = cantidad;
        this.articuloManufacturado = articuloManufacturado;
        this.articuloInsumo = articuloInsumo;
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

    public ArticuloManufacturado getArticuloManufacturado() {
        return articuloManufacturado;
    }

    public void setArticuloManufacturado(ArticuloManufacturado articuloManufacturado) {
        this.articuloManufacturado = articuloManufacturado;
    }

    public ArticuloInsumo getArticuloInsumo() {
        return articuloInsumo;
    }

    public void setArticuloInsumo(ArticuloInsumo articuloInsumo) {
        this.articuloInsumo = articuloInsumo;
    }
}
