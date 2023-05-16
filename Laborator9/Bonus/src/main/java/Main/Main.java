package Main;

import DataAcces.AlbumDAO;
import Entities.AlbumsEntity;
import Factories.AbstractFactory;
import ObjModel.Entity;
import Repos.AlbumRepo;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.variables.IntVar;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        AbstractFactory jpaFactory = AbstractFactory.getFactory("JPA");
        AbstractFactory jdbcFactory = AbstractFactory.getFactory("JDBC");

        AlbumDAO albumDAO = (AlbumDAO) jdbcFactory.getAlbumDAO();
        AlbumRepo albumDAO1 = (AlbumRepo) jpaFactory.getAlbumDAO();

        AlbumsEntity albumsEntity = albumDAO1.findById(1);
        System.out.println(albumsEntity.getTitle());
        Entity album = albumDAO.findById(1);
        System.out.println(album.getName());
        System.out.println("==================================");

        Set<AlbumsEntity> albumsEntitiesSet = new HashSet<>();
        AlbumRepo albumRepo = (AlbumRepo) jpaFactory.getAlbumDAO();
        albumsEntitiesSet.addAll(albumRepo.findAll());

        List<AlbumsEntity> albumsEntityList = new ArrayList<>(albumsEntitiesSet);

        int p = 10, k=15;
        char c = 'C';

        Model model = new Model("AlbumSolver");
        IntVar []x = new IntVar[albumsEntityList.size()];
        for(int i=0; i<albumsEntityList.size(); i++){
            x[i]= model.intVar(0);
        }

        int i=0, j=0;
        for(AlbumsEntity a: albumsEntityList){
            for(AlbumsEntity b: albumsEntityList){
                int dif =Math.abs(a.getReleaseYear() - b.getReleaseYear());
                if(a.getTitle().charAt(0) == c && b.getTitle().charAt(0) == c){
                    if(dif <= p){
                        x[i] = model.intVar(1);
                        x[j] = model.intVar(1);
                    }
                }else{
                    model.arithm(x[i], "+", x[j], "<=", 1).post();
                }
                j++;
            }
            j=0;
            i++;
        }

        model.sum(x, ">=", k).post();

        while (model.getSolver().solve()) {
            for (int z = 0; z < x.length; z++) {
                if (x[z].getValue() == 1) {
                    System.out.println("Albumul " + z + " a fost selectat.");
                }
            }
            System.out.println();
        }
    }

}
