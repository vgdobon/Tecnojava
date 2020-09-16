public class FactoryDAO {

    public static IDAO createDAO(Constantes.DAOS actualDB){

        switch (actualDB){
            case POSTGRES:
                return new DAOPostgres();
            case MYSQL:
                return new DAOMySQL();
        }

        return null;
    }
}
