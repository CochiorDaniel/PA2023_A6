import DataAcces.*;
import ObjModel.Album;
import ObjModel.Artist;
import ObjModel.Entity;
import ObjModel.Genre;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static DAO albums = new AlbumDAO();
    public static DAO artists = new ArtistDAO();
    public static DAO genres = new GenreDAO();
    public static BoundsDAO bounds = new BoundsDAO();

    public static void main(String[] args) throws SQLException, IOException {

        CSVFormat format = CSVFormat.DEFAULT;
        CSVParser csvParser = new CSVParser(new FileReader("C:\\Users\\Daniel\\Desktop\\Programare Avansata\\Laborator8\\Homework\\src\\main\\resources\\albumlist.csv"), format);
        int cnt = 0;
        for (CSVRecord record : csvParser) {
            System.out.println(record.get(0) + " || " + record.get(1) + " || " + record.get(2) + " || "
                    + record.get(3) + " || " + record.get(4) + " || " + record.get(5));

            if (cnt > 40) {
                if (((ArtistDAO) artists).findByName(record.get(3)) == null) {
                    System.out.println("Inserez in artists " + record.get(3));
                    ((ArtistDAO) artists).create(new Artist(record.get(3)));
                }
                if (((AlbumDAO) albums).findByName(record.get(2)) == null) {
                    System.out.println("Inserez in albums " + record.get(2));
                    ((AlbumDAO) albums).create(new Album(Integer.parseInt(record.get(1)), record.get(2), record.get(3), record.get(4)));
                }

                String[] genuri = new String[10];
                genuri = record.get(4).split(",");
                for (int i = 0; i < genuri.length; i++) {

                    if (genuri[i].charAt(0) == ' ')
                        genuri[i] = genuri[i].substring(1);

                    if (((GenreDAO) genres).findByName(genuri[i]) == null) {
                        System.out.println("Inserez in genres " + record.get(4));
                        ((GenreDAO) genres).create(new Genre(genuri[i]));
                    }


                    Entity album = ((AlbumDAO) albums).findByName(record.get(2));
                    Entity genre = ((GenreDAO) genres).findByName(genuri[i]);
                    bounds.create(album.getId(), genre.getId());

                }
            }
            cnt++;
        }
        csvParser.close();


    }
}
