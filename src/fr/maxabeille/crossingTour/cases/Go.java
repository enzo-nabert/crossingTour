package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;

public class Go extends Case{

    private final int beginMoney;

    public Go(int beginMoney){
        add(this,0);
        this.beginMoney = beginMoney;
    }

    public void activate(){
        Test.getCurrentPlayer().addMoney(beginMoney);
        Test.refreshInfos();
    }

    @Override
    public String toString() {
        return "Go";
    }
}
