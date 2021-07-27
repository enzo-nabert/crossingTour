package fr.maxabeille.crossingTour.cases;


import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.jeu.Player;
import javafx.scene.paint.Color;

public class Field extends Buyable {

    public Field(String nom, Color color, int prixInit, int nu, int one, int two, int three, int four, int hotel) {
        super(nom,color,prixInit,nu,one,two,three,four,hotel);
        add(this);
    }

    public void activate(){
        Player current = Test.getCurrentPlayer();
        if (getPossesseur() == null) {
            openAchat();
        }else if (getPossesseur() != current){
            Player.transferMoney(current,getPossesseur(),getLoyers()[0]);
        }
    }
}
