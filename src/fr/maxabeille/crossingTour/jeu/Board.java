package fr.maxabeille.crossingTour.jeu;

import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.elements.GameImage;

public class Board {

    public Board(String link){

        GameImage view = new GameImage(link);
        Test.getRoot().add(view);

        view.setDimensions(800,800);
        view.setPosition(350,28);

    }

    public void setUpInteraction(){

    }
}
