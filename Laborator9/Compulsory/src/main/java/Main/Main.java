package Main;

import Database.Database;
import Entities.ArtistsEntity;
import Repos.ArtistRepo;
import Repos.DataRepo;
import Test.Test;

public class Main {
    public static DataRepo<ArtistsEntity,Integer> dataRepo = new ArtistRepo();
    public static void main(String[] args){

        Test test = new Test();
        test.testJPA();

        ArtistsEntity artistsEntity = (ArtistsEntity) dataRepo.findByName("The Beatles").get(0);
        //System.out.println(artistsEntity.getName() + artistsEntity.getId());

    }
}
