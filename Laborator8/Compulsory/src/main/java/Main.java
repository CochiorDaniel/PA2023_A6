import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String args[]) throws SQLException {
        try {
            var artists = new ArtistDAO();
            artists.create("Pink Floyd");
            artists.create("Michael Jackson");
            System.out.println(artists.findByName("Pink Floyd"));
            System.out.println(artists.findByName("Michael Jackson"));
//            var genres = new GenreDAO();
//            genres.create("Rock"); //TODO: Funk, Soul, Pop
            Database.getConnection().commit();
//            var albums = new AlbumDAO();
//            albums.create(1979, "The Wall", "Pink Floyd", "Rock");
//            //findByName
//            albums.create(1982, "Thriller", "Michael Jackson","Funk,Soul,Pop"
//            Database.getConnection().commit();
//            //TODO: print all the albums in the database
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
//            Database.rollback();
        }
    }
}
