package Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "artists", schema = "dbpa")
@NamedQueries({
        @NamedQuery(name = "artists.findAll",
                query = "select e from ArtistsEntity e order by e.name"),
        @NamedQuery(name = "artists.findByName",
                query = "select e from ArtistsEntity e where e.name = :name "),
        @NamedQuery(name = "artists.findById",
                query = "select e from ArtistsEntity e where e.id = :id ")
})
public class ArtistsEntity extends AbstractEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;

    public ArtistsEntity(String name) {
        this.name = name;
    }

    public ArtistsEntity() {}
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

        ArtistsEntity that = (ArtistsEntity) o;

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
