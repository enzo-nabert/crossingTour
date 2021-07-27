package fr.maxabeille.crossingTour.cases;


import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.Utils.Ratio;
import fr.maxabeille.crossingTour.elements.GameButton;
import fr.maxabeille.crossingTour.elements.GameRectangle;
import fr.maxabeille.crossingTour.elements.GameText;
import fr.maxabeille.crossingTour.jeu.Dice;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Jail extends Case{

    private final Group visual = new Group();
    public Jail(){
        add(this);
        hide();
    }

    private void createVisual(){
        GameRectangle border = new GameRectangle(Ratio.getFromScreenX(25,192) + 50,Ratio.getFromScreenY(25,72));
        border.setPosition(Ratio.getFromScreenX(4,10),Ratio.getFromScreenY(125,432));
        border.setProperties(Color.WHITE,Color.BLACK,5);
        GameText result = new GameText("");
        GameButton tenterDouble = new GameButton("Essayer de faire un double",actionEvent -> {
            Dice dice = Test.getDice();
            dice.roll();
            result.setFontSize(25);
            result.setPosition(600,600);
           if (dice.isDouble()){
               result.setText("double !");
           }else{
               result.setText("raté !");
           }

        });
        tenterDouble.setPosition(Ratio.getFromContainerX(border,1,10),Ratio.getFromContainerY(border,1,10));
        visual.getChildren().addAll(result,border,tenterDouble);
    }

    public void show(){
        visual.setVisible(true);
    }

    public void hide(){
        visual.setVisible(false);
    }

    public void activate(){
        createVisual();
        show();
    }

    public void addToRoot(){
        Test.getRoot().add(visual);
    }

    public Group getVisual() {
        return visual;
    }
}
