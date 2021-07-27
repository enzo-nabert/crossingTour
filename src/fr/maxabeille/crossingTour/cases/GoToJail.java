package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;

public class GoToJail extends Case{

    public GoToJail(int position){
        add(this,position);
    }

    @Override
    public void activate() {
        Test.getCurrentPlayer().backward(20);
    }

    @Override
    public String toString() {
        return "GoToJail";
    }
}
