package org.example.entidades;

import javax.persistence.*;

@Entity
@Table(name = "articulo_manufacturado")
public class ArticuloManufacturado extends Articulo{

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "tiempo_estimado_en_minutos")
    private Integer tiempoEstimadoMinutos;

    @Column(name = "preparacion")
    private String preparacion;

    public ArticuloManufacturado() {
    }

    public ArticuloManufacturado(String articulo, Double precioVenta, Imagen imagenPromocion, UnidadMedida unidadmedida) {
        super(articulo, precioVenta, imagenPromocion, unidadmedida);
    }

    public ArticuloManufacturado(String articulo, Double precioVenta, Imagen imagenPromocion, UnidadMedida unidadmedida, String descripcion, Integer tiempoEstimadoMinutos, String preparacion) {
        super(articulo, precioVenta, imagenPromocion, unidadmedida);
        this.descripcion = descripcion;
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
        this.preparacion = preparacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getTiempoEstimadoMinutos() {
        return tiempoEstimadoMinutos;
    }

    public void setTiempoEstimadoMinutos(Integer tiempoEstimadoMinutos) {
        this.tiempoEstimadoMinutos = tiempoEstimadoMinutos;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}
