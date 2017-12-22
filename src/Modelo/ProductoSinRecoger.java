
package Modelo;

/**
 *
 * @author MARCEL
 */
public class ProductoSinRecoger {
    private int idproductosinrecoger;
    private int idproductopresentacion;
    private int idflujoinventario;
    private double cantidad;
    private double precio;

    public ProductoSinRecoger(int idproductosinrecoger, int idproductopresentacion, int idflujoinventario, double cantidad, double precio) {
        this.idproductosinrecoger = idproductosinrecoger;
        this.idproductopresentacion = idproductopresentacion;
        this.idflujoinventario = idflujoinventario;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoSinRecoger() {
    }

    public int getIdproductosinrecoger() {
        return idproductosinrecoger;
    }

    public void setIdproductosinrecoger(int idproductosinrecoger) {
        this.idproductosinrecoger = idproductosinrecoger;
    }

    public int getIdproductopresentacion() {
        return idproductopresentacion;
    }

    public void setIdproductopresentacion(int idproductopresentacion) {
        this.idproductopresentacion = idproductopresentacion;
    }

    public int getIdflujoinventario() {
        return idflujoinventario;
    }

    public void setIdflujoinventario(int idflujoinventario) {
        this.idflujoinventario = idflujoinventario;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
        
}
