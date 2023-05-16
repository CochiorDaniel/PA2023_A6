package DataAcces;

import ObjModel.Album;
import ObjModel.Entity;
import Factories.AbstractFactory;
import Factories.JdbcFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlbumDAO extends DAO {
    private Connection connection;

    public AlbumDAO(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JdbcFactory){
            connection = ((JdbcFactory) abstractFactory).getConnection();
        }else {
            throw new IllegalStateException("Not an instance of JDBCFactory");
        }
    }
    public void create(Album album) throws SQLException {
        Connection con = connection;
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
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from albums where title = '" + name + "'")) {

            return rs.next() ? new Album(rs.getInt(1), name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select title from albums where id='" + id + "'")) {

            return rs.next() ? new Album(id ,rs.getString(1)) : null;
        }
    }

    public List<Album> findAll() throws SQLException {
        Connection con = connection;
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from albums")){

        List<Album> albums = new ArrayList<>();
        while(rs.next()){
            albums.add(new Album(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
        }
            return albums;
        }
        }

}
