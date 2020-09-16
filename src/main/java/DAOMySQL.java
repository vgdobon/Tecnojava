import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DAOMySQL implements IDAO {

    Connection conexión = null;
    String url = "jdbc:mysql://localhost:3306/tecnojava?serverTimezone=" + TimeZone.getDefault().getID();
    String usuario = "root";
    String clave = "620312786";

    public DAOMySQL() {

        try
        {
            conexión = DriverManager.getConnection(url,usuario,clave);

        }
        catch(SQLException ex)
        {
            System.out.println("Error la Base de Datos");
            ex.printStackTrace();

        }
    }

    public Connection getConnection(){
        return conexión;
    }

    public void cerrarConexion(){
        conexión = null;
    }

    @Override
    public String insertUser(Usuario usuario) throws SQLException {
        Statement s = this.conexión.createStatement();
        String sql = "INSERT INTO usuarios(nombre,apellidos,departamento,sede)\n" +
                "VALUES('" + usuario.nombre + "','" + usuario.apellidos + "','" + usuario.departamento + "','" + usuario.sede + "');";

        int rowAdd=s.executeUpdate(sql);

        if(rowAdd==1){
            return "Se ha añadido correctamente el registro a la bbdd";
        }else{
            return "No se ha añadido el registro a la bbdd";
        }


    }

    @Override
    public String deleteUser(int id) throws SQLException {
        Statement s = this.conexión.createStatement();
        String sql = "DELETE FROM usuarios WHERE id=" + id + ";";
        int rowModified = s.executeUpdate(sql);

        if(rowModified==1){

            return "Se ha eliminado correctamente el registro a la bbdd";

        }else{

            return "No se ha eliminado el registro de la bbdd";

        }
    }

    @Override
    public List<Usuario> loadUsers() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();

        Statement statement = conexión.createStatement();
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
