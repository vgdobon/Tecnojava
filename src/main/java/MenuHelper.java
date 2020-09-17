import sun.util.locale.LocaleUtils;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuHelper {

    IDAO dao=FactoryDAO.createDAO(Constantes.actualDDBB);
    public Scanner sc = new Scanner(System.in);

    public void mostrarUsuario() throws SQLException {
        for (Usuario usuario:dao.loadUsers()) {
            System.out.println(usuario.toString());
        }
        //dao.cerrarConexion();
    }

    public void mostrarUsuario(int id) throws SQLException {

            System.out.println(dao.loadUser(id).toString());

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

        mostrarUsuario();
        System.out.println("Indica el id del usuario que quiere eliminar");
        int idUsuarioEliminar = sc.nextInt();
        System.out.println( dao.deleteUser(idUsuarioEliminar));

    }

    public void modificarUsuario() throws SQLException {
        mostrarUsuario();
        System.out.println("Indica el id del registro que quieres modificar");

        int idUsuarioModificar= sc.nextInt();
        mostrarUsuario(idUsuarioModificar);
        Usuario usuario = dao.loadUser(idUsuarioModificar);

        System.out.println("Elija una opcion:\n" +
                           "1.Modificar un campo\n" +
                           "2.Modificar todos");
        int nCamposModificar = sc.nextInt();

        do {
            switch (nCamposModificar){
                case 1:
                    System.out.println("Que campo quieres modificar");
                    String campoUsuarioModificar = sc.next();
                    System.out.println("Introduce el nuevo valor del campo que quieres modificar");
                    String valorCampoModificado = sc.next();
                    dao.modifyUser(usuario,campoUsuarioModificar,valorCampoModificado);
                    break;
                case 2:
                    dao.deleteUser(idUsuarioModificar);
                    añadirUsuario();
                    break;
                default:
                    System.out.println("No has elegido una opción correcta.Pulse 1 o 2.");
            }
        }while(!Comunes.isNumeric(Integer.toString(nCamposModificar)) ||
                nCamposModificar>2 || nCamposModificar<1);






    }
}
