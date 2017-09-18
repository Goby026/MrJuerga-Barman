/*
CLASE PARA GENERAR REPORTES CON JASPER REPORTS
 */
package Controlador;

import Modelo.MySQLDAO.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GROVER
 */
public class MyReport extends Conexion{
    
    JasperReport reporte;
    
    String path;
    
    HashMap parametro;
    JasperPrint jprint;
    
    Connection con;

    public MyReport(String path, HashMap param) {
        this.path = path;
        this.parametro = param;
    }
    
    public void generarReporte() throws SQLException, Exception{
        try {
            this.conectar();
            con = this.conexion;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(path);
            //reporte = JasperCompileManager.compileReport(path);
            jprint = JasperFillManager.fillReport(reporte, parametro, con);
            JasperViewer viewer = new JasperViewer(jprint, false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
        } catch (Exception e) {
            throw e;
        }finally{
            this.cerrar();
        }
    }
    
    public void exportToPDF(String ruta) throws JRException{
        try {
            JasperExportManager.exportReportToPdfFile(jprint,ruta);
        } catch (JRException ex) {
            throw ex;
        }
    }
    
}
