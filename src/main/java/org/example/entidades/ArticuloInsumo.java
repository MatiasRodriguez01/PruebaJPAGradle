package org.example.entidades;

import javax.persistence.*;

@Entity
@Table(name = "articulo_insumo")
public class ArticuloInsumo extends Articulo{

    @Column(name = "precio_compra")
    private Double precioCompra;

    @Column(name = "stock_actual")
    private Integer stockActual;

    @Column(name = "stock_maximo")
    private Integer stockMaximo;

    @Column(name = "es_para_elaborar")
    private boolean esParaElaborar;

    public ArticuloInsumo() {
    }

    public ArticuloInsumo(String articulo, Double precioVenta, Imagen imagenPromocion, UnidadMedida unidadmedida) {
        super(articulo, precioVenta, imagenPromocion, unidadmedida);
    }

    public ArticuloInsumo(String articulo, Double precioVenta, Imagen imagenPromocion, UnidadMedida unidadmedida, Double precioCompra, Integer stockActual, Integer stockMaximo, boolean esParaElaborar) {
        super(articulo, precioVenta, imagenPromocion, unidadmedida);
        this.precioCompra = precioCompra;
        this.stockActual = stockActual;
        this.stockMaximo = stockMaximo;
        this.esParaElaborar = esParaElaborar;
    }

    // Getters and setters

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Integer getStockActual() {
        return stockActual;
    }

    public void setStockActual(Integer stockActual) {
        this.stockActual = stockActual;
    }

    public Integer getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(Integer stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public boolean isEsParaElaborar() {
        return esParaElaborar;
    }

    public void setEsParaElaborar(boolean esParaElaborar) {
        this.esParaElaborar = esParaElaborar;
    }
}
