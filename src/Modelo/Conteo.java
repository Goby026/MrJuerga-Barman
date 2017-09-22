
package Modelo;

/**
 *
 * @author MARCEL
 */
public class Conteo {
    private int idConteo;
    private int idusuario;
    private int idAlmacen;
    private String fecha;
    private String hora;

    public Conteo() {
    }

    public Conteo(int idConteo, int idusuario, int idAlmacen, String fecha, String hora) {
        this.idConteo = idConteo;
        this.idusuario = idusuario;
        this.idAlmacen = idAlmacen;
        this.fecha = fecha;
        this.hora = hora;
    }
    
    public int getIdConteo() {
        return idConteo;
    }

    public void setIdConteo(int idConteo) {
        this.idConteo = idConteo;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(int idAlmacen) {
        this.idAlmacen = idAlmacen;
    }
        
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Conteo{" + "idConteo=" + idConteo + ", idusuario=" + idusuario + ", idAlmacen=" + idAlmacen + ", fecha=" + fecha + ", hora=" + hora + '}';
    }
    
}
