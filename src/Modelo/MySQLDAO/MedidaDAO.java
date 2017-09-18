/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.Medida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adolfo
 */
public class MedidaDAO extends Conexion implements DAO<Medida> {

    @Override
    public boolean Registrar(Medida m) throws Exception {
        boolean b = false;
        try {
            String sql = "INSERT INTO medida(descripcion) VALUES (?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, m.getDescripcion());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public boolean Modificar(Medida m) throws Exception {
        boolean b = false;

        try {
            String sql = "UPDATE medida SET descripcion = ? WHERE idmedida = ?";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, m.getDescripcion());
            pst.setInt(2, m.getIdmedida());
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
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
            String sql = "DELETE FROM medida WHERE idmedida = ? ";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            int res = pst.executeUpdate();
            if (res > 0) {
                b = true;
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return b;
    }

    @Override
    public List<Medida> Listar() throws Exception {
        List<Medida> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM medida");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Medida m = new Medida();
                m.setIdmedida(res.getInt("idmedida"));
                m.setDescripcion(res.getString("descripcion"));

                li.add(m);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }

        return li;
    }

    @Override
    public Medida Obtener(int id) throws Exception {
        Medida m = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM medida WHERE idmedida = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                m = new Medida();
                m.setIdmedida(res.getInt(1));
                m.setDescripcion(res.getString(2));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }finally{
            this.cerrar();
        }
        return m;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
