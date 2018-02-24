/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.VentaGeneral;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MARCEL
 */
public class VentaGeneralDAO extends Conexion implements DAO<VentaGeneral> {

    @Override
    public boolean Registrar(VentaGeneral p) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Modificar(VentaGeneral p) throws Exception {
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
    public VentaGeneral Obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<VentaGeneral> Listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<VentaGeneral> ListarPorFlujo(int idFlujoCaja, int idCaja) throws Exception {
        List<VentaGeneral> lista = new ArrayList<>();
        try {
            this.conectar();
            VentaGeneral eg = null;
            String sql = "";

            switch (idCaja) {
                case 1://entrada general 01
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(ve.numCovers)\n"
                            + "    from entradageneral eg\n"
                            + "    inner join ventaentrada ve on eg.identradageneral = ve.venta_idventa\n"
                            + "    inner join productopresentacion pp on ve.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    where eg.idflujocaja = " + idFlujoCaja + " \n"
                            + "    group by pp.idproductopresentacion";
                    break;
                case 3://caja 01
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(vp.cantidad)\n"
                            + "    from venta v\n"
                            + "    inner join ventaproducto vp on v.idventa = vp.idventa    \n"
                            + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    where v.idflujocaja = " + idFlujoCaja + " \n"
                            + "    group by pp.idproductopresentacion\n"
                            + "    order by sum(vp.cantidad) desc";
                    break;
                case 4://caja 02
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(vp.cantidad)\n"
                            + "    from venta2 v\n"
                            + "    inner join ventaproducto2 vp on v.idventa2 = vp.idventa\n"
                            + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    where v.idflujocaja = " + idFlujoCaja + " \n"
                            + "    group by pp.idproductopresentacion\n"
                            + "    order by sum(vp.cantidad) desc";
                    break;
                case 6://entrada general 02
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(ve.numCovers) \n"
                            + "    from entradageneral2 eg\n"
                            + "    inner join ventaentrada2 ve on eg.identradageneral2 = ve.venta_idventa\n"
                            + "    inner join productopresentacion pp on ve.idproducto = pp.idproductopresentacion\n"
                            + "    inner join producto p on pp.idproducto = p.idproducto\n"
                            + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "    where eg.idflujocaja = " + idFlujoCaja + " \n"
                            + "    group by pp.idproductopresentacion";
                    break;
            }

            PreparedStatement st = this.getConexion().prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                eg = new VentaGeneral();
                eg.setCodProducto(rs.getInt(1));
                eg.setProducto(rs.getString(2));
                eg.setPresentacion(rs.getString(3));
                eg.setCantidad(rs.getDouble(4));

                lista.add(eg);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
