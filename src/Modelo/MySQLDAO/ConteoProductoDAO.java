package Modelo.MySQLDAO;

import Modelo.ConteoProducto;
import Modelo.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConteoProductoDAO extends Conexion implements DAO<ConteoProducto> {

    String REGISTRAR = "INSERT INTO `conteoproducto`(idconteo, idproductopresentacion, idpresentacion, idmedida, stock) VALUES (?,?,?,?,?)";
    String MODIFICAR = "UPDATE `conteoproducto` SET idconteo = ? ,`idproductopresentacion`=?,`idpresentacion`=?, idmedida=?,`stock`=? WHERE `idconteoproducto`=?";
    String ELIMINAR = "DELETE FROM `conteoproducto` WHERE `idconteoproducto` = ?";
    String LISTAR_TODOS = "SELECT idconteoproducto, idconteo, idproductopresentacion, idpresentacion, idmedida, stock FROM `conteoproducto`";
    String OBTENER = "SELECT idconteoproducto, idconteo, idproductopresentacion, idpresentacion, idmedida, stock FROM `conteoproducto` WHERE `idconteoproducto` = ?";

    @Override
    public boolean Registrar(ConteoProducto cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(REGISTRAR);
            pst.setInt(1, cp.getIdconteo());
            pst.setInt(2, cp.getIdProductoPresentacion());
            pst.setInt(3, cp.getIdPresentacion());
            pst.setInt(4, cp.getMedida().getIdmedida());
            pst.setInt(5, cp.getStock());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Modificar(ConteoProducto cp) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(MODIFICAR);
            pst.setInt(1, cp.getIdconteo());
            pst.setInt(2, cp.getIdProductoPresentacion());
            pst.setInt(3, cp.getIdPresentacion());
            pst.setInt(4, cp.getMedida().getIdmedida());
            pst.setInt(5, cp.getStock());
            pst.setInt(6, cp.getIdConteoProducto());
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(ELIMINAR);
            pst.setInt(1, id);
            int res = pst.executeUpdate();
            if (res > 0) {
                return true;
            }
            pst.close();
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.cerrar();
        }
        return false;
    }

    @Override
    public List<ConteoProducto> Listar() throws Exception {
        List<ConteoProducto> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(LISTAR_TODOS);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                ConteoProducto cp = new ConteoProducto();
                cp.setIdConteoProducto(res.getInt(1));
                cp.setIdconteo(res.getInt(2));
                cp.setIdProductoPresentacion(res.getInt(3));
                cp.setIdPresentacion(res.getInt(4));
                cp.setMedida(new MedidaDAO().Obtener(res.getInt(5)));
                cp.setStock(res.getInt(6));
                lista.add(cp);
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
    public ConteoProducto Obtener(int ID) throws Exception {
        ConteoProducto cp = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(OBTENER);
            pst.setInt(1, ID);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                cp = new ConteoProducto();
                cp.setIdConteoProducto(res.getInt(1));
                cp.setIdconteo(res.getInt(2));
                cp.setIdProductoPresentacion(res.getInt(3));
                cp.setIdPresentacion(res.getInt(4));
                cp.setMedida(new MedidaDAO().Obtener(res.getInt(5)));
                cp.setStock(res.getInt(6));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return cp;
    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
