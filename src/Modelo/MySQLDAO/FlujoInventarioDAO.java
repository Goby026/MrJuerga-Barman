package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.FlujoInventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GROVER
 */
public class FlujoInventarioDAO extends Conexion implements DAO<FlujoInventario> {

    @Override
    public boolean Registrar(FlujoInventario fc) throws Exception {
        try {
            String sql = "INSERT INTO flujoinventario(fecha_inicio,hora_inicio,fecha_final, hora_final, idusuario,idalmacen,saldo_favor ,estado)VALUE (?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFecha_inicio());
            pst.setString(2, fc.getHora_inicio());
            pst.setString(3, fc.getFecha_final());
            pst.setString(4, fc.getHora_final());
            pst.setInt(5, fc.getIdusuario());
            pst.setInt(6, fc.getIdalmacen());
            pst.setDouble(7, fc.getSaldoFavor());
            pst.setInt(8, fc.getEstado());
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
    public boolean Modificar(FlujoInventario fc) throws Exception {
        try {
            String sql = ("UPDATE caja flujocaja SET fecha_inicio = ?,hora_inicio=?,fecha_final=? ,hora_final=? , idusuario = ?, idalmacen = ?,saldo_favor = ? ,estado= ? WHERE idflujoinventario = ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setString(1, fc.getFecha_inicio());
            pst.setString(2, fc.getHora_inicio());
            pst.setString(3, fc.getFecha_final());
            pst.setString(4, fc.getHora_final());
            pst.setInt(5, fc.getIdusuario());
            pst.setInt(6, fc.getIdalmacen());
            pst.setDouble(7, fc.getSaldoFavor());
            pst.setInt(8, fc.getEstado());
            pst.setInt(9, fc.getIdflujoinventario());

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
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FlujoInventario Obtener(int id) throws Exception {
        FlujoInventario fc = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujoinventario WHERE idflujoinventario = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                fc = new FlujoInventario();
                fc.setIdflujoinventario(res.getInt(1));
                fc.setFecha_inicio(res.getString(2));
                fc.setHora_inicio(res.getString(3));
                fc.setFecha_final(res.getString(4));
                fc.setHora_final(res.getString(5));
                fc.setIdusuario(res.getInt(6));
                fc.setIdalmacen(res.getInt(7));
                fc.setSaldoFavor(res.getDouble(8));
                fc.setEstado(res.getInt(9));
            }
            pst.close();
            res.close();
        } catch (Exception error) {
            throw error;
        } finally {
            this.cerrar();
        }
        return fc;
    }

    @Override
    public List<FlujoInventario> Listar() throws Exception {
        List<FlujoInventario> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM flujocaja");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                FlujoInventario fc = new FlujoInventario();
                fc.setIdflujoinventario(res.getInt(1));
                fc.setFecha_inicio(res.getString(2));
                fc.setHora_inicio(res.getString(3));
                fc.setFecha_final(res.getString(4));
                fc.setHora_final(res.getString(5));
                fc.setIdusuario(res.getInt(6));
                fc.setIdalmacen(res.getInt(7));
                fc.setSaldoFavor(res.getDouble(8));
                fc.setEstado(res.getInt(9));
                lista.add(fc);
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

    /* METODO PARA OBTENER EL ID DE FLUJO DE INVENTARIO PARA LA VALIDACION  */
    public int getIdFlujo(int idUsuario, int idAlmacen) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idflujoinventario) FROM flujoinventario where idusuario= " + idUsuario + " and idalmacen=" + idAlmacen + " and estado = 1");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    /* METODO PARA OBTENER EL ID DE FLUJO DE INVENTARIO PARA APERTURAR UN NUEVO INVENTARIO  */
    public int getIdFlujo(int idAlmacen) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT MAX(idflujoinventario) FROM flujoinventario where idalmacen=" + idAlmacen + " and estado = 0");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    /*obtener el max idflujoinventario de las cajas activas*/
    public int getIdFlujoCaja(int idCaja, String fecha) throws Exception {
        try {
            this.conectar();
            //String sql = "select max(idflujocaja) from flujocaja where estado = 1 and idcaja = "+idCaja;
            String sql = "select max(idflujocaja) from flujocaja where idcaja = ? AND fecha_inicio = ?";
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, idCaja);
            pst.setString(2, fecha);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    /*obtener el ultimo idflujoinventario para guardar un nuevo INVENTARIO*/
    public int getLastIdFlujoInventario(int idAlmacen) throws Exception {
        try {
            this.conectar();
            String sql = "SELECT MAX(idflujoinventario) FROM flujoinventario WHERE estado = 1 AND idalmacen = " + idAlmacen;
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                return res.getInt(1);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }
}
