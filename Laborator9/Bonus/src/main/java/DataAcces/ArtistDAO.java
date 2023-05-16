package DataAcces;

import ObjModel.Artist;
import ObjModel.Entity;
import Factories.AbstractFactory;
import Factories.JdbcFactory;

import java.sql.*;

public class ArtistDAO extends DAO {
    private Connection connection;

    public ArtistDAO(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JdbcFactory){
            connection = ((JdbcFactory) abstractFactory).getConnection();
        }else {
            throw new IllegalStateException("Not an instance of JDBCFactory");
        }
    }
    public void create(Artist artist) throws SQLException {
        Connection con = connection;
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (name) values (?)")) {
            pstmt.setString(1, artist.getName());
            pstmt.executeUpdate();
        }
    }
    @Override
    public Entity findByName(String name) throws SQLException {
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {

            return rs.next() ? new Artist(rs.getInt(1), name) : null;
        }
    }
    @Override
    public Entity findById(int id) throws SQLException {
        Connection con = connection;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from artists where id='" + id + "'")) {

            return rs.next() ? new Artist(id, rs.getString(1)) : null;
        }
    }
}