
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.TrasladoProdPres;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class TrasladoProdPresDAO extends Conexion implements DAO<TrasladoProdPres> {

    @Override
    public boolean Registrar(TrasladoProdPres p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO traslado_prod_pres(idtraslado, idproductopresentacion, cantidad, origen, destino) VALUES (?,?,?,?,?) ");
            pst.setInt(1, p.getIdTraslado());
            pst.setInt(2, p.getIdProductoPresentacion());
            pst.setInt(3, p.getCantidad());
            pst.setString(4, p.getOrigen());
            pst.setString(5, p.getDestino());
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
    public boolean Modificar(TrasladoProdPres p) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE traslado_prod_pres SET idproductopresentacion=?, cantidad=?, origen=?, destino=? WHERE idtraslado = ?");
            
            pst.setInt(1, p.getIdProductoPresentacion());
            pst.setInt(2, p.getCantidad());
            pst.setString(3, p.getOrigen());
            pst.setString(4, p.getDestino());
            pst.setInt(5, p.getIdTraslado());
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrasladoProdPres> Listar() throws Exception {
        List<TrasladoProdPres> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM traslado_prod_pres");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                TrasladoProdPres t = new TrasladoProdPres();
                t.setIdTrasladoProdPres(res.getInt(1));
                t.setIdTraslado(res.getInt(2));
                t.setIdProductoPresentacion(res.getInt(3));
                t.setCantidad(res.getInt(4));
                t.setOrigen(res.getString(5));
                t.setDestino(res.getString(6));
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
    public TrasladoProdPres Obtener(int id) throws Exception {
        TrasladoProdPres tpp = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM traslado_prod_pres WHERE idtraslado_prod_pres = ?");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                tpp = new TrasladoProdPres();
                tpp.setIdTrasladoProdPres(res.getInt(1));
                tpp.setIdTraslado(res.getInt(2));
                tpp.setIdProductoPresentacion(res.getInt(3));
                tpp.setCantidad(res.getInt(4));
                tpp.setOrigen(res.getString(5));
                tpp.setDestino(res.getString(6));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
        
        return tpp;
    }
    
}
