package fr.maxabeille.crossingTour;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Window extends Stage {

    private final Pane pane = new Pane();
    private static double sizeX,sizeY;

    public Window(String title){
        setTitle(title);
        setScene(new Scene(pane));
        setMaximized(true);
        setResizable(false);
        sizeX = Screen.getPrimary().getBounds().getWidth();
        sizeY = Screen.getPrimary().getBounds().getHeight();
        show();
    }

    public static double getSizeX() {
        return sizeX;
    }
    public static double getSizeY() {
        return sizeY;
    }

    public void add(Node... nodes){
        pane.getChildren().addAll(nodes);
    }

    public void setBackgroundColor(Color color){
        pane.setStyle("-fx-background-color: " + "#" + color.toString().substring(2,8));
    }
}
