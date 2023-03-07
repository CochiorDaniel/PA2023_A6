import Compulsory.Company;
import Compulsory.Node;
import Compulsory.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> list = new ArrayList<>();
        Person p1 = new Person("Eugen");
        Person p2 = new Person("Diana");
        Person p3 = new Person("Razvan");
        Person p4 = new Person("Cosmin");

        Company c1 = new Company("Centric");
        Company c2 = new Company("Microsoft");
        Company c3 = new Company("Samsung");
        Company c4 = new Company("Loto");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);

        for (Node node: list)
            System.out.println(node.getName());


    }
}