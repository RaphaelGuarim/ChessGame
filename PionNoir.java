import java.util.ArrayList;

class PionNoir extends Pion{
    
    // constructeur par default appele le constructeur de pion par default
    public PionNoir(){
        super();
    }

    // constructeur par position et par couleur appele le constructeur de pion
    public PionNoir(Position p ,char couleur){
        super(p,couleur);
    }

    // methode de calcul des deplacement possible
    public ArrayList<Position> getDeplacementPossible(Plateau p){
        int x,y;
        ArrayList<Position> tab = new ArrayList<Position>();
        x=this.getPosition().getx();
        y=this.getPosition().gety();
        // Avancer de 1 case
        if (y-1>=0 && p.getCase(x, y-1)==null){
            tab.add(new Position(x,y-1));
            // avancer de 2 case si c'est le premier coup
            if (y==6){
                if (p.getCase(x, y-2)==null){
                    tab.add(new Position(x,y-2));
                }
            }
        }
        // prise en diagonale par la gauche
        if (x-1>=0 && y-1>=0 && p.getCase(x-1, y-1)!=null){
            if (p.getCase(x-1, y-1).getCouleur()!=this.getCouleur()){
                tab.add(new Position(x-1,y-1));
            }
        }
        // prise en diagonale par la droite
        if (x+1<8 && y-1>=0 && p.getCase(x+1, y-1)!=null){
            if (p.getCase(x+1, y-1).getCouleur()!=this.getCouleur()){
                tab.add(new Position(x+1,y-1));
            }
        }

        return tab;
    }
}