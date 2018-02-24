//Clase para modelar los datos de entrada general que se necesita para los calculos de barman
package Modelo;

/**
 *
 * @author MARCEL
 */
public class VentaGeneral {
    private int codProducto;
    private String producto;
    private String presentacion;
    private double cantidad;

    public VentaGeneral() {
    }

    public VentaGeneral(int codProducto, String producto, String presentacion, double cantidad) {
        this.codProducto = codProducto;
        this.producto = producto;
        this.presentacion = presentacion;
        this.cantidad = cantidad;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
