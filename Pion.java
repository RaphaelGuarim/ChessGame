import java.util.ArrayList;

public abstract class Pion extends Piece{
    
    // constructeur par default appele le constructeur de piece par default
    public Pion(){
        super();
    }

    // constructeur par position et par couleur appele le constructeur de piece 
    public Pion(Position p ,char couleur){
        super(couleur,p);
    }

    // Methode gettype abstraite dans la classe mere definit pour le pion
    public String getType(){
        return "pion";
    }

    // methode abstraite de calcul des coups possible
    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);

}