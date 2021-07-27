package fr.maxabeille.crossingTour.elements;

import javafx.scene.text.Text;

public class GameText extends Text {

    private double posX,posY;

    public GameText(String text){
        super(text);
    }

    public void setPosition(double x, double y){
        setPosX(x);
        setPosY(y);
    }

    public void setPosX(double posX) {
        setLayoutX(posX);
        this.posX = posX;
    }

    public void setPosY(double posY) {
        setLayoutY(posY);
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setFontSize(int size){
        setStyle("-fx-font-size: " + size);
    }
}
