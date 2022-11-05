import MG2D.* ;
import MG2D.geometrie.* ;
import java.util.ArrayList;
import java.util.*;
class MainGraphique {

    public static void main(String[] args){
        int joueur=1;
        Fenetre f = new Fenetre ( "test mgl", 800, 800 );
        Plateau plat = new Plateau();
        plat.affiche(f);
        Souris souris=f.getSouris();
        Position from=new Position();
        int clic=0;
        boolean fini =false;
        while(fini==false){
            if (joueur==1){
                System.out.println(" ");
                if (souris.getClicGauche()){
                    int i,j;
                    Point p1 =souris.getPosition();
                    i=p1.getX()/100;
                    j=p1.getY()/100;
                    if(clic!=0){
                        clic+=1;
                    }
                    if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='B'){
                        ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                        plat.affiche(f);
                        for (Position p2 : tab){
                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                        }
                        f.rafraichir();
                        if (clic==0){
                            clic+=1;
                        }
                        if (clic ==1){
                            from = new Position(i,j);
                        }
                    }
                    System.out.println(clic);
                    if (clic==2){
                        plat.affiche(f);
                        Point p3 =souris.getPosition();
                        i=p3.getX()/100;
                        j=p3.getY()/100;
                        Position to = new Position(i,j);
                        if (plat.deplacer(from, to)){
                            plat.affiche(f);
                            if (plat.estEchec('B')){
                                int roix=plat.getRoi('B').getPosition().getx();
                                int roiy=plat.getRoi('B').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            if (plat.estEchec('N')){
                                int roix=plat.getRoi('N').getPosition().getx();
                                int roiy=plat.getRoi('N').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            f.rafraichir();
                            joueur=2;
                        }
                        clic=0;
                    }
                }
            }
            if (joueur==2){
                System.out.println(" ");
                if (souris.getClicGauche()){
                    int i,j;
                    Point p1 =souris.getPosition();
                    i=p1.getX()/100;
                    j=p1.getY()/100;
                    if(clic!=0){
                        clic+=1;
                    }
                    if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='N'){
                        ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                        plat.affiche(f);
                        for (Position p2 : tab){
                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                        }
                        f.rafraichir();
                        if (clic==0){
                            clic+=1;
                        }
                        if (clic ==1){
                            from = new Position(i,j);
                        }
                    }
                    System.out.println(clic);
                    if (clic==2){
                        plat.affiche(f);
                        Point p3 =souris.getPosition();
                        i=p3.getX()/100;
                        j=p3.getY()/100;
                        Position to = new Position(i,j);
                        if (plat.deplacer(from, to)){
                            plat.affiche(f);
                            if (plat.estEchec('B')){
                                int roix=plat.getRoi('B').getPosition().getx();
                                int roiy=plat.getRoi('B').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            if (plat.estEchec('N')){
                                int roix=plat.getRoi('N').getPosition().getx();
                                int roiy=plat.getRoi('N').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            f.rafraichir();
                            joueur=1;
                        }
                        clic=0;
                    }
                }
            }
        }
    }
}