package fr.maxabeille.crossingTour.jeu;

import fr.maxabeille.crossingTour.Window;

public class Game {

    private static Player currentPlayer;

    public static void start(){
        Window root = new Window("Crossing Tour");

    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }
}
