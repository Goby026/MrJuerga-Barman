package Modelo;

/**
 *
 * @author Marce
 */
public class ProductoPresentacion {

    int idProductoPresentacion;
    private int idProducto;
    private int idPresentacion;
    private int idalmacen;
    private double stock;
    private double stock2;
    private double stock3;
    private double precio;
    private double precio2;
    private int idcategoria;
    
    

    public ProductoPresentacion() {
    }

    public ProductoPresentacion(int idProductoPresentacion, int idProducto, int idPresentacion, int idalmacen, double stock, double stock2, double stock3, double precio, double precio2, int idcategoria) {
        this.idProductoPresentacion = idProductoPresentacion;
        this.idProducto = idProducto;
        this.idPresentacion = idPresentacion;
        this.idalmacen = idalmacen;
        this.stock = stock;
        this.stock2 = stock2;
        this.stock3 = stock3;
        this.precio = precio;
        this.precio2 = precio2;
        this.idcategoria = idcategoria;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getStock2() {
        return stock2;
    }

    public void setStock2(double stock2) {
        this.stock2 = stock2;
    }

    public double getStock3() {
        return stock3;
    }

    public void setStock3(double stock3) {
        this.stock3 = stock3;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecio2() {
        return precio2;
    }

    public void setPrecio2(double precio2) {
        this.precio2 = precio2;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    

}
