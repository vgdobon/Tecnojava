import org.postgresql.core.SqlCommand;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDAO {

    public String insertUser(Usuario usuario) throws SQLException;
    public String deleteUser(int id) throws SQLException;
    public String modifyUser(Usuario usuario,String campoModificar,String valorCampoModificar) throws SQLException;
    public List<Usuario> loadUsers() throws SQLException;
    public Usuario loadUser(int id) throws SQLException;
}



