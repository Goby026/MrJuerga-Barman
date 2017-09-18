
package Controlador;

import Modelo.Usuario;
import Modelo.MySQLDAO.UsuarioDAO;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginControl {
    public boolean validar(String usuario, String pass) throws Exception{
        try {
            UsuarioDAO udao = new UsuarioDAO();
            
            for (Usuario u : udao.listar()) {
                if (u.getUsuario().equals(usuario)) {
                    if (u.getPass().equals(pass)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return false;
    }
    public int verificarRegistroUsuario(){
        try {            
            UsuarioDAO udao = new UsuarioDAO();
            for (Usuario u : udao.listar()) {
                return u.getId();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
