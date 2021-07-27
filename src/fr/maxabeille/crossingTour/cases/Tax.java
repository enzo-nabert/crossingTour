package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;

public class Tax extends Case{

    private final int tax;

    public Tax(int tax,int position){
        this.tax = tax;
        add(this,position);
    }

    @Override
    public String toString() {
        return "Tax";
    }

    public void activate(){
        Test.getCurrentPlayer().removeMoney(tax);
    }
}
