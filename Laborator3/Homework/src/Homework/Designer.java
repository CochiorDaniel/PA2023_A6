package Homework;

public class Designer extends Person{
    private String favoriteColor;

    public Designer(String name, String birthDate, String favoriteColor){
        super(name,birthDate);
        this.favoriteColor = favoriteColor;
    }

    @Override
    public String toString() {
        return "Designer-ul  " + this.name + " nascut la data de " + this.birthDate
                + " prefera culoarea " + this.favoriteColor;
    }
}
