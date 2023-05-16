package DataAcces;

import ObjModel.Entity;
import ObjModel.Genre;
import Factories.AbstractFactory;
import Factories.JdbcFactory;

import java.sql.*;

public class GenreDAO extends DAO{
    private Connection connection;

    public GenreDAO(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JdbcFactory){
            connection = ((JdbcFactory) abstractFactory).getConnection();
        }else {
            throw new IllegalStateException("Not an instance of JDBCFactory");
        }
    }
    public void create(Genre genre) throws SQLException {
        Connection con = connection;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
    }
    @Override
    public Entity findByName(String name) throws SQLException {
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {

            return rs.next() ? new Genre(rs.getInt(1),name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {

            return rs.next() ? new Genre(id, rs.getString(1)) : null;

        }
    }
}
