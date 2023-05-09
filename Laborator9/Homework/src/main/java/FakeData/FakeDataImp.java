package FakeData;

import Entities.AlbumsEntity;
import Entities.ArtistsEntity;;
import Repos.AbstractRepo;
import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.logging.Logger;

public class FakeDataImp {
    Faker faker = new Faker();
    Logger loggerData = Logger.getLogger(AbstractRepo.class.getName());
    long time = 0;

    public void addFakeData(int nr) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("compulsory");
        EntityManager em = emf.createEntityManager();

        int cnt = 500;

        for(int i=0+cnt; i<nr+cnt; i++) {
            em.getTransaction().begin();

            long startTime = System.nanoTime();
            AlbumsEntity album = new AlbumsEntity();
            ArtistsEntity artist = new ArtistsEntity();

            String name = faker.artist().name();
            int year = faker.number().numberBetween(1850,2023);
            String gen = faker.music().genre();
            String title = faker.book().title();

            artist.setId(i);
            artist.setName(name);

            album.setId(i);
            album.setArtist(name);
            album.setReleaseYear(year);
            album.setGenre(gen);
            album.setTitle(title);

            em.persist(artist);
            em.persist(album);
            em.getTransaction().commit();

            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000;
            time += duration;

        }
        em.close();
        emf.close();

        loggerData.info("Timpul pentru inserare: " + time + " ms!");
    }
}
