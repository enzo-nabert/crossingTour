package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.jeu.Player;

public class Company extends Buyable {

    public Company(String name,int position){
        super(name,300);
        add(this,position);
    }

    public void activate(){
        Player current = Test.getCurrentPlayer();
        if (getPossesseur() == null) {
            openAchat();
        }else if (getPossesseur() != current){
            Player.transferMoney(current,getPossesseur(),Test.getResult() * 4);
        }
    }
}