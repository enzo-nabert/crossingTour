package fr.maxabeille.crossingTour.jeu;

import fr.maxabeille.crossingTour.Test.Test;

public class Dice {

    private boolean equal;
    private int doubleNumber = 0;

    public int roll(){
        int dice1,dice2;
        dice1 = 1 + (int)(Math.random() * 6);
        dice2 = 1 + (int)(Math.random() * 6);
        if (dice1 == dice2){
            equal = true;
            doubleNumber++;
        }else{
            doubleNumber = 0;
            equal = false;
        }
        int res = dice1 + dice2;
        Test.getDiceResult().setText(dice1 + " + " + dice2 + " : " + res);
        return res;
    }

    public boolean isDouble() {
        return equal;
    }

    public boolean troisConsecutif(){
        if (doubleNumber == 3){
            doubleNumber = 0;
            return true;
        }else{
            return false;
        }
    }


}
