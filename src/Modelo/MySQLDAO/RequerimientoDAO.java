package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.Requerimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class RequerimientoDAO extends Conexion implements DAO<Requerimiento> {

    @Override
    public boolean Registrar(Requerimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("INSERT INTO requerimiento(idusuario,idalmacen ,fecha, hora, observacion,estado) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, m.getIdUsuario());
            pst.setInt(2, m.getIdAlmacen());
            pst.setString(3, m.getFecha());
            pst.setString(4, m.getHora());
            pst.setString(5, m.getObservacion());
            pst.setInt(6, m.getEstado());
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
    public boolean Modificar(Requerimiento m) throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE `requerimiento` SET `idusuario` = ?, `fecha` = ?, `hora` = ?, `observacion` = ?,`estado` = ? WHERE `idrequerimiento` = ?");
            pst.setInt(1, m.getIdUsuario());
            pst.setInt(2, m.getIdAlmacen());
            pst.setString(3, m.getFecha());
            pst.setString(4, m.getHora());
            pst.setString(5, m.getObservacion());
            pst.setInt(6, m.getEstado());
            pst.setInt(7, m.getIdRequerimiento());
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
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("UPDATE requerimiento SET estado = 0 WHERE idrequerimiento = ?");
            pst.setInt(1, id);
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
    public List<Requerimiento> Listar() throws Exception {
        List<Requerimiento> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM requerimiento");
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                Requerimiento m = new Requerimiento();
                m.setIdRequerimiento(res.getInt(1));
                m.setIdUsuario(res.getInt(2));
                m.setIdAlmacen(res.getInt(3));
                m.setFecha(res.getString(4));
                m.setHora(res.getString(5));
                m.setObservacion(res.getString(6));
                m.setEstado(res.getInt(7));
                lista.add(m);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    @Override
    public Requerimiento Obtener(int id) throws Exception {
        Requerimiento m = null;
        try {

            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT * FROM requerimiento WHERE idrequerimiento = ?");
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                m = new Requerimiento();
                m.setIdRequerimiento(res.getInt("idrequerimiento"));
                m.setIdUsuario(res.getInt("idusuario"));
                m.setFecha(res.getString("fecha"));
                m.setHora(res.getString("hora"));
                m.setObservacion(res.getString("observacion"));
                m.setEstado(res.getInt("estado"));
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return m;
    }

    public int getUltimoRequerimiento() throws Exception {
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idrequerimiento FROM requerimiento ORDER BY idrequerimiento DESC limit 1");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return rs.getInt("idrequerimiento");
            }
            pst.close();
            rs.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return -1;
    }

    @Override
    public boolean Eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*METODO PARA BUSCAR REQUERIMIENTOS A PARTIR DE DOS FECHAS*/
    public List<tablaBuscar> buscarRequerimientoPorFechas(String fechaInicio, String fechaFinal) throws Exception {
        List<tablaBuscar> lista = new ArrayList<>();
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT r.idrequerimiento, r.fecha,u.nombre , u.apellido\n"
                    + "FROM requerimiento r\n"
                    + "INNER JOIN usuario u ON r.idusuario = u.idusuario\n"
                    + "WHERE r.fecha between ? AND ? ");
            pst.setString(1, fechaInicio);
            pst.setString(2, fechaFinal);
            ResultSet res = pst.executeQuery();
            while (res.next()) {
                tablaBuscar tb = new tablaBuscar();
                
                tb.setIdRequermiento(res.getInt(1));
                tb.setFecha(res.getString(2));
                tb.setUsuario(res.getString(3)+" "+ res.getString(4));
                
                lista.add(tb);
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    
    /*CLASE INTERNA PARA EL MODELO DE LA TABLA BUSCAR REQUERMIENTO*/
    public class tablaBuscar{
        int idRequermiento;
        String fecha;
        String usuario;

        public tablaBuscar() {
        }

        public int getIdRequermiento() {
            return idRequermiento;
        }

        public void setIdRequermiento(int idRequermiento) {
            this.idRequermiento = idRequermiento;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        @Override
        public String toString() {
            return "tablaBuscar{" + "idRequermiento=" + idRequermiento + ", fecha=" + fecha + ", usuario=" + usuario + '}';
        }
                
    }

}
