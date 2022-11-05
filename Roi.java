import java.util.ArrayList;

class Roi extends Piece{
    
    // constructeur par default roi blanche en 0 0
    public Roi(){
        super('B',0,0);
    }

    // Constructeur par copie d'une piece
    public Roi(Piece piece){
        super(piece);
    }

    // Constructeur par position et couleur
    public Roi(Position p ,char couleur){
        super(couleur,p);
    }

    // methode abstraite de piece definit pour le roi
    public String getType(){
        return "roi";
    }

    // methode de calcul des deplacement possible
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x,y;
        ArrayList<Position> tab = new ArrayList<Position>();
        x=this.getPosition().getx();
        y=this.getPosition().gety();

        // Case 1
        if (x+1<8 && y+1<8){
            if (p.getCase(x+1, y+1)==null){
                tab.add(new Position(x+1,y+1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x+1, y+1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+1,y+1));
                }
            }
        }

        // Case 2
        if (x+1<8 ){
            if (p.getCase(x+1, y)==null){
                tab.add(new Position(x+1,y));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x+1, y).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+1,y));
                }
            }
        }

        // Case 3
        if (x+1<8 && y-1>=0){
            if (p.getCase(x+1, y-1)==null){
                tab.add(new Position(x+1,y-1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x+1, y-1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+1,y-1));
                }
            }
        }

        // Case 4
        if (y+1<8){
            if (p.getCase(x, y+1)==null){
                tab.add(new Position(x,y+1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x, y+1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x,y+1));
                }
            }
        }

        // Case 5
        if (y-1>=0){
            if (p.getCase(x, y-1)==null){
                tab.add(new Position(x,y-1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x, y-1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x,y-1));
                }
            }
        }

        // Case 6
        if (x-1>=0 && y+1<8){
            if (p.getCase(x-1, y+1)==null){
                tab.add(new Position(x-1,y+1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x-1, y+1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-1,y+1));
                }
            }
        }

        // Case 7
        if (x-1>=0 ){
            if (p.getCase(x-1, y)==null){
                tab.add(new Position(x-1,y));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x-1, y).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-1,y));
                }
            }
        }

        // Case 8
        if (x-1>=0 && y-1>=0){
            if (p.getCase(x-1, y-1)==null){
                tab.add(new Position(x-1,y-1));
            }
            // verification de la couleur pour la prise
            else{
                if (p.getCase(x-1, y-1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-1,y-1));
                }
            }
        }


        return tab;
    }
}