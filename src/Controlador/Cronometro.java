
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Grover
 */
public class Cronometro implements ActionListener{
    JTextField campoHora;
    Timer timer;
    
    public Cronometro(){
    }

    public Cronometro(JTextField campoHora) {
        this.campoHora = campoHora;
    }

    public JTextField getCampoHora() {
        return campoHora;
    }

    public void setCampoHora(JTextField campoHora) {
        this.campoHora = campoHora;
    }
    
    public void iniciarCronometro(JTextField campo){
        Cronometro c = new Cronometro(campo);
        timer = new Timer(1000, c);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        GregorianCalendar tiempo = new GregorianCalendar();
        int hora, minuto, segundo;
        
        hora = tiempo.get(Calendar.HOUR);
        minuto = tiempo.get(Calendar.MINUTE);
        segundo = tiempo.get(Calendar.SECOND);
        
        this.campoHora.setText(""+hora+":"+minuto+":"+segundo);
    }
    
    
}
