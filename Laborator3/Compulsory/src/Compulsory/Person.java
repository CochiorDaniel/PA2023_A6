package Compulsory;

public class Person implements Comparable<Person>, Node{
    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String getName() {
        return name;
    }
}
