package Controlador;

import Modelo.MySQLDAO.ProductoRequerimientoDAO;
import Modelo.MySQLDAO.RequerimientoDAO;
import Vista.BuscarRequerimientos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class BuscarRequerimientosControl implements ActionListener, WindowListener, MouseListener {

    BuscarRequerimientos br;
    DefaultTableModel modelo;
    DefaultTableModel modeloDetalle;

    public BuscarRequerimientosControl(BuscarRequerimientos br) {
        this.br = br;
        this.br.btnBuscar.addActionListener(this);
        this.br.btnReimprimir.addActionListener(this);
        this.br.addWindowListener(this);
        this.br.tblRequerimientos.addMouseListener(this);
    }

    /*cargar titulos de la tabla requerimientos*/
    public void titulos(JTable tabla) {
        String titulos[] = {"COD", "FECHA", "USUARIO"};
        modelo = new DefaultTableModel(null, titulos);
        tabla.setModel(modelo);
    }

    /* cargar titulos de la tabla detalle requerimientos */
    public void titulosDetalles(JTable tabla) {
        String titulos[] = {"CANTIDAD", "MEDIDA", "PRODUCTO"};
        modeloDetalle = new DefaultTableModel(null, titulos);
        tabla.setModel(modeloDetalle);
    }

    /* cargar tabla requerimientos */
    public void cargarTabla(String fechaInicial, String fechaFinal) throws Exception {
        try {
            Object columna[] = new Object[3];
            List<RequerimientoDAO.tablaBuscar> lista = new RequerimientoDAO().buscarRequerimientoPorFechas(fechaInicial, fechaFinal);
            for (int i = 0; i < lista.size(); i++) {
                columna[0] = lista.get(i).getIdRequermiento();
                columna[1] = lista.get(i).getFecha();
                columna[2] = lista.get(i).getUsuario();

                modelo.addRow(columna);
            }
            br.tblRequerimientos.setModel(modelo);

        } catch (Exception e) {
            throw e;
        }
    }

    /* cargar tabla detalle requerimiento */
    public void cargarTablaDetalle(int id) throws Exception {
        try {
            Object columna[] = new Object[3];
            List<ProductoRequerimientoDAO.tablaDetalleRequerimiento> lista = new ProductoRequerimientoDAO().getDetalleRequerimiento(id);
            for (int i = 0; i < lista.size(); i++) {
                columna[0] = lista.get(i).getCantidad();
                columna[1] = lista.get(i).getMedida();
                columna[2] = lista.get(i).getProducto();

                modeloDetalle.addRow(columna);
            }
            br.tblDetalleRequerimiento.setModel(modeloDetalle);

        } catch (Exception e) {
            throw e;
        }
    }

    public void LimpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }


    /* ACTION PERFORMED - BOTONES */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == br.btnBuscar) {
            ManejadorFechas mf = new ManejadorFechas();
            String fechaInicial = mf.getJdcFecha(br.jdcInicio);
            String fechaFinal = mf.getJdcFecha(br.jdcFinal);
            if (br.jdcInicio != null && br.jdcFinal != null) {
                LimpiarTabla(br.tblRequerimientos, modelo);
                try {
                    cargarTabla(fechaInicial, fechaFinal);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "INDIQUE LAS FECHAS CORRECTAMENTE");
            }
        }
        
        
        if (e.getSource() == br.btnReimprimir) {
            
            
            
        }
    }
    
    

    /*WINDOW LISTENER - EVENTOS DE FORMULARIO*/
    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource() == br) {
            titulos(br.tblRequerimientos);
            titulosDetalles(br.tblDetalleRequerimiento);
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    /* EVENTOS DE MOUSE */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == br.tblRequerimientos) {
            if (e.getClickCount() == 2) {
                try {
                    LimpiarTabla(br.tblDetalleRequerimiento, modeloDetalle);
                    int fila = br.tblRequerimientos.getSelectedRow();
                    int id = Integer.parseInt(br.tblRequerimientos.getValueAt(fila, 0).toString());
                    br.DetalleRequerimiento.setVisible(true);
                    br.DetalleRequerimiento.setBounds(100, 100, 550, 400);
                    cargarTablaDetalle(id);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
