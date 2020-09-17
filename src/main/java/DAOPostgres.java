import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOPostgres implements IDAO {

    Connection conexion = null;
    String url = "jdbc:postgresql://192.168.56.2/tecnojava";
    String usuario = "victor";
    String clave = "620312786";

    public DAOPostgres(){

        try
        {
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url,usuario,clave);
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            System.out.println("Error la Base de Datos");
            ex.printStackTrace();

        }
    }



    public String insertUser(Usuario usuario) throws SQLException {
        Statement s = this.conexion.createStatement();
        String sql = "INSERT INTO usuarios(nombre,apellidos,departamento,sede)\n" +
                "VALUES('" + usuario.nombre + "','" + usuario.apellidos + "','" + usuario.departamento + "','" + usuario.sede + "');";

        int rowAdd=s.executeUpdate(sql);

        if(rowAdd==1){
            return "Se ha añadido correctamente el registro a la bbdd";
        }else{
            return "No se ha añadido el registro a la bbdd";
        }


    }

    public String deleteUser(int id) throws SQLException {
        Statement s = this.conexion.createStatement();
        String sql = "DELETE FROM usuarios WHERE id=" + id + ";";
        int rowModified = s.executeUpdate(sql);

        if(rowModified==1){
            return "Se ha eliminado correctamente el registro a la bbdd";
        }else{
            return "No se ha eliminado el registro de la bbdd";
        }
    }

    public List<Usuario> loadUsers() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        Statement statement = conexion.createStatement();
        String sql = "SELECT * FROM usuarios;";

        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            int id= resultSet.getInt("id");
            String nombre =resultSet.getString("nombre");
            String apellidos = resultSet.getString("apellidos");
            String departamento =resultSet.getString("departamento");
            String sede = resultSet.getString("sede");
            Usuario usuario = new Usuario(id,nombre,apellidos,departamento,sede);
            usuarios.add(usuario);
        }
        statement.close();
        return usuarios;
    }

}
