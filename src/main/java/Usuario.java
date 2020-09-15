public class Usuario {
    int id;
    String nombre;
    String apellidos;
    String departamento;
    String sede;


    public Usuario(String nombre, String apellidos, String departamento, String sede) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.sede = sede;
    }

    public Usuario(int id, String nombre, String apellidos, String departamento, String sede) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", departamento='" + departamento + '\'' +
                ", sede='" + sede + '\'' +
                '}';
    }
}
