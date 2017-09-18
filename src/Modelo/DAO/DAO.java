/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.DAO;

import java.util.List;

/**
 *
 * @author MARCEL
 */
public interface DAO<Param> {
    public boolean Registrar(Param p) throws Exception;
    public boolean Modificar(Param p) throws Exception;
    public boolean Anular(int id) throws Exception;
    public boolean Eliminar(int id) throws Exception;
    public Param Obtener(int id) throws Exception;
    public List<Param> Listar()throws Exception;
}
