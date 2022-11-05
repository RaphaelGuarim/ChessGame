import java.util.ArrayList;
public abstract class Piece {

    private char couleur;
    private Position position;

    // Constructeur par defaut une piece blanche en 0 0
    public Piece(){
        this.couleur= 'B';
        this.position = new Position(0,0);
    }

    // Methode absraite qui donne le type
    public abstract String getType();

    // methode abstraite des deplacement possible
    public abstract ArrayList<Position> getDeplacementPossible(Plateau p);

    // constructeur par copie
    public Piece(Piece p){
        this.couleur= p.couleur ;
        this.position = p.position;
    }

    // Constructeur avec couleur et coordonnes
    public Piece( char c, int a , int b){
        if (c=='B'^c=='N'){
            this.couleur= c;
        }else{
            System.out.println("Erreur de couleur");
        }
        this.position = new Position(a,b);
    }

    // Constructeur avec couleur et position
    public Piece( char c, Position P){
        if (c=='B'^c=='N'){
            this.couleur= c;
        }else{
            System.out.println("Erreur de couleur");
        }
        this.position = P;
    }

    // Constructeur avec couleur et chaine de charactere
    public Piece( char c, String chaine){
        if (c=='B'^c=='N'){
            this.couleur= c;
        }else{
            System.out.println("Erreur de couleur");
        }
        this.position = new Position(chaine);
    }

    // getters 

    public char getCouleur(){
        return this.couleur;
    }

    public Position getPosition(){
        return this.position;
    }

    // setters

    public void setCouleur(char c1){
        if (c1=='B'^c1=='N'){
            this.couleur= c1;
        }else{
            System.out.println("Erreur de couleur");
        }
    }

    public void setPosition(Position P){
        this.position=P;
    }

    // renvoie le nom court
    public String getNomCourt(){
        String nom = this.getType().substring(0, 1).toUpperCase() + this.getType().substring(1, 2) + String.valueOf(this.couleur);
        return nom;
    }

    // renvoie le nom long
    public String getNomLong(){
        String nom = this.getType() + "_" + String.valueOf(this.couleur);
        return nom;
    }

    // methode equals
    public boolean equals(Piece O){
        if (O==this && O.getType()==this.getType()){
            return true;
        }
        return false;
    }

    // toString
    public String toString(){
        String couleur;
        if (this.couleur=='N'){
            couleur="noir";
        }else{
            couleur="blanc";
        }
        return (this.getType() +" "+ couleur + " en " + this.position.toString());
    }

}
