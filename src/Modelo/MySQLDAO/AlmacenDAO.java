/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;
import Modelo.Almacen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class AlmacenDAO extends Conexion{
    
    public boolean Registrar(Almacen a) throws SQLException, Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("insert into almacen(nombre,direccion,ciudad,telefono,responsable) values (?,?,?,?,?)");
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getDireccion());
            pst.setString(3, a.getCiudad());
            pst.setString(4, a.getTelefono());
            pst.setString(5, a.getResponsable());
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
    
    public boolean modificar(Almacen a) throws Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("update almacen set nombre=?, direccion=?,ciudad=?, telefono=?, responsable=? where idalmacen = ?");
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getDireccion());
            pst.setString(3, a.getCiudad());
            pst.setString(4, a.getTelefono());
            pst.setString(5, a.getResponsable());
            pst.setInt(6, a.getId());
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
    
    public boolean eliminar(Almacen a) throws SQLException, Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("delete from almacen where idalmacen = ?");
            pst.setInt(1, a.getId());
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
    
    public List<Almacen> listar() throws SQLException, Exception{
        List<Almacen> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM almacen");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Almacen a = new Almacen();
                a.setId(res.getInt("idalmacen"));
                a.setNombre(res.getString("nombre"));
                a.setDireccion(res.getString("direccion"));
                a.setCiudad(res.getString("ciudad"));
                a.setTelefono(res.getString("telefono"));
                a.setResponsable(res.getString("responsable"));
                lista.add(a);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        
        return lista;
    }
}
