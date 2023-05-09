package DataAcces;

import DataAcces.Database;
import ObjModel.Entity;
import ObjModel.Genre;

import java.sql.*;

public class GenreDAO extends DAO{
    private Database database = new Database();
    public void create(Genre genre) throws SQLException {
        Connection con = database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into genres (name) values (?)")) {
            pstmt.setString(1, genre.getName());
            pstmt.executeUpdate();
        }
    }
    @Override
    public Entity findByName(String name) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from genres where name='" + name + "'")) {

            return rs.next() ? new Genre(rs.getInt(1),name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from genres where id='" + id + "'")) {

            return rs.next() ? new Genre(id, rs.getString(1)) : null;

        }
    }
}
