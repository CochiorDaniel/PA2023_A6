package Entities;

import jakarta.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "bonds", schema = "dbpa")
public class BondsEntity extends AbstractEntity implements Serializable {
    @Basic
    @Column(name = "id_album", nullable = false)
    private int idAlbum;
    @Basic
    @Column(name = "id_genre", nullable = false)
    private int idGenre;

    @Id
    private Integer id;

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BondsEntity that = (BondsEntity) o;

        if (idAlbum != that.idAlbum) return false;
        if (idGenre != that.idGenre) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAlbum;
        result = 31 * result + idGenre;
        return result;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
