package fr.maxabeille.crossingTour.Test;

import fr.maxabeille.crossingTour.Window;
import fr.maxabeille.crossingTour.cases.*;
import fr.maxabeille.crossingTour.elements.GameButton;
import fr.maxabeille.crossingTour.elements.GameText;
import fr.maxabeille.crossingTour.jeu.Board;
import fr.maxabeille.crossingTour.jeu.Dice;
import fr.maxabeille.crossingTour.jeu.Player;
import javafx.scene.paint.Color;

public class Test {

    private static Player currentPlayer;
    private static final Dice dice = new Dice();
    private static final Window root = new Window("test");
    private static final GameText diceResult = new GameText("0 + 0 : 0");
    private static int result;

    public static GameText getDiceResult() {
        return diceResult;
    }

    public static void start() {

        new Board("ressources/images/board/monopoly.png");
        Player p1 = new Player("p1",Color.RED);
        Player p2 = new Player("p2",Color.YELLOW);
        p1.addToRoot();
        p2.addToRoot();
        setFirstPlayer(p1);

        ///////////////////////////////////////CRÉATION DES CASES////////////////////////////////////////////////////
        int[] pos = {9,21,23,2,6,17,22,33,33,4,35,5,15,25,35};

        for (int i = 0; i < 23; i++) {
            new Field("case " + i,Color.BLUE,i * 6,i,i * 3,i * 4,i * 5,i * 6,i * 10).addToRoot();
        }

        for (int i = 0; i < 2; i++) {
            new Company("company" + i,pos[i]).addToRoot();
        }
        new GoToJail(pos[2]);
        new Go(200);
        for (int i = 11; i < 15; i++) {
            new Transport("gare" + (i - 11),200);
        }
        for (int i = 3; i < 9; i++) {
            new Chance(pos[i]);
        }
        for (int i = 9; i < 11; i++) {
            new Tax((i==9)?100:200,pos[i]);
        }
        new FreeParking(20);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////

        GameButton launch = new GameButton("Lancer dés",actionEvent -> {
            result = dice.roll();
            currentPlayer.forward(result);
        });
        launch.setPosition(1150,700);

        diceResult.setPosition(1150,800);
        diceResult.setFill(Color.RED);
        root.add(launch,diceResult);
        System.out.println(Case.getCases());
    }

    public static void refreshInfos() {
        for(Player player : Player.getPlayerList()) {
           player.setAccountText(player.getNomJoueur() + " : " + player.getCompte());
        }
    }

    private static void setFirstPlayer(Player first){
        currentPlayer = first;
        currentPlayer.setAccountBorder(Color.RED);
    }

    public static int getResult() {
        return result;
    }

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static Dice getDice() {
        return dice;
    }

    public static void nextPlayer() {
        currentPlayer.setAccountBorder(Color.BLACK);
        if (currentPlayer.getId() + 1 == Player.getPlayerList().size()) {
            currentPlayer = Player.getPlayerList().get(0);
        } else {
            currentPlayer = Player.getPlayerList().get(currentPlayer.getId() + 1);
        }
        currentPlayer.setAccountBorder(Color.RED);
    }

    public static Window getRoot() {
        return root;
    }

}
