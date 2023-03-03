import Compulsory.*;

public class Main {
    public static void main(String[] args) {

        Location loc1 = new Location("Jilava" , LocationType.prison, 100, 150);
        Location loc2 = new Location("Constanta", LocationType.city, 300, 50);
        Road road1 = new Road(loc1, loc2, RoadType.express, 230, 90);
        road1.setMaxSpeed(90);
        System.out.println(loc2);
        System.out.println(road1);
        Location c1 = new Location();
        c1.setName("Iași");
        c1.setX(0);
        c1.setY(0);
        c1.setType(LocationType.city);
        System.out.println(c1);
        Road road2 = new Road();
        road2.setLocation1(loc2);
        road2.setLocation2(c1);
        road2.setType(RoadType.highways);
        road2.setLength(339.12);
        road2.setMaxSpeed(130.0);
        System.out.println(road2);








    }
}