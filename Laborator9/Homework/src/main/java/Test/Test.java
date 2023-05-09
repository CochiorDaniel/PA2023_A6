package Test;

import Entities.ArtistsEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {
    public <Artist> void testJPA() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("compulsory");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        ArtistsEntity artist = new ArtistsEntity("Beatles");
        em.persist(artist);

        ArtistsEntity a = (ArtistsEntity) em.createQuery(
                        "select e from ArtistsEntity e where e.name='Beatles'")
                .getSingleResult();
        a.setName("The Beatles");
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println(a.getName());
    }

}
