package fr.maxabeille.crossingTour.cases;

public class Chance extends Case{

    public Chance(int position){
        add(this,position);
    }

    @Override
    public String toString() {
        return "Chance";
    }
}
