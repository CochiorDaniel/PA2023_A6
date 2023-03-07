package Homework;

public class Airport extends Location{
    private int flights;
    public Airport(String name, double x, double y, int f){
        super(name, x, y);
        this.flights = f;
    }
    @Override
    public String toString() {
        return  this.name+ " airport with coordinates x="+ this.x +", y="+ this.y+ " has "
                + this.flights +" more flights today.";
    }
}
