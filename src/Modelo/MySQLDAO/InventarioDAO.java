
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GROVER
 */
public class InventarioDAO extends Conexion implements DAO<Inventario> {

    @Override
    public boolean Registrar(Inventario p) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO inventario1(fecha, hora, idusuario, idflujoinventario, estado) VALUES (?,?,?,?,?)";
            PreparedStatement pst = this.conexion.prepareStatement(sql);

            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdusuario());
            pst.setInt(4, p.getIdflujoinventario());
            pst.setInt(5, p.getEstado());

            if (pst.executeUpdate() > 0) {
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

    public boolean Registrar(Inventario p, int idAlmacen) throws Exception {
        try {
            this.conectar();
            String sql = "";
            switch (idAlmacen) {
                case 2:
                    sql = "INSERT INTO inventario2(fecha, hora, idusuario, idflujoinventario, estado) VALUES (?,?,?,?,?)";
                    break;
                case 3:
                    sql = "INSERT INTO inventario3(fecha, hora, idusuario, idflujoinventario, estado) VALUES (?,?,?,?,?)";
                    break;
            }
            PreparedStatement pst = this.conexion.prepareStatement(sql);

            pst.setString(1, p.getFecha());
            pst.setString(2, p.getHora());
            pst.setInt(3, p.getIdusuario());
            pst.setInt(4, p.getIdflujoinventario());
            pst.setInt(5, p.getEstado());

            if (pst.executeUpdate() > 0) {
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
    public boolean Modificar(Inventario p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Inventario> Listar() throws Exception {
        List<Inventario> lista = new ArrayList<>();
        Inventario i =  null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM inventario1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                i = new Inventario();
                i.setIdinventario(res.getInt(1));
                i.setFecha(res.getString(2));
                i.setHora(res.getString(3));
                i.setIdusuario(res.getInt(4));
                i.setIdflujoinventario(res.getInt(5));
                i.setEstado(res.getInt(6));
                lista.add(i);
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public Inventario Obtener(int id) throws Exception {
        Inventario i = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM inventario1 WHERE inventario1 = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                i = new Inventario();
                i.setIdinventario(res.getInt(1));
                i.setFecha(res.getString(2));
                i.setHora(res.getString(3));
                i.setIdusuario(res.getInt(4));
                i.setIdflujoinventario(res.getInt(5));
                i.setEstado(res.getInt(6));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return i;
    }

    public Inventario Obtener(int id, int idAlmacen) throws Exception {
        Inventario i = null;
        String sql = "";
        try {
            switch (idAlmacen) {
                case 2:
                    sql = "SELECT * FROM inventario2 WHERE inventario2 = ?";
                    break;
                case 3:
                    sql = "SELECT * FROM inventario3 WHERE inventario3 = ?";
                    break;
            }
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                i = new Inventario();
                i.setIdinventario(res.getInt(1));
                i.setFecha(res.getString(2));
                i.setHora(res.getString(3));
                i.setIdusuario(res.getInt(4));
                i.setIdflujoinventario(res.getInt(5));
                i.setEstado(res.getInt(6));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return i;
    }
    
    //metodo para obtener el ultimo id registrado
    public int getLastId(int inventario) throws Exception{
        try {
            this.conectar();
            String sql = "";
            switch(inventario){
                case 1:
                    sql = "SELECT max(idInventario1) FROM inventario1 ORDER BY idinventario1 DESC LIMIT 1";
                    break;
                case 2:
                    sql = "SELECT max(idInventario2) FROM inventario2 ORDER BY idinventario2 DESC LIMIT 1";
                    break;
                case 3:
                    sql = "SELECT max(idInventario3) FROM inventario3 ORDER BY idinventario3 DESC LIMIT 1";
                    break;
            }
            
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            
            ResultSet res = pst.executeQuery();
            
            if(res.next()){
                return res.getInt(1);
            }
            
            pst.close();
            res.close();
           
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        return -1;
    }

}
