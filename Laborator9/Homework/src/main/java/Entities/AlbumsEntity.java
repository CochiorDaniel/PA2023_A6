package Entities;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "albums", schema = "dbpa")
@NamedQueries({
        @NamedQuery(name = "albums.findAll",
                query = "select e from AlbumsEntity e order by e.title"),
        @NamedQuery(name = "albums.findByName",
                query = "select e from AlbumsEntity e where e.title = :name "),
        @NamedQuery(name = "albums.findById",
                query = "select e from AlbumsEntity e where e.id = :id ")
})
public class AlbumsEntity extends AbstractEntity implements Serializable {
    @OneToMany
    List<ArtistsEntity> artistsEntityList = new ArrayList<>();
    @ManyToMany
    List<GenresEntity> genresEntities = new ArrayList<>();
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "release_year", nullable = true)
    private Integer releaseYear;
    @Basic
    @Column(name = "title", nullable = true, length = 100)
    private String title;
    @Basic
    @Column(name = "artist", nullable = true)
    private String artist;
    @Basic
    @Column(name = "genre", nullable = true)
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumsEntity that = (AlbumsEntity) o;

        if (id != that.id) return false;
        if (releaseYear != null ? !releaseYear.equals(that.releaseYear) : that.releaseYear != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (artist != null ? !artist.equals(that.artist) : that.artist != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (releaseYear != null ? releaseYear.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (artist != null ? artist.hashCode() : 0);
        return result;
    }
}
