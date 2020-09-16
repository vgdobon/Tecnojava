import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOPostgres implements IDAO {

    Connection conexión = null;
    String url = "jdbc:postgresql://192.168.56.2/tecnojava";
    String usuario = "victor";
    String clave = "620312786";

    public Boolean realizarConexion(){

        try
        {
            Class.forName("org.postgresql.Driver");
            conexión = DriverManager.getConnection(url,usuario,clave);
            return true;
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            System.out.println("Error la Base de Datos");
            ex.printStackTrace();
            return false;
        }
    }

    public Connection getConnection(){
        return conexión;
    }

    public void cerrarConexion(){
        conexión = null;
    }

    public String insertUsuario(Usuario usuario) throws SQLException {
        Statement s = this.conexión.createStatement();
        String sql = "INSERT INTO usuario(nombre,apellidos,departamento,sede)\n" +
                "VALUES('" + usuario.nombre + "','" + usuario.apellidos + "','" + usuario.departamento + "','" + usuario.sede + "');";

        int rowAdd=s.executeUpdate(sql);

        if(rowAdd==1){
            return "Se ha añadido correctamente el registro a la bbdd";
        }else{
            return "No se ha añadido el registro a la bbdd";
        }


    }

    public String deleteUsuario(int id) {
        return " ";
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        Statement statement = conexión.createStatement();
        String sql = "SELECT * FROM usuario;";

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
