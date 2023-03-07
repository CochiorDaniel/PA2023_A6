package Homework;

public class GasStation extends Location{
    private double gasPrice;

    public GasStation(String name, double x, double y, double gasPrice){
        super(name, x, y);
        this.gasPrice = gasPrice;
    }

    @Override
    public String toString() {
        return "Gas station " + this.name +" with coordinates x="+ this.x +", y="+ this.y+ " ahas the gas price "
                + this.gasPrice + " $.";
    }
}
