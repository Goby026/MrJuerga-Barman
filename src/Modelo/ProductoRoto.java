package Modelo;

/**
 *
 * @author MARCEL
 */
public class ProductoRoto {

    private int idproductoroto;
    private int idproductopresentacion;
    private int idflujoinventario;
    private double cantidad;
    private double precio;

    public ProductoRoto(int idproductoroto, int idproductopresentacion, int idflujoinventario, double cantidad, double precio) {
        this.idproductoroto = idproductoroto;
        this.idproductopresentacion = idproductopresentacion;
        this.idflujoinventario = idflujoinventario;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public ProductoRoto() {
    }

    public int getIdproductoroto() {
        return idproductoroto;
    }

    public void setIdproductoroto(int idproductoroto) {
        this.idproductoroto = idproductoroto;
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
