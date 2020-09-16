import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDAO {


    public String insertUsuario(Usuario usuario) throws SQLException;
    public String deleteUsuario(int id);
    public List<Usuario> listarUsuarios() throws SQLException;
    public void cerrarConexion();
    }


