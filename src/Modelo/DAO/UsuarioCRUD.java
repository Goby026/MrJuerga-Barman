
package Modelo.DAO;

import Modelo.Usuario;
import java.util.List;


public interface UsuarioCRUD {
    public boolean registrar(Usuario u) throws Exception;

    public boolean modificar(Usuario u) throws Exception;

    public boolean eliminar(Usuario u) throws Exception;

    public List<Usuario> listar() throws Exception;
}
