package fr.maxabeille.crossingTour.elements;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Shear;

public class GameRectangle extends Rectangle {

    private double posX,posY,sizeX,sizeY;
    private double rx,ry;
    private double vpx,vpy;

    public GameRectangle(double w,double h){
        setDimensions(w,h);
    }

    public GameRectangle(double w,double h,double rx,double ry){
        this(w,h);
        this.rx = rx;
        this.ry = ry;
        setBorderRadius(rx,ry);

    }

    public double getRx() {
        return rx;
    }

    public double getRy() {
        return ry;
    }

    public GameRectangle(double w, double h, double x, double y, Color fill){
        this(w,h);
        setPosition(x,y);
        setFill(fill);
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
        setWidth(sizeX);
        this.sizeX = sizeX;
    }

    public void setSizeY(double sizeY) {
        setHeight(sizeY);
        this.sizeY = sizeY;
    }

    public void setVpx(double vpx) {
        this.vpx = vpx;
    }

    public void setVpy(double vpy) {
        this.vpy = vpy;
    }

    public double getVpx() {
        return vpx;
    }

    public double getVpy() {
        return vpy;
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

    public void setProperties(Color fill,Color stroke,int strokeWidth){
        setFill(fill);
        setStroke(stroke);
        setStrokeWidth(strokeWidth);
    }

    public void setBorderRadius(double rx,double ry){
        setArcWidth(rx);
        setArcHeight(ry);
    }

    public void setShear(double x,double y){
        Shear shear = new Shear();
        shear.setX(x);
        shear.setY(y);

        getTransforms().add(shear);
    }
}
