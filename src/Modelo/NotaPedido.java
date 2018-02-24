/*
Clase para listar los datos de nota de pedido, para sumarlos con los datos de ventas reales
 */
package Modelo;

/**
 *
 * @author MARCEL
 */
public class NotaPedido {
    private int idProducto;
    private String producto;
    private String presentacion;
    private Double cantidad;

    public NotaPedido() {
    }

    public NotaPedido(int idProducto, String producto, String presentacion, Double cantidad) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
