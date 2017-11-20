
package Modelo;

/**
 *
 * @author MARCEL
 */
public class FlujoInventario {
    
    private int idflujoinventario;
    private String fecha_inicio;
    private String hora_inicio;
    private String fecha_final;
    private String hora_final;
    private int idusuario;
    private int idalmacen;
    private int estado;

    public FlujoInventario() {
    }

    public FlujoInventario(int idflujoinventario, String fecha_inicio, String hora_inicio, String fecha_final, String hora_final, int idusuario, int idalmacen, int estado) {
        this.idflujoinventario = idflujoinventario;
        this.fecha_inicio = fecha_inicio;
        this.hora_inicio = hora_inicio;
        this.fecha_final = fecha_final;
        this.hora_final = hora_final;
        this.idusuario = idusuario;
        this.idalmacen = idalmacen;
        this.estado = estado;
    }

    public int getIdflujoinventario() {
        return idflujoinventario;
    }

    public void setIdflujoinventario(int idflujoinventario) {
        this.idflujoinventario = idflujoinventario;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdalmacen() {
        return idalmacen;
    }

    public void setIdalmacen(int idalmacen) {
        this.idalmacen = idalmacen;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
