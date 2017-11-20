/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author MARCEL
 */
public class TrasladoProdPres {

    private int idTrasladoProdPres;
    private int idTraslado;
    private int idProductoPresentacion;
    private int cantidad;
    private String origen;
    private String destino;

    public TrasladoProdPres() {
    }

    public TrasladoProdPres(int idTrasladoProdPres, int idTraslado, int idProductoPresentacion, int cantidad, String origen, String destino) {
        this.idTrasladoProdPres = idTrasladoProdPres;
        this.idTraslado = idTraslado;
        this.idProductoPresentacion = idProductoPresentacion;
        this.cantidad = cantidad;
        this.origen = origen;
        this.destino = destino;
    }

    public int getIdTrasladoProdPres() {
        return idTrasladoProdPres;
    }

    public void setIdTrasladoProdPres(int idTrasladoProdPres) {
        this.idTrasladoProdPres = idTrasladoProdPres;
    }

    public int getIdTraslado() {
        return idTraslado;
    }

    public void setIdTraslado(int idTraslado) {
        this.idTraslado = idTraslado;
    }

    public int getIdProductoPresentacion() {
        return idProductoPresentacion;
    }

    public void setIdProductoPresentacion(int idProductoPresentacion) {
        this.idProductoPresentacion = idProductoPresentacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "TrasladoProdPres{" + "idTrasladoProdPres=" + idTrasladoProdPres + ", idTraslado=" + idTraslado + ", idProductoPresentacion=" + idProductoPresentacion + ", cantidad=" + cantidad + ", origen=" + origen + ", destino=" + destino + '}';
    }    

}
