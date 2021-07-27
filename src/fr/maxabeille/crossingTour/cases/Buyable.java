package fr.maxabeille.crossingTour.cases;

import fr.maxabeille.crossingTour.Test.Test;
import fr.maxabeille.crossingTour.Utils.Ratio;
import fr.maxabeille.crossingTour.Utils.Ut;
import fr.maxabeille.crossingTour.elements.GameButton;
import fr.maxabeille.crossingTour.elements.GameRectangle;
import fr.maxabeille.crossingTour.elements.GameText;
import fr.maxabeille.crossingTour.jeu.Player;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public abstract class Buyable extends Case{

        private int[] loyers;
        private GameRectangle border,monopole;
        private GameText name, infos,valeurHypothecaire;
        private final int prixInit,valeurHypotheque;
        private boolean hypotheque = false;
        private final String nom;
        private Color color;
        private final Group visual = new Group(), buyVisual = new Group(),loyerVisual = new Group();
        private static final ArrayList<Buyable> displayed = new ArrayList<>();
        private Player possesseur;


        public Buyable(String nom, Color color, int prixInit, int nu, int one, int two, int three, int four, int hostel){
            cacher();
            buyVisual.setVisible(false);
            this.prixInit = prixInit;
            valeurHypotheque = prixInit / 2;
            this.nom = nom;
            loyers = new int[]{nu,one,two,three,four,hostel};
            this.color = color;
            createVisual();
            setDimensions(Ratio.getFromScreenX(25,192),Ratio.getFromScreenY(25,72));
            setDefaultPosition();
            setUpLoyerVisual();
        }

        public Buyable(String nom,int prixInit){
            cacher();
            buyVisual.setVisible(false);
            this.prixInit = prixInit;
            valeurHypotheque = prixInit / 2;
            this.nom = nom;
            createVisual();
            setDimensions(Ratio.getFromScreenX(25,192),Ratio.getFromScreenY(25,72));
            setDefaultPosition();
            setUpLoyerVisual();
        }

        public Buyable(String nom,int prixInit,int un,int deux,int trois,int quatre){
            cacher();
            buyVisual.setVisible(false);
            this.prixInit = prixInit;
            loyers = new int[]{un,deux,trois,quatre};
            valeurHypotheque = prixInit / 2;
            this.nom = nom;
            createVisual();
            setDimensions(Ratio.getFromScreenX(25,192),Ratio.getFromScreenY(25,72));
            setDefaultPosition();
            setUpLoyerVisual();
        }

        public void setDefaultPosition(){
            setPosition(Ratio.getFromScreenX(4,10),Ratio.getFromScreenY(125,432));
        }

        public int getValeurHypotheque() {
            return valeurHypotheque;
        }

        public int getPrixInit() {
            return prixInit;
        }

        public void hypothequer(){
            hypotheque = true;
        }

        public int[] getLoyers() {
            return loyers;
        }

        public void racheter(){
            hypotheque = false;
        }

        public boolean isHypotheque() {
            return hypotheque;
        }

        private void createVisual(){
            border = new GameRectangle(100,400);
            border.setProperties(Color.WHITE,Color.BLACK,5);
            monopole = new GameRectangle(border.getSizeX(),50);
            monopole.setProperties(color,Color.BLACK,5);
            name = new GameText(nom);
            name.setFontSize(24);
            name.setTextAlignment(TextAlignment.CENTER);
            if(this instanceof Field) {
                infos = new GameText("Terrain nu :        " + loyers[0]
                        + "\n1 Maison  :        " + loyers[1]
                        + "\n2 Maisons :        " + loyers[2]
                        + "\n3 Maisons :        " + loyers[3]
                        + "\n4 Maisons :        " + loyers[4]
                        + "\nHôtel :                " + loyers[5]
                );
            }else if(this instanceof Company){
                infos = new GameText("Loyer en fonction du dé\n" +
                        "dé x4 si une possédée\n" +
                        "dé x10 si deux possédées"
                );
            }else if (this instanceof Transport){
                infos = new GameText("1 gare :        " + loyers[0]
                        + "\n2 gares  :        " + loyers[1]
                        + "\n3 gares :        " + loyers[2]
                        + "\n4gares :        " + loyers[3]
                );
            }
            infos.setFontSize(15);
            valeurHypothecaire = new GameText("Valeur Hypothécaire : " + valeurHypotheque);
            valeurHypothecaire.setFontSize(15);
            visual.getChildren().addAll(border,monopole,name, infos,valeurHypothecaire);
        }

        public void show(){
            hide();
            displayed.add(this);
            visual.setVisible(true);
        }

        public static void hide(){
            if (displayed.size() != 0){
                displayed.get(0).cacher();
                displayed.clear();
            }
        }
        private void cacher(){
            visual.setVisible(false);
        }

        public void addToRoot(){
            Test.getRoot().add(visual,buyVisual);
        }

        public void setPosition(double x,double y){
            border.setPosition(x,y);
            monopole.setPosition(border.getPosX(),border.getPosY());
            name.setPosition(Ratio.getFromContainerX(border,1,15),Ratio.getFromContainerY(border,1,4));
            if(this instanceof Field) {
                infos.setPosition(Ratio.getFromContainerX(border, 1, 6), Ratio.getFromContainerY(border, 1, 2));
            }else if (this instanceof Company){
                infos.setPosition(Ratio.getFromContainerX(border, 1, 13), Ratio.getFromContainerY(border, 1, 2));
            }
            valeurHypothecaire.setPosition(Ratio.getFromContainerX(border,1,15),Ratio.getFromContainerY(border,95,100));
        }

        public void setDimensions(double w, double h){
            border.setDimensions(w,h);
            monopole.setSizeX(w);
            name.setWrappingWidth(w - 20);
        }

        public void setUpLoyerVisual(){
            GameRectangle loyerBorder = new GameRectangle(border.getSizeX() + 50,border.getSizeY());
            loyerBorder.setPosition(border.getPosX() + border.getSizeX(),border.getPosY());
            loyerBorder.setProperties(Color.WHITE,Color.BLACK,5);
        }

        public void openAchat(){
            setPosition(Ratio.getFromScreenX(35,100),Ratio.getFromScreenY(125,432));
            show();
            buyVisual.setVisible(true);
            GameRectangle menuAchat = new GameRectangle(border.getSizeX() + 50,border.getSizeY());
            menuAchat.setPosition(border.getPosX() + border.getSizeX(),border.getPosY());
            menuAchat.setProperties(Color.WHITE,Color.BLACK,5);

            GameText prixLabel = new GameText("Prix de vente : " + prixInit);
            prixLabel.setFontSize(25);
            prixLabel.setPosition(Ratio.getFromContainerX(menuAchat,1,10),Ratio.getFromContainerY(menuAchat,1,5));

            GameButton acheter = new GameButton("Acheter", actionEvent -> {
                possesseur = Test.getCurrentPlayer();
                possesseur.removeMoney(prixInit);
                GameRectangle playerPion = possesseur.getPion();

                GameRectangle actePropriete = new GameRectangle(playerPion.getSizeX() / 5,playerPion.getSizeY() / 5);
                actePropriete.setFill(playerPion.getFill());

                double acteX =  playerPion.getPosX() + playerPion.getVpx(), acteY = playerPion.getPosY() + playerPion.getVpy();
                if (Ut.getLine(possesseur.getNumCase()) == 0){
                    actePropriete.setPosition(acteX, acteY);
                }else if (Ut.getLine(possesseur.getNumCase()) == 1){
                    actePropriete.setPosition(acteX, acteY);
                }else if (Ut.getLine(possesseur.getNumCase()) == 2){
                    actePropriete.setPosition(acteX, acteY);
                }else{
                    actePropriete.setPosition(acteX, acteY);
                }
                Test.getRoot().add(actePropriete);

                closeAchat();
                if (!Test.getDice().isDouble()){
                    Test.nextPlayer();
                }
            });

            acheter.setDisable(Test.getCurrentPlayer().getCompte() < prixInit);
            acheter.setPosition(menuAchat.getPosX() + 20,Ratio.getFromContainerY(menuAchat,45,100));
            acheter.setDimensions(border.getSizeX() + 10,30);
            acheter.setTextProperties(Color.BLACK,18);
            acheter.setFill(Color.RED,5);
            acheter.setShear(-0.3,0);

            GameButton passer = new GameButton("Passer",actionEvent -> {
                closeAchat();
                if (!Test.getDice().isDouble()){
                    Test.nextPlayer();
                }
            });
            passer.setPosition(menuAchat.getPosX() + 20,Ratio.getFromContainerY(menuAchat,7,10));
            passer.setDimensions(border.getSizeX() + 10,30);
            passer.setTextProperties(Color.BLACK,18);
            passer.setFill(Color.ORANGE,5);
            passer.setShear(-0.3,0);
            buyVisual.getChildren().addAll(menuAchat,prixLabel,acheter,passer);
        }

        private void closeAchat(){
            cacher();
            buyVisual.setVisible(false);
            setDefaultPosition();
        }

    public Player getPossesseur() {
        return possesseur;
    }

    @Override
    public String toString() {
        return name.getText();
    }
}
