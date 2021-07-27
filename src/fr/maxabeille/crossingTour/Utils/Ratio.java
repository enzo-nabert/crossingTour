package fr.maxabeille.crossingTour.Utils;

import fr.maxabeille.crossingTour.Window;
import fr.maxabeille.crossingTour.elements.GameRectangle;

public class Ratio {

    public static double getFromContainerX(GameRectangle container, double n, double d){
        return container.getPosX() + container.getSizeX() * n / d;
    }

    public static double getFromContainerY(GameRectangle container,double n,double d){
        return container.getPosY() + container.getSizeY() * n / d;
    }

    public static double getFromScreenX(double n,double d){
        return Window.getSizeX() * n / d;
    }

    public static double getFromScreenY(double n,double d){
        return Window.getSizeY() * n / d;
    }
}
