/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ColumnasTablas;
import Controlador.Cronometro;
import Controlador.FormatoFechas;
import Controlador.JTableControl;
import Controlador.ManejadorFechas;
import Modelo.Almacen;
import Modelo.VentaGeneral;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.Conexion;
import Modelo.MySQLDAO.VentaGeneralDAO;
import Modelo.MySQLDAO.FlujoInventarioDAO;
import Modelo.MySQLDAO.NotaPedidoDAO;
import Modelo.MySQLDAO.ProductoPresentacionDAO;
import Modelo.MySQLDAO.ProductoRotoDAO;
import Modelo.MySQLDAO.ProductoSinRecogerDAO;
import Modelo.MySQLDAO.RequerimientoDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.NotaPedido;
import Modelo.ProductoPresentacion;
import Modelo.ProductoRoto;
import Modelo.ProductoSinRecoger;
import Modelo.Requerimiento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author GROVER
 */
public class CierreBarman extends javax.swing.JFrame {

    JTableControl jcEntradaGneral;
    JTableControl jcEntradaGneral2;
    JTableControl jcCajaGeneral;
    JTableControl jcCajaGeneral2;
    JTableControl jcTotal;
    JTableControl jcTotalVentas;
    JTableControl jcBuscarProducto;
    JTableControl jcProductoSinRecoger;
    JTableControl jcIngresos;
    JTableControl jcStockFinal;
    JTableControl jcRequerimiento;
    JTableControl jcTraslado;
    JTableControl jcTotalProductosRotos;
    JTableControl jcTotalProductoSinRecoger;
    JTableControl jcTotalVentasTickets;
    JTableControl jcTotalNotasPedido;

    Almacen almacen = null;
    int idUsuario = 0;
    int tipoProducto = 0; //variable para reconocer si es un producto sin recoger o un producto roto

    boolean ingresos = true;
    boolean salidaPorVenta = true;
    boolean prodRotos = true;
    boolean prodSinRec = true;

    public CierreBarman(String usuario, String storage) throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        formSalidaPorVentas.setTitle(storage);
        lblUsuario.setText(usuario);
        lblAlmacen.setText(storage);
        almacen = new AlmacenDAO().Obtener(storage);
        idUsuario = new UsuarioDAO().getIdUsuario(usuario);
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        new Cronometro().iniciarCronometro(txtHora);

        this.setTitle("CIERRE DE BARMAN - " + storage);

        String titulos[] = {"COD", "PRODUCTO", "PRESENTACION", "CANTIDAD"};
        String titulosBuscarProducto[] = {"COD", "PRODUCTO", "PRESENTACION"};
        String titulosTraslados[] = {"COD", "PRODUCTO", "PRESENTACION", "ORIGEN", "DESTINO", "CANTIDAD"};

        jcEntradaGneral = new JTableControl(titulos, tblEntradaGeneral);
        jcEntradaGneral2 = new JTableControl(titulos, tblEntradaGeneral2);
        jcCajaGeneral = new JTableControl(titulos, tblCajaGeneral);
        jcCajaGeneral2 = new JTableControl(titulos, tblCajaGeneral2);
        jcTotal = new JTableControl(titulos, tblTotal);
        jcTotalVentas = new JTableControl(titulos, tblVentas);
        jcBuscarProducto = new JTableControl(titulosBuscarProducto, tblBuscarProductoSinRecoger);
        jcProductoSinRecoger = new JTableControl(titulos, tblProductosSinRecogerRotos);
        jcIngresos = new JTableControl(titulos, tblTotalIngresos);
        jcStockFinal = new JTableControl(titulos, tblStockFinal);
        jcRequerimiento = new JTableControl(titulos, tblIngresosRequerimientos);
        jcTraslado = new JTableControl(titulosTraslados, tblIngresosTraslados);
        jcTotalProductosRotos = new JTableControl(titulos, tblProductoRotos);
        jcTotalProductoSinRecoger = new JTableControl(titulos, tblProductoSinRecoger);
        jcTotalVentasTickets = new JTableControl(titulos, tblTotalVentasTicket);
        jcTotalNotasPedido = new JTableControl(titulos, tblTotalNotasPedido);

        jcEntradaGneral.llenarTitulos();
        jcEntradaGneral2.llenarTitulos();
        jcCajaGeneral.llenarTitulos();
        jcCajaGeneral2.llenarTitulos();
        jcTotal.llenarTitulos();
        jcTotalVentas.llenarTitulos();
        jcBuscarProducto.llenarTitulos();
        jcProductoSinRecoger.llenarTitulos();
        jcIngresos.llenarTitulos();
        jcStockFinal.llenarTitulos();
        jcRequerimiento.llenarTitulos();
        jcTraslado.llenarTitulos();
        jcTotalProductosRotos.llenarTitulos();
        jcTotalProductoSinRecoger.llenarTitulos();
        jcTotalVentasTickets.llenarTitulos();
        jcTotalNotasPedido.llenarTitulos();

        cargarInventarioInicial(almacen.getId());

    }

    private CierreBarman() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formSalidaPorVentas = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntradaGeneral2 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradaGeneral = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotal = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblCajaGeneral2 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblCajaGeneral = new javax.swing.JTable();
        btnConfirmarTotal = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnMostrarVentas = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        xyz = new com.toedter.calendar.JDateChooser();
        formInventarioInicial = new javax.swing.JDialog();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblInventarioInicial = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        formProductosSinRecogerRotos = new javax.swing.JDialog();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblBuscarProductoSinRecoger = new javax.swing.JTable();
        btnBuscarProductoSinRecoger = new javax.swing.JButton();
        txtBuscarProducto = new javax.swing.JTextField();
        btnSeleccionarProductoSinRecoger = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblProductosSinRecogerRotos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnConfirmarProductoRotoSinRecoger = new javax.swing.JButton();
        formIngresos = new javax.swing.JDialog();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblIngresosRequerimientos = new javax.swing.JTable();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblIngresosTraslados = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnConfirmarIngresos = new javax.swing.JButton();
        formVentasTotales = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTotalVentasTicket = new javax.swing.JTable();
        jScrollPane17 = new javax.swing.JScrollPane();
        tblTotalNotasPedido = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnMostrarTotalVentas = new javax.swing.JButton();
        jdcFechaAperturaCaja = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jlabelu = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jlabelf = new javax.swing.JLabel();
        jlabelh = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        jlabelh1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblStockFinal = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnSalidaPorVentas = new javax.swing.JButton();
        btnProdSinRecog = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnConfirmarTotalBarra = new javax.swing.JButton();
        btnIngresos = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblTotalIngresos = new javax.swing.JTable();
        btnProductosRotos = new javax.swing.JButton();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblProductoSinRecoger = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblProductoRotos = new javax.swing.JTable();
        btnPrueba = new javax.swing.JButton();

        formSalidaPorVentas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEntradaGeneral2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblEntradaGeneral2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEntradaGeneral2);

        formSalidaPorVentas.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 370, 240));

        tblEntradaGeneral.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblEntradaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblEntradaGeneral);

        formSalidaPorVentas.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 370, 240));

        tblTotal.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblTotal);

        formSalidaPorVentas.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 50, 460, 240));

        jButton3.setText("TOTAL");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, -1, -1));

        tblCajaGeneral2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblCajaGeneral2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tblCajaGeneral2);

        formSalidaPorVentas.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 370, 240));

        tblCajaGeneral.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblCajaGeneral.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblCajaGeneral);

        formSalidaPorVentas.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 370, 240));

        btnConfirmarTotal.setText("CONFIRMAR TOTAL");
        btnConfirmarTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTotalActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(btnConfirmarTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 540, -1, -1));

        jLabel8.setText("CAJA GENERAL 02");
        formSalidaPorVentas.getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, -1, -1));

        btnMostrarVentas.setText("MOSTRAR TOTAL VENTAS");
        btnMostrarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarVentasActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(btnMostrarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, -1, -1));

        jLabel9.setText("TOTALES");
        formSalidaPorVentas.getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, -1));

        jLabel10.setText("FECHA DE APERTURA DE CAJAS");
        formSalidaPorVentas.getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jLabel11.setText("ENTRADA GENERAL 02");
        formSalidaPorVentas.getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, -1, -1));

        jLabel12.setText("CAJA GENERAL 01");
        formSalidaPorVentas.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel18.setText("ENTRADA GENERAL");
        formSalidaPorVentas.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));
        formSalidaPorVentas.getContentPane().add(xyz, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 170, -1));

        formInventarioInicial.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventarioInicial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane11.setViewportView(tblInventarioInicial);

        formInventarioInicial.getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jLabel4.setText("INVENTARIO INICAL");
        formInventarioInicial.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        formProductosSinRecogerRotos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblBuscarProductoSinRecoger = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblBuscarProductoSinRecoger.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblBuscarProductoSinRecoger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBuscarProductoSinRecoger.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarProductoSinRecogerMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblBuscarProductoSinRecoger);

        formProductosSinRecogerRotos.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 220));

        btnBuscarProductoSinRecoger.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBuscarProductoSinRecoger.setText("Buscar");
        btnBuscarProductoSinRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoSinRecogerActionPerformed(evt);
            }
        });
        formProductosSinRecogerRotos.getContentPane().add(btnBuscarProductoSinRecoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, -1, 30));

        txtBuscarProducto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscarProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarProductoKeyReleased(evt);
            }
        });
        formProductosSinRecogerRotos.getContentPane().add(txtBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 30));

        btnSeleccionarProductoSinRecoger.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSeleccionarProductoSinRecoger.setText("SELECCIONAR");
        btnSeleccionarProductoSinRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarProductoSinRecogerActionPerformed(evt);
            }
        });
        formProductosSinRecogerRotos.getContentPane().add(btnSeleccionarProductoSinRecoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, -1, -1));

        tblProductosSinRecogerRotos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblProductosSinRecogerRotos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblProductosSinRecogerRotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane12.setViewportView(tblProductosSinRecogerRotos);

        formProductosSinRecogerRotos.getContentPane().add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, -1, 220));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LISTA");
        formProductosSinRecogerRotos.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 450, -1));

        btnConfirmarProductoRotoSinRecoger.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConfirmarProductoRotoSinRecoger.setText("CONFIRMAR");
        btnConfirmarProductoRotoSinRecoger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarProductoRotoSinRecogerActionPerformed(evt);
            }
        });
        formProductosSinRecogerRotos.getContentPane().add(btnConfirmarProductoRotoSinRecoger, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, -1, -1));

        formIngresos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblIngresosRequerimientos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblIngresosRequerimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(tblIngresosRequerimientos);

        formIngresos.getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 400, 260));

        tblIngresosTraslados.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblIngresosTraslados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane13.setViewportView(tblIngresosTraslados);

        formIngresos.getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 580, 260));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("TRASLADOS");
        formIngresos.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 580, -1));

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("REQUERIMIENTOS");
        formIngresos.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, -1));

        btnConfirmarIngresos.setText("CONFIRMAR");
        btnConfirmarIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarIngresosActionPerformed(evt);
            }
        });
        formIngresos.getContentPane().add(btnConfirmarIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, 120, -1));

        formVentasTotales.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("NOTA DE PEDIDO");
        formVentasTotales.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        jLabel2.setText("FECHA DE APERTURA DE LAS CAJAS");
        formVentasTotales.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        tblTotalVentasTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tblTotalVentasTicket);

        formVentasTotales.getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 490));

        tblTotalNotasPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane17.setViewportView(tblTotalNotasPedido);

        formVentasTotales.getContentPane().add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 380, 490));

        jButton1.setText("CANCELAR");
        formVentasTotales.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 560, 90, -1));

        jButton2.setText("ACEPTAR");
        formVentasTotales.getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 90, -1));

        btnMostrarTotalVentas.setText("MOSTRAR");
        btnMostrarTotalVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTotalVentasActionPerformed(evt);
            }
        });
        formVentasTotales.getContentPane().add(btnMostrarTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));
        formVentasTotales.getContentPane().add(jdcFechaAperturaCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 150, -1));

        jLabel17.setText("VENTAS TICKET");
        formVentasTotales.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("_____");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 8, 200, -1));

        jlabelu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelu.setForeground(new java.awt.Color(255, 255, 255));
        jlabelu.setText("Usuario:");
        jPanel1.add(jlabelu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("____");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 8, 150, -1));

        jlabelf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelf.setForeground(new java.awt.Color(255, 255, 255));
        jlabelf.setText("Fecha:");
        jPanel1.add(jlabelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, -1, -1));

        jlabelh.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelh.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh.setText("Hora:");
        jPanel1.add(jlabelh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 8, -1, -1));

        lblAlmacen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        lblAlmacen.setText("____");
        jPanel1.add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 180, -1));

        jlabelh1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelh1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh1.setText("Almacen:");
        jPanel1.add(jlabelh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, -1, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(102, 102, 102));
        txtHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setBorder(null);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 8, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 1090, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VENTAS TOTALES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 540, 20));

        tblVentas.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tblVentas);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 540, 330));

        jButton4.setText("CERRAR INVENTARIO");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 672, 150, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REQUERIMIENTOS - TRASLADOS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 540, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("PRODUCTOS SIN RECOGER");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 540, 20));

        tblStockFinal.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblStockFinal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane10.setViewportView(tblStockFinal);

        getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 540, 330));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1080, 10));

        btnSalidaPorVentas.setBackground(new java.awt.Color(0, 153, 255));
        btnSalidaPorVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalidaPorVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnSalidaPorVentas.setText("SALIDAS POR VENTAS");
        btnSalidaPorVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaPorVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalidaPorVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 180, 40));

        btnProdSinRecog.setBackground(new java.awt.Color(0, 153, 255));
        btnProdSinRecog.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        btnProdSinRecog.setForeground(new java.awt.Color(255, 255, 255));
        btnProdSinRecog.setText("PRODUCTOS SIN RECOGER");
        btnProdSinRecog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdSinRecogActionPerformed(evt);
            }
        });
        getContentPane().add(btnProdSinRecog, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 180, 40));

        btnVolver.setBackground(new java.awt.Color(255, 51, 51));
        btnVolver.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 180, 40));

        btnConfirmarTotalBarra.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnConfirmarTotalBarra.setText("CONFIRMAR");
        btnConfirmarTotalBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarTotalBarraActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfirmarTotalBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 672, -1, -1));

        btnIngresos.setBackground(new java.awt.Color(0, 153, 255));
        btnIngresos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnIngresos.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresos.setText("INGRESOS");
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        tblTotalIngresos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblTotalIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane14.setViewportView(tblTotalIngresos);

        getContentPane().add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 540, 260));

        btnProductosRotos.setBackground(new java.awt.Color(0, 153, 255));
        btnProductosRotos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnProductosRotos.setForeground(new java.awt.Color(255, 255, 255));
        btnProductosRotos.setText("PRODUCTOS ROTOS");
        btnProductosRotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosRotosActionPerformed(evt);
            }
        });
        getContentPane().add(btnProductosRotos, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 180, 40));

        tblProductoSinRecoger.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblProductoSinRecoger.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane15.setViewportView(tblProductoSinRecoger);

        getContentPane().add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 200, 540, 120));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("INVENTARIO FINAL");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 320, 540, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("PRODUCTOS ROTOS");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 540, 20));

        tblProductoRotos.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        tblProductoRotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane16.setViewportView(tblProductoRotos);

        getContentPane().add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 540, 120));

        btnPrueba.setText("PRUEBA");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 0, 160, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalidaPorVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaPorVentasActionPerformed
        formSalidaPorVentas.setVisible(true);
        formSalidaPorVentas.setBounds(300, 200, 1250, 606);
    }//GEN-LAST:event_btnSalidaPorVentasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jcTotal.LimpiarTabla();
        calculos();
        fusionarTablas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnProdSinRecogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdSinRecogActionPerformed
        tipoProducto = 2; //2=producto sin recoger
        formProductosSinRecogerRotos.setVisible(true);
        formProductosSinRecogerRotos.setBounds(400, 350, 1022, 354);
        formProductosSinRecogerRotos.setTitle("PRODUCTOS SIN RECOGER");
        jcBuscarProducto.LimpiarTabla();
        jcProductoSinRecoger.LimpiarTabla();
    }//GEN-LAST:event_btnProdSinRecogActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea cerrar el inventario de" + lblAlmacen.getText() + " ?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.out.println("SI");
            try {
                int c = 0;
                int y = 0;
                int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idUsuario, almacen.getId());
                //registra productos rotos
                for (int i = 0; i < tblProductoRotos.getRowCount(); i++) {
                    int idProducto = Integer.parseInt(tblProductoRotos.getValueAt(i, 0).toString());
                    ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto);
                    ProductoRoto pr = new ProductoRoto();

                    pr.setIdproductopresentacion(pp.getIdProductoPresentacion());
                    pr.setIdflujoinventario(idFlujoInventario);
                    pr.setCantidad(Double.parseDouble(tblProductoRotos.getValueAt(i, 3).toString()));
                    pr.setPrecio(pp.getPrecio());

                    ProductoRotoDAO prdao = new ProductoRotoDAO();

                    if (prdao.Registrar(pr)) {
                        y++;
                    }
                }
                //registra producto sin recoger
                for (int i = 0; i < tblProductoSinRecoger.getRowCount(); i++) {
                    int idProducto = Integer.parseInt(tblProductoSinRecoger.getValueAt(i, 0).toString());
                    ProductoPresentacion pp = new ProductoPresentacionDAO().Obtener(idProducto);
                    ProductoSinRecoger p = new ProductoSinRecoger();

                    p.setIdproductopresentacion(pp.getIdProductoPresentacion());
                    p.setIdflujoinventario(idFlujoInventario);
                    p.setCantidad(Double.parseDouble(tblProductoSinRecoger.getValueAt(i, 3).toString()));
                    p.setPrecio(pp.getPrecio());

                    ProductoSinRecogerDAO prdao = new ProductoSinRecogerDAO();

                    if (prdao.Registrar(p)) {
                        c++;
                    }
                }

                if (c > 0 && y > 0) {
                    System.out.println("SE REGISTRARON LOS PRODUCTOS ROTOS y SIN RECOGER");
                }

                //REGISTRAR INVENTARIO FINAL
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            //registrar productos sin recoger
            //registrar inventario

        } else {
            System.out.println("NO");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnConfirmarTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTotalActionPerformed
        //validaciones
        int filas = tblTotal.getRowCount();
        if (filas > 0) {
            salidaPorVenta = false;
            btnSalidaPorVentas.setEnabled(salidaPorVenta);
            //confirmar ventas totales
            Object datos[] = new Object[4];

            for (int i = 0; i < tblTotal.getRowCount(); i++) {
                datos[0] = tblTotal.getValueAt(i, 0).toString();
                datos[1] = tblTotal.getValueAt(i, 1).toString();
                datos[2] = tblTotal.getValueAt(i, 2).toString();
                datos[3] = tblTotal.getValueAt(i, 3).toString();

                jcTotalVentas.getModelo().addRow(datos);
            }

            tblVentas.setModel(jcTotalVentas.getModelo());

            formSalidaPorVentas.dispose();
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "LA TABLA TOTALES ESTA VACIA");
        }
    }//GEN-LAST:event_btnConfirmarTotalActionPerformed

    private void txtBuscarProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarProductoKeyReleased
        try {
            jcBuscarProducto.LimpiarTabla();
            LlenarTablaBuscarProductos(txtBuscarProducto.getText().toUpperCase());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_txtBuscarProductoKeyReleased

    private void btnSeleccionarProductoSinRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarProductoSinRecogerActionPerformed
        int fila = tblBuscarProductoSinRecoger.getSelectedRow();
        double cantidad = Double.parseDouble(JOptionPane.showInputDialog("CANTIDAD"));
        try {
            if (fila >= 0) {
                if (cantidad > 0) {

                    Object datos[] = new Object[4];
                    datos[0] = tblBuscarProductoSinRecoger.getValueAt(fila, 0).toString();
                    datos[1] = tblBuscarProductoSinRecoger.getValueAt(fila, 1).toString();
                    datos[2] = tblBuscarProductoSinRecoger.getValueAt(fila, 2).toString();
                    datos[3] = cantidad;

                    jcProductoSinRecoger.getModelo().addRow(datos);
                    tblProductosSinRecogerRotos.setModel(jcProductoSinRecoger.getModelo());

                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "INDIQUE UNA CANTIDAD VALIDA");
                }
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "SELECCIONE UN PRODUCTO");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnSeleccionarProductoSinRecogerActionPerformed

    private void tblBuscarProductoSinRecogerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarProductoSinRecogerMouseClicked

        if (evt.getClickCount() == 2) {
            btnSeleccionarProductoSinRecoger.doClick();
        }
    }//GEN-LAST:event_tblBuscarProductoSinRecogerMouseClicked

    private void btnConfirmarProductoRotoSinRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarProductoRotoSinRecogerActionPerformed
        formProductosAdd(tipoProducto);
    }//GEN-LAST:event_btnConfirmarProductoRotoSinRecogerActionPerformed

    private void btnMostrarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarVentasActionPerformed
        if (xyz.getDate() != null) {
            try {
                String fecha = new FormatoFechas().FormatoFec(xyz);
                System.out.println("La fecha es: " + fecha);

                int idflujocajaJaime = new FlujoInventarioDAO().getIdFlujoCaja(1,fecha);//1= idcaja de jaime
                LlenarTablaEntradaGeneral(idflujocajaJaime);

                int idflujocajaCaja01 = new FlujoInventarioDAO().getIdFlujoCaja(3,fecha);//3= idcaja caja general, SI HAY NOTA DE PEDIDO
                System.out.println("El idFlujoCaja01 es :" + idflujocajaCaja01);
                LlenarTablaCajaGeneral(idflujocajaCaja01);

                int idflujocajaCaja02 = new FlujoInventarioDAO().getIdFlujoCaja(4,fecha);//4= idcaja caja general2, SI HAY NOTA DE PEDIDO
                LlenarTablaCajaGeneral2(idflujocajaCaja02);

                int idflujocajaAlejandro = new FlujoInventarioDAO().getIdFlujoCaja(6,fecha);//6 = idcaja de aljeandro (entrada general 02)
                LlenarTablaEntradaGeneral2(idflujocajaAlejandro);
            } catch (Exception ex) {
                Logger.getLogger(CierreBarman.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "DEBE INDICAR LA FECHA DE APERTURA DE INVENTARIO");
        }
        
    }//GEN-LAST:event_btnMostrarVentasActionPerformed

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
        jcRequerimiento.LimpiarTabla();
        jcTraslado.LimpiarTabla();

        formIngresos.setVisible(true);
        formIngresos.setBounds(400, 200, 1100, 415);
        //cargar requerimientos - traslados
        try {
            cargarRequerimientos(almacen.getId());
            cargarTraslados(almacen.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CierreBarman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            Menu m = new Menu(lblUsuario.getText(), lblAlmacen.getText());
            m.setVisible(true);
            dispose();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnProductosRotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosRotosActionPerformed
        tipoProducto = 1;//1=producto roto
        formProductosSinRecogerRotos.setVisible(true);
        formProductosSinRecogerRotos.setBounds(400, 350, 1022, 354);
        formProductosSinRecogerRotos.setTitle("PRODUCTOS ROTOS");
        jcBuscarProducto.LimpiarTabla();
        jcProductoSinRecoger.LimpiarTabla();
    }//GEN-LAST:event_btnProductosRotosActionPerformed

    private void btnConfirmarIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarIngresosActionPerformed
        //sumar las tablas
        int filasRequerimientos = tblIngresosRequerimientos.getRowCount();
        int filasTraslados = tblIngresosTraslados.getRowCount();

        Object datosReq[] = new Object[filasRequerimientos];
        Object datosTras[] = new Object[filasTraslados];

        List<String> listaReq = new ArrayList<>();
        List<String> listaTras = new ArrayList<>();

        //llenando el arreglo datosReq[]
        for (int i = 0; i < filasRequerimientos; i++) {
            datosReq[i] = tblIngresosRequerimientos.getValueAt(i, 1).toString();
        }
        //llenando el arreglo datosTras[]
        for (int i = 0; i < filasTraslados; i++) {
            datosTras[i] = tblIngresosTraslados.getValueAt(i, 1).toString();
        }

        //agrega los elementos del arreglo datos[] a la lista1
        for (Object x : datosReq) {
            listaReq.add(x.toString());
        }
        //agrega los elementos del arreglo datos2[] a la lista2
        for (Object y : datosTras) {
            listaTras.add(y.toString());
        }

        Iterator<String> it = listaTras.iterator();

        while (it.hasNext()) {
            if (listaReq.contains(it.next())) {
                it.remove();
            }
        }

        listaReq.addAll(listaTras);

        System.out.println("Lista Traslados: " + listaTras);
        System.out.println("Lista Requerimientos: " + listaReq);

        //suma las cantidades
        Object datosY[] = new Object[4];
        if (filasRequerimientos >= 0) {//si hay elementos en requerimientos
            for (int i = 0; i < filasRequerimientos; i++) {//recorre la primera tabla
                double cantidad = Double.parseDouble(tblIngresosRequerimientos.getValueAt(i, 3).toString());
                datosY[0] = tblIngresosRequerimientos.getValueAt(i, 0).toString();
                datosY[1] = tblIngresosRequerimientos.getValueAt(i, 1).toString();
                datosY[2] = tblIngresosRequerimientos.getValueAt(i, 2).toString();
                for (int j = 0; j < filasTraslados; j++) {//recorre la segunda tabla
                    if (tblIngresosRequerimientos.getValueAt(i, 1).equals(tblIngresosTraslados.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblIngresosTraslados.getValueAt(j, 5).toString());
                    }
                }
                datosY[3] = cantidad;
                jcIngresos.getModelo().addRow(datosY);
            }
        }

        //combina las tablas
        Object datosX[] = new Object[4];
        for (int i = 0; i < listaTras.size(); i++) {
            datosX[0] = tblIngresosTraslados.getValueAt(i, 0).toString();
            datosX[1] = tblIngresosTraslados.getValueAt(i, 1).toString();
            datosX[2] = tblIngresosTraslados.getValueAt(i, 2).toString();
            datosX[3] = tblIngresosTraslados.getValueAt(i, 5).toString();
            jcIngresos.getModelo().addRow(datosX);
        }
        tblTotalIngresos.setModel(jcIngresos.getModelo());

        if (tblTotalIngresos.getRowCount() >= 0) {
            ingresos = false;
            btnIngresos.setEnabled(ingresos);
        }

        formIngresos.dispose();
    }//GEN-LAST:event_btnConfirmarIngresosActionPerformed

    private void btnConfirmarTotalBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarTotalBarraActionPerformed

        // sumar y restar las tablas respectivas
        int filasTotalIngresos = tblTotalIngresos.getRowCount();
        int filasVentasTotales = tblVentas.getRowCount();
        int filasProdRotos = tblProductoRotos.getRowCount();
        int filasProdSR = tblProductoSinRecoger.getRowCount();
        int filasStockFinal = tblStockFinal.getRowCount();

        Object datos[] = new Object[4];

        if (filasTotalIngresos >= 0 || filasVentasTotales >= 0) {//si hay elementos en ambas tablas
            for (int i = 0; i < filasTotalIngresos; i++) {//recorre la tabla de requerimientos-traslados
                double cantidad = Double.parseDouble(tblTotalIngresos.getValueAt(i, 3).toString());
                datos[0] = tblTotalIngresos.getValueAt(i, 0).toString();
                datos[1] = tblTotalIngresos.getValueAt(i, 1).toString();
                datos[2] = tblTotalIngresos.getValueAt(i, 2).toString();
                for (int j = 0; j < filasStockFinal; j++) {//recorre la tabla de stock final
                    if (tblTotalIngresos.getValueAt(i, 1).toString().equals(tblStockFinal.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblStockFinal.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasProdSR; j++) {//recorre la tabla productos sin recoger
                    if (tblTotalIngresos.getValueAt(i, 1).toString().equals(tblProductoSinRecoger.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblProductoSinRecoger.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasStockFinal; j++) {//recorre la tabla stock final
                    if (tblTotalIngresos.getValueAt(i, 1).toString().equals(tblStockFinal.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblStockFinal.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasVentasTotales; j++) {//recorre la tabla ventas totales
                    if (tblTotalIngresos.getValueAt(i, 1).toString().equals(tblVentas.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad -= Double.parseDouble(tblVentas.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasProdRotos; j++) {//recorre la tabla productos rotos
                    if (tblTotalIngresos.getValueAt(i, 1).toString().equals(tblProductoRotos.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad -= Double.parseDouble(tblProductoRotos.getValueAt(j, 3).toString());
                    }
                }

                datos[3] = cantidad;

                jcStockFinal.getModelo().addRow(datos);
            }
            //tblStockFinal.setModel(jcStockFinal.getModelo());
        }
//        fusionar las tablas
        Object totalIngresos[] = new Object[filasTotalIngresos];
        Object ventasTotales[] = new Object[filasVentasTotales];
        Object prodRotos[] = new Object[filasProdRotos];
        Object prodSR[] = new Object[filasProdSR];
        Object stockFinal[] = new Object[filasStockFinal];

        List<String> lstTotalIngresos = new ArrayList<>();
        List<String> lstVentasTotales = new ArrayList<>();
        List<String> lstProdRotos = new ArrayList<>();
        List<String> lstProdSR = new ArrayList<>();
        List<String> lstStockFinal = new ArrayList<>();

        //llenando el arreglo totalIngresos[] con la columna nombre
        for (int i = 0; i < filasTotalIngresos; i++) {
            totalIngresos[i] = tblTotalIngresos.getValueAt(i, 1).toString();
        }
        //llenando el arreglo ventasTotales[]
        for (int i = 0; i < filasVentasTotales; i++) {
            ventasTotales[i] = tblVentas.getValueAt(i, 1).toString();
        }
        //llenando el arreglo prodRotos[]
        for (int i = 0; i < filasProdRotos; i++) {
            prodRotos[i] = tblProductoRotos.getValueAt(i, 1).toString();
        }
        //llenando el arreglo prodSR[]
        for (int i = 0; i < filasProdSR; i++) {
            prodSR[i] = tblProductoSinRecoger.getValueAt(i, 1).toString();
        }
        //llenando el arreglo stockFinal[]
        for (int i = 0; i < filasStockFinal; i++) {
            stockFinal[i] = tblStockFinal.getValueAt(i, 1).toString();
        }

        //agrega los elementos del arreglo totalIngresos[] a la lstTotalIngresos
        for (Object x : totalIngresos) {
            lstTotalIngresos.add(x.toString());
        }
        //agrega los elementos del arreglo ventasTotales[] a la lstVentasTotales
        for (Object y : ventasTotales) {
            lstVentasTotales.add(y.toString());
        }
        //agrega los elementos del arreglo prodRotos[] a la lstProdRotos
        for (Object z : prodRotos) {
            lstProdRotos.add(z.toString());
        }

        //agrega los elementos del arreglo prodSR[] a la lstProdSR
        for (Object m : prodSR) {
            lstProdSR.add(m.toString());
        }

        //agrega los elementos del arreglo stockFinal[] a la lstStockFinal
        for (Object o : stockFinal) {
            lstStockFinal.add(o.toString());
        }

        Iterator<String> it = lstVentasTotales.iterator();

        while (it.hasNext()) {
            if (lstTotalIngresos.contains(it.next())) {
                it.remove();
            }
        }

        lstTotalIngresos.addAll(lstVentasTotales); //agrega todos los elementos de lstVentasTotales que no estan en lstTotalIngresos

        Iterator<String> iterador = lstProdRotos.iterator();
        while (iterador.hasNext()) {
            if (lstTotalIngresos.contains(iterador.next())) {
                iterador.remove();
            }
        }

        lstTotalIngresos.addAll(lstProdRotos); //agrega todos los elementos de lstProdRotos que no estan en lstTotalIngresos

        Iterator<String> iterador2 = lstProdSR.iterator();
        while (iterador2.hasNext()) {
            if (lstTotalIngresos.contains(iterador2.next())) {
                iterador2.remove();
            }
        }

        lstTotalIngresos.addAll(lstProdSR);

        Iterator<String> iterador3 = lstStockFinal.iterator();
        while (iterador3.hasNext()) {
            if (lstTotalIngresos.contains(iterador3.next())) {
                iterador3.remove();
            }
        }

        lstTotalIngresos.addAll(lstStockFinal);

        System.out.println(lstTotalIngresos);//funciona bien hasta aqui

        Object total[] = new Object[4];

        System.out.println("lista de ventas totales " + lstVentasTotales);

        for (int j = 0; j < filasVentasTotales; j++) {//recorre la tabla de total ventas
            for (int i = 0; i < lstVentasTotales.size(); i++) {
                if (tblVentas.getValueAt(j, 1).toString().equals(lstVentasTotales.get(i).toString())) {
                    total[0] = tblVentas.getValueAt(i, 0).toString();
                    total[1] = tblVentas.getValueAt(i, 1).toString();
                    total[2] = tblVentas.getValueAt(i, 2).toString();
                    total[3] = tblVentas.getValueAt(i, 3).toString();
                    jcStockFinal.getModelo().addRow(total);
                }
            }
        }

        tblStockFinal.setModel(jcStockFinal.getModelo());

//        for (int i = 0; i < filasCajaGeneral; i++) {
//
//            for (int j = 0; j < lista3.size(); j++) {
//                if (tblCajaGeneral.getValueAt(i, 0).toString().equals(lista3.get(j).toString())) {
//                    total[0] = tblCajaGeneral.getValueAt(i, 0).toString();
//                    total[1] = tblCajaGeneral.getValueAt(i, 1).toString();
//                    total[2] = tblCajaGeneral.getValueAt(i, 2).toString();
//                    total[3] = tblCajaGeneral.getValueAt(i, 3).toString();
//                    jcTotal.getModelo().addRow(total);
//                }
//            }
//
//        }
//
//        for (int i = 0; i < filasCajaGeneral2; i++) {
//
//            for (int j = 0; j < lista4.size(); j++) {
//                if (tblCajaGeneral2.getValueAt(i, 0).toString().equals(lista4.get(j).toString())) {
//                    total[0] = tblCajaGeneral2.getValueAt(i, 0).toString();
//                    total[1] = tblCajaGeneral2.getValueAt(i, 1).toString();
//                    total[2] = tblCajaGeneral2.getValueAt(i, 2).toString();
//                    total[3] = tblCajaGeneral2.getValueAt(i, 3).toString();
//                    jcTotal.getModelo().addRow(total);
//                }
//            }
//
//        }
    }//GEN-LAST:event_btnConfirmarTotalBarraActionPerformed

    private void btnBuscarProductoSinRecogerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoSinRecogerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarProductoSinRecogerActionPerformed

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        formVentasTotales.setVisible(true);
        formVentasTotales.setBounds(100, 220, 862, 655);
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void btnMostrarTotalVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTotalVentasActionPerformed
        try {
            if (jdcFechaAperturaCaja.getDate() != null) {
                String fecha = new FormatoFechas().FormatoFec(jdcFechaAperturaCaja);

                int idflujocajaJaime = new FlujoInventarioDAO().getIdFlujoCaja(1, fecha);//1= idcaja de jaime
                System.out.println("idFlujoCaja jaime: " + idflujocajaJaime);
                int idflujocajaAlejandro = new FlujoInventarioDAO().getIdFlujoCaja(6, fecha);//6 = idcaja de aljeandro (entrada general 02)
                System.out.println("idFlujoCaja alejandro: " + idflujocajaAlejandro);
                int idflujocajaCaja01 = new FlujoInventarioDAO().getIdFlujoCaja(3, fecha);//3= idcaja caja general, SI HAY NOTA DE PEDIDO
                System.out.println("idFlujoCaja general 1: " + idflujocajaCaja01);
                int idflujocajaCaja02 = new FlujoInventarioDAO().getIdFlujoCaja(4, fecha);//4= idcaja caja general2, SI HAY NOTA DE PEDIDO
                System.out.println("idFlujoCaja general 2: " + idflujocajaCaja02);

                cargarDatosTotalesTickets(idflujocajaJaime, idflujocajaAlejandro, idflujocajaCaja01, idflujocajaCaja02);
                sumarTickets(idflujocajaCaja01, idflujocajaCaja02, idflujocajaJaime, idflujocajaAlejandro);
                cargarDatosTotalesNP(idflujocajaCaja01, idflujocajaCaja02);
                sumarNotasDePedido(idflujocajaCaja02);
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "INDIQUE LA FECHA DE APERTURA DE LAS CAJAS");
            }
        } catch (Exception ex) {
            Logger.getLogger(CierreBarman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMostrarTotalVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CierreBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CierreBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CierreBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CierreBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CierreBarman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarProductoSinRecoger;
    private javax.swing.JButton btnConfirmarIngresos;
    private javax.swing.JButton btnConfirmarProductoRotoSinRecoger;
    private javax.swing.JButton btnConfirmarTotal;
    private javax.swing.JButton btnConfirmarTotalBarra;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnMostrarTotalVentas;
    private javax.swing.JButton btnMostrarVentas;
    private javax.swing.JButton btnProdSinRecog;
    private javax.swing.JButton btnProductosRotos;
    private javax.swing.JButton btnPrueba;
    private javax.swing.JButton btnSalidaPorVentas;
    private javax.swing.JButton btnSeleccionarProductoSinRecoger;
    private javax.swing.JButton btnVolver;
    private javax.swing.JDialog formIngresos;
    private javax.swing.JDialog formInventarioInicial;
    private javax.swing.JDialog formProductosSinRecogerRotos;
    private javax.swing.JDialog formSalidaPorVentas;
    private javax.swing.JDialog formVentasTotales;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jdcFechaAperturaCaja;
    private javax.swing.JLabel jlabelf;
    private javax.swing.JLabel jlabelh;
    private javax.swing.JLabel jlabelh1;
    private javax.swing.JLabel jlabelu;
    public javax.swing.JLabel lblAlmacen;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblBuscarProductoSinRecoger;
    private javax.swing.JTable tblCajaGeneral;
    private javax.swing.JTable tblCajaGeneral2;
    private javax.swing.JTable tblEntradaGeneral;
    private javax.swing.JTable tblEntradaGeneral2;
    private javax.swing.JTable tblIngresosRequerimientos;
    private javax.swing.JTable tblIngresosTraslados;
    private javax.swing.JTable tblInventarioInicial;
    private javax.swing.JTable tblProductoRotos;
    private javax.swing.JTable tblProductoSinRecoger;
    private javax.swing.JTable tblProductosSinRecogerRotos;
    private javax.swing.JTable tblStockFinal;
    private javax.swing.JTable tblTotal;
    private javax.swing.JTable tblTotalIngresos;
    private javax.swing.JTable tblTotalNotasPedido;
    private javax.swing.JTable tblTotalVentasTicket;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextField txtBuscarProducto;
    private javax.swing.JTextField txtHora;
    private com.toedter.calendar.JDateChooser xyz;
    // End of variables declaration//GEN-END:variables

    public void LlenarTablaEntradaGeneral(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        try {
            c.conectar();
            jcEntradaGneral.LimpiarTabla();
            String datos[] = new String[4];
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(ve.numCovers)\n"
                    + "    from entradageneral eg\n"
                    + "    inner join ventaentrada ve on eg.identradageneral = ve.venta_idventa\n"
                    + "    inner join productopresentacion pp on ve.idproducto = pp.idproductopresentacion\n"
                    + "    inner join producto p on pp.idproducto = p.idproducto\n"
                    + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "    where eg.idflujocaja = " + idFlujoCaja + " \n"
                    + "    group by pp.idproductopresentacion";

            Statement st = c.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                jcEntradaGneral.getModelo().addRow(datos);
            }
            tblEntradaGeneral.setModel(jcEntradaGneral.getModelo());
            //tbl_productos.setModel(new DefaultTableModel());
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblEntradaGeneral, 10, 100, 100, 10);
    }

    public void LlenarTablaEntradaGeneral2(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        try {
            c.conectar();
            jcEntradaGneral2.LimpiarTabla();
            String datos[] = new String[4];
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(ve.numCovers) \n"
                    + "    from entradageneral2 eg\n"
                    + "    inner join ventaentrada2 ve on eg.identradageneral2 = ve.venta_idventa\n"
                    + "    inner join productopresentacion pp on ve.idproducto = pp.idproductopresentacion\n"
                    + "    inner join producto p on pp.idproducto = p.idproducto\n"
                    + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "    where eg.idflujocaja = " + idFlujoCaja + " \n"
                    + "    group by pp.idproductopresentacion";

            Statement st = c.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                jcEntradaGneral2.getModelo().addRow(datos);
            }
            tblEntradaGeneral2.setModel(jcEntradaGneral2.getModelo());

            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblEntradaGeneral2, 10, 100, 100, 10);
    }

    public void LlenarTablaCajaGeneral(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        try {
            c.conectar();
            jcCajaGeneral.LimpiarTabla();
            String datos[] = new String[4];
            //ventas reales
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(vp.cantidad)\n"
                    + "    from venta v\n"
                    + "    inner join ventaproducto vp on v.idventa = vp.idventa    \n"
                    + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                    + "    inner join producto p on pp.idproducto = p.idproducto\n"
                    + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "    where v.idflujocaja = " + idFlujoCaja + " \n"
                    + "    group by pp.idproductopresentacion\n"
                    + "    order by sum(vp.cantidad) desc";
            //ventas con nota de pedido
            String sqlNP = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(np.cantidad)\n"
                    + "	from npbarra n\n"
                    + "	inner join npbarra_prod np on n.idnpbarra = np.idnpbarra\n"
                    + "	inner join productopresentacion pp on np.idproductopresentacion = pp.idproductopresentacion\n"
                    + "	inner join producto p on pp.idproducto = p.idproducto\n"
                    + "	inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "	where idflujocaja = " + idFlujoCaja + " \n"
                    + "    group by pp.idproductopresentacion";
            Statement st = c.getConexion().createStatement();
            Statement stNP = c.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSet rsNP = stNP.executeQuery(sqlNP);
            while (rs.next()) {
                Double cantidad = 0.0;
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);

                System.out.println("Producto normal: " + rs.getString(2));
                datos[2] = rs.getString(3);
                cantidad = Double.parseDouble(rs.getString(4));
                datos[3] = String.valueOf(cantidad);

                while (rsNP.next()) {
//                    if (rs.getString(2).equals(rsNP.getString(2))) {
//                        System.out.println("Producto: " + rs.getString(2) + " - NP: " + rsNP.getString(2));
//                        cantidad = Double.parseDouble(rs.getString(4)) + Double.parseDouble(rsNP.getString(4));
//                        System.out.println("CAntidad NP: " + cantidad);
//                    }

                    System.out.println("Imprime dentro del blucle Producto normal: " + rs.getString(2));
                    System.out.println("Imprime dentro del blucle Producto nota pedido: " + rsNP.getString(2));
                }
                System.out.println("CAntidad: " + cantidad);
                jcCajaGeneral.getModelo().addRow(datos);
            }
            tblCajaGeneral.setModel(jcCajaGeneral.getModelo());

            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblCajaGeneral, 10, 100, 100, 10);
    }

    public void LlenarTablaCajaGeneral2(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        try {
            c.conectar();
            jcCajaGeneral2.LimpiarTabla();
            String datos[] = new String[4];
            String sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, sum(vp.cantidad)\n"
                    + "    from venta2 v\n"
                    + "    inner join ventaproducto2 vp on v.idventa2 = vp.idventa\n"
                    + "    inner join productopresentacion pp on vp.idproducto = pp.idproductopresentacion\n"
                    + "    inner join producto p on pp.idproducto = p.idproducto\n"
                    + "    inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                    + "    where v.idflujocaja = " + idFlujoCaja + " \n"
                    + "    group by pp.idproductopresentacion\n"
                    + "    order by sum(vp.cantidad) desc";

            Statement st = c.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                jcCajaGeneral2.getModelo().addRow(datos);
            }
            tblCajaGeneral2.setModel(jcCajaGeneral2.getModelo());

            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblCajaGeneral2, 10, 100, 100, 10);
    }

    public void LlenarTablaBuscarProductos(String nomProd) throws Exception {
        Conexion c = new Conexion();
        try {
            c.conectar();
            String datos[] = new String[3];
            String sql = "SELECT productopresentacion.idproducto, producto.nombre, presentacion.descripcion \n"
                    + "FROM producto\n"
                    + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                    + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                    + "where producto.nombre like '%" + nomProd + "%' AND productopresentacion.idalmacen = 2 \n"
                    + "order by idproductopresentacion";

            Statement st = c.getConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                jcBuscarProducto.getModelo().addRow(datos);
            }
            tblBuscarProductoSinRecoger.setModel(jcBuscarProducto.getModelo());
            //tbl_productos.setModel(new DefaultTableModel());
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            c.cerrar();
        }
        tblBuscarProductoSinRecoger.setModel(jcBuscarProducto.getModelo());
        new ColumnasTablas().tresColumnas(tblBuscarProductoSinRecoger, 10, 100, 100);
    }

    //metodo para cargar requerimientos y traslados
    private void cargarRequerimientos(int idAlmacen) throws SQLException {
        Conexion con = new Conexion();
        try {
            con.conectar();
            //se necesita los requerimientos generados con un determinado flujo de inventario
            //validar el flujo de inventario APERTURADO del usuario que esta logeado
            int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idUsuario, almacen.getId());
            Requerimiento req = new RequerimientoDAO().ObtenerPorFlujoInventario(idFlujoInventario);
            System.out.println("IdAlmacen: " + idAlmacen);
            System.out.println("Flujo: " + idFlujoInventario);
            System.out.println("Req: " + req.getIdRequerimiento());
            String sql = "";
            switch (idAlmacen) {
                case 2:
                    sql = "SELECT pp.idproductopresentacion, p.nombre, pre.descripcion,pr.cantidad\n"
                            + "FROM requerimiento r\n"
                            + "INNER JOIN producto_requerimiento pr ON r.idrequerimiento = pr.idrequerimiento\n"
                            + "INNER JOIN productopresentacion pp ON pr.idproductopresentacion = pp.idproductopresentacion\n"
                            + "INNER JOIN producto p ON pp.idproducto = p.idproducto\n"
                            + "INNER JOIN presentacion pre ON pre.idpresentacion = pp.idpresentacion\n"
                            + "WHERE r.idflujoinventario = " + idFlujoInventario;
                    break;
                case 3:
                    break;
            }

            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            Object datos[] = new Object[4];

            while (res.next()) {
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getDouble(4);

                jcRequerimiento.getModelo().addRow(datos);
            }
            tblIngresosRequerimientos.setModel(jcRequerimiento.getModelo());

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        } finally {
            con.cerrar();
        }
    }

    private void cargarTraslados(int idAlmacen) throws SQLException {
        Conexion con = new Conexion();
        try {
            con.conectar();
            //se necesita los requerimientos generados con un determinado flujo de inventario
            //validar el flujo de inventario APERTURADO del usuario que esta logeado
            int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idUsuario, almacen.getId());
            Requerimiento req = new RequerimientoDAO().ObtenerPorFlujoInventario(idFlujoInventario);
            System.out.println("IdAlmacen: " + idAlmacen);
            System.out.println("Flujo: " + idFlujoInventario);
            System.out.println("Req: " + req.getIdRequerimiento());
            String sql = "";
            switch (idAlmacen) {
                case 2:
                    sql = "SELECT pp.idproductopresentacion, p.nombre, pre.descripcion,tpp.origen ,tpp.destino,tpp.cantidad\n"
                            + "FROM traslado t\n"
                            + "INNER JOIN traslado_prod_pres tpp ON t.idtraslado = tpp.idtraslado\n"
                            + "INNER JOIN productopresentacion pp ON tpp.idproductopresentacion = pp.idproductopresentacion\n"
                            + "INNER JOIN producto p ON pp.idproducto = p.idproducto\n"
                            + "INNER JOIN presentacion pre ON pre.idpresentacion = pp.idpresentacion\n"
                            + "WHERE t.idflujoinventario = " + idFlujoInventario;
                    break;
                case 3:
                    break;
            }

            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            ResultSet res = pst.executeQuery();

            Object datos[] = new Object[6];

            while (res.next()) {
                datos[0] = res.getString(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getString(4);
                datos[4] = res.getString(5);
                datos[5] = res.getString(6);

                jcTraslado.getModelo().addRow(datos);
            }
            tblIngresosTraslados.setModel(jcTraslado.getModelo());

            pst.close();
            res.close();

        } catch (Exception e) {
            System.out.println("Error :" + e.getMessage());
            e.printStackTrace();
        } finally {
            con.cerrar();
        }
    }

    //metodo para abrir form de producto rotos o sin recoger
    private void formProductosAdd(int tipoProductos) {
        Object datos[] = new Object[4];

        switch (tipoProductos) {
            case 1:// productos rotos
                jcTotalProductosRotos.LimpiarTabla();
                for (int i = 0; i < tblProductosSinRecogerRotos.getRowCount(); i++) {
                    datos[0] = tblProductosSinRecogerRotos.getValueAt(i, 0).toString();
                    datos[1] = tblProductosSinRecogerRotos.getValueAt(i, 1).toString();
                    datos[2] = tblProductosSinRecogerRotos.getValueAt(i, 2).toString();
                    datos[3] = tblProductosSinRecogerRotos.getValueAt(i, 3).toString();
                    jcTotalProductosRotos.getModelo().addRow(datos);
                }
                tblProductoRotos.setModel(jcTotalProductosRotos.getModelo());
                if (tblProductoRotos.getRowCount() >= 0) {
                    prodRotos = false;
                    btnProductosRotos.setEnabled(prodRotos);
                }
                break;
            case 2:// productos sin recoger
                jcTotalProductoSinRecoger.LimpiarTabla();
                for (int i = 0; i < tblProductosSinRecogerRotos.getRowCount(); i++) {
                    datos[0] = tblProductosSinRecogerRotos.getValueAt(i, 0).toString();
                    datos[1] = tblProductosSinRecogerRotos.getValueAt(i, 1).toString();
                    datos[2] = tblProductosSinRecogerRotos.getValueAt(i, 2).toString();
                    datos[3] = tblProductosSinRecogerRotos.getValueAt(i, 3).toString();
                    jcTotalProductoSinRecoger.getModelo().addRow(datos);
                }
                tblProductoSinRecoger.setModel(jcTotalProductoSinRecoger.getModelo());
                if (tblProductoSinRecoger.getRowCount() >= 0) {
                    prodSinRec = false;
                    btnProdSinRecog.setEnabled(prodSinRec);
                }
                break;
        }

        formProductosSinRecogerRotos.dispose();
    }

    private void cargarInventarioInicial(int idAlmacen) throws SQLException {
        Conexion con = new Conexion();

        try {
            int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idAlmacen);
            con.conectar();
            String sql = "";
            switch (idAlmacen) {
                case 2:
                    sql = "select pp.idproductopresentacion, p.nombre, pre.descripcion, ip.cantidad\n"
                            + "from flujoinventario fi\n"
                            + "inner join inventario2 i on fi.idflujoinventario = i.idflujoinventario\n"
                            + "inner join inventarioproductos2 ip on i.idinventario2 = ip.idinventario2\n"
                            + "inner join productopresentacion pp on ip.idproductopresentacion = pp.idproductopresentacion\n"
                            + "inner join producto p on pp.idproducto = p.idproducto\n"
                            + "inner join presentacion pre on pp.idpresentacion = pre.idpresentacion\n"
                            + "where fi.idflujoinventario = " + idFlujoInventario + " and fi.idalmacen = 2 and i.estado = 0";
                    break;
                case 3:

                    break;
            }

            PreparedStatement pst = con.getConexion().prepareStatement(sql);

            ResultSet res = pst.executeQuery();

            Object datos[] = new Object[4];

            while (res.next()) {
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);
                datos[2] = res.getString(3);
                datos[3] = res.getDouble(4);
                jcStockFinal.getModelo().addRow(datos);
            }

            tblInventarioInicial.setModel(jcStockFinal.getModelo());
            ColumnasTablas ct = new ColumnasTablas();
            int t[] = {40, 200, 150, 50};
            ct.sizeColumns(tblInventarioInicial, 4, t);
            pst.close();
            res.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "ERROR: " + e);
        } finally {
            con.cerrar();
        }
    }

    //metodo para calcular la suma de las tablas de entrada general 1 + entrada general 2
    private void calculos() {
        int filasEntradaGeneral = tblEntradaGeneral.getRowCount();
        int filasEntradaGeneral2 = tblEntradaGeneral2.getRowCount();
        int filasCajaGeneral = tblCajaGeneral.getRowCount();
        int filasCajaGeneral2 = tblCajaGeneral2.getRowCount();

        Object datos[] = new Object[4];

        if (filasEntradaGeneral >= 0 && filasEntradaGeneral >= 0) {//si hay elementos en ambas tablas
            for (int i = 0; i < filasEntradaGeneral; i++) {//recorre la primera tabla
                double cantidad = Double.parseDouble(tblEntradaGeneral.getValueAt(i, 3).toString());
                datos[0] = tblEntradaGeneral.getValueAt(i, 0).toString();
                datos[1] = tblEntradaGeneral.getValueAt(i, 1).toString();
                datos[2] = tblEntradaGeneral.getValueAt(i, 2).toString();
                for (int j = 0; j < filasEntradaGeneral2; j++) {//recorre la segunda tabla
                    if (tblEntradaGeneral.getValueAt(i, 1).toString().equals(tblEntradaGeneral2.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblEntradaGeneral2.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasCajaGeneral; j++) {//recorre la tercera tabla caja general
                    if (tblEntradaGeneral.getValueAt(i, 1).toString().equals(tblCajaGeneral.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblCajaGeneral.getValueAt(j, 3).toString());
                    }
                }

                for (int j = 0; j < filasCajaGeneral2; j++) {//recorre la cuarta tabla caja general 2
                    if (tblEntradaGeneral.getValueAt(i, 1).toString().equals(tblCajaGeneral2.getValueAt(j, 1).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblCajaGeneral2.getValueAt(j, 3).toString());
                    }
                }

                datos[3] = cantidad;

                jcTotal.getModelo().addRow(datos);
            }
            tblTotal.setModel(jcTotal.getModelo());
        } else {
            for (int i = 0; i < filasEntradaGeneral; i++) {
                datos[0] = tblEntradaGeneral.getValueAt(i, 0).toString();
                datos[1] = tblEntradaGeneral.getValueAt(i, 1).toString();
                datos[2] = tblEntradaGeneral.getValueAt(i, 2).toString();
                datos[3] = Double.parseDouble(tblEntradaGeneral.getValueAt(i, 3).toString());
                jcTotal.getModelo().addRow(datos);
            }
            tblTotal.setModel(jcTotal.getModelo());
        }
    }

    private void fusionarTablas() {
        int filasEntradaGeneral = tblEntradaGeneral.getRowCount();
        int filasEntradaGeneral2 = tblEntradaGeneral2.getRowCount();
        int filasCajaGeneral = tblCajaGeneral.getRowCount();
        int filasCajaGeneral2 = tblCajaGeneral2.getRowCount();

        Object datos[] = new Object[filasEntradaGeneral];
        Object datos2[] = new Object[filasEntradaGeneral2];
        Object datos3[] = new Object[filasCajaGeneral];
        Object datos4[] = new Object[filasCajaGeneral2];

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();
        List<String> lista3 = new ArrayList<>();
        List<String> lista4 = new ArrayList<>();

        //llenando el arreglo datos[]
        for (int i = 0; i < filasEntradaGeneral; i++) {
            datos[i] = tblEntradaGeneral.getValueAt(i, 1).toString();
        }
        //llenando el arreglo datos2[]
        for (int i = 0; i < filasEntradaGeneral2; i++) {
            datos2[i] = tblEntradaGeneral2.getValueAt(i, 1).toString();
        }
        //llenando el arreglo datos3[]
        for (int i = 0; i < filasCajaGeneral; i++) {
            datos3[i] = tblCajaGeneral.getValueAt(i, 1).toString();
        }
        //llenando el arreglo datos4[]
        for (int i = 0; i < filasCajaGeneral2; i++) {
            datos4[i] = tblCajaGeneral2.getValueAt(i, 1).toString();
        }

        //agrega los elementos del arreglo datos[] a la lista1
        for (Object x : datos) {
            lista1.add(x.toString());
        }
        //agrega los elementos del arreglo datos2[] a la lista2
        for (Object y : datos2) {
            lista2.add(y.toString());
        }
        //agrega los elementos del arreglo datos3[] a la lista3
        for (Object z : datos3) {
            lista3.add(z.toString());
        }

        //agrega los elementos del arreglo datos3[] a la lista3
        for (Object o : datos4) {
            lista4.add(o.toString());
        }

        Iterator<String> it = lista2.iterator();

        while (it.hasNext()) {
            if (lista1.contains(it.next())) {
                it.remove();
            }
        }

        lista1.addAll(lista2); //agrega todos los elementos de la lista 2 que no estan en la lista1 a la lista1

        Iterator<String> iterador = lista3.iterator();
        while (iterador.hasNext()) {
            if (lista1.contains(iterador.next())) {
                iterador.remove();
            }
        }

        lista1.addAll(lista3); //agrega todos los elementos de la lista 3 que no estan en la lista1 a la lista1

        Iterator<String> iterador2 = lista4.iterator();
        while (iterador2.hasNext()) {
            if (lista1.contains(iterador2.next())) {
                iterador2.remove();
            }
        }

        Object total[] = new Object[4];

        for (int i = 0; i < filasEntradaGeneral2; i++) {

            for (int j = 0; j < lista2.size(); j++) {
                if (tblEntradaGeneral2.getValueAt(i, 1).toString().equals(lista2.get(j).toString())) {
                    total[0] = tblEntradaGeneral2.getValueAt(i, 0).toString();
                    total[1] = tblEntradaGeneral2.getValueAt(i, 1).toString();
                    total[2] = tblEntradaGeneral2.getValueAt(i, 2).toString();
                    total[3] = tblEntradaGeneral2.getValueAt(i, 3).toString();
                    jcTotal.getModelo().addRow(total);
                }
            }
        }

        for (int i = 0; i < filasCajaGeneral; i++) {

            for (int j = 0; j < lista3.size(); j++) {
                if (tblCajaGeneral.getValueAt(i, 1).toString().equals(lista3.get(j).toString())) {
                    total[0] = tblCajaGeneral.getValueAt(i, 0).toString();
                    total[1] = tblCajaGeneral.getValueAt(i, 1).toString();
                    total[2] = tblCajaGeneral.getValueAt(i, 2).toString();
                    total[3] = tblCajaGeneral.getValueAt(i, 3).toString();
                    jcTotal.getModelo().addRow(total);
                }
            }

        }

        for (int i = 0; i < filasCajaGeneral2; i++) {

            for (int j = 0; j < lista4.size(); j++) {
                if (tblCajaGeneral2.getValueAt(i, 1).toString().equals(lista4.get(j).toString())) {
                    total[0] = tblCajaGeneral2.getValueAt(i, 0).toString();
                    total[1] = tblCajaGeneral2.getValueAt(i, 1).toString();
                    total[2] = tblCajaGeneral2.getValueAt(i, 2).toString();
                    total[3] = tblCajaGeneral2.getValueAt(i, 3).toString();
                    jcTotal.getModelo().addRow(total);
                }
            }

        }

        tblTotal.setModel(jcTotal.getModelo());
    }

    private void cargarDatosTotalesNP(int idFlujoCaja01, int idFlujoCaja02) throws Exception {
        NotaPedidoDAO npdao = new NotaPedidoDAO();
        //recuperar los idFlujoCaja de caja 01 y caja 02
        //los id de las cajas son 3 y 4
        //cargar los datos de las notas de pedido de caja 01

        //la tabla debe empezar con los datos de caja 01 y luego comparar con caja 02
        List<NotaPedido> listnp1 = npdao.ListarPorFlujo(idFlujoCaja01, 3);//primera lista -> debe ser caja 01
        Object datosCaja01[] = new Object[4];
        for (NotaPedido notaPedido : listnp1) {
            datosCaja01[0] = notaPedido.getIdProducto();
            datosCaja01[1] = notaPedido.getProducto();
            datosCaja01[2] = notaPedido.getPresentacion();
            datosCaja01[3] = notaPedido.getCantidad();

            jcTotalNotasPedido.getModelo().addRow(datosCaja01);
        }

        //tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
        List<String> l1 = new ArrayList<>();

        for (int i = 0; i < npdao.ListarPorFlujo(idFlujoCaja01, 3).size(); i++) {
            l1.add(npdao.ListarPorFlujo(idFlujoCaja01, 3).get(i).getProducto());
        }
        System.out.println("Lista 1: " + l1);

        List<String> l2 = new ArrayList<>();

        for (int i = 0; i < npdao.ListarPorFlujo(idFlujoCaja02, 4).size(); i++) {
            l2.add(npdao.ListarPorFlujo(idFlujoCaja02, 4).get(i).getProducto());
        }
        System.out.println("Lista 2: " + l2);

        Iterator<String> it = l2.iterator();

        while (it.hasNext()) {
            if (l1.contains(it.next())) {
                it.remove();
            }
        }

        l1.addAll(l2);

        System.out.println("Lista 1 despues: " + l1);
        System.out.println("Lista 2 despues: " + l2);

        List<NotaPedido> listnp2 = npdao.ListarPorFlujo(idFlujoCaja02, 4);//segunda lista -> debe ser caja 02
        Object datos[] = new Object[4];

        for (int i = 0; i < listnp2.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {

                if (listnp2.get(i).getProducto().equals(l2.get(j))) {
                    datos[0] = listnp2.get(i).getIdProducto();
                    datos[1] = listnp2.get(i).getProducto();
                    datos[2] = listnp2.get(i).getPresentacion();
                    datos[3] = listnp2.get(i).getCantidad();
                    System.out.println("if: " + listnp2.get(i).getProducto());
                    //agregar este arreglo a la tabla
                    jcTotalNotasPedido.getModelo().addRow(datos);
                }
            }
        }

        tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
    }

    private void cargarDatosTotalesTickets(int idFlujoEntradaGeneral, int idFlujoEntradaGeneral02, int idFlujoCaja01, int idFlujoCaja02) throws Exception {
        VentaGeneralDAO egdao = new VentaGeneralDAO();
        //recuperar los idFlujoCaja de caja 01 y caja 02
        //los id de las cajas son 3 y 4
        //cargar los datos de las notas de pedido de caja 01

        List<VentaGeneral> listeg1 = egdao.ListarPorFlujo(idFlujoEntradaGeneral, 1);//primera lista -> debe ser entrada general 01
        Object datosEntradaGeneral[] = new Object[4];
        for (VentaGeneral eg : listeg1) {
            datosEntradaGeneral[0] = eg.getCodProducto();
            datosEntradaGeneral[1] = eg.getProducto();
            datosEntradaGeneral[2] = eg.getPresentacion();
            datosEntradaGeneral[3] = eg.getCantidad();
            jcTotalVentasTickets.getModelo().addRow(datosEntradaGeneral);
        }

        //tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
        List<String> l1 = new ArrayList<>();

        //llena la lista 1 con los productos de entrada general 01
        for (int i = 0; i < egdao.ListarPorFlujo(idFlujoEntradaGeneral, 1).size(); i++) {
            l1.add(egdao.ListarPorFlujo(idFlujoEntradaGeneral, 1).get(i).getProducto());
        }
        System.out.println("Lista Entrada general 01: " + l1);

        List<String> l2 = new ArrayList<>();

        //llena la lista 2 con los productos de entrada general 02
        for (int i = 0; i < egdao.ListarPorFlujo(idFlujoEntradaGeneral02, 6).size(); i++) {
            l2.add(egdao.ListarPorFlujo(idFlujoEntradaGeneral02, 6).get(i).getProducto());
        }
        System.out.println("Lista Entrada general 02: " + l2);

        List<String> l3 = new ArrayList<>();

        //llena la lista 3 con los productos de caja general 01
        for (int i = 0; i < egdao.ListarPorFlujo(idFlujoCaja01, 3).size(); i++) {
            l3.add(egdao.ListarPorFlujo(idFlujoCaja01, 3).get(i).getProducto());
        }
        System.out.println("Lista Caja general 01: " + l3);

        List<String> l4 = new ArrayList<>();

        //llena la lista 4 con los productos de caja general 02
        for (int i = 0; i < egdao.ListarPorFlujo(idFlujoCaja02, 4).size(); i++) {
            l4.add(egdao.ListarPorFlujo(idFlujoCaja02, 4).get(i).getProducto());
        }
        System.out.println("Lista Caja general 02: " + l4);

        Iterator<String> it2 = l2.iterator();

        while (it2.hasNext()) {
            if (l1.contains(it2.next())) {
                it2.remove();
            }
        }

        l1.addAll(l2);

        Iterator<String> it3 = l3.iterator();

        while (it3.hasNext()) {
            if (l1.contains(it3.next())) {
                it3.remove();
            }
        }

        l1.addAll(l3);

        Iterator<String> it4 = l4.iterator();

        while (it4.hasNext()) {
            if (l1.contains(it4.next())) {
                it4.remove();
            }
        }

        l1.addAll(l4);

        System.out.println("Lista 1 despues: " + l1);
        //System.out.println("Lista 2 despues: " + l2);

        List<VentaGeneral> listeg2 = egdao.ListarPorFlujo(idFlujoEntradaGeneral02, 6);//segunda lista -> debe ser entrada general 02
        Object datosEntradaGeneral02[] = new Object[4];

        for (int i = 0; i < listeg2.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {

                if (listeg2.get(i).getProducto().equals(l2.get(j))) {
                    datosEntradaGeneral02[0] = listeg2.get(i).getCodProducto();
                    datosEntradaGeneral02[1] = listeg2.get(i).getProducto();
                    datosEntradaGeneral02[2] = listeg2.get(i).getPresentacion();
                    datosEntradaGeneral02[3] = listeg2.get(i).getCantidad();
                    //agregar este arreglo a la tabla
                    jcTotalVentasTickets.getModelo().addRow(datosEntradaGeneral02);
                }
            }
        }

        List<VentaGeneral> listcj01 = egdao.ListarPorFlujo(idFlujoCaja01, 3);//tercera lista -> debe ser caja general 01
        Object datosCajaGeneral01[] = new Object[4];

        for (int i = 0; i < listcj01.size(); i++) {
            for (int j = 0; j < l3.size(); j++) {

                if (listcj01.get(i).getProducto().equals(l3.get(j))) {
                    datosCajaGeneral01[0] = listcj01.get(i).getCodProducto();
                    datosCajaGeneral01[1] = listcj01.get(i).getProducto();
                    datosCajaGeneral01[2] = listcj01.get(i).getPresentacion();
                    datosCajaGeneral01[3] = listcj01.get(i).getCantidad();
                    //agregar este arreglo a la tabla
                    jcTotalVentasTickets.getModelo().addRow(datosCajaGeneral01);
                }
            }
        }

        List<VentaGeneral> listcj02 = egdao.ListarPorFlujo(idFlujoCaja01, 4);//cuarta lista -> debe ser caja general 02
        Object datosCajaGeneral02[] = new Object[4];

        for (int i = 0; i < listcj02.size(); i++) {
            for (int j = 0; j < l4.size(); j++) {

                if (listcj02.get(i).getProducto().equals(l4.get(j))) {
                    datosCajaGeneral02[0] = listcj02.get(i).getCodProducto();
                    datosCajaGeneral02[1] = listcj02.get(i).getProducto();
                    datosCajaGeneral02[2] = listcj02.get(i).getPresentacion();
                    datosCajaGeneral02[3] = listcj02.get(i).getCantidad();
                    //agregar este arreglo a la tabla
                    jcTotalVentasTickets.getModelo().addRow(datosCajaGeneral02);
                }
            }
        }

        tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
    }

    private void sumarNotasDePedido(int idFlujoCaja2) {
        try {
            NotaPedidoDAO npdao = new NotaPedidoDAO();
            //SUMAR LOS CAMPOS DE CANTIDAD

            int numRowsTabla = tblTotalNotasPedido.getRowCount();
            int numFilasnpCaja02 = npdao.ListarPorFlujo(idFlujoCaja2, 4).size();//4=caja general 02

            Object data[] = new Object[4];

            if (numRowsTabla >= 0) {//si hay elementos en ambas tablas
                for (int i = 0; i < numRowsTabla; i++) {//recorre la tabla total que tiene ya todos los productos sin repetir de caja 01 y caja 02
                    double cantidad = Double.parseDouble(tblTotalNotasPedido.getValueAt(i, 3).toString());
                    data[0] = tblTotalNotasPedido.getValueAt(i, 0).toString();//cod Producto
                    data[1] = tblTotalNotasPedido.getValueAt(i, 1).toString();//producto
                    data[2] = tblTotalNotasPedido.getValueAt(i, 2).toString();//presentacion
                    for (int j = 0; j < numFilasnpCaja02; j++) {//recorre la segunda caja
                        if (data[1].equals(npdao.ListarPorFlujo(idFlujoCaja2, 4).get(j).getProducto())) {//si es el mismo producto
                            cantidad += npdao.ListarPorFlujo(idFlujoCaja2, 4).get(i).getCantidad();
                            tblTotalNotasPedido.setValueAt(cantidad, i, 3);
                            System.out.println("cantidad: " + cantidad);
                        }
                    }

                    //data[3] = cantidad;
                    //jcTotalNotasPedido.getModelo().addRow(data);
                }
                tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
            }
//          else {
//                for (int i = 0; i < numRowsTabla; i++) {
//                    data[0] = npdao.ListarPorFlujo(1003, 3).get(i).getIdProducto();
//                    data[1] = npdao.ListarPorFlujo(1003, 3).get(i).getProducto();
//                    data[2] = npdao.ListarPorFlujo(1003, 3).get(i).getPresentacion();
//                    data[3] = npdao.ListarPorFlujo(1003, 3).get(i).getCantidad();
//                    jcTotalNotasPedido.getModelo().addRow(data);
//                }
//                //tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
//            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private void sumarTickets(int idFlujoCaja01, int idFlujoCaja02, int idFlujoEntrada01, int idFlujoEntrada02) {
        try {
            VentaGeneralDAO vgdao = new VentaGeneralDAO();
            //SUMAR LOS CAMPOS DE CANTIDAD

            int numRowsTabla = tblTotalVentasTicket.getRowCount();//la tabla YA fusionada con todas las ventas de barra general
            int numFilasCaja01 = vgdao.ListarPorFlujo(idFlujoCaja01, 3).size();//3=caja general 01
            int numFilasCaja02 = vgdao.ListarPorFlujo(idFlujoCaja02, 4).size();//4=caja general 02
            int numFilasEntrada01 = vgdao.ListarPorFlujo(idFlujoEntrada01, 1).size();//1=entrada general 01
            int numFilasEntrada02 = vgdao.ListarPorFlujo(idFlujoEntrada02, 6).size();//6=entrada general 02
            String producto = null;

            if (numRowsTabla >= 0) {//si hay elementos en la tabla
                for (int i = 0; i < numRowsTabla; i++) {//recorre la tabla total que tiene ya todos los productos sin repetir de caja 01, caja 02, entrada general 01 y entrada general 02
                    //double cantidad = Double.parseDouble(tblTotalVentasTicket.getValueAt(i, 3).toString());
                    double cantidad = 0;                    
                    //data[0] = tblTotalVentasTicket.getValueAt(i, 0).toString();//cod Producto
                    producto = tblTotalVentasTicket.getValueAt(i, 1).toString();//producto
                    System.out.println(producto);
                    //data[2] = tblTotalVentasTicket.getValueAt(i, 2).toString();//presentacion
                    
                    for (int j = 0; j < numFilasCaja01; j++) {//recorre la segunda caja
                        System.out.println("producto: "+ vgdao.ListarPorFlujo(idFlujoCaja01, 3).get(j).getProducto()+" - cantidad: "+vgdao.ListarPorFlujo(idFlujoCaja01, 3).get(j).getCantidad());
                        if (producto.equals(vgdao.ListarPorFlujo(idFlujoCaja01, 3).get(j).getProducto())) {//si es el mismo producto
                            cantidad += vgdao.ListarPorFlujo(idFlujoCaja01, 3).get(i).getCantidad();
                            tblTotalVentasTicket.setValueAt(cantidad, i, 3);
                            //System.out.println("cantidad: " + cantidad);
                        }
                    }

                    for (int j = 0; j < numFilasCaja02; j++) {//recorre la segunda caja
                        if (producto.equals(vgdao.ListarPorFlujo(idFlujoCaja02, 4).get(j).getProducto())) {//si es el mismo producto
                            cantidad += vgdao.ListarPorFlujo(idFlujoCaja02, 4).get(i).getCantidad();
                            tblTotalVentasTicket.setValueAt(cantidad, i, 3);
                            //System.out.println("cantidad: " + cantidad);
                        }
                    }

                    for (int j = 0; j < numFilasEntrada01; j++) {//recorre los datos de entrada general 01
                        if (producto.equals(vgdao.ListarPorFlujo(idFlujoEntrada01, 1).get(j).getProducto())) {//si es el mismo producto
                            cantidad += vgdao.ListarPorFlujo(idFlujoEntrada01, 1).get(i).getCantidad();
                            tblTotalVentasTicket.setValueAt(cantidad, i, 3);
                            //System.out.println("cantidad: " + cantidad);
                        }
                    }

                    for (int j = 0; j < numFilasEntrada02; j++) {//recorre los datos de entrada general 02
                        if (producto.equals(vgdao.ListarPorFlujo(idFlujoEntrada02, 6).get(j).getProducto())) {//si es el mismo producto
                            cantidad += vgdao.ListarPorFlujo(idFlujoEntrada02, 6).get(i).getCantidad();
                            tblTotalVentasTicket.setValueAt(cantidad, i, 3);
                            //System.out.println("cantidad: " + cantidad);
                        }
                    }

                    //data[3] = cantidad;
                    //jcTotalNotasPedido.getModelo().addRow(data);
                }
                tblTotalVentasTicket.setModel(jcTotalVentasTickets.getModelo());
            }
//          else {
//                for (int i = 0; i < numRowsTabla; i++) {
//                    data[0] = npdao.ListarPorFlujo(1003, 3).get(i).getIdProducto();
//                    data[1] = npdao.ListarPorFlujo(1003, 3).get(i).getProducto();
//                    data[2] = npdao.ListarPorFlujo(1003, 3).get(i).getPresentacion();
//                    data[3] = npdao.ListarPorFlujo(1003, 3).get(i).getCantidad();
//                    jcTotalNotasPedido.getModelo().addRow(data);
//                }
//                //tblTotalNotasPedido.setModel(jcTotalNotasPedido.getModelo());
//            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

}
