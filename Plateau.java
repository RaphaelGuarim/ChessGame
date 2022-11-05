import java.util.ArrayList;
import MG2D.* ;
import MG2D.geometrie.* ;
import java.util.*;

public class Plateau {
    private ArrayList<Piece> tab = new ArrayList<Piece>();

    // constructeur du plateau de depart
    public Plateau(){

        tab.add(new Tour(new Position(0,0),'B'));
        tab.add(new Cavalier(new Position(1,0),'B'));
        tab.add(new Fou(new Position(2,0),'B'));
        tab.add(new Dame(new Position(3,0),'B'));
        tab.add(new Roi(new Position(4,0),'B'));
        tab.add(new Fou(new Position(5,0),'B'));
        tab.add(new Cavalier(new Position(6,0),'B'));
        tab.add(new Tour(new Position(7,0),'B'));

        tab.add(new PionBlanc(new Position(0,1),'B'));
        tab.add(new PionBlanc(new Position(1,1),'B'));
        tab.add(new PionBlanc(new Position(2,1),'B'));
        tab.add(new PionBlanc(new Position(3,1),'B'));
        tab.add(new PionBlanc(new Position(4,1),'B'));
        tab.add(new PionBlanc(new Position(5,1),'B'));
        tab.add(new PionBlanc(new Position(6,1),'B'));
        tab.add(new PionBlanc(new Position(7,1),'B'));

        tab.add(new Tour(new Position(0,7),'N'));
        tab.add(new Cavalier(new Position(1,7),'N'));
        tab.add(new Fou(new Position(2,7),'N'));
        tab.add(new Dame(new Position(3,7),'N'));
        tab.add(new Roi(new Position(4,7),'N'));
        tab.add(new Fou(new Position(5,7),'N'));
        tab.add(new Cavalier(new Position(6,7),'N'));
        tab.add(new Tour(new Position(7,7),'N'));

        tab.add(new PionNoir(new Position(0,6),'N'));
        tab.add(new PionNoir(new Position(1,6),'N'));
        tab.add(new PionNoir(new Position(2,6),'N'));
        tab.add(new PionNoir(new Position(3,6),'N'));
        tab.add(new PionNoir(new Position(4,6),'N'));
        tab.add(new PionNoir(new Position(5,6),'N'));
        tab.add(new PionNoir(new Position(6,6),'N'));
        tab.add(new PionNoir(new Position(7,6),'N'));
        
    }

    // constructeur par copie
    public Plateau(Plateau p){
        this.tab = p.tab;
    }

    // getters par coordonnes
    public Piece getCase(int x,int y){
        int i;
        for (i=0;i<this.tab.size();i++){
            if (this.tab.get(i).getPosition().getx() ==x && this.tab.get(i).getPosition().gety() == y){
                return this.tab.get(i);
            }
            
        }
        return null;
    }

    // getters par position
    public Piece getCase2(Position p){
        for (Piece pi : this.tab){
            if (pi!=null && pi.getPosition().getx() ==p.getx() && pi.getPosition().gety() == p.gety()){
                return pi;
            }
        }
        return null;
    }

    // getters par chaine de charactere
    public Piece getCase3(String chaine){
        int i,x1,x2;
        String chaine2 ="ABCDEFGH";
        x1=chaine2.indexOf(chaine.substring(0,1));
        x2= Integer.parseInt(chaine.substring(1,2));
        for (i=0;i<this.tab.size();i++){
            if (this.tab.get(i).getPosition().getx() ==x1 && this.tab.get(i).getPosition().gety() == x2){
                return this.tab.get(i);
            }
        }
        return null;
    }

    // to string
    public String toString(){
        int num;
        num=7;
        while (num>=0)
        {
            if (num !=8 )
            {
                System.out.print(" |---|---|---|---|---|---|---|---|\n");
            }
            System.out.print(num);
            for (int i=0 ; i<8 ;i++)
            {
                if(getCase(i,num)==null)
                {
                    System.out.print( "|   ");
                }
                else
                {
                    System.out.print( "|"+getCase(i,num).getNomCourt());
                }
            }
            System.out.print( "|"+num+"\n");
            num=num-1;
        }
        System.out.print(" |---|---|---|---|---|---|---|---|\n");
        System.out.print("  A   B   C   D   E   F   G   H\n");
        return "\n";
    }
    
    // getter piece blanche
    public ArrayList<Piece> getPiecesBlanches(){
        ArrayList<Piece> tabBlanc = new ArrayList<Piece>();
        for (Piece pi : this.tab){
            if (pi.getCouleur()=='B'){
                tabBlanc.add(pi);
            }
        }
        return tabBlanc ;
    }
    
    //getter piece noire
    public ArrayList<Piece> getPiecesNoires(){
        ArrayList<Piece> tabNoir = new ArrayList<Piece>();
        for (Piece pi : this.tab){
            if (pi.getCouleur()=='N'){
                tabNoir.add(pi);
            }
        }
        return tabNoir ;
    }

    // getter pieces
    public ArrayList<Piece> getPieces(){
        ArrayList<Piece> piece = new ArrayList<Piece>();
        for (Piece pi : this.tab){
            piece.add(pi);
        }
        return piece ;
    }


    // methode deplacement des pieces
    public boolean deplacer(Position from, Position to){
        ArrayList<Position> coup =this.getCase2(from).getDeplacementPossible(this);
        // si la case depart est une piece
        if (this.getCase2(from)!=null ){
            // Pour chaque position dans les coups possible de la piece
            for (Position c : coup){
                // si la case ou l'on veut aller est dans ces couts possible 
                if (to.toString().equals(c.toString())){
                    // On supprime la piece qui se trouve sur la case depart si il yen a une
                    if (this.getCase2(to)!= null){
                        tab.remove(this.getCase2(to));
                    }
                    // on change la piece de position
                    this.getCase2(from).setPosition(to);
                    // le deplacement a été effectué
                    return true;
                }
            }
        }
        return false;
    }

    // methode pour recuperer la longueur
    public int lenght(){
        int i =0;
        for (Piece p1 : tab){
            i+=1;
        }
        return i;
    }

    // getter du roi par couleur
    public Roi getRoi(char couleur){
        if (couleur =='B'){
            for (Piece pi : this.getPiecesBlanches()){
                if ( pi.getNomLong().contains("roi")){
                    return(new Roi(pi));
                }
            }
        }else {
            for (Piece pi : this.getPiecesNoires()){
                if (pi.getNomLong().contains("roi")){
                    return(new Roi(pi));
                }
            }
        }
        return null;
    }

    // methode qui definit si il ya echec selon la couleur
    public boolean estEchec(char couleur){
        for (Piece pi : this.tab){
            for (Position element : pi.getDeplacementPossible(this)){
                // si le roi de la couleur est dans les coups possible d'une piece de l'autre couleur alors il ya echec
                if (element.toString().equals(this.getRoi(couleur).getPosition().toString())){
                    return true;
                }
            }
        }
        return false;
    }

    // Methode de mise a jour graphique du plateau
    public void affiche(Fenetre f){

        // Dictionnaire image piece
        Hashtable<String, String> image=new Hashtable();
        image.put("PiB","./images/pion_B.png");
        image.put("CaB","./images/cavalier_B.png");
        image.put("ToB","./images/tour_B.png");
        image.put("FoB","./images/fou_B.png");
        image.put("RoB","./images/roi_B.png");
        image.put("DaB","./images/reine_B.png");
        image.put("PiN","./images/pion_N.png");
        image.put("CaN","./images/cavalier_N.png");
        image.put("ToN","./images/tour_N.png");
        image.put("FoN","./images/fou_N.png");
        image.put("RoN","./images/roi_N.png");
        image.put("DaN","./images/reine_N.png");

        f.ajouter(new Texture("./images/plat.jpg",new Point(0,0),800,800));
        
        // Pour chaque piece du plateau on place son image
        for (Piece p1 : this.tab){
            int i,j;
            Position pos=p1.getPosition();
            i=pos.getx()*100;
            j=pos.gety()*100;
            f.ajouter(new Texture(image.get(p1.getNomCourt()),new Point(i,j),100,100));
            
        }
        f.rafraichir();
    }
    
    // Methode d'ajout de piece
    public void ajt(Piece pie){
        tab.add(pie);
    }


}
