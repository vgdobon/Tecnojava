import java.sql.SQLException;
import java.util.Scanner;

public class MenuHelper {

    DAOPostgres dao;
    public Scanner sc = new Scanner(System.in);

    public void mostrarUsuarios() throws SQLException {
        dao=new DAOPostgres();
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
        dao=new DAOPostgres();
        dao.realizarConexion();
        System.out.println(dao.insertUsuario(usuario));
        dao.conexión.close();
        //dao.cerrarConexion();
    }

    public void eliminarUsuario(){



    }

}
