/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.Presentacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class PresentacionDAO extends Conexion implements DAO<Presentacion> {

    @Override
    public boolean Registrar(Presentacion p) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO presentacion(descripcion,valorml) VALUES (?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            pst.setDouble(2, p.getValorMl());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Presentacion p) throws Exception {
        boolean b = false;

        try {
            String sql = "UPDATE presentacion SET descripcion = ?,valorml = ? WHERE idPresentacion = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, p.getDescripcion());
            pst.setDouble(2, p.getValorMl());
            pst.setInt(3, p.getIdPresentacion());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        boolean b = false;

        try {
            String sql = "DELETE FROM presentacion WHERE idPresentacion = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;

    }

    @Override
    public List<Presentacion> Listar() throws Exception {
        List<Presentacion> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM presentacion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Presentacion p = new Presentacion();
                p.setIdPresentacion(res.getInt(1));
                p.setDescripcion(res.getString(2));
                p.setValorMl(res.getDouble(3));
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

    public Presentacion obtenerPresentacion(int idPresentacion) throws SQLException, Exception {
        Presentacion p = new Presentacion();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idpresentacion, descripcion, valorml FROM presentacion WHERE idpresentacion = " + idPresentacion);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                p.setIdPresentacion(res.getInt(1));
                p.setDescripcion(res.getString(2));
                p.setValorMl(res.getDouble(3));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return p;
    }

    public int getIdPresentacion(String presentacion) throws SQLException, Exception {
        int idPresentacion = 0;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idpresentacion FROM presentacion WHERE descripcion = '" + presentacion + "'");
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                idPresentacion = res.getInt("idpresentacion");
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return idPresentacion;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Presentacion Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
