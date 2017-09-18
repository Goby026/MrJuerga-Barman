package Modelo;

/**
 *
 * @author Grover
 */
public class Preparacion {
    private int idPreparacion;
    private int idProducto;
    private int idProductoPresentacion;
    private double cantidad;
    private String detalles;

    public Preparacion() {
    }

    public Preparacion(int idPreparacion, int idProducto, int idProductoPresentacion, double cantidad, String detalles) {
        this.idPreparacion = idPreparacion;
        this.idProducto = idProducto;
        this.idProductoPresentacion = idProductoPresentacion;
        this.cantidad = cantidad;
        this.detalles = detalles;
    }

    public int getIdPreparacion() {
        return idPreparacion;
    }

    public void setIdPreparacion(int idPreparacion) {
        this.idPreparacion = idPreparacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Preparacion{" + "idPreparacion=" + idPreparacion + ", idProducto=" + idProducto + ", idProductoPresentacion=" + idProductoPresentacion + ", cantidad=" + cantidad + ", detalles=" + detalles + '}';
    }
    
}
