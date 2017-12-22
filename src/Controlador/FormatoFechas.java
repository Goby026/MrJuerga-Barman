package Controlador;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoFechas {
    public String FormatoFec(JDateChooser jdc){
        Date f = jdc.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(f);
        return fecha; 
    }
    public String getFormatoFec(JDateChooser jdc){
        Date f = jdc.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = sdf.format(f);
        return fecha;
    }
    public String setFormatoFec(JDateChooser jdc){
        Date f = jdc.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fecha = sdf.format(f);
        return fecha; 
    }
}
