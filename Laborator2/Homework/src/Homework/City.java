package Homework;

public class City extends Location{
    private int population;

    public City(String name, double x, double y, int p){
        super(name, x, y);
        this.population = p;
    }
    @Override
    public String toString() {
        return  this.name+ " city with coordinates x="+ this.x +", y="+ this.y+ " has a population of "
                + this.population +" people.";
    }

}
