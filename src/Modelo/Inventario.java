
package Modelo;

/**
 *
 * @author GROVER
 */
public class Inventario {
    private int idinventario;
    private String fecha;
    private String hora;
    private int idusuario;
    private int idflujoinventario;
    private int estado;

    public Inventario(int idinventario, String fecha, String hora, int idusuario, int idflujoinventario, int estado) {
        this.idinventario = idinventario;
        this.fecha = fecha;
        this.hora = hora;
        this.idusuario = idusuario;
        this.idflujoinventario = idflujoinventario;
        this.estado = estado;
    }

    public Inventario() {
    }

    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
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

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdflujoinventario() {
        return idflujoinventario;
    }

    public void setIdflujoinventario(int idflujoinventario) {
        this.idflujoinventario = idflujoinventario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }    
    
}
