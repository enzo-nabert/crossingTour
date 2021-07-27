package fr.maxabeille.crossingTour.cases;

import java.util.ArrayList;

public class Case {

    private static final ArrayList<Case> cases = new ArrayList<>();
    private static final double size = 67;

    public void add(Case newCase){
        cases.add(newCase);
    }

    public void add(Case newCase,int index){
        cases.add(index,newCase);
    }

    public void remove(Case remove){
        cases.remove(remove);
    }

    public void activate(){
        if (this instanceof Company){
            Company c = (Company) this;
            c.activate();
        }else if (this instanceof Field){
            Field p = (Field) this;
            p.activate();
        }else if(this instanceof GoToJail){
            GoToJail goToJail = (GoToJail) this;
            goToJail.activate();
        }else if(this instanceof Go){
            Go go = (Go) this;
            go.activate();
        }else if(this instanceof Tax){
            Tax t = (Tax) this;
            t.activate();
        }
    }

    public static ArrayList<Case> getCases() {
        return cases;
    }

    public int getNumCase() {
        return cases.indexOf(this);
    }

    public static double getSize() {
        return size;
    }
}
