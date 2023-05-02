package DataAcces;

import DataAcces.Database;
import ObjModel.Album;
import ObjModel.Entity;

import java.sql.*;

public class AlbumDAO extends DAO {
    private Database database = new Database();
    public void create(Album album) throws SQLException {
        Connection con = database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO albums (release_year, title, artist, genre) VALUES (?, ?, ?, ?)")){
            pstmt.setInt(1, album.getRelease_year());
            pstmt.setString(2, album.getName());
            pstmt.setString(3, album.getArtist());
            pstmt.setString(4, album.getGenre());
            pstmt.executeUpdate();
        }
    }
    @Override
    public Entity findByName(String name) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title = '" + name + "'")) {

            return rs.next() ? new Album(rs.getInt(1), name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id='" + id + "'")) {

            return rs.next() ? new Album(id ,rs.getString(1)) : null;
        }
    }
}
