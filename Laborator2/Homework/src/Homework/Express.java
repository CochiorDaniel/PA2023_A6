package Homework;

public class Express extends Road{
    public Express(String name, Location location1, Location location2, double length, double maxSpeed){
        super(name, location1, location2, length, maxSpeed);
    }
    @Override
    public String toString() {
        return "Express road " + this.name + " binds " +  this.location1.getName() + " - " +
                this.location2.getName() + " with the length of " + this.length + " km and the speed limit: "
                + this.maxSpeed + " km/h.";
    }
}
