package fr.maxabeille.crossingTour;

import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.jeu.Game;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Game.start();
        Test.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
