package Controlador;

import Modelo.InventarioProducto;
import Modelo.MySQLDAO.PreparacionDAO;
import Modelo.Preparacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grover
 */
public class StockBebidasPreparadas2 {

    public void validarProducto(List<Preparacion> preparacion) {

        for (Preparacion p : preparacion) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) throws Exception {
        //ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();
        PreparacionDAO predao = new PreparacionDAO();
        List<Preparacion> lst = predao.ListarProductosPreparar(123);
        
//        for (Preparacion pre : lst) {//parametro: producto que esta entrando para prepararaciones
//            for (int i = 0; i < predao.ListaProductosHijos().size(); i++) {
//                if (pre.getIdProducto() == Integer.parseInt(predao.ListaProductosHijos().get(i))) {
//                    System.out.println(pre);
//                }
//            }
//        }

//        for (ProductoPresentacion p : ppdao.ListarPorCategoria(1)) {//parametro el id de categoria
//
//            List<Preparacion> pre = predao.Listar(p.getIdProducto());
//
//            StockBebidasPreparadas2 s2 = new StockBebidasPreparadas2();
//
//            s2.validarProducto(pre);
//        }
    }

    public List<InventarioProducto> establecerStocks(InventarioProducto ip) {
        List<InventarioProducto> lst = new ArrayList<>();
        return null;
    }

}
