package Homework;

public abstract class Road{
    protected String name;
    protected double length, maxSpeed;
    protected Location location1, location2;
    public Road(String name, Location location1, Location location2, double length, double maxSpeed){
        this.name = name;
        this.location1 = location1;
        this.location2 = location2;
        this.length = length;
        this.maxSpeed = maxSpeed;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public double getLength(){
        return  length;
    }
    public void setLength(double length) {
        if(length>Math.sqrt(Math.pow((location2.getX()-location1.getX()),2)
                +Math.pow((location2.getY()-location1.getY()),2)))
            this.length = length;
    }
    public boolean verifyLength(){
        if(this.length > Math.sqrt(Math.pow((location2.getX()-location1.getX()),2)
                +Math.pow((location2.getY()-location1.getY()),2)))
            return true;
        else {
            System.out.println("Road " + this.name + " not have a valid length!");
            return false;
        }
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
        return this.name + " binds " +  this.location1.getName() + " - " + this.location2.getName() +
                " : " + this.length + " km, speed limit: " + this.maxSpeed + " km/h.";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Road))
            return false;

        if(obj == this)
            return true;

        Road road = (Road)obj;
        return name.equals(road.name);
    }

}

