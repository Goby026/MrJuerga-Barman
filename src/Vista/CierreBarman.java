/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ColumnasTablas;
import Controlador.Cronometro;
import Controlador.JTableControl;
import Controlador.ManejadorFechas;
import Modelo.MySQLDAO.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author GROVER
 */
public class CierreBarman extends javax.swing.JFrame {

    JTableControl jcEntradaGneral;
    JTableControl jcEntradaGneral2;
    JTableControl jcTotal;

    public CierreBarman(String usuario, String storage) throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        lblUsuario.setText(usuario);
        lblAlmacen.setText(storage);
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        new Cronometro().iniciarCronometro(txtHora);

        String titulos[] = {"COD", "PRODUCTO", "PRESENTACION", "CANTIDAD"};

        jcEntradaGneral = new JTableControl(titulos, tblEntradaGeneral);
        jcEntradaGneral2 = new JTableControl(titulos, tblEntradaGeneral2);
        jcTotal = new JTableControl(titulos, tblTotal);

        jcEntradaGneral.llenarTitulos();
        jcEntradaGneral2.llenarTitulos();
        jcTotal.llenarTitulos();

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
        cbEntradaGeneral2 = new javax.swing.JCheckBox();
        cbEntradaGeneral = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntradaGeneral = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTotal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cbCaja = new javax.swing.JCheckBox();
        formInventarioInicial = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        btnTraslado = new javax.swing.JButton();
        btnRequerimiento = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        jlabelu = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jlabelf = new javax.swing.JLabel();
        jlabelh = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        jlabelh1 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        btnSalidaPorVentas = new javax.swing.JButton();
        btnInventarioInicial = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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

        formSalidaPorVentas.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 370, 240));

        cbEntradaGeneral2.setText("ENTRADA GENERAL 2");
        cbEntradaGeneral2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntradaGeneral2ActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(cbEntradaGeneral2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        cbEntradaGeneral.setText("ENTRADA GENERAL");
        cbEntradaGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbEntradaGeneralActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(cbEntradaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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

        formSalidaPorVentas.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 370, 240));

        tblTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        formSalidaPorVentas.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 800, 280));

        jLabel1.setText("TOTALES");
        formSalidaPorVentas.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, -1));

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 310, -1, -1));

        jTable1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        formSalidaPorVentas.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 40, 370, 250));

        cbCaja.setText("CAJAS");
        cbCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCajaActionPerformed(evt);
            }
        });
        formSalidaPorVentas.getContentPane().add(cbCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        formInventarioInicial.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("TOTAL JARRAS ROTAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 510, -1, -1));

        btnTraslado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnTraslado.setText("TRASLADOS");
        getContentPane().add(btnTraslado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 160, 60));

        btnRequerimiento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRequerimiento.setText("REQUERIMIENTOS");
        getContentPane().add(btnRequerimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 60));

        jTextField1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 180, 30));

        jTextField2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 530, 180, 30));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setText("_____");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 8, 200, -1));

        jlabelu.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelu.setForeground(new java.awt.Color(255, 255, 255));
        jlabelu.setText("usuario:");
        jPanel1.add(jlabelu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(255, 255, 255));
        lblFecha.setText("____");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 8, 150, -1));

        jlabelf.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelf.setForeground(new java.awt.Color(255, 255, 255));
        jlabelf.setText("fecha:");
        jPanel1.add(jlabelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 8, -1, -1));

        jlabelh.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelh.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh.setText("hora:");
        jPanel1.add(jlabelh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 8, -1, -1));

        lblAlmacen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        lblAlmacen.setText("____");
        jPanel1.add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 8, 180, -1));

        jlabelh1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jlabelh1.setForeground(new java.awt.Color(255, 255, 255));
        jlabelh1.setText("almacen:");
        jPanel1.add(jlabelh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 8, -1, -1));

        txtHora.setEditable(false);
        txtHora.setBackground(new java.awt.Color(102, 102, 102));
        txtHora.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtHora.setForeground(new java.awt.Color(255, 255, 255));
        txtHora.setBorder(null);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 8, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 1160, 30));

        btnSalidaPorVentas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSalidaPorVentas.setText("SALIDAS POR VENTAS");
        btnSalidaPorVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalidaPorVentasActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalidaPorVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 170, 60));

        btnInventarioInicial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnInventarioInicial.setText("INVENTARIO INICIAL");
        btnInventarioInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioInicialActionPerformed(evt);
            }
        });
        getContentPane().add(btnInventarioInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("TOTAL JARRAS DESPACHADAS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalidaPorVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalidaPorVentasActionPerformed
        formSalidaPorVentas.setVisible(true);
        formSalidaPorVentas.setBounds(300, 200, 1281, 722);
    }//GEN-LAST:event_btnSalidaPorVentasActionPerformed

    private void cbEntradaGeneral2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntradaGeneral2ActionPerformed
        try {
            if (cbEntradaGeneral2.isSelected()) {
                LlenarTablaEntradaGeneral2(681);
                //calculos();
            } else {
                jcEntradaGneral2.LimpiarTabla();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }//GEN-LAST:event_cbEntradaGeneral2ActionPerformed

    private void cbEntradaGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbEntradaGeneralActionPerformed
        try {
            if (cbEntradaGeneral.isSelected()) {
                LlenarTablaEntradaGeneral(693);
                //calculos();
            } else {
                jcEntradaGneral.LimpiarTabla();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_cbEntradaGeneralActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        calculos();
        fusionarTablas();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCajaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCajaActionPerformed

    private void btnInventarioInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioInicialActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "¿Desea aperturar el inventario de"+lblAlmacen.getText()+" ?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            System.out.println("SI");
            //registrar inventario
            
        }else{
            System.out.println("NO");
        }
    }//GEN-LAST:event_btnInventarioInicialActionPerformed

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
    private javax.swing.JButton btnInventarioInicial;
    private javax.swing.JButton btnRequerimiento;
    private javax.swing.JButton btnSalidaPorVentas;
    private javax.swing.JButton btnTraslado;
    private javax.swing.JCheckBox cbCaja;
    private javax.swing.JCheckBox cbEntradaGeneral;
    private javax.swing.JCheckBox cbEntradaGeneral2;
    private javax.swing.JDialog formInventarioInicial;
    private javax.swing.JDialog formSalidaPorVentas;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlabelf;
    private javax.swing.JLabel jlabelh;
    private javax.swing.JLabel jlabelh1;
    private javax.swing.JLabel jlabelu;
    public javax.swing.JLabel lblAlmacen;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblEntradaGeneral;
    private javax.swing.JTable tblEntradaGeneral2;
    private javax.swing.JTable tblTotal;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables

    public void LlenarTablaEntradaGeneral(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
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
        try {
            Statement st = con.createStatement();
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
            con.close();
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblEntradaGeneral, 10, 100, 100, 10);
    }

    public void LlenarTablaEntradaGeneral2(int idFlujoCaja) throws Exception {
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
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
        try {
            Statement st = con.createStatement();
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
            con.close();
            c.cerrar();
        }
        new ColumnasTablas().cuatroColumnas(tblEntradaGeneral2, 10, 100, 100, 10);
    }

    //metodo para calcular la suma de las tablas de entrada general 1 + entrada general 2
    private void calculos() {
        int filasEntradaGeneral = tblEntradaGeneral.getRowCount();
        int filasEntradaGeneral2 = tblEntradaGeneral2.getRowCount();

        Object datos[] = new Object[4];

        if (filasEntradaGeneral >= 0 && filasEntradaGeneral >= 0) {//si hay elementos en ambas tablas
            for (int i = 0; i < filasEntradaGeneral; i++) {//recorre la primera tabla
                double cantidad = Double.parseDouble(tblEntradaGeneral.getValueAt(i, 3).toString());
                datos[0] = tblEntradaGeneral.getValueAt(i, 0).toString();
                datos[1] = tblEntradaGeneral.getValueAt(i, 1).toString();
                datos[2] = tblEntradaGeneral.getValueAt(i, 2).toString();
                for (int j = 0; j < filasEntradaGeneral2; j++) {//recorre la segunda tabla
                    if (Integer.parseInt(tblEntradaGeneral.getValueAt(i, 0).toString()) == Integer.parseInt(tblEntradaGeneral2.getValueAt(j, 0).toString())) {//si es el mismo producto
                        cantidad += Double.parseDouble(tblEntradaGeneral2.getValueAt(j, 3).toString());
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
        Object datos[] = new Object[filasEntradaGeneral];
        Object datos2[] = new Object[filasEntradaGeneral2];

        List<Integer> lista1 = new ArrayList<>();
        List<Integer> lista2 = new ArrayList<>();

        for (int i = 0; i < filasEntradaGeneral; i++) {
            datos[i] = Integer.parseInt(tblEntradaGeneral.getValueAt(i, 0).toString());
        }

        for (Object x : datos) {
            lista1.add(Integer.parseInt(x.toString()));
        }

        for (int i = 0; i < filasEntradaGeneral2; i++) {
            datos2[i] = Integer.parseInt(tblEntradaGeneral2.getValueAt(i, 0).toString());
        }

        for (Object y : datos2) {
            lista2.add(Integer.parseInt(y.toString()));
        }

        Iterator<Integer> it = lista2.iterator();

        while (it.hasNext()) {
            if (lista1.contains(it.next())) {
                it.remove();
            }
        }

        System.out.println(lista2);//la lista2 queda con los productos que no estan en la lista1

        Object total[] = new Object[4];

        for (int i = 0; i < filasEntradaGeneral2; i++) {

            for (int j = 0; j < lista2.size(); j++) {
                if (tblEntradaGeneral2.getValueAt(i, 0).toString().equals(lista2.get(j).toString())) {
                    total[0] = tblEntradaGeneral2.getValueAt(i, 0).toString();
                    total[1] = tblEntradaGeneral2.getValueAt(i, 1).toString();
                    total[2] = tblEntradaGeneral2.getValueAt(i, 2).toString();
                    total[3] = tblEntradaGeneral2.getValueAt(i, 3).toString();
                    jcTotal.getModelo().addRow(total);
                }
            }

        }

        tblTotal.setModel(jcTotal.getModelo());
    }

}