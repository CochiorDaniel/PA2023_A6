package Compulsory;

public class Road{
    private RoadType type;
    private double length, maxSpeed;
    private Location location1, location2;
    public Road(){}
    public Road(Location location1, Location location2, RoadType roadType, double length, double maxSpeed){
        this.location1 = location1;
        this.location2 = location2;
        this.length = length;
        this.type = roadType;
        this.maxSpeed = maxSpeed;
    }

    public RoadType getType(){
        return type;
    }
    public void setType(RoadType type) {
        this.type = type;
    }
    public double getLength(){
        return  length;
    }
    public void setLength(double length) {
        if(length>Math.sqrt(Math.pow((location2.getX()-location1.getX()),2)
                +Math.pow((location2.getY()-location1.getY()),2)))
            this.length = length;
        else
            System.out.println("Lungimea drumului este insuficienta astfel incat sa uneasca cele doua locatii!");
    }
    public double getMaxSpeed() {
        return maxSpeed;
    }
    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    public Location getLocation1(){
        return location1;
    }
    public void setLocation1(Location location1) {
        this.location1 = location1;
    }
    public Location getLocation2(){
        return location2;
    }
    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    @Override
    public String toString() {
        return this.location1.getName() + " - " + this.location2.getName() +
                " : " + this.length + " km, " + this.type + ", speed limit: " + this.maxSpeed + " km";
    }

}

