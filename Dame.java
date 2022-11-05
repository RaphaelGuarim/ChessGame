import java.util.ArrayList;

class Dame extends Piece {
    
    // constructeur par default dame blanche en 0 0
    public Dame(){
        super('B',0,0);
    }

    // Constructeur par position et couleur
    public Dame(Position p ,char couleur){
        super(couleur,p);
    }

    // methode abstraite de piece definit pour la dame
    public String getType(){
        return "dame";
    }

     // methode de calcul des deplacement possible
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        ArrayList<Position> tab = new ArrayList<Position>();
        int x,y,i;
        x=this.getPosition().getx();
        y=this.getPosition().gety();
        i=1;

        // en ligne

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
        i=1;

        // en diagonale

        // vers droite haut
        while ((i+x<8) && (i+y<8) && (p.getCase(x+i, y+i)==null)){
            tab.add(new Position(x+i,y+i));
            i+=1;
        }
        if ((i+x<8) && (i+y<8) && p.getCase(x+i, y+i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x+i,y+i));
        }
        i=1;

        // vers gauche bas
        while ((x-i>=0) && (y-i>=0) && (p.getCase(x-i, y-i)==null)){
            tab.add(new Position(x-i,y-i));
            i+=1;
        }
        if ((x-i>=0) && (y-i>=0) && p.getCase(x-i, y-i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x-i,y-i));
        }
        i=1;
        
        // vers gauche haut
        while ((x-i>=0) && (y+i<8) && (p.getCase(x-i, y+i)==null)){
            tab.add(new Position(x-i,y+i));
            i+=1;
        }
        if ((x-i>=0) && (y+i<8) && p.getCase(x-i, y+i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x-i,y+i));
        }
        i=1;

        // vers droite bas
        while ((i+x<8) && (y-i>=0) && (p.getCase(x+i, y-i)==null)){
            tab.add(new Position(x+i,y-i));
            i+=1;
        }
        if ((i+x<8) && (y-i>=0) && p.getCase(x+i, y-i).getCouleur()!=this.getCouleur()){
            tab.add(new Position(x+i,y-i));
        }
        
        return tab;
    }
}
