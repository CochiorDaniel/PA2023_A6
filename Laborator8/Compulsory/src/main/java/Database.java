import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/dbpa";
    private static final String USER = "danielcochior";
    private static final String PASSWORD = "parolastrong123";
    private static Connection connection = null;

    private Database() {}

    public static Connection getConnection() {
        createConnection();
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void closeConnection() throws SQLException {
        try{
            connection.close();
            System.out.println("Connection closed.");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}