package Entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres", schema = "dbpa")
@NamedQueries({
        @NamedQuery(name = "genres.findAll",
                query = "select e from GenresEntity e order by e.name"),
        @NamedQuery(name = "genres.findByName",
                query = "select e from GenresEntity e where e.name = :name "),
        @NamedQuery(name = "genres.findById",
                query = "select e from GenresEntity e where e.id = :id ")
})
public class GenresEntity extends AbstractEntity implements Serializable {
    @ManyToMany
    List<ArtistsEntity> artistsEntities = new ArrayList<>();
    @ManyToMany
    List<AlbumsEntity> albumsEntities = new ArrayList<>();
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    public GenresEntity(String name) {
        this.name = name;
    }

    public GenresEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenresEntity that = (GenresEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
