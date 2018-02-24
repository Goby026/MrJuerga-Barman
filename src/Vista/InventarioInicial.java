package Vista;

import Controlador.ColumnasTablas;
import Controlador.DropXlsx;
import Controlador.JTableControl;
import Controlador.ManejadorFechas;
import Modelo.Almacen;
import Modelo.FlujoInventario;
import Modelo.Inventario;
import Modelo.InventarioProducto;
import Modelo.MySQLDAO.AlmacenDAO;
import Modelo.MySQLDAO.Conexion;
import Modelo.MySQLDAO.FlujoInventarioDAO;
import Modelo.MySQLDAO.InventarioDAO;
import Modelo.MySQLDAO.InventarioProductoDAO;
import Modelo.MySQLDAO.UsuarioDAO;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author GROVER
 */
public class InventarioInicial extends javax.swing.JFrame {

    String usuario;
    ManejadorFechas mf = new ManejadorFechas();
    JTableControl jcTabla = null;
    Almacen a = null;

    public InventarioInicial(String user, String storage) throws Exception {
        initComponents();
        setLocationRelativeTo(null);

        this.usuario = user;
        lblUsuario.setText(usuario);
        lblAlmacen.setText(storage);
        a = new AlmacenDAO().Obtener(lblAlmacen.getText());

        DropXlsx dropXlsx = new DropXlsx();
        dropXlsx.setJtable(tblInventarioInicial);
        titulos();
        lblFecha.setText(mf.getFechaActual());

        cargarTabla(a.getId());
    }

    public InventarioInicial() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventarioInicial = new javax.swing.JTable();
        lblAlmacen = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNroInventario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblInventarioInicial = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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
        jScrollPane1.setViewportView(tblInventarioInicial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 720, 440));

        lblAlmacen.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblAlmacen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlmacen.setText(".........");
        getContentPane().add(lblAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 160, -1));

        lblUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setText("user");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 140, 30));

        lblFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblFecha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFecha.setText("date");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, 140, 30));

        btnVolver.setBackground(new java.awt.Color(102, 102, 102));
        btnVolver.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        getContentPane().add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 650, 190, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 153, 153));
        btnGuardar.setFont(new java.awt.Font("Microsoft Yi Baiti", 0, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setText("APERTURAR INVENTARIO");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 270, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 730, 10));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("INVENTARIO INICIAL - BARMAN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ALMACEN");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 80, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("N° INVENTARIO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 80, -1));

        lblNroInventario.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblNroInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNroInventario.setText(".........");
        getContentPane().add(lblNroInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            Menu vrb = new Menu(usuario, lblAlmacen.getText());
            vrb.setVisible(true);
            dispose();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        System.out.println("ID almacen: " + a.getId());
        aperturarInventario();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void limpiarCampos() {
        tblInventarioInicial.clearSelection();
    }

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
            java.util.logging.Logger.getLogger(InventarioInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblNroInventario;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTable tblInventarioInicial;
    // End of variables declaration//GEN-END:variables

    private void titulos() {
        String titulos[] = {"COD", "PRODUCTO", "PRESENTACION", "CANTIDAD"};
        jcTabla = new JTableControl(titulos, tblInventarioInicial);
        jcTabla.llenarTitulos();
    }

    private void cargarTabla(int idAlmacen) throws SQLException {
        Conexion con = new Conexion();

        try {
            int idFlujoInventario = new FlujoInventarioDAO().getIdFlujo(idAlmacen);
            System.out.println("IdFlujo inventario: "+idFlujoInventario);
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
                jcTabla.getModelo().addRow(datos);
            }

            tblInventarioInicial.setModel(jcTabla.getModelo());
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

    private boolean aperturarInventario() {
        try {
            if (tblInventarioInicial.getRowCount() > 0) {

                int opc = JOptionPane.showConfirmDialog(null, "¿DESEA GUARDAR LA LISTA?", "GUARDAR INVENTARIO " + new ManejadorFechas().getFechaActual(), JOptionPane.YES_NO_OPTION);
                if (opc == 0) { //verdadero
                    Usuario u = new UsuarioDAO().Obtener(lblUsuario.getText());
                    //registrar nuevo flujo de inventario
                    FlujoInventario fi = new FlujoInventario();
                    fi.setFecha_inicio(new ManejadorFechas().getFechaActualMySQL());
                    fi.setHora_inicio(new ManejadorFechas().getHoraActual());
                    fi.setFecha_final(null);
                    fi.setHora_final(null);
                    fi.setIdusuario(u.getId());
                    fi.setIdalmacen(a.getId());
                    fi.setSaldoFavor(0.0);
                    fi.setEstado(1);

                    int c = 0;
                    FlujoInventarioDAO fidao = new FlujoInventarioDAO();

                    if (fidao.Registrar(fi)) {
                        System.out.println("Registró el flujo de inventario");
                        int idFlujoInventario = fidao.getLastIdFlujoInventario(a.getId());

                        Inventario i = new Inventario();
                        i.setFecha(new ManejadorFechas().getFechaActualMySQL());
                        i.setHora(new ManejadorFechas().getHoraActual());
                        i.setIdusuario(u.getId());
                        i.setIdflujoinventario(idFlujoInventario);
                        i.setEstado(1);

                        InventarioDAO idao = new InventarioDAO();
                        InventarioProductoDAO ipdao = new InventarioProductoDAO();

                        if (a.getId() == 1) {
                            if (idao.Registrar(i)) {
                                System.out.println("Registró el inventario de almacen 1");
                                int idInventario = idao.getLastId(a.getId());
                                for (int j = 0; j < tblInventarioInicial.getRowCount(); j++) {
                                    InventarioProducto ip = new InventarioProducto();
                                    ip.setIdinventario(idInventario);
                                    ip.setIdproductopresentacion(Integer.parseInt(tblInventarioInicial.getValueAt(j, 0).toString()));
                                    ip.setCantidad(Double.parseDouble(tblInventarioInicial.getValueAt(j, 3).toString()));
                                    ip.setCantidad_final(0.0);

                                    if (ipdao.Registrar(ip)) {
                                        c++;
                                    }
                                }
                            }
                        } else {
                            if (idao.Registrar(i, a.getId())) {
                                System.out.println("Registró el inventario de almacen " + a.getId());
                                int idInventario = idao.getLastId(a.getId());
                                for (int j = 0; j < tblInventarioInicial.getRowCount(); j++) {
                                    InventarioProducto ip = new InventarioProducto();
                                    ip.setIdinventario(idInventario);
                                    ip.setIdproductopresentacion(Integer.parseInt(tblInventarioInicial.getValueAt(j, 0).toString()));
                                    ip.setCantidad(Double.parseDouble(tblInventarioInicial.getValueAt(j, 3).toString()));
                                    ip.setCantidad_final(0.0);

                                    if (ipdao.Registrar(ip, a.getId())) {
                                        c++;
                                    }
                                }
                            }

                        }

                        if (c > 0) {
                            JOptionPane.showMessageDialog(getRootPane(), "SE REGISTRO EL INVENTARIO CORRECTAMENTE");
                        }
                    } else {
                        System.out.println("Error al registrar el flujo de inventario");
                    }
                } else {//falso
                }
            } else {
                JOptionPane.showMessageDialog(getRootPane(), "NO SE PUEDE APERTURAR UN INVENTARIO VACIO, INFORME A SISTEMAS");
            }

            for (int i = 0; i < tblInventarioInicial.getRowCount(); i++) {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(getRootPane(), "ERROR: " + e.getMessage());
        }
        return false;
    }
}
