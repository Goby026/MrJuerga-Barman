
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.ProductoRoto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class ProductoRotoDAO extends Conexion implements DAO<ProductoRoto>{

    @Override
    public boolean Registrar(ProductoRoto p) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productoroto(idproductoroto, idflujoinventario, cantidad, precio) values (?,?,?,?) ";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdproductopresentacion());
            pst.setInt(2, p.getIdflujoinventario());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getPrecio());
            
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
    public boolean Modificar(ProductoRoto p) throws Exception {
        try {
            this.conectar();
            String sql = "update productoroto set idproductopresentacion=?, idflujoinventario=?, cantidad=?, precio=? where idproductoroto = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdproductopresentacion());
            pst.setInt(2, p.getIdflujoinventario());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getPrecio());
            pst.setInt(5, p.getIdproductoroto());
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
    public ProductoRoto Obtener(int id) throws Exception {
        ProductoRoto p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM productoroto where idproductoroto = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new ProductoRoto();
                p.setIdproductoroto(res.getInt(1));
                p.setIdproductopresentacion(res.getInt(2));
                p.setIdflujoinventario(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setPrecio(res.getDouble(5));
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
    public List<ProductoRoto> Listar() throws Exception {
        List<ProductoRoto> li = new ArrayList<>();
        ProductoRoto p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM productoroto");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new ProductoRoto();
                p.setIdproductoroto(res.getInt(1));
                p.setIdproductopresentacion(res.getInt(2));
                p.setIdflujoinventario(res.getInt(3));
                p.setCantidad(res.getDouble(4));
                p.setPrecio(res.getDouble(5));
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
