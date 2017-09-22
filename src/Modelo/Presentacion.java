/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Adolfo -- updated by Grover
 */
public class Presentacion implements Serializable{
    private Integer idPresentacion;
    private String descripcion;
    private Double valorMl;

    public Presentacion() {
    }

    public Presentacion(Integer idPresentacion, String descripcion, Double valorMl) {
        this.idPresentacion = idPresentacion;
        this.descripcion = descripcion;
        this.valorMl = valorMl;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorMl() {
        return valorMl;
    }

    public void setValorMl(Double valorMl) {
        this.valorMl = valorMl;
    }

    @Override
    public String toString() {
        return descripcion ;
    }
    
}
