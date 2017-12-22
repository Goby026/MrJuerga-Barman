
package Controlador;

import javax.swing.JTable;

public class ColumnasTablas {
    
    public void dosColumnas(JTable tabla, int col1, int col2){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);
    }
    
    public void tresColumnas(JTable tabla, int col1, int col2, int col3){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);
    }
    
    public void cuatroColumnas(JTable tabla, int col1, int col2, int col3, int col4){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);
    }
    
    public void cincoColumnas(JTable tabla, int col1, int col2, int col3, int col4, int col5){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);
    }
    
    public void seisColumnas(JTable tabla, int col1, int col2, int col3, int col4, int col5, int col6){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(col6);
    }
    
    public void sieteColumnas(JTable tabla, int col1, int col2,int col3, int col4, int col5, int col6, int col7){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);        
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);        
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);        
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);        
        tabla.getColumnModel().getColumn(5).setPreferredWidth(col6);        
        tabla.getColumnModel().getColumn(6).setPreferredWidth(col7);        
    }
    
    public void ochoColumnas(JTable tabla, int col1, int col2, int col3, int col4, int col5, int col6, int col7, int col8){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);        
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);        
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);        
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);        
        tabla.getColumnModel().getColumn(5).setPreferredWidth(col6);        
        tabla.getColumnModel().getColumn(6).setPreferredWidth(col7);        
        tabla.getColumnModel().getColumn(7).setPreferredWidth(col8);        
    }
    
    public void nueveColumnas(JTable tabla, int col1, int col2, int col3, int col4, int col5, int col6, int col7, int col8, int col9){

        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);        
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);        
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);        
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);        
        tabla.getColumnModel().getColumn(5).setPreferredWidth(col6);        
        tabla.getColumnModel().getColumn(6).setPreferredWidth(col7);        
        tabla.getColumnModel().getColumn(7).setPreferredWidth(col8);        
        tabla.getColumnModel().getColumn(8).setPreferredWidth(col9);        
    }
    
    public void sizeColumns(JTable tabla,int nroColumnas, int columnas[]){        
        for (int i = 0; i < nroColumnas; i++) {
            tabla.getColumnModel().getColumn(i).setPreferredWidth(columnas[i]);
        }
    }
    
    public void diezColumnas(JTable tabla, int col1, int col2, int col3, int col4, int col5, int col6, int col7, int col8, int col9, int col10){
        tabla.getColumnModel().getColumn(0).setPreferredWidth(col1);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(col2);        
        tabla.getColumnModel().getColumn(2).setPreferredWidth(col3);        
        tabla.getColumnModel().getColumn(3).setPreferredWidth(col4);        
        tabla.getColumnModel().getColumn(4).setPreferredWidth(col5);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(col6);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(col7);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(col8);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(col9);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(col10);
    }
    
    public int getPageSize(JTable tabla) {
        int filas = tabla.getRowCount();
        System.out.println("cantidad de filas: " + filas);
        int rowCount = 2;//FILAS DE GRACIA
        int fontSize = 7;//TAMAÑO DE LETRA DEL DETAIL
        int rowSize = fontSize + 2;//TAMAÑO DE LA FILA
        int caracteresPorLinea = 16;// CANTIDAD DE CARACTERES PARA QUE PASE A LA SIGTE LINEA
        for (int i = 0; i < filas; i++) {
            String descripcionDeProducto = tabla.getValueAt(i, 1).toString();
            rowCount += (1 + (int) (descripcionDeProducto.length() / caracteresPorLinea));
        }
        int cabecera = 156;
        int piePagina = 217;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finale:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }
}
