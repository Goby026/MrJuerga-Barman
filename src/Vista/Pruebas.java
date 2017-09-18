/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.MySQLDAO.RequerimientoDAO;
import Modelo.Requerimiento;
import Modelo.tablaBuscarProducto;

/**
 *
 * @author MARCEL
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RequerimientoDAO rdao = new RequerimientoDAO();
        
        for (RequerimientoDAO.tablaBuscar tb : rdao.buscarRequerimientoPorFechas("2017-07-30", "2017-07-31")) {
            System.out.println(tb.getIdRequermiento()+" "+ tb.getFecha() +" "+ tb.getUsuario()  );
        }
    }
    
}
