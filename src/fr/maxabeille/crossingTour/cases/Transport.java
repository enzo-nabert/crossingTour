package fr.maxabeille.crossingTour.cases;

public class Transport extends Buyable{

    public Transport(String nom,int prixInit){
        super(nom,prixInit,25,50,100,200);
        add(this);
    }
}
