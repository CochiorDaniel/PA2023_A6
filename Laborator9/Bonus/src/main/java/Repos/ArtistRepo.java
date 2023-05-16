package Repos;

import Factories.AbstractFactory;
import Factories.JdbcFactory;
import Factories.JpaFactory;
import Entities.ArtistsEntity;
import jakarta.persistence.*;

import java.sql.SQLException;
import java.util.List;

public class ArtistRepo extends AbstractRepo<ArtistsEntity,Integer> {
    EntityManager entityManager;
    public ArtistRepo(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JpaFactory){
            entityManager = ((JpaFactory) abstractFactory).getEntityManager();
        }else {
            throw new IllegalStateException("Not an instance of JpaFactory");
        }
    }

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
