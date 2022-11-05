import java.util.function.LongBinaryOperator;

public class Position{
    
    private int x,y;

    // Constructeur par defaut en 0 0
    public Position(){
        this.x=0;
        this.y=0;
    }

    // constructeur par copie
    public Position(Position a){
        this.x=a.x;
        this.y=a.y;
    }

    // constructeur par coordonnées
    public Position(int x2,int y2){
        this.x=x2;
        this.y=y2;
    }

    // constructeur par chaine de characteres 
    public Position(String chaine){
        String ligne = new String ("ABCDEFGH");
        this.x=(ligne.indexOf(chaine.charAt(0)));
        this.y= Integer.parseInt(chaine.substring(1,2));
    }

    // getters

    public int getx(){
        return this.x;
    }

    public int gety(){
        return this.y;
    }

    // setters 

    public void setx(int x2){
        this.x=x2;
    }

    public void sety(int y2){
        this.y=y2;
    }

    // methode equals
    public boolean equals(Object O){
        if (O==this){
            return true;
        }
        return false;
    }
    
    // methode to string
    public String toString(){
        String ligne = new String ("ABCDEFGH");
        String affichage = new String();
        affichage=ligne.charAt(this.x)+ String.valueOf(this.y);
        return affichage;
    }

}



