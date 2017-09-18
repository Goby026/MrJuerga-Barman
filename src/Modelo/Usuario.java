package Modelo;

public class Usuario {

    int id;
    String nombre;
    String apellido;
    String dni;
    String ruc;
    String telefono;
    String direccion;
    String imagen;
    String usuario;
    String pass;
    double sueldo;
    int planilla;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String dni, String ruc, String telefono, String direccion, String imagen, String usuario, String pass, double sueldo, int planilla) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.ruc = ruc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.imagen = imagen;
        this.usuario = usuario;
        this.pass = pass;
        this.sueldo = sueldo;
        this.planilla = planilla;
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public int getPlanilla() {
        return planilla;
    }

    public void setPlanilla(int planilla) {
        this.planilla = planilla;
    }
    
    

}
