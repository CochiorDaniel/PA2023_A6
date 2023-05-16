package Factories;

import DataAcces.AlbumDAO;
import DataAcces.ArtistDAO;
import DataAcces.DAO;
import DataAcces.GenreDAO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcFactory extends AbstractFactory<DAO> {
    private static final String URL = "jdbc:mysql://localhost:3306/dbpa";
    private static final String USER = "danielcochior";
    private static final String PASSWORD = "parolastrong123";
    private static HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource hikariDataSource;

    public JdbcFactory() throws SQLException {
        hikariConfig.setUsername(USER);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setMaximumPoolSize(3000);
        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
    public void closeConnection() throws SQLException {
        hikariDataSource.getConnection().close();
    }
    public void rollback() throws SQLException {
        hikariDataSource.getConnection().rollback();
    }
    @Override
    public DAO getAlbumDAO() throws SQLException {
        return new AlbumDAO(this);
    }

    @Override
    public DAO getArtistDAO() throws SQLException {
        return new ArtistDAO(this);
    }

    @Override
    public DAO getGenreDAO() throws SQLException {
        return new GenreDAO(this);
    }
}
