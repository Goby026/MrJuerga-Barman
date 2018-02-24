/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.NotaPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class NotaPedidoDAO extends Conexion implements DAO<NotaPedido> {

    @Override
    public boolean Registrar(NotaPedido p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Modificar(NotaPedido p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public NotaPedido Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NotaPedido> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*metodo para obtener las ventas por nota de pedido segun flujo de caja y por caja*/
    public List<NotaPedido> ListarPorFlujo(int idFlujoCaja, int idCaja) throws Exception {
        List<NotaPedido> lista = new ArrayList<>();
        NotaPedido np = null;
        try {
            this.conectar();
            String sql = "";
            switch (idCaja) {
                case 2://entrada VIP
                    sql = "";
                    break;
                case 3://general 01
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(np.cantidad)\n"
                            + "from npbarra n\n"
                            + "inner join npbarra_prod np on n.idnpbarra = np.idnpbarra\n"
                            + "inner join productopresentacion pp on np.idproductopresentacion = pp.idproductopresentacion\n"
                            + "inner join producto p on pp.idproducto = p.idproducto\n"
                            + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "where n.idflujocaja = ? \n"
                            + "group by p.nombre";
                    break;
                case 4://general 02
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(np.cantidad)\n"
                            + "from npbarra2 n\n"
                            + "inner join npbarra_prod2 np on n.idnpbarra2 = np.idnpbarra2\n"
                            + "inner join productopresentacion pp on np.idproductopresentacion = pp.idproductopresentacion\n"
                            + "inner join producto p on pp.idproducto = p.idproducto\n"
                            + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "where n.idflujocaja = ? \n"
                            + "group by p.nombre";
                    break;
                case 6://entrada general 02
                    sql = "";
                    break;
            }

            PreparedStatement pst = this.getConexion().prepareStatement(sql);
            pst.setInt(1, idFlujoCaja);
            ResultSet res = pst.executeQuery();

            while (res.next()) {
                np = new NotaPedido();
                np.setIdProducto(res.getInt(1));
                np.setProducto(res.getString(2));
                np.setPresentacion(res.getString(3));
                np.setCantidad(res.getDouble(4));

                lista.add(np);
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

}
