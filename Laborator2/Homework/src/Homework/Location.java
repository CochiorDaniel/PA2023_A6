package Homework;

public abstract class Location {
    protected String name;
    protected double x,y; // coordonatele orasului

    public Location(){}
    public Location(String name, double x, double y ){
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Location "+this.name +" x="+ this.x +", y="+ this.y+ ".";
    }


    @Override
    public boolean equals(Object obj){
        if (obj == null || !(obj instanceof Location))
            return false;

        if(obj == this)
            return true;

        Location loc = (Location)obj;
        return name.equals(loc.name);
    }


}

