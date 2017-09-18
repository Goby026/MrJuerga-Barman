
package Modelo.DAO;

import Modelo.ProductoPresentacion;
import java.util.List;

/**
 *
 * @author Marce
 */
public interface ProductoPresentacionCRUD {
    public boolean registrar(ProductoPresentacion pp) throws Exception;

    public boolean modificar(ProductoPresentacion pp) throws Exception;

    public boolean eliminar(ProductoPresentacion pp) throws Exception;

    public List<ProductoPresentacion> listar() throws Exception;
}
