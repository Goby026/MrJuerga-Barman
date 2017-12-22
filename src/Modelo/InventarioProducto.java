
package Modelo;

/**
 *
 * @author Grover
 */
public class InventarioProducto {
    private int idinventarioproducto;
    private int idinventario;
    private int idproductopresentacion;
    private double cantidad;
    private double cantidad_final;

    public InventarioProducto(int idinventarioproducto, int idinventario, int idproductopresentacion, double cantidad, double cantidad_final) {
        this.idinventarioproducto = idinventarioproducto;
        this.idinventario = idinventario;
        this.idproductopresentacion = idproductopresentacion;
        this.cantidad = cantidad;
        this.cantidad_final = cantidad_final;
    }   

    public InventarioProducto() {
    }

    public int getIdinventarioproducto() {
        return idinventarioproducto;
    }

    public void setIdinventarioproducto(int idinventarioproducto) {
        this.idinventarioproducto = idinventarioproducto;
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public int getIdproductopresentacion() {
        return idproductopresentacion;
    }

    public void setIdproductopresentacion(int idproductopresentacion) {
        this.idproductopresentacion = idproductopresentacion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad_final() {
        return cantidad_final;
    }

    public void setCantidad_final(double cantidad_final) {
        this.cantidad_final = cantidad_final;
    }
    
}
