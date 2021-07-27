package fr.maxabeille.crossingTour.jeu;

import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.Utils.Ratio;
import fr.maxabeille.crossingTour.Utils.Ut;
import fr.maxabeille.crossingTour.cases.Case;
import fr.maxabeille.crossingTour.elements.GameRectangle;
import fr.maxabeille.crossingTour.elements.GameText;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

public class Player {

    private static int suiv = 0;
    private final String nomJoueur;
    private int numCase = 0, compte = 2000, dx, dy;
    private final int id = suiv;
    private static double suivAccountY = Ratio.getFromScreenY(1, 5);
    private final Group accountVisual = new Group();
    private GameRectangle border, pion;
    private GameText infos;
    private final SequentialTransition playerMoveTransition = new SequentialTransition();
    private static final ArrayList<Player> playerList = new ArrayList<>();
    private final Color colorPion;

    public Player(String name,Color color) {
        suiv++;
        nomJoueur = name;
        colorPion = color;
        setUpAccountVisual();
        setUpPionVisual();
        playerList.add(this);
    }

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }

    public int getNumCase() {
        return numCase;
    }

    public void addMoney(int add) {
        compte += add;
        Test.refreshInfos();
    }

    public void setAccountBorder(Color color) {
        border.setStroke(color);
    }

    public void setAccountText(String text) {
        infos.setText(text);
    }

    public void removeMoney(int remove) {
        compte -= remove;
        Test.refreshInfos();
    }

    public int getId() {
        return id;
    }

    public int getCompte() {
        return compte;
    }

    private void setUpAccountVisual() {
        border = new GameRectangle(Ratio.getFromScreenX(1, 10), Ratio.getFromScreenY(1, 20), 24, 24);
        border.setPosition(Ratio.getFromScreenX(8, 10), suivAccountY);
        border.setProperties(Color.WHITE, Color.BLACK, 5);
        infos = new GameText(nomJoueur + " : " + compte);
        infos.setPosition(Ratio.getFromContainerX(border, 1, 5), Ratio.getFromContainerY(border, 6, 10));
        accountVisual.getChildren().addAll(border, infos);
        suivAccountY += border.getSizeY() + 10;
    }

    private void setUpPionVisual() {
        pion = new GameRectangle(50, 50, 20, 20);
        pion.setFill(colorPion);
        pion.setPosition(1065, 740);
        pion.setStroke(Color.BLACK);
        pion.setStrokeWidth(5);
        Test.getRoot().add(pion);
    }

    public GameRectangle getPion() {
        return pion;
    }

    private void moveLine(int line, int movement) {
        if (line == 0) {

            TranslateTransition line0 = new TranslateTransition(Duration.millis(500), pion);
            line0.setFromX(pion.getVpx());
            line0.setToX(pion.getVpx() - movement * Case.getSize());
            playerMoveTransition.getChildren().add(line0);
            pion.setVpx(pion.getVpx() - movement * Case.getSize());

        } else if (line == 1) {

            TranslateTransition line1 = new TranslateTransition(Duration.millis(500), pion);
            line1.setFromY(pion.getVpy());
            line1.setToY(pion.getVpy() - movement * Case.getSize());
            playerMoveTransition.getChildren().add(line1);
            pion.setVpy(pion.getVpy() - movement * Case.getSize());

        } else if (line == 2) {

            TranslateTransition line2 = new TranslateTransition(Duration.millis(500), pion);
            line2.setFromX(pion.getVpx());
            line2.setToX(pion.getVpx() + movement * Case.getSize());
            playerMoveTransition.getChildren().add(line2);
            pion.setVpx(pion.getVpx() + movement * Case.getSize());

        } else {

            TranslateTransition line3 = new TranslateTransition(Duration.millis(500), pion);
            line3.setFromY(pion.getVpy());
            line3.setToY(pion.getVpy() + movement * Case.getSize());
            playerMoveTransition.getChildren().add(line3);
            pion.setVpy(pion.getVpy() + movement * Case.getSize());

        }
    }

    public static void transferMoney(Player from, Player to, int money){
        from.removeMoney(money);
        to.addMoney(money);
        Test.refreshInfos();
    }

    public void backward(int movement){
        int restant = movement, line = Ut.getLine(numCase);

        while (restant != 0) {
            int bound = (line != 0)?Ut.getBound(line - 1):0;
            if (numCase - restant >= bound) {
                moveLine(line, - restant);
                numCase -= restant;
                restant = 0;
            }else {
                int curMove = numCase - bound;
                restant -= curMove;
                moveLine(line, - curMove);
                line--;
                numCase = bound;
            }
            if (numCase == 0){
                line = 3;
                numCase = 40;
            }
        }
        playerMoveTransition.play();
        playerMoveTransition.setOnFinished(actionEvent -> {
            Case.getCases().get(numCase).activate();
            playerMoveTransition.getChildren().clear();
        });
    }

    public void forward(int movement) {

        int restant = movement, line = Ut.getLine(numCase);

        while (restant != 0) {
            int bound = Ut.getBound(line);
            if (numCase + restant <= bound) {
                moveLine(line,restant);
                numCase += restant;
                restant = 0;
            }else {
                int curMove = bound - numCase;
                restant -= curMove;
                moveLine(line, curMove);
                line++;
                numCase = bound;
            }
            if (numCase == 40){
                line = 0;
                numCase = 0;
                Case.getCases().get(0).activate();
            }
        }
        playerMoveTransition.play();
        playerMoveTransition.setOnFinished(actionEvent -> {
            playerMoveTransition.getChildren().clear();
            Case.getCases().get(numCase).activate();
        });

    }

    public void addToRoot() {
        Test.getRoot().add(accountVisual);
    }
}
