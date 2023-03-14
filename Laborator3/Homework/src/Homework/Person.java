package Homework;

import java.util.HashMap;
import java.util.Map;

public class Person implements Comparable<Person>, Node{
    protected String name;
    protected String birthDate;
    protected Map<Node, String> relationships = new HashMap<>();

    public Person(String name, String birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Persoana " + this.name + " nascut la data de  " + this.birthDate;
    }
}
