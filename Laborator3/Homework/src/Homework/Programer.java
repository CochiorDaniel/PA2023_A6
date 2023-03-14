package Homework;

public class Programer extends Person{
    private String mainProgramingLanguage;

    public Programer(String name, String birthDate, String mainProgramingLanguage){
        super(name, birthDate);
        this.mainProgramingLanguage = mainProgramingLanguage;
    }

    @Override
    public String toString() {
        return "Programatorul " + this.name + " nascut la data de " + this.birthDate
                + " cunoaste cel mai bine limbajul " + this.mainProgramingLanguage;
    }



}
