
package Modelo.MySQLDAO;


import Modelo.MySQLDAO.Conexion;
import Modelo.DAO.DAO;
import Modelo.Preparacion;
import Modelo.Preparacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class PreparacionDAO extends Conexion implements DAO<Preparacion>{

    @Override
    public boolean Registrar(Preparacion p) throws Exception {
        try {
            this.conectar();
            String sql = "insert into preparacion(idproducto, idproductopresentacion, cantidad, detalles) values (?,?,?,?) ";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdProducto());
            pst.setInt(2, p.getIdProductoPresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setString(4, p.getDetalles());
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
    public boolean Modificar(Preparacion p) throws Exception {
        try {
            this.conectar();
            String sql = "update preparacion set idproducto=?, idproductopresentacion=?, cantidad=?, detalles=? where idpreparacion = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdProducto());
            pst.setInt(2, p.getIdProductoPresentacion());
            pst.setDouble(3, p.getCantidad());
            pst.setString(4, p.getDetalles());
            pst.setInt(5, p.getIdPreparacion());
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
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Preparacion> Listar() throws Exception {
        List<Preparacion> li = new ArrayList<>();
        Preparacion p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM preparacion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new Preparacion();
                p.setIdPreparacion(res.getInt(1));
                p.setIdProducto(res.getInt(2));
                p.setIdProductoPresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setDetalles(res.getString(5));
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

    @Override
    public Preparacion Obtener(int id) throws Exception {
        Preparacion p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM preparacion where idpreparacion = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new Preparacion();
                p.setIdPreparacion(res.getInt(1));
                p.setIdProducto(res.getInt(2));
                p.setIdProductoPresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setDetalles(res.getString(5));
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
    
    //obtener detalles de preparacion a partir de id de producto
    public List<Preparacion> Listar(int idproducto) throws Exception {
        List<Preparacion> li = new ArrayList<>();
        Preparacion p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM preparacion where idproducto = ?");
            pst.setInt(1, idproducto);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new Preparacion();
                p.setIdPreparacion(res.getInt(1));
                p.setIdProducto(res.getInt(2));
                p.setIdProductoPresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setDetalles(res.getString(5));
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
    
    //obtener detalles de preparacion a partir de id de productoPresentacion
    public List<Preparacion> ListarProductosPreparar(int idprodPres) throws Exception {
        List<Preparacion> li = new ArrayList<>();
        Preparacion p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM preparacion where idproductopresentacion = ?");
            pst.setInt(1, idprodPres);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new Preparacion();
                p.setIdPreparacion(res.getInt(1));
                p.setIdProducto(res.getInt(2));
                p.setIdProductoPresentacion(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setDetalles(res.getString(5));
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
    
    //obtener detalles de preparacion a partir de id de productoPresentacion
    public List<String> ListaProductosHijos() throws Exception {
        List<String> li = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT DISTINCT idproducto FROM preparacion");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                li.add(res.getString(1));
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
