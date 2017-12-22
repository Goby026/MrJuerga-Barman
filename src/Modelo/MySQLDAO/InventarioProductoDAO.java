/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.InventarioProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class InventarioProductoDAO extends Conexion implements DAO<InventarioProducto>{

    @Override
    public boolean Registrar(InventarioProducto p) throws Exception {
        try {
            this.conectar();
            String sql = "insert into inventarioproductos1(idinventario1, idproductopresentacion, cantidad, cantidad_final) values (?,?,?,?) ";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdinventario());
            pst.setInt(2, p.getIdproductopresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getCantidad_final());
            
            int res = pst.executeUpdate();
            if (res>0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }
    
    public boolean Registrar(InventarioProducto p, int idInventario) throws Exception {
        try {
            this.conectar();
            String sql = "";
            switch(idInventario){
                case 2:
                    sql = "insert into inventarioproductos2(idinventario2, idproductopresentacion, cantidad, cantidad_final) values (?,?,?,?) ";
                    break;
                case 3:
                    sql = "insert into inventarioproductos3(idinventario3, idproductopresentacion, cantidad, cantidad_final) values (?,?,?,?) ";
                    break;
            }            
            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdinventario());
            pst.setInt(2, p.getIdproductopresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getCantidad_final());
            
            int res = pst.executeUpdate();
            if (res>0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }
    
    public boolean RegistrarFinal(InventarioProducto p, int idInventario, int idFlujoInventario) throws Exception {
        //validar si el producto estaba en el inventario inicial, sino entonces registrarlo, para los demas casos acutalizar el campo cantidad_final
        try {
            this.conectar();
            String sql = "";
            switch(idInventario){
                case 2:
                    sql = "insert into inventarioproductos2(idinventario2, idproductopresentacion, cantidad, cantidad_final) values (?,?,?,?) ";
                    break;
                case 3:
                    sql = "insert into inventarioproductos3(idinventario3, idproductopresentacion, cantidad, cantidad_final) values (?,?,?,?) ";
                    break;
            }
            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdinventario());
            pst.setInt(2, p.getIdproductopresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getCantidad_final());
            
            int res = pst.executeUpdate();
            if (res>0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(InventarioProducto p) throws Exception {
        try {
            this.conectar();
            String sql = "update inventarioproductos1 set idinventario1=?, idproductopresentacion=?, cantidad=?,cantidad_final = ? where idinventarioproductos1 = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdinventario());
            pst.setInt(2, p.getIdproductopresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getCantidad_final());
            pst.setInt(5, p.getIdinventarioproducto());
            int res = pst.executeUpdate();
            if (res>0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InventarioProducto Obtener(int id) throws Exception {
        InventarioProducto p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM inventarioproductos1 where idinventarioproductos1 = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new InventarioProducto();
                p.setIdinventarioproducto(res.getInt(1));
                p.setIdinventario(res.getInt(2));
                p.setIdproductopresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setCantidad_final(res.getDouble(5));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return p;
    }
    
    public InventarioProducto Obtener(int id, int idInventario) throws Exception {
        InventarioProducto p = null;
        try {
            String sql = "";
            switch(idInventario){
                case 2:
                    sql = "SELECT * FROM inventarioproductos2 where idinventarioproductos2 = ?";
                    break;
                case 3:
                    sql = "SELECT * FROM inventarioproductos3 where idinventarioproductos3 = ?";
                    break;
            }
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new InventarioProducto();
                p.setIdinventarioproducto(res.getInt(1));
                p.setIdinventario(res.getInt(2));
                p.setIdproductopresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setCantidad_final(res.getDouble(5));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return p;
    }

    @Override
    public List<InventarioProducto> Listar() throws Exception {
        List<InventarioProducto> li = new ArrayList<>();
        InventarioProducto p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM inventarioproductos1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new InventarioProducto();
                p.setIdinventarioproducto(res.getInt(1));
                p.setIdinventario(res.getInt(2));
                p.setIdproductopresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setCantidad_final(res.getDouble(5));
                li.add(p);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            this.cerrar();
        }
        return li;
    }
    
    public List<InventarioProducto> Listar(int idInventario) throws Exception {
        List<InventarioProducto> li = new ArrayList<>();
        InventarioProducto p = null;
        try {
            String sql = "";
            switch(idInventario){
                case 2:
                    sql = "SELECT * FROM inventarioproductos2" ;
                    break;
                case 3:
                    sql = "SELECT * FROM inventarioproductos3";
                    break;
            }
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new InventarioProducto();
                p.setIdinventarioproducto(res.getInt(1));
                p.setIdinventario(res.getInt(2));
                p.setIdproductopresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setCantidad_final(res.getDouble(5));
                li.add(p);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        } finally {
            this.cerrar();
        }
        return li;
    }
    
}
