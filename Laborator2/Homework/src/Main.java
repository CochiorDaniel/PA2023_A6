import Homework.*;
/**
 * @author Cochior Daniel
 */
public class Main {
    public static void main(String[] args) {

        Location location1 = new City("Bacau" ,100.23, 150.11, 20_000);
        Location location2 = new City("Constanta",300.11, 50.09, 31_234);
        Location location3 = new GasStation("Mol", 412.4, 612.89, 3.21);
        Location location4 = new Airport("Otopeni", 123.43, 801.34, 3);
        Location location5 = new City("Iasi", 123.4, 849.3, 30_000);
        Location location6 = new Airport("Coanda", 13.4, 83.5, 5);

        Road road1  = new Highway("DN3", location1, location2, 430, 130);
        Road road2 = new Country("DBN", location1, location3, 919.7, 60);
        Road road3 = new Express("E85", location1, location5, 710.3, 100);
        Road road4 = new Express("E120", location4, location5, 408.3, 90);
        Road road5 = new Highway("Soarelui", location2, location5, 931, 130);

//        System.out.println(location1);
//        System.out.println(location2);
//        System.out.println(location3);
//        System.out.println(location4);
//        System.out.println(road1);
//        System.out.println(road2);
//        System.out.println(road3);

        Problem problem1 = new Problem();

        problem1.addRoads(road1);
        problem1.addRoads(road2);
        problem1.addRoads(road3);
        problem1.addRoads(road4);
        problem1.addRoads(road5);
        problem1.addLocations(location6);


        //System.out.println(problem1.verifyInstance());
        problem1.printEdges();
        System.out.println(problem1.isRoad(location2,location3));
        System.out.println(problem1.isRoad(location2,location1));
        System.out.println(problem1.isRoad(location6,location3));
        System.out.println(problem1.isRoad(location2,location4));



    }
}