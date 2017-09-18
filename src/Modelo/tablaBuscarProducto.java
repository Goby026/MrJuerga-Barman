package Modelo;

//Clase para presentar los datos en la tabla buscarProductos del formulario ConteoDiario
public class tablaBuscarProducto {

    int idProducto;
    String producto;
    String presentacion;
    int stock;

    public tablaBuscarProducto(int idProducto, String producto, String presentacion, int stock) {
        this.idProducto = idProducto;
        this.producto = producto;
        this.presentacion = presentacion;
        this.stock = stock;
    }

    public tablaBuscarProducto() {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "tablaBuscarProducto{" + "idProducto=" + idProducto + ", producto=" + producto + ", presentacion=" + presentacion + ", stock=" + stock + '}';
    }
    
}
