package ObjModel;

public class Album extends Entity {
    private int id;
    private int release_year;
    private String name;
    private String artist;
    private String genre;
    private static int idCnt = 0;

    public Album(int id, int release_year, String name, String artist, String genre) {
        this.id = id;
        this.release_year = release_year;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    public Album(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Album(int release_year, String name, String artist, String genre) {
        this.release_year = release_year;
        this.name = name;
        this.artist = artist;
        this.genre = genre;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

}

