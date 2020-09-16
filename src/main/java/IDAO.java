import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IDAO {

    public String insertUser(Usuario usuario) throws SQLException;
    public String deleteUser(int id) throws SQLException;
    public List<Usuario> loadUsers() throws SQLException;

    }



