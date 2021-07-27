package fr.maxabeille.crossingTour.Utils;

import javafx.scene.paint.Color;

public class Ut {

    public static String colorToHexa(Color color){
        return "#" + color.toString().substring(2,8);
    }

    public static int getBound(int numLine){
        return (numLine + 1) * 10;
    }

    public static int getLine(int cases){
        return cases / 10;
    }
}
