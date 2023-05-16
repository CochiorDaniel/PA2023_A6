package DataAcces;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Factories.AbstractFactory;
import Factories.JdbcFactory;

public class BoundsDAO {
    private Connection connection;

    public BoundsDAO(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JdbcFactory){
            connection = ((JdbcFactory) abstractFactory).getConnection();
        }else {
            throw new IllegalStateException("Not an instance of JDBCFactory");
        }
    }
    public void create(int a, int b) throws SQLException {
        Connection con = connection;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into bonds (id_album, id_genre) values (?, ?)")) {
            pstmt.setInt(1, a);
            pstmt.setInt(2, b);
            pstmt.executeUpdate();
        }
    }
}
