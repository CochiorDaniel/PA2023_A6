package Factories;

import java.sql.SQLException;

public abstract class AbstractFactory<T> {
    public static AbstractFactory getFactory(String str) throws SQLException {
        if(str.equals("JDBC")){
            return new JdbcFactory();
        }
        if(str.equals("JPA")){
            return new JpaFactory();
        }
        throw new IllegalArgumentException("Argumentul nu este valid!");
    }

    public abstract T getAlbumDAO() throws SQLException;
    public abstract T getArtistDAO() throws SQLException;
    public abstract T getGenreDAO() throws SQLException;

}
