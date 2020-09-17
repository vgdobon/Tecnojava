import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {
    MenuHelper menu;
    Scanner sc = new Scanner(System.in);

    public void ejecutar() throws SQLException {

        MenuHelper menuHelper=new MenuHelper();

        int opcionMenu=0;
        while(opcionMenu!=5){

            opcionMenu=mostrarMenu();
            switch (opcionMenu){
                case 1:

                    menuHelper.mostrarUsuario();
                    break;
                case 2:

                    menuHelper.añadirUsuario();
                    break;
                case 3:

                    menuHelper.eliminarUsuario();
                    break;
                case 4:

                   menuHelper.modificarUsuario();
                   break;
                case 5:

                    System.out.println("CERRANDO LA APLICACIÓN");
                    break;
            }
        }

    }



    private  int mostrarMenu(){
        System.out.println("Elija una opción:\n" +
                           "1.Listar usuarios\n" +
                           "2.Añadir usuario\n"+
                           "3.Eliminar usuario\n" +
                           "4.Modificar usuario\n" +
                           "5.Cerrar la aplicación");

        int opcion = sc.nextInt();
        return opcion;
    }


}
