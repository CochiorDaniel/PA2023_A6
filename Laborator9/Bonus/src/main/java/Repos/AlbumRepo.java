package Repos;

import Factories.AbstractFactory;
import Factories.JdbcFactory;
import Factories.JpaFactory;
import Entities.AlbumsEntity;
import jakarta.persistence.EntityManager;

import java.sql.SQLException;
import java.util.List;


public class AlbumRepo extends AbstractRepo<AlbumsEntity, Integer> {
    EntityManager entityManager;
    public AlbumRepo(AbstractFactory abstractFactory) throws SQLException {
        if(abstractFactory instanceof JpaFactory){
            entityManager = ((JpaFactory) abstractFactory).getEntityManager();
        }else {
            throw new IllegalStateException("Not an instance of JpaFactory");
        }
    }

    @Override
    public AlbumsEntity findById(Integer integer) {
        return (AlbumsEntity) entityManager.createNamedQuery("albums.findById").setParameter("id",integer).getResultList().get(0);
    }
    @Override
    public List<AlbumsEntity> findByName(String name) {
        return entityManager.createNamedQuery("albums.findByName").setParameter("name",name).getResultList();
    }
    @Override
    public void create(AlbumsEntity entity) {
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
    public List<AlbumsEntity> findAll(){
        return entityManager.createNamedQuery("albums.findAll").getResultList();
    }
}
