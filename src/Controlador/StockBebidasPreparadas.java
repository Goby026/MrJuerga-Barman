package Controlador;


import Modelo.MySQLDAO.PreparacionDAO;
import Modelo.MySQLDAO.PresentacionDAO;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import Modelo.Preparacion;
import Modelo.Presentacion;
import Modelo.ProductoPresentacion;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grover
 */
public class StockBebidasPreparadas {

    private int idProducto;//producto que se compondrá de otros productos
    private int idAlmacen;

    public StockBebidasPreparadas(int idProducto, int idAlmacen) {
        this.idProducto = idProducto;
        this.idAlmacen = idAlmacen;
    }

    //metodo para evaluar si el producto inicializado tiene componentes de preparacion
    private boolean verificarProducto() {
        try {
            PreparacionDAO pdao = new PreparacionDAO();
            if (pdao.Listar(idProducto).size() > 0) {
                System.out.println("el producto si tiene componentes");
                return true;
            }
        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //metodo para calcular el stock de un producto en mililitros
    private double calcularStockML(int idProductoPresentacion) {
        try {
            //convertir todo a ML
            ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProductoPresentacion, idAlmacen);//almacen 1 = ALMACEN GENERAL
            Presentacion p = new PresentacionDAO().obtenerPresentacion(pp.getIdPresentacion());
            System.out.println("stock de componente: " + pp.getStock());
            return p.getValorMl() * pp.getStock();
        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    //metodo para obtener el stock calculado de un producto padre
    //idProd es el producto que se compondrá de otros productos
    private double getStock() {
        double stockReal = 0;
        try {
            if (verificarProducto()) {
                List<Double> stocksCalculados = new ArrayList<>();
                PreparacionDAO pdao = new PreparacionDAO();
                for (Preparacion p : pdao.Listar(idProducto)) {
                    System.out.println("componente :" + p.getIdProductoPresentacion() + " -> ml :" + p.getCantidad());
                    stocksCalculados.add(calcularStockML(p.getIdProductoPresentacion()) / p.getCantidad());
                }
                stockReal = stocksCalculados.stream().mapToDouble(i -> i).min().getAsDouble();//expresion Lambda para obtener el minimo de la Lista StockBebidasPreparadas
                System.out.println("el stock seria : " + stockReal);
                //System.out.println(stocksCalculados.stream().mapToDouble(i -> i).max().getAsDouble());//expresion Lambda para obtener el maximo de la Lista StockBebidasPreparadas
            }
        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stockReal;
    }

    //metodo para actualizar stock segun el almacen indicado en un traslado
    public boolean updateStock(int idAlmacen) {
        try {

            if (verificarProducto()) {
                ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

                if (ppdao.updateStock((int) getStock(), idProducto, idAlmacen)) {
                    return true;
                }
            } else {
                System.out.println("El producto no tiene componentes para calcular el stock");
            }

        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    //metodo para actualizar stock de componentes en una venta normal
    public boolean updateStockVenta() {
        try {
            if (verificarProducto()) {
                int c = 0;
                
                ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

                PreparacionDAO pdao = new PreparacionDAO();

                for (Preparacion p : pdao.Listar(idProducto)) {
                    
                    ProductoPresentacion prodp = ppdao.Obtener(p.getIdProductoPresentacion());
                    
                    Presentacion pre = new PresentacionDAO().obtenerPresentacion(prodp.getIdPresentacion());
                    
                    //System.out.println("VALOR DE PRESENTACION:::::::"+pre.getValorMl());
                    
                    double valor = p.getCantidad() / pre.getValorMl();//cantidad de receta entre el valor de la presentacion
                    //System.out.println("VALOR ---> CANTIDAD ML:::::::"+p.getCantidad());
                    //System.out.println("VALOR ---> PRESENTACION ML:::::::"+pre.getValorMl());
                    //System.out.println("VALOR CALCULADO ---> CANTIDAD ML / VALOR DE PRESENTACION:::::::"+valor);

                    //en este caso el idproductopresentacion siempre sera de almacen 1 por que la receta se configuro con ese id
                    //por eso se pasa el idWarehouse para que cuando busque en la tabla productopresentacion
                    //el idproductopresentacion lo tome como si fuera un idProducto y pueda ubicar el correcto stock
                    ProductoPresentacion pp = ppdao.Obtener(p.getIdProductoPresentacion(), idAlmacen);//las cantidades en ML estan registradas en la tabla preparacion que siempre apunta a almacen 1

                    //System.out.println("STOCK DE PRODUCTO COMPONENTE ANTES:::::::::::"+pp.getStock());
                    
                    double stock = pp.getStock() - valor;
                    
                    //System.out.println("STOCK DE PRODUCTO COMPONENTE DESPUES:::::::::::"+stock);
                    if (ppdao.updateStock(stock, p.getIdProductoPresentacion(), idAlmacen)) {
                        c++;
                    }
                }

                if (c > 0) {
                    return true;
                }

            } else {
                //se debe validar si el producto es componente de alguna bebida y hacer los calculos pertinentes
                System.out.println("El producto no tiene componentes para calcular el stock");
            }

        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
        //metodo para actualizar stock2 de componentes en una venta con nota de pedido
    public boolean updateStockNotaPedido() {
        try {
            if (verificarProducto()) {
                int c = 0;
                
                ProductoPresentacionDAO ppdao = new ProductoPresentacionDAO();

                PreparacionDAO pdao = new PreparacionDAO();

                for (Preparacion p : pdao.Listar(idProducto)) {
                    
                    ProductoPresentacion prodp = ppdao.Obtener(p.getIdProductoPresentacion());
                    
                    Presentacion pre = new PresentacionDAO().obtenerPresentacion(prodp.getIdPresentacion());
                    
                    //System.out.println("VALOR DE PRESENTACION:::::::"+pre.getValorMl());
                    
                    double valor = p.getCantidad() / pre.getValorMl();//cantidad de receta entre el valor de la presentacion
//                    System.out.println("VALOR ---> CANTIDAD ML:::::::"+p.getCantidad());
//                    System.out.println("VALOR ---> PRESENTACION ML:::::::"+pre.getValorMl());
//                    System.out.println("VALOR CALCULADO ---> CANTIDAD ML / VALOR DE PRESENTACION:::::::"+valor);

                    //en este caso el idproductopresentacion siempre sera de almacen 1 por que la receta se configuro con ese id
                    //por eso se pasa el idWarehouse para que cuando busque en la tabla productopresentacion
                    //el idproductopresentacion lo tome como si fuera un idProducto y pueda ubicar el correcto stock
                    ProductoPresentacion pp = ppdao.Obtener(p.getIdProductoPresentacion(), idAlmacen);//las cantidades en ML estan registradas en la tabla preparacion que siempre apunta a almacen 1

//                    System.out.println("STOCK DE PRODUCTO COMPONENTE ANTES:::::::::::"+pp.getStock());
                    
                    double stock = pp.getStock2() - valor;
                    
//                    System.out.println("STOCK DE PRODUCTO COMPONENTE DESPUES:::::::::::"+stock);
                    if (ppdao.updateStock2(stock, p.getIdProductoPresentacion(), idAlmacen)) {
                        c++;
                    }
                }

                if (c > 0) {
                    return true;
                }

            } else {
                //se debe validar si el producto es componente de alguna bebida y hacer los calculos pertinentes
                System.out.println("El producto no tiene componentes para calcular el stock");
            }

        } catch (Exception ex) {
            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

//    public static void main(String[] args) {
//        try {
//            StockBebidasPreparadas sbp = new StockBebidasPreparadas(1,2);//(productoPadre, almacen)
//            Presentacion p = new PresentacionDAO().obtenerPresentacion(13);
//            sbp.updateStockVenta(p,2);
//        } catch (Exception ex) {
//            Logger.getLogger(StockBebidasPreparadas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
}
