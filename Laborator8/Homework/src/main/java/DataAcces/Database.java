package DataAcces;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/dbpa2";
    private static final String USER = "danielcochior";
    private static final String PASSWORD = "parolastrong123";
    private static HikariConfig hikariConfig = new HikariConfig();
    private static HikariDataSource hikariDataSource;

    public Database() {
        hikariConfig.setUsername(USER);
        hikariConfig.setPassword(PASSWORD);
        hikariConfig.setJdbcUrl(URL);
        hikariConfig.setMaximumPoolSize(3000);
        hikariDataSource = new HikariDataSource(hikariConfig);
    }

    public static Connection getConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
    public static void closeConnection() throws SQLException {
        hikariDataSource.getConnection().close();
    }
    public static void rollback() throws SQLException {
        hikariDataSource.getConnection().rollback();
    }

}