/*
CLASE PARA GENERAR REPORTES CON JASPER REPORTS
 */
package Controlador;

import Modelo.MySQLDAO.Conexion;
import java.awt.BorderLayout;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author GROVER
 */
public class MyReport extends Conexion {

    JasperReport reporte;

    String path;

    HashMap parametro;
    JasperPrint jprint;

    Connection con;

    public MyReport(String path, HashMap param) {
        this.path = path;
        this.parametro = param;
    }

    public void generarReporte() throws SQLException, Exception {
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
        } finally {
            this.cerrar();
        }
    }

    public void exportToPDF(String ruta) throws JRException {
        try {
            JasperExportManager.exportReportToPdfFile(jprint, ruta);
        } catch (JRException ex) {
            throw ex;
        }
    }

    //Embeber reporte en un jpanel sin parametros
    public void incrustarReporte(JPanel jpContainer) throws Exception {
        Conexion con = new Conexion();
        try {
            con.conectar();
            //archivo jasper
            URL jasperUrl = this.getClass().getResource(path);
            JasperReport report = (JasperReport) JRLoader.loadObject(jasperUrl);
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, null, con.getConexion());
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);
            //se elimina elementos del contenedor JPanel
            jpContainer.removeAll();
            //para el tamaño de l reporte se agrega un BorderLayout
            jpContainer.setLayout(new BorderLayout());
            jpContainer.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setVisible(true);
            jpContainer.repaint();
            jpContainer.revalidate();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }finally{
        }
    }

    //Embeber reporte en un jpanel con parametros parametros
    public void incrustarReporte(JPanel jpContainer, Map parametros) throws Exception {
        Conexion con = new Conexion();
        try {
            con.conectar();
            //archivo jasper
            URL jasperUrl = this.getClass().getResource(path);
            JasperReport report = (JasperReport) JRLoader.loadObject(jasperUrl);
            //para los parametro
            parametros = new HashMap();
            parametros.clear();
            //Nuestro parametro se llama "pLastName"
            //parametros.put("pLastName", txtParameter.getText());
            //agregamos los parametros y la conexion a la base de datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(report, parametros, con.getConexion());
            //se crea el visor con el reporte
            JRViewer jRViewer = new JRViewer(jasperPrint);
            //se elimina elementos del contenedor JPanel
            jpContainer.removeAll();
            //para el tamaño del reporte se agrega un BorderLayout
            jpContainer.setLayout(new BorderLayout());
            jpContainer.add(jRViewer, BorderLayout.CENTER);
            jRViewer.setVisible(true);
            jpContainer.repaint();
            jpContainer.revalidate();
        } catch (JRException ex) {
            System.err.println(ex.getMessage());
        }finally{
            con.cerrar();
        }
    }

}
