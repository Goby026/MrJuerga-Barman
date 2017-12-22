/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.Traslado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class TrasladoDAO extends Conexion implements DAO<Traslado> {

    @Override
    public boolean Registrar(Traslado p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO traslado(fecha, hora, idusuario, idtipotraslado, idflujoinventario) VALUES (?,?,?,?,?)");
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdUsuario());
            pst.setInt(4, p.getIdTipoTraslado());
            pst.setInt(5, p.getIdFlujoInventario());
            
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(Traslado p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE traslado SET fecha=?, hora=?, idusuario=?, idtipotraslado = ?, idflujoinventario = ? WHERE idtraslado = ?");
            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdUsuario());
            pst.setInt(4, p.getIdTipoTraslado());
            pst.setInt(5, p.getIdFlujoInventario());
            pst.setInt(6, p.getIdTraslado());
            
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Anular(int id) throws Exception {
//        Traslado t = null;
//        try {
//            this.conectar();
//            PreparedStatement pst = this.conexion.prepareStatement("UPDATE traslado SET fecha=?, hora=?, idusuario=?, origen=?, destino=? WHERE idtraslado = ?");
//            pst.setString(1, p.getFecha());
//            pst.setString(2, p.getHora());
//            pst.setInt(3, p.getIdUsuario());
//            pst.setString(4, p.getOrigen());
//            pst.setString(5, p.getDestino());
//            pst.setInt(6, p.getIdTraslado());
//            int res = pst.executeUpdate();
//            if (res > 0) {
//                return true;
//            }
//            pst.close();            
//        } catch (Exception e) {
//            throw e;
//        }finally{
//            this.cerrar();
//        }
        return false;
    }

    @Override
    public List<Traslado> Listar() throws Exception {
        List<Traslado> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM traslado");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Traslado t = new Traslado();
                t.setIdTraslado(res.getInt(1));
                t.setFecha(res.getString(2));
                t.setHora(res.getString(3));
                t.setIdUsuario(res.getInt(4));
                t.setIdTipoTraslado(res.getInt(5));
                t.setIdFlujoInventario(res.getInt(6));
                lista.add(t);
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

    @Override
    public Traslado Obtener(int id) throws Exception {
        Traslado t = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM traslado where idtraslado = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                t = new Traslado();
                t.setIdTraslado(res.getInt(1));
                t.setFecha(res.getString(2));
                t.setHora(res.getString(3));
                t.setIdUsuario(res.getInt(4));
                t.setIdTipoTraslado(res.getInt(5));
                t.setIdFlujoInventario(res.getInt(6));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        
        return t;
    }
    
    public int ultimoTraslado() throws Exception{
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idtraslado FROM traslado ORDER BY idtraslado DESC LIMIT 1");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                return res.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return -1;
    }

}
