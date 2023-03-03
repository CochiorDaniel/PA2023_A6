package Compulsory;

public class Location {
    private String name;
    private LocationType type;
    private double x,y; // coordonatele orasului

    public Location(){}
    public Location(String name, LocationType locationType, double x, double y ){
        this.name = name;
        this.type = locationType;
        this.x = x;
        this.y = y;
    }
    public LocationType getType() {
        return type;
    }
    public void setType(LocationType locationType){this.type = locationType; }
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
        return this.name +" "+ this.type +" x="+ this.x +", y="+ this.y+ ".";
    }



}

