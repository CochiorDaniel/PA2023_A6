package Repos;

import Factories.JpaFactory;
import Entities.AbstractEntity;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

public abstract class AbstractRepo<T extends AbstractEntity, ID extends Serializable> {

    public abstract T findById(ID id);
    public abstract List<T> findByName(String name);
    public abstract void create(T entity);
    public boolean persist(T entity, EntityManager entityManager){
        try{
            entityManager.getTransaction();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return true;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            System.err.println(e);
        }
        return false;
    }

}
