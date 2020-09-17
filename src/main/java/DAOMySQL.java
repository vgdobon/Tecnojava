import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DAOMySQL implements IDAO {

    Connection conexion = null;
    String url = "jdbc:mysql://localhost:3306/tecnojava?serverTimezone=" + TimeZone.getDefault().getID();
    String usuario = "root";
    String clave = "620312786";

    public DAOMySQL() {

        try
        {
            conexion = DriverManager.getConnection(url,usuario,clave);
            Class.forName("org.postgresql.Driver");
            System.out.println("Conexión a la bbdd establecida.");
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            System.out.println("Error la Base de Datos");
            ex.printStackTrace();

        }
    }

//    public Connection getConnection(){
//        return conexion;
//    }
//
//    public void cerrarConexion(){
//        conexion = null;
//    }

    @Override
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

    @Override
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


    @Override
    public String modifyUser(Usuario usuario,String campoModificar,String valorCampoModificar) throws SQLException {
        Statement s = this.conexion.createStatement();
        String sql = "UPDATE usuarios SET " + campoModificar + "= '" + valorCampoModificar + "'" +
                "WHERE id=" + usuario.id + ";";
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

    @Override
    public Usuario loadUser(int id) throws SQLException {

        Statement statement = conexion.createStatement();
        String sql = "SELECT * FROM usuarios WHERE id=" + id +";";
        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        Usuario usuario=new Usuario(resultSet.getInt("id"),resultSet.getString("nombre"),resultSet.getString("apellidos"),resultSet.getString("departamento"),resultSet.getString("sede"));
        statement.close();
        return usuario;
    }
}
