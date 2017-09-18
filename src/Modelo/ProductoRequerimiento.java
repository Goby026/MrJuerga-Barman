
package Modelo;

/**
 *
 * @author Grover
 */
public class ProductoRequerimiento {
    
    private int idProductoRequerimiento;
    private int idRequerimiento;
    private int idProductoPresentacion;
    private int cantidad;
    private Medida medida;

    public ProductoRequerimiento() {
    }

    public ProductoRequerimiento(int idProductoRequerimiento, int idRequerimiento, int idProductoPresentacion, int cantidad, Medida medida) {
        this.idProductoRequerimiento = idProductoRequerimiento;
        this.idRequerimiento = idRequerimiento;
        this.idProductoPresentacion = idProductoPresentacion;
        this.cantidad = cantidad;
        this.medida = medida;
    }

    public int getIdProductoRequerimiento() {
        return idProductoRequerimiento;
    }

    public void setIdProductoRequerimiento(int idProductoRequerimiento) {
        this.idProductoRequerimiento = idProductoRequerimiento;
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    @Override
    public String toString() {
        return "ProductoRequerimiento{" + "idProductoRequerimiento=" + idProductoRequerimiento + ", idRequerimiento=" + idRequerimiento + ", idProductoPresentacion=" + idProductoPresentacion + ", cantidad=" + cantidad + ", medida=" + medida + '}';
    }

    
}
