package Factories;

import Repos.AbstractRepo;
import Repos.AlbumRepo;
import Repos.ArtistRepo;
import Repos.GenreRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.SQLException;

public class JpaFactory extends AbstractFactory<AbstractRepo>{
    private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compulsory");
    private static EntityManager entityManager = entityManagerFactory.createEntityManager();
    public EntityManager getEntityManager(){
        return entityManager;
    }
    public EntityTransaction getTransaction(){
        return entityManager.getTransaction();
    }
    public void closeManager(){
        entityManager.close();
    }
    public void closeFactory(){
        entityManagerFactory.close();
    }

    @Override
    public AbstractRepo getAlbumDAO() throws SQLException {
        return new AlbumRepo(this);
    }

    @Override
    public AbstractRepo getArtistDAO() throws SQLException {
        return new ArtistRepo(this);
    }

    @Override
    public AbstractRepo getGenreDAO() throws SQLException {
        return new GenreRepo(this);
    }
}
