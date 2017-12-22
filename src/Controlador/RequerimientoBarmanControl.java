package Controlador;

import Modelo.Almacen;
import Modelo.Medida;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.FlujoInventarioDAO;
import Modelo.MySQLDAO.MedidaDAO;
import Modelo.MySQLDAO.ProductoRequerimientoDAO;
import Modelo.MySQLDAO.RequerimientoDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.ProductoRequerimiento;
import Modelo.Requerimiento;
import Vista.VistaRequerimientoBarman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class RequerimientoBarmanControl implements KeyListener, MouseListener, WindowListener, ActionListener {

    VistaRequerimientoBarman vrb;
    DefaultTableModel modeloProductos;
    DefaultTableModel modeloAdd;
    HashMap parametro = new HashMap();

    public RequerimientoBarmanControl(VistaRequerimientoBarman vrb) {
        this.vrb = vrb;
        this.vrb.addWindowListener(this);
        this.vrb.txtProducto.addKeyListener(this);
        this.vrb.tblRequerimientos.addMouseListener(this);
        this.vrb.btnAdd.addActionListener(this);
        this.vrb.btnQuitarAdd.addActionListener(this);
        this.vrb.cmbMedida.addActionListener(this);
        this.vrb.btnGuardar.addActionListener(this);
        this.vrb.btnListarPedidos.addActionListener(this);
    }

    /* METODOS DE LOGICA DE NEGOCIO */
    
    public void cargarTitulosAdd() {
        String cabeceraAdd[] = {"ID", "PRODUCTO", "PRESENTACION", "MEDIDA", "CANTIDAD"};
        modeloAdd = new DefaultTableModel(null, cabeceraAdd);
        vrb.tblAdd.setModel(modeloAdd);
    }

    public void LimpiarTabla(JTable tabla, DefaultTableModel modelo) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    public void limpiarCampos() {
        vrb.txtCantidad.setText("");
        vrb.txtProducto.setText("");
        vrb.txaObservaciones.setText("");
        vrb.tblRequerimientos.clearSelection();
    }

    public void cargarComboMedidas() {
        MedidaDAO mdao = new MedidaDAO();
        try {
            for (Medida m : mdao.Listar()) {
                vrb.cmbMedida.addItem(m);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* EVENTOS DE TECLADO */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == vrb.txtProducto) {
            
        }
    }

    /* EVENTOS DE VENTANA */
    @Override
    public void windowOpened(WindowEvent e) {
        if (e.getSource() == vrb) {
            cargarTitulosAdd();
            cargarComboMedidas();
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
        if (e.getSource() == vrb.tblAdd) {
            if (e.getClickCount() == 2) {
                vrb.btnAdd.doClick();
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

    /* BOTONES (action performed) */
    @Override
    public void actionPerformed(ActionEvent e) {

        //boton agregar pedido a la tabla derecha
        if (e.getSource() == vrb.btnAdd) {
            int fila = vrb.tblRequerimientos.getSelectedRow();

            if (fila >= 0) {
                if (!vrb.txtCantidad.getText().isEmpty()) {

                    Object datos[] = new Object[5];
                    datos[0] = vrb.tblRequerimientos.getValueAt(fila, 0).toString();
                    datos[1] = vrb.tblRequerimientos.getValueAt(fila, 1).toString();
                    datos[2] = vrb.tblRequerimientos.getValueAt(fila, 2).toString();
                    Medida m = (Medida) vrb.cmbMedida.getSelectedItem();
                    datos[3] = m;//medida
                    datos[4] = vrb.txtCantidad.getText();

                    modeloAdd.addRow(datos);
                    vrb.tblAdd.setModel(modeloAdd);

                    limpiarCampos();

                } else {
                    JOptionPane.showMessageDialog(vrb.getRootPane(), "INDIQUE UNA CANTIDAD");
                }
            } else {
                JOptionPane.showMessageDialog(vrb.getRootPane(), "SELECCIONE UN PRODUCTO");
            }

        }

        //boton quitar producto agregado
        if (e.getSource() == vrb.btnQuitarAdd) {
            int fila = vrb.tblAdd.getSelectedRow();

            if (fila >= 0) {
                modeloAdd.removeRow(fila);
            } else {
                JOptionPane.showMessageDialog(vrb.getRootPane(), "SELECCIONE PRODUCTO A QUITAR");
            }
        }

        /* BOTON REGISTRAR REQUERIMIENTO */
        if (e.getSource() == vrb.btnGuardar) {
            try {                
                int idReq = 0;
                int contador = 0;
                UsuarioDAO udao = new UsuarioDAO();
                int idUsuario = udao.getIdUsuario(vrb.txtUsuario.getText());
                Almacen almacen = new AlmacenDAO().Obtener(vrb.lblAlmacen.getText());
                int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idUsuario, almacen.getId());

                //registrar el requermiento
                Requerimiento r = new Requerimiento();
                r.setIdUsuario(idUsuario);
                
                r.setIdAlmacen(almacen.getId());
                r.setIdFlujoInventario(idFlujoInventario);
                r.setFecha(new ManejadorFechas().getFechaActualMySQL());
                r.setHora(new ManejadorFechas().getHoraActual());
                r.setObservacion(vrb.txaObservaciones.getText());
                r.setEstado(1);//pendiente

                RequerimientoDAO rdao = new RequerimientoDAO();
                if (rdao.Registrar(r)) {
                    ProductoRequerimiento rp = new ProductoRequerimiento();
                    //obtener el ultimo id de requerimiento registrado
                    idReq = new RequerimientoDAO().getUltimoRequerimiento();

                    for (int i = 0; i < vrb.tblAdd.getRowCount(); i++) {
                        rp.setIdRequerimiento(idReq);
                        rp.setIdProductoPresentacion(Integer.parseInt(vrb.tblAdd.getValueAt(i, 0).toString()));
                        rp.setMedida((Medida) vrb.tblAdd.getValueAt(i, 3));
                        rp.setCantidad(Integer.parseInt(vrb.tblAdd.getValueAt(i, 4).toString()));

                        ProductoRequerimientoDAO prdao = new ProductoRequerimientoDAO();

                        if (prdao.Registrar(rp)) {
                            contador++;
                        }
                    }
                }

                if (contador > 0) {
                    JOptionPane.showMessageDialog(null, "SE REGISTRÓ EL REQUERIMIENTO CORRECTAMENTE");
                    limpiarCampos();
                    LimpiarTabla(vrb.tblAdd, modeloAdd);
                    
                    /*creacion del reporte*/
                    parametro.put("idRequerimiento", idReq);
                    String path = System.getProperty("user.dir") + "\\reportes\\ReportePrueba.jasper";
                    System.out.println(path);
                    MyReport mireporte = new MyReport(path, parametro);
                    mireporte.generarReporte();
                    String rutaParaPDF = "D:\\reportesBarman\\requerimiento-"+idReq+".pdf";
                    mireporte.exportToPDF(rutaParaPDF);
                } else {
                    JOptionPane.showMessageDialog(null, "ALGO SALIO MAL, REVISA LOS PARAMETROS DEL PEDIDO");
                }
            } catch (Exception ex) {
                Logger.getLogger(RequerimientoBarmanControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

}
