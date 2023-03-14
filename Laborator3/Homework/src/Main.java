import Homework.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Person p1 = new Programer("Eugen", "12.12.1990", "C++");
        Person p2 = new Person("Diana", "19.12.2000");
        Person p3 = new Designer("Razvan", "30.01.1999","albastru");
        Person p4 = new Programer("Cosmin", "12.03.2001", "Java");

        p1.addRelationship(p4, "colegi");
        p1.addRelationship(p2, "prietena");
        p2.addRelationship(p4, "colegi");
        p3.addRelationship(p1, "colegi");
        p4.addRelationship(p2, "colegi");
        p4.addRelationship(p2, "prietena");


        Company c1 = new Company("Centric");
        Company c2 = new Company("Microsoft");
        Company c3 = new Company("Samsung");
        Company c4 = new Company("Loto");

        p1.addRelationship(c1, "angajat");
        p4.addRelationship(c1 , "boss");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        Network n1 = new Network(list);
        n1.printSorted();

    }
}