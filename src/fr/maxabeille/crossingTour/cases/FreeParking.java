package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;

public class FreeParking extends Case{

    private int money = 0;

    public FreeParking(int position){
        add(this,position);
    }

    public void addMoney(int add){
        money += add;
    }

    @Override
    public void activate() {
        Test.getCurrentPlayer().addMoney(money);
        money = 0;
    }

    @Override
    public String toString() {
        return "FreeParking";
    }
}
