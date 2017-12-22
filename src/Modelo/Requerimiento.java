/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author USER
 */
public class Requerimiento {
    private int idRequerimiento;
    private int idUsuario;
    private int idAlmacen;
    private int idFlujoInventario;
    private String fecha;
    private String hora;
    private String observacion;
    private int estado;

    public Requerimiento(int idRequerimiento, int idUsuario, int idAlmacen, int idFlujoInventario, String fecha, String hora, String observacion, int estado) {
        this.idRequerimiento = idRequerimiento;
        this.idUsuario = idUsuario;
        this.idAlmacen = idAlmacen;
        this.idFlujoInventario = idFlujoInventario;
        this.fecha = fecha;
        this.hora = hora;
        this.observacion = observacion;
        this.estado = estado;
    }
    
    public Requerimiento() {
    }

    public int getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(int idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public int getIdFlujoInventario() {
        return idFlujoInventario;
    }

    public void setIdFlujoInventario(int idFlujoInventario) {
        this.idFlujoInventario = idFlujoInventario;
    }    
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Requerimiento{" + "idRequerimiento=" + idRequerimiento + ", idUsuario=" + idUsuario + ", idAlmacen=" + idAlmacen + ", idFlujoInventario=" + idFlujoInventario + ", fecha=" + fecha + ", hora=" + hora + ", observacion=" + observacion + ", estado=" + estado + '}';
    }   
    
}
