package Vista;

import Controlador.ColumnasTablas;
import Controlador.ManejadorFechas;
import Controlador.RequerimientoBarmanControl;
import Modelo.Almacen;
import Modelo.Medida;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.Conexion;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Grover
 */
public class VistaRequerimientoBarman extends javax.swing.JFrame {

    RequerimientoBarmanControl rb = null;
    DefaultTableModel modeloProductos;

    public VistaRequerimientoBarman(String usuario, String storage) throws Exception {
        initComponents();
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        txtUsuario.setText(usuario);
        txtFecha.setText(new ManejadorFechas().getFechaActual());
        lblAlmacen.setText(storage);
        rb = new RequerimientoBarmanControl(this);
        cargarTitulosRequerimientos();
        cargarComboAlmacen();
    }

    public void cargarTitulosRequerimientos() {
        String cabeceraProductos[] = {"ID", "PRODUCTO", "PRESENTACION", "STOCK"};
        modeloProductos = new DefaultTableModel(null, cabeceraProductos);
        tblRequerimientos.setModel(modeloProductos);
    }

    public void LlenarTablaBuscarProductos(String nomProd) throws Exception {
        Conexion c = new Conexion();
        c.conectar();
        Connection con = c.getConexion();
        limpiarTabla();
        String art = txtProducto.getText();
        String datos[] = new String[4];
        String sql = "SELECT productopresentacion.idproducto, producto.nombre, presentacion.descripcion, productopresentacion.stock\n"
                + "FROM producto\n"
                + "inner join productopresentacion on producto.idproducto = productopresentacion.idproducto\n"
                + "inner join presentacion on productopresentacion.idpresentacion = presentacion.idpresentacion\n"
                + "where (producto.nombre like '" + nomProd + "%' or producto.nombre like '%" + nomProd + "') AND productopresentacion.idalmacen = 1 \n"
                + "order by idproductopresentacion";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                modeloProductos.addRow(datos);
            }
            tblRequerimientos.setModel(modeloProductos);
            //tbl_productos.setModel(new DefaultTableModel());
            st.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(getRootPane(), e.getMessage());
        } finally {
            con.close();
            c.cerrar();
        }
        tblRequerimientos.setModel(modeloProductos);
        new ColumnasTablas().cuatroColumnas(tblRequerimientos, 10, 100, 100, 10);
    }

    private VistaRequerimientoBarman() {

    }

    private void cargarComboAlmacen() throws Exception {
        AlmacenDAO adao = new AlmacenDAO();
        for (Almacen a : adao.listar()) {
            cmbAlmacen.addItem(a);
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < tblRequerimientos.getRowCount(); i++) {
            modeloProductos.removeRow(i);
            i -= 1;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        lblAlmacen = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnListarPedidos = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequerimientos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaObservaciones = new javax.swing.JTextArea();
        txtProducto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAdd = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnQuitarAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbMedida = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbAlmacen = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnRecetas = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("COMPRAS PENDIENTES");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAlmacen.setBackground(new java.awt.Color(204, 204, 255));
        lblAlmacen.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblAlmacen.setForeground(new java.awt.Color(204, 204, 204));
        lblAlmacen.setText("Almacen");
        jPanel6.add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 130, 20));

        jLabel6.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("REQUERIMIENTOS");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jLabel11.setBackground(new java.awt.Color(204, 204, 255));
        jLabel11.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("BARMAN");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 40));

        jLabel12.setBackground(new java.awt.Color(204, 204, 255));
        jLabel12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Almacen");
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, -1, 20));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 80));

        btnListarPedidos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnListarPedidos.setText("LISTA DE PEDIDOS");
        btnListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarPedidosActionPerformed(evt);
            }
        });
        getContentPane().add(btnListarPedidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 680, 180, -1));

        btnGuardar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnGuardar.setText("REGISTRAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 560, 200, -1));

        tblRequerimientos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex,int colIndex){
                return false;
            }
        };
        tblRequerimientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRequerimientos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 450, 290));

        jLabel3.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel3.setText("AREA SOLICITANTE");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("CANTIDAD");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 220, -1));

        txaObservaciones.setColumns(20);
        txaObservaciones.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txaObservaciones.setRows(5);
        txaObservaciones.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txaObservaciones);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 670, 130));

        txtProducto.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        txtProducto.setForeground(new java.awt.Color(0, 102, 255));
        txtProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductoKeyReleased(evt);
            }
        });
        getContentPane().add(txtProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 350, -1));

        tblAdd.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblAdd);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 450, 290));

        btnAdd.setBackground(new java.awt.Color(204, 255, 204));
        btnAdd.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnAdd.setText(">");
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, 220, 40));

        btnQuitarAdd.setBackground(new java.awt.Color(255, 153, 153));
        btnQuitarAdd.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 24)); // NOI18N
        btnQuitarAdd.setText("x");
        getContentPane().add(btnQuitarAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 430, 60, 30));

        jLabel7.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LISTA DE PRODUCTOS A PEDIR");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 100, 450, -1));

        txtCantidad.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 102, 255));
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 220, 40));

        jLabel8.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel8.setText("PRODUCTO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("MEDIDA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 220, -1));

        cmbMedida.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(cmbMedida, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 220, -1));

        jLabel10.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel10.setText("OBSERVACIONES");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        cmbAlmacen.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        getContentPane().add(cmbAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 560, 240, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("USUARIO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 70, -1));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        txtUsuario.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 680, 210, -1));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 680, 210, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("FECHA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 680, 60, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 670, 1190, 10));

        btnRecetas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRecetas.setText("RECETAS");
        btnRecetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecetasActionPerformed(evt);
            }
        });
        getContentPane().add(btnRecetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 680, 180, -1));

        btnVolver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 680, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductoKeyReleased
        try {
            LlenarTablaBuscarProductos(txtProducto.getText().toUpperCase());
        } catch (Exception ex) {
            Logger.getLogger(RequerimientoBarmanControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtProductoKeyReleased

    private void btnRecetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecetasActionPerformed
        Recetas r = new Recetas(txtUsuario.getText(), lblAlmacen.getText());
        r.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRecetasActionPerformed

    private void btnListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarPedidosActionPerformed

        BuscarRequerimientos lr = new BuscarRequerimientos(txtUsuario.getText(), lblAlmacen.getText());
        lr.setVisible(true);
        dispose();

    }//GEN-LAST:event_btnListarPedidosActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            CierreBarman cb = new CierreBarman(txtUsuario.getText(), lblAlmacen.getText());
            cb.setVisible(true);
            dispose();
        } catch (Exception ex) {
            Logger.getLogger(VistaRequerimientoBarman.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRequerimientoBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRequerimientoBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRequerimientoBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRequerimientoBarman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRequerimientoBarman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnListarPedidos;
    public javax.swing.JButton btnQuitarAdd;
    public javax.swing.JButton btnRecetas;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<Almacen> cmbAlmacen;
    public javax.swing.JComboBox<Medida> cmbMedida;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAlmacen;
    public javax.swing.JTable tblAdd;
    public javax.swing.JTable tblRequerimientos;
    public javax.swing.JTextArea txaObservaciones;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtFecha;
    public javax.swing.JTextField txtProducto;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
