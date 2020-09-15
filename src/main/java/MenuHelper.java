import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    DAO dao;
    public Scanner sc = new Scanner(System.in);

    public void mostrarUsuarios() throws SQLException {
        dao=new DAO();
        dao.realizarConexion();
        for (Usuario usuario:dao.listarUsuarios()
             ) {
            System.out.println(usuario.toString());
        }
        dao.cerrarConexion();
    }

    public void añadirUsuario() throws SQLException {
        System.out.println("Nombre");
        String nombre = sc.next();

        System.out.println("Apellidos");
        String apellidos = sc.next();

        System.out.println("Departamento");
        String departamento = sc.next();

        System.out.println("Sede");
        String sede = sc.next();

        Usuario usuario=new Usuario(nombre,apellidos,departamento,sede);
        dao=new DAO();
        dao.insertUsuario(usuario);
    }

    public void eliminarUsuario(){

    }

}
