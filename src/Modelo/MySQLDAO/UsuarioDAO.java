/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.UsuarioCRUD;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaby
 */
public class UsuarioDAO extends Conexion implements UsuarioCRUD{

    @Override
    public boolean registrar(Usuario u) throws Exception {
        try {
            String sql = "insert into usuario (nombre, apellido, dni,ruc, telefono, direccion,imagen, usuario, pass, sueldo, planilla) values (?,?,?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellido());
            pst.setString(3, u.getDni());
            pst.setString(4, u.getRuc());
            pst.setString(5, u.getTelefono());
            pst.setString(6, u.getDireccion());
            pst.setString(7, u.getImagen());
            pst.setString(8, u.getUsuario());
            pst.setString(9, u.getPass());
            pst.setDouble(10, u.getSueldo());
            pst.setInt(11, u.getPlanilla());
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
    public boolean modificar(Usuario u) throws Exception {
        try {
            String sql = ("UPDATE usuario set nombre = ?, apellido= ?, dni=?,ruc = ? ,telefono = ?, direccion = ?, imagen= ?,usuario = ?, pass = ?, sueldo = ?, planilla=? where idusuario=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, u.getNombre());
            pst.setString(2, u.getApellido());
            pst.setString(3, u.getDni());
            pst.setString(4, u.getRuc());
            pst.setString(5, u.getTelefono());
            pst.setString(6, u.getDireccion());
            pst.setString(7, u.getImagen());
            pst.setString(8, u.getUsuario());
            pst.setString(9, u.getPass());
            pst.setDouble(10, u.getSueldo());
            pst.setInt(11, u.getPlanilla());
            pst.setInt(12, u.getId());
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
    public boolean eliminar(Usuario u) throws Exception {
        try {
            String sql = ("delete from usuario where idusuario=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, u.getId());
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
    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from usuario");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("idusuario"));
                u.setNombre(rs.getString("nombre"));
                u.setApellido(rs.getString("apellido"));
                u.setDni(rs.getString("dni"));
                u.setRuc(rs.getString("ruc"));
                u.setTelefono(rs.getString("telefono"));
                u.setDireccion(rs.getString("direccion"));
                u.setImagen(rs.getString("imagen"));
                u.setUsuario(rs.getString("usuario"));
                u.setPass(rs.getString("pass"));
                u.setSueldo(rs.getDouble("sueldo"));
                u.setPlanilla(rs.getInt("planilla"));
                lista.add(u);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public int getIdUsuario(String usuario) throws Exception {
        int idUsuario = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idusuario FROM usuario WHERE usuario =  '"+usuario+"'");            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("idusuario");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return idUsuario;
    }
    
}
