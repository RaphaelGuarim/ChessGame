import java.util.ArrayList;

class Tour extends Piece{
    
    // constructeur par default tour blanche en 0 0
    public Tour(){
        super('B',0,0);
    }

    // Constructeur par position et couleur
    public Tour(Position p ,char couleur){
        super(couleur,p);
    }

    // methode abstraite de piece definit pour la tour
    public String getType(){
        return "tour";
    }

    // methode de calcul des deplacement possible
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x,y,i;
        ArrayList<Position> tab = new ArrayList<Position>();
        x=this.getPosition().getx();
        y=this.getPosition().gety();
        i=1;

        
        // vers droite
        while ((i+x<8) && (p.getCase(x+i, y)==null)){
            tab.add(new Position(x+i,y));
            i+=1;
        }
        if (i+x<8 && p.getCase(x+i, y).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x+i,y));
        }
        i=1;

        // vers gauche

        while ((x-i>=0) && (p.getCase(x-i, y)==null)){
            tab.add(new Position(x-i,y));
            i+=1;
        }
        if (x-i>=0 && p.getCase(x-i, y).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x-i,y));
        }
        i=1;

        // vers haut
        while ((i+y<8) && (p.getCase(x, y+i)==null)){
            tab.add(new Position(x,y+i));
            i+=1;
        }
        if (i+y<8 && p.getCase(x,y+i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x,y+i));
        }
        i=1;

        // vers bas

        while ((y-i>=0) && (p.getCase(x, y-i)==null)){
            tab.add(new Position(x, y-i));
            i+=1;
        }
        if (y-i>=0 && p.getCase(x, y-i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x, y-i));
        }

        return tab;
    }


    

    
}

