package Repos;

import Database.Database;
import Entities.GenresEntity;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GenreRepo extends AbstractRepo<GenresEntity, Integer> {

    EntityManager entityManager = Database.getEntityManager();
    @Override
    public GenresEntity findById(Integer integer) {
        return (GenresEntity) entityManager.createNamedQuery("genres.findById").setParameter("id",integer).getResultList().get(0);
    }

    @Override
    public List<GenresEntity> findByName(String name) {
        return entityManager.createNamedQuery("genres.findByName").setParameter("name",name).getResultList();
    }

    @Override
    public void create(GenresEntity entity) {
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
