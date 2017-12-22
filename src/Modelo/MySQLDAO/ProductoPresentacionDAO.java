/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.MySQLDAO;

import Modelo.DAO.DAO;
import Modelo.ProductoPresentacion;
//import ModelosTablas.InventarioValorizado;
//import ModelosTablas.tablaBuscarProducto;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce
 */
public class ProductoPresentacionDAO extends Conexion implements DAO<ProductoPresentacion> {

    @Override
    public boolean Registrar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = "insert into productopresentacion (idproducto, idpresentacion, idalmacen, stock, stock2, stock3, precio, precio2, idcategoria)VALUES (?,?,?,?,?,?,?,?,?)";
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setDouble(4, pp.getStock());
            pst.setDouble(5, pp.getStock2());
            pst.setDouble(6, pp.getStock3());
            pst.setDouble(7, pp.getPrecio());
            pst.setDouble(8, pp.getPrecio2());
            pst.setDouble(9, pp.getIdcategoria());
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
    public boolean Modificar(ProductoPresentacion pp) throws Exception {
        try {
            String sql = ("UPDATE productopresentacion SET idproducto=?, idpresentacion=?, idalmacen=?, stock=?, stock2=?, stock3=?,precio=?, precio2=?, idcategoria=? WHERE idproductopresentacion=?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setInt(1, pp.getIdProducto());
            pst.setInt(2, pp.getIdPresentacion());
            pst.setInt(3, pp.getIdalmacen());
            pst.setDouble(4, pp.getStock());
            pst.setDouble(5, pp.getStock2());
            pst.setDouble(6, pp.getStock3());
            pst.setDouble(7, pp.getPrecio());
            pst.setDouble(8, pp.getPrecio2());
            pst.setDouble(9, pp.getIdcategoria());
            pst.setInt(10, pp.getIdProductoPresentacion());
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
        try {
            String sql = ("delete from productopresentacion where idproductopresentacion= ?");
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
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
    public List<ProductoPresentacion> Listar() throws Exception {
        List<ProductoPresentacion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion");
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getDouble(5));
                pp.setStock2(rs.getDouble(6));
                pp.setStock3(rs.getDouble(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
                lista.add(pp);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }
    
    public List<ProductoPresentacion> ListarPorCategoria(int idCategoria) throws Exception {
        List<ProductoPresentacion> lista = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion where idcategoria = ?");
            pst.setInt(1, idCategoria);
            lista = new ArrayList();
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                ProductoPresentacion pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getDouble(5));
                pp.setStock2(rs.getDouble(6));
                pp.setStock3(rs.getDouble(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
                lista.add(pp);
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return lista;
    }

    //Metodo para obteber un elemento a partir de su id y el almacen
    public ProductoPresentacion Obtener(int idProducto, int idAlmacen) throws Exception {
        try {
            ProductoPresentacion pp = new ProductoPresentacion();
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT idproductopresentacion, idproducto, idpresentacion, idalmacen, stock, stock2, stock3, precio, precio2, idcategoria FROM productopresentacion "
                    + "WHERE idproducto = " + idProducto + " AND idalmacen = " + idAlmacen);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getDouble(5));
                pp.setStock2(rs.getDouble(6));
                pp.setStock3(rs.getDouble(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
            }
            rs.close();
            pst.close();
            return pp;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    //Metodo para obtener un ProductoPresentacion a partir de un nombre de producto y el almacen
    public ProductoPresentacion Obtener(String nomProd, int idAlmacen) throws Exception {
        try {
            ProductoPresentacion pp = new ProductoPresentacion();
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("SELECT pp.idproductopresentacion, pp.idproducto, pp.idpresentacion, pp.idalmacen, pp.stock, pp.stock2, pp.stock3, pp.precio, pp.precio2, pp.idcategoria  \n"
                    + "FROM  productopresentacion pp\n"
                    + "INNER JOIN producto p ON p.idproducto = pp.idproducto\n"
                    + "WHERE p.nombre = '"+nomProd+"' AND pp.idalmacen = "+idAlmacen);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getDouble(5));
                pp.setStock2(rs.getDouble(6));
                pp.setStock3(rs.getDouble(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
            }
            rs.close();
            pst.close();
            return pp;
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    //Metodo para obtener los datos de la tabla buscar producto en la parte de conteo diario
    public Object[] datosTablaBuscar(String categoria) throws Exception {
        Object[] datos = new Object[3];
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select producto.idproducto, producto.nombre, presentacion.descripcion from producto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "inner join categoria on productopresentacion.idcategoria = categoria.idcategoria\n"
                    + "where categoria.descripcion = '" + categoria + "'");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getInt("producto.idproducto");
                datos[1] = rs.getString("producto.nombre");
                datos[2] = rs.getString("presentacion.descripcion");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return datos;
    }

    //Metodo para obteber los datos de la tabla buscar producto en la parte de conteo diario
//    public List<tablaBuscarProducto> tablaBuscar(String categoria) throws Exception {
//        List<tablaBuscarProducto> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            PreparedStatement pst = this.conexion.prepareStatement("select producto.idproducto, producto.nombre, presentacion.descripcion from producto\n"
//                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
//                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
//                    + "inner join categoria on productopresentacion.idcategoria = categoria.idcategoria\n"
//                    + "where categoria.descripcion = '" + categoria + "'");
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//                tablaBuscarProducto tbp = new tablaBuscarProducto();
//                tbp.setIdProducto(rs.getInt("producto.idproducto"));
//                tbp.setProducto(rs.getString("producto.nombre"));
//                tbp.setPresentacion(rs.getString("presentacion.descripcion"));
//                lista.add(tbp);
//            }
//            rs.close();
//            pst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

//    public List<tablaBuscarProducto> mostrarProductos(String categoria) throws Exception {
//        List<tablaBuscarProducto> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            CallableStatement query = this.conexion.prepareCall("{call mostrar_conteo(?)}");
//            query.setString(1, categoria);
//            ResultSet rs = query.executeQuery();
//            while (rs.next()) {
//                tablaBuscarProducto tbp = new tablaBuscarProducto();
//                tbp.setIdProducto(rs.getInt(1));
//                tbp.setProducto(rs.getString(2));
//                tbp.setPresentacion(rs.getString(3));
//                lista.add(tbp);
//            }
//            rs.close();
//            query.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

//    public List<InventarioValorizado> getInventario(String orden) throws Exception {
//        List<InventarioValorizado> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            CallableStatement cst = this.conexion.prepareCall("{call get_inventario_ordenado(?)}");
//            cst.setString(1, orden);
//            ResultSet rs = cst.executeQuery();
//            while (rs.next()) {
//                InventarioValorizado iv = new InventarioValorizado();
//                iv.setCodigo(rs.getInt(1));
//                iv.setProducto(rs.getString(2));
//                iv.setPresentacion(rs.getString(3));
//                iv.setCategoria(rs.getString(4));
//                iv.setStock(rs.getDouble(5));
//                iv.setValorizacion(rs.getDouble(6));
//                lista.add(iv);
//            }
//            rs.close();
//            cst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

//    public List<InventarioValorizado> getInventario() throws Exception {
//        List<InventarioValorizado> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            CallableStatement cst = this.conexion.prepareCall("{call get_inventario}");
//            ResultSet rs = cst.executeQuery();
//            while (rs.next()) {
//                InventarioValorizado iv = new InventarioValorizado();
//                iv.setCodigo(rs.getInt(1));
//                iv.setProducto(rs.getString(2));
//                iv.setPresentacion(rs.getString(3));
//                iv.setCategoria(rs.getString(4));
//                iv.setStock(rs.getDouble(5));
//                iv.setPrecio(rs.getDouble(6));
//                iv.setValorizacion(rs.getDouble(7));
//                lista.add(iv);
//            }
//            rs.close();
//            cst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

    //metodo para obtener nombre de producto y su presentacion
//    public List<tablaBuscarProducto> getProductoPresentacion(String nomCategoria) throws Exception {
//        List<tablaBuscarProducto> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            CallableStatement cst = this.conexion.prepareCall("{call get_producto_presentacion_categoria(?)}");
//            cst.setString(1, nomCategoria);
//            ResultSet rs = cst.executeQuery();
//            while (rs.next()) {
//                tablaBuscarProducto tbp = new tablaBuscarProducto();
//                tbp.setIdProducto(rs.getInt(1));
//                tbp.setProducto(rs.getString(2));
//                tbp.setPresentacion(rs.getString(3));
//                tbp.setStock(rs.getInt(4));
//                lista.add(tbp);
//            }
//            rs.close();
//            cst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

//    public List<tablaBuscarProducto> getProductoPresentacion() throws Exception {
//        List<tablaBuscarProducto> lista = new ArrayList<>();
//        try {
//            this.conectar();
//            CallableStatement cst = this.conexion.prepareCall("{call get_producto_presentacion}");
//            ResultSet rs = cst.executeQuery();
//            while (rs.next()) {
//                tablaBuscarProducto tbp = new tablaBuscarProducto();
//                tbp.setIdProducto(rs.getInt(1));
//                tbp.setProducto(rs.getString(2));
//                tbp.setPresentacion(rs.getString(3));
//                tbp.setStock(rs.getInt(4));
//
//                lista.add(tbp);
//            }
//            rs.close();
//            cst.close();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//        return lista;
//    }

    //actualizar el stock de almacen principal
    public boolean updateStock(double newStock, int idProductoPresentacion) throws Exception {
        String sql = "UPDATE productopresentacion SET stock = ? WHERE idproductopresentacion = ?";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, newStock);
            pst.setInt(2, idProductoPresentacion);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
    
    
    //actualizar el stock segun almacen indicado
    public boolean updateStock(double newStock, int idProducto, int idAlmacen) throws Exception {
        String sql = "UPDATE productopresentacion SET stock = ? WHERE idproducto = ? AND idalmacen = ?";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, newStock);
            pst.setInt(2, idProducto);
            pst.setInt(3, idAlmacen);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
    
    
    //actualizar el stock de productos con nota de pedido
    public boolean updateStock2(double newStock, int idProductoPresentacion) throws Exception {
        String sql = "UPDATE productopresentacion SET stock2 = ? WHERE idproductopresentacion = ?";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, newStock);
            pst.setInt(2, idProductoPresentacion);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
    
            //actualizar el stock2 segun idproducto e idalmacen indicado
    public boolean updateStock2(double newStock, int idProducto, int idAlmacen) throws Exception {
        String sql = "UPDATE productopresentacion SET stock2 = ? WHERE idproducto = ? AND idalmacen = ?";
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement(sql);
            pst.setDouble(1, newStock);
            pst.setInt(2, idProducto);
            pst.setInt(3, idAlmacen);
            if (pst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }
    

    public boolean updatePrecio(ProductoPresentacion pp) throws Exception {
        try {
            this.conectar();
            CallableStatement cst = this.conexion.prepareCall("{call set_updateprecio(?,?)}");
            cst.setDouble(1, pp.getPrecio());
            cst.setInt(2, pp.getIdProductoPresentacion());
            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return false;
    }

//    public List<tablaBuscarProducto> buscarProducto(String art) throws SQLException, Exception {
//        tablaBuscarProducto tbp = null;
//        List<tablaBuscarProducto> lista = new ArrayList<>();
//        String sql = "SELECT productopresentacion.idproductopresentacion, producto.nombre, presentacion.descripcion, productopresentacion.stock, productopresentacion.precio\n"
//                + "FROM producto\n"
//                + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
//                + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
//                + "where producto.nombre like '%" + art + "%' AND productopresentacion.idalmacen = 1\n"
//                + "order by idproductopresentacion";
//        this.conectar();
//        try {
//            Statement st = this.conexion.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            while (rs.next()) {
//                tbp = new tablaBuscarProducto();
//                tbp.setIdProducto(rs.getInt("productopresentacion.idproductopresentacion"));
//                tbp.setProducto(rs.getString("producto.nombre"));
//                tbp.setPresentacion(rs.getString("presentacion.descripcion"));
//                tbp.setStock(Integer.parseInt(rs.getString("productopresentacion.stock")));
//                lista.add(tbp);
//            }
//            rs.close();
//            st.close();
//            return lista;
//        } catch (SQLException e) {
//            throw e;
//        } finally {
//            this.cerrar();
//        }
//    }

    @Override
    public boolean Anular(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductoPresentacion Obtener(int id) throws Exception {
        ProductoPresentacion pp = null;
        try {
            this.conectar();
            PreparedStatement pst = this.conexion.prepareStatement("select * from productopresentacion where idproductopresentacion = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                pp = new ProductoPresentacion();
                pp.setIdProductoPresentacion(rs.getInt(1));
                pp.setIdProducto(rs.getInt(2));
                pp.setIdPresentacion(rs.getInt(3));
                pp.setIdalmacen(rs.getInt(4));
                pp.setStock(rs.getDouble(5));
                pp.setStock2(rs.getDouble(6));
                pp.setStock3(rs.getDouble(7));
                pp.setPrecio(rs.getDouble(8));
                pp.setPrecio2(rs.getDouble(9));
                pp.setIdcategoria(rs.getInt(10));
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return pp;
    }

}
