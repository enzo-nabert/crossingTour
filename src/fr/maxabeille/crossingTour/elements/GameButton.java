package fr.maxabeille.crossingTour.elements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.transform.Shear;


public class GameButton extends Button {

    private double posX,posY,sizeX,sizeY,borderRadius;
    private Color fill;

    public GameButton(String text){
        super(text);
    }
    public GameButton(String text, EventHandler<ActionEvent> e){
        this(text);
        setOnAction(e);
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
        setMinWidth(sizeX);
        this.sizeX = sizeX;
    }

    public void setSizeY(double sizeY) {
        setMinHeight(sizeY);
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

    public void setShear(double x,double y){
        Shear shear = new Shear();
        shear.setX(x);
        shear.setY(y);

        getTransforms().add(shear);
    }

    public void setFill(Color fill,double radius){
        borderRadius = radius;
        this.fill = fill;
        setDefaultHover();
        setBackground(new Background(new BackgroundFill(fill,new CornerRadii(radius),null)));
    }

    private void setHoverFill(Color fill,double radius){
        setBackground(new Background(new BackgroundFill(fill,new CornerRadii(radius),null)));
    }
    public void setTextProperties(Color textFill,double fontSize){
        setTextFill(textFill);
        setStyle("-fx-font-size: " + fontSize);
    }

    private void setDefaultHover(){
        setOnMouseEntered(mouseEvent -> setHoverFill(Color.rgb((int)(255 * fill.getRed()),(int)(255 * fill.getGreen()),(int)(255 * fill.getBlue()),0.7),borderRadius));
        setOnMouseExited(mouseEvent -> setHoverFill(fill,borderRadius));
    }
//
//    public void setOnHover(EventHandler<MouseEvent> entered,EventHandler<MouseEvent> exited){
//        setOnMouseEntered(entered);
//        setOnMouseExited(exited);
//    }
}
