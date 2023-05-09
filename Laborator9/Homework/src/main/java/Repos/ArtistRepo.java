package Repos;

import Database.Database;
import Entities.AlbumsEntity;
import Entities.ArtistsEntity;
import Entities.GenresEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepo extends AbstractRepo<ArtistsEntity,Integer> {
    EntityManager entityManager = Database.getEntityManager();

    @Override
    public ArtistsEntity findById(Integer integer) {

        return (ArtistsEntity) entityManager.createNamedQuery("artists.findById").setParameter("id",integer).getResultList().get(0);
    }

    @Override
    public List<ArtistsEntity> findByName(String name) {

        return entityManager.createNamedQuery("artists.findByName").setParameter("name",name).getResultList();
    }
    @Override
    public void create(ArtistsEntity entity){

        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.err.println(e);
        }
        entityManager.close();
    }
}
