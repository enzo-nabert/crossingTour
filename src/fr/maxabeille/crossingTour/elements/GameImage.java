package fr.maxabeille.crossingTour.elements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class GameImage extends ImageView {

    private double posX,posY,sizeX,sizeY;

    public GameImage(String link){
        super(new Image(new File(link).toURI().toString()));
    }

    public void setPosition(double x, double y){
        setPosX(x);
        setPosY(y);
    }

    public void setDimensions(double w, double h){
        setSizeX(w);
        setSizeY(h);
    }

    public void setPosX(double posX) {
        setLayoutX(posX);
        this.posX = posX;
    }

    public void setPosY(double posY) {
        setLayoutY(posY);
        this.posY = posY;
    }

    public void setSizeX(double sizeX) {
        setFitWidth(sizeX);
        this.sizeX = sizeX;
    }

    public void setSizeY(double sizeY) {
        setFitHeight(sizeY);
        this.sizeY = sizeY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public double getSizeX() {
        return sizeX;
    }

    public double getSizeY() {
        return sizeY;
    }
}
