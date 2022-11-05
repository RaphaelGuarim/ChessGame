import java.util.ArrayList;

class Cavalier extends Piece {
    
    // constructeur par default piece blanche en 0 0
    public Cavalier(){
        super('B',0,0);
    }

    // constructeur par couleur et position
    public Cavalier(Position p ,char couleur){
        super(couleur,p);
    }

    // methode abstraite de piece definit pour le cavalier
    public String getType(){
        return "cavalier";
    }

    // methode de calcul des deplacement possible
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        ArrayList<Position> tab = new ArrayList<Position>();
        int x,y;
        x=this.getPosition().getx();
        y=this.getPosition().gety();

        // Case 1
        if (x+2<8 && y+1<8){
            if (p.getCase(x+2, y+1)==null){
                tab.add(new Position(x+2,y+1));
            }else{
                if (p.getCase(x+2, y+1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+2,y+1));
                }
            }
        }

        // Case 2
        if (x+1<8 && y+2<8){
            if (p.getCase(x+1, y+2)==null){
                tab.add(new Position(x+1,y+2));
            }else{
                if (p.getCase(x+1, y+2).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+1,y+2));
                }
            }
        }

        // Case 3
        if (x+2<8 && y-1>=0){
            if (p.getCase(x+2, y-1)==null){
                tab.add(new Position(x+2,y-1));
            }else{
                if (p.getCase(x+2, y-1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+2,y-1));
                }
            }
        }

        // Case 4
        if (x+1<8 && y-2>=0){
            if (p.getCase(x+1, y-2)==null){
                tab.add(new Position(x+1,y-2));
            }else{
                if (p.getCase(x+1, y-2).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x+1,y-2));
                }
            }
        }

        // Case 5
        if (x-2>=0 && y+1<8){
            if (p.getCase(x-2, y+1)==null){
                tab.add(new Position(x-2,y+1));
            }else{
                if (p.getCase(x-2, y+1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-2,y+1));
                }
            }
        }

        // Case 6
        if (x-1>=0 && y+2<8){
            if (p.getCase(x-1, y+2)==null){
                tab.add(new Position(x-1,y+2));
            }else{
                if (p.getCase(x-1, y+2).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-1,y+2));
                }
            }
        }

        // Case 7
        if (x-2>=0 && y-1>=0){
            if (p.getCase(x-2, y-1)==null){
                tab.add(new Position(x-2,y-1));
            }else{
                if (p.getCase(x-2, y-1).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-2,y-1));
                }
            }
        }

        // Case 8
        if (x-1>=0 && y-2>=0){
            if (p.getCase(x-1, y-2)==null){
                tab.add(new Position(x-1,y-2));
            }else{
                if (p.getCase(x-1, y-2).getCouleur()!=this.getCouleur()){
                    tab.add(new Position(x-1,y-2));
                }
            }
        }



        return tab;
    }
}
