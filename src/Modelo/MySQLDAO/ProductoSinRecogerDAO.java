
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.ProductoSinRecoger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class ProductoSinRecogerDAO extends Conexion implements DAO<ProductoSinRecoger>{

    @Override
    public boolean Registrar(ProductoSinRecoger p) throws Exception {
        try {
            this.conectar();
            String sql = "insert into productosinrecoger(idproductopresentacion, idflujoinventario, cantidad, precio) values (?,?,?,?) ";
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
    public boolean Modificar(ProductoSinRecoger p) throws Exception {
        try {
            this.conectar();
            String sql = "update productosinrecoger set idproductopresentacion=?, idflujoinventario=?, cantidad=?, precio=? where idproductosinrecoger = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, p.getIdproductopresentacion());
            pst.setInt(2, p.getIdflujoinventario());
            pst.setDouble(3, p.getCantidad());
            pst.setDouble(4, p.getPrecio());
            pst.setInt(5, p.getIdproductosinrecoger());
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
    public ProductoSinRecoger Obtener(int id) throws Exception {
        ProductoSinRecoger p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM productosinrecoger where idproductosinrecoger = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new ProductoSinRecoger();
                p.setIdproductosinrecoger(res.getInt(1));
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
    public List<ProductoSinRecoger> Listar() throws Exception {
        List<ProductoSinRecoger> li = new ArrayList<>();
        ProductoSinRecoger p = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM productosinrecoger");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                p = new ProductoSinRecoger();
                p.setIdproductosinrecoger(res.getInt(1));
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
