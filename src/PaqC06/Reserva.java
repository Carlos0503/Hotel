package PaqC06;

public class Reserva {
    String dni;
    String nombre;
    String apellidos;
    String telefono;
    String tarjeta;
    String fechaent;
    String fechasal;
    String regali;

    public Reserva(String dni, String nombre, String apellidos,String telefono, String tarjeta, String fechaent, String fechasal, String regali) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.tarjeta = tarjeta;
        this.fechaent = fechaent;
        this.fechasal = fechasal;
        this.regali = regali;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String  dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getFechaent() {
        return fechaent;
    }

    public void setFechaent(String fechaent) {
        this.fechaent = fechaent;
    }

    public String getFechasal() {
        return fechasal;
    }

    public void setFechasal(String fechasal) {
        this.fechasal = fechasal;
    }

    public String getRegali() {
        return regali;
    }

    public void setRegali(String regali) {
        this.regali = regali;
    }

    @Override
    public String toString() {
        return "Cliente" + '\n'+
                "dni: " + dni + '\n' +
                ", nombre: " + nombre + '\n' +
                ", apellidos: " + apellidos + '\n' +
                ", telefono: " + telefono + '\n' +
                ", tarjeta: " + tarjeta + '\n' +
                ", fechaent: " + fechaent + '\n' +
                ", fechasal: " + fechasal + '\n' +
                ", regali:" + regali + '\n';
    }
}
