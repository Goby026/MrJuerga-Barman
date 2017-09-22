
package Modelo;

public class ConteoProducto {
    private int idConteoProducto;
    private int idconteo;
    private int idProductoPresentacion;
    private int idPresentacion;
    private Medida medida;
    private int stock;

    public ConteoProducto() {
    }

    public ConteoProducto(int idConteoProducto, int idconteo, int idProductoPresentacion, int idPresentacion, Medida medida, int stock) {
        this.idConteoProducto = idConteoProducto;
        this.idconteo = idconteo;
        this.idProductoPresentacion = idProductoPresentacion;
        this.idPresentacion = idPresentacion;
        this.medida = medida;
        this.stock = stock;
    }

    public int getIdConteoProducto() {
        return idConteoProducto;
    }

    public void setIdConteoProducto(int idConteoProducto) {
        this.idConteoProducto = idConteoProducto;
    }

    public int getIdconteo() {
        return idconteo;
    }

    public void setIdconteo(int idconteo) {
        this.idconteo = idconteo;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public int getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(int idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Medida getMedida() {
        return medida;
    }

    public void setMedida(Medida medida) {
        this.medida = medida;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ConteoProducto{" + "idConteoProducto=" + idConteoProducto + ", idconteo=" + idconteo + ", idProductoPresentacion=" + idProductoPresentacion + ", idPresentacion=" + idPresentacion + ", medida=" + medida + ", stock=" + stock + '}';
    }

}


