package DataAcces;

import DataAcces.Database;
import ObjModel.Artist;
import ObjModel.Entity;

import java.sql.*;

public class ArtistDAO extends DAO {
    private Database database = new Database();
    public void create(Artist artist) throws SQLException {
        Connection con = database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
    }
    @Override
    public Entity findByName(String name) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {

            return rs.next() ? new Artist(rs.getInt(1), name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {

            return rs.next() ? new Artist(id, rs.getString(1)) : null;
        }
    }
}