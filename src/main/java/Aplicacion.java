import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {
    MenuHelper menu;
    Scanner sc = new Scanner(System.in);

    public void ejecutar() throws SQLException {

        MenuHelper menuHelper=new MenuHelper();

        switch (mostrarMenu()){
            case 1:
                menuHelper.mostrarUsuarios();
                ;
            case 2:

                menuHelper.añadirUsuario();
                ;
            case 3:

                menuHelper.eliminarUsuario();
                ;
            case 4:
                System.out.println("CERRANDO LA APLICACIÓN");
                ;
        }

    }

    private  int mostrarMenu(){
        System.out.println("Elija una opción:\n " +
                           "1.Listar usuarios\n" +
                           "2.Añadir usuario\n"+
                           "3.Eliminar usuario\n" +
                           "4.Cerrar la aplicación");

        int opcion = sc.nextInt();

        return opcion;
    }


}
