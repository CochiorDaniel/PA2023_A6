package ObjModel;

import java.sql.Timestamp;
import java.util.List;

public class Playlists {
    private String name;
    private Timestamp time;
    private List<Album> listOfAlbums;

    public Playlists(String name, Timestamp time, List<Album> listOfAlbums) {
        this.name = name;
        this.time = time;
        this.listOfAlbums = listOfAlbums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public List<Album> getListOfAlbums() {
        return listOfAlbums;
    }

    public void setListOfAlbums(List<Album> listOfAlbums) {
        this.listOfAlbums = listOfAlbums;
    }
}

