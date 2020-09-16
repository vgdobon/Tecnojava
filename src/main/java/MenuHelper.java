import java.sql.SQLException;
import java.util.Scanner;

public class MenuHelper {

    IDAO dao=FactoryDAO.createDAO(Constantes.actualDDBB);
    public Scanner sc = new Scanner(System.in);

    public void mostrarUsuarios() throws SQLException {
        for (Usuario usuario:dao.loadUsers()) {
            System.out.println(usuario.toString());
        }
        //dao.cerrarConexion();
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
        System.out.println(dao.insertUser(usuario));
        //dao.cerrarConexion();
    }

    public void eliminarUsuario() throws SQLException {

        mostrarUsuarios();
        System.out.println("Indica el id del usuario que quiere eliminar");
        int idEliminar = sc.nextInt();
        System.out.println( dao.deleteUser(idEliminar));

    }

}
