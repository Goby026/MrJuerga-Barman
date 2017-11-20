
package Controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GROVER
 */
public class JTableControl{

    private String titulos[];
    private DefaultTableModel modelo;
    private JTable tabla;

    public JTableControl(String[] titulos, JTable tabla) {
        this.titulos = titulos;
        this.modelo = new DefaultTableModel();
        this.tabla = tabla;
    }
    
    public void llenarTitulos(){
        this.modelo = new DefaultTableModel(null, this.titulos);
        this.tabla.setModel(this.modelo);
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }
    
    public void LimpiarTabla() {
        for (int i = 0; i < this.tabla.getRowCount(); i++) {
            this.modelo.removeRow(i);
            i -= 1;
        }
    }

}
