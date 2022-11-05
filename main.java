import MG2D.* ;
import MG2D.geometrie.* ;
import java.util.ArrayList;
import java.lang.Thread;
class main {

    public static void main(String[] args) throws InterruptedException{
        // definition des variables
        int joueur=1;
        Fenetre f = new Fenetre ( "test mgl", 800, 800 );
        Plateau plat = new Plateau();
        plat.affiche(f);
        Souris souris=f.getSouris();
        Position from=new Position();
        int clic=0;
        boolean fini =false;
        boolean verif =false;
        while(fini==false){
            // Pour le joueur 1
            if (joueur==1){
                verif =false;
                System.out.print("");
                // Tant qu'on est dans une situation d'echec on va detecter les clics
                while (plat.estEchec('B')==true ){
                    if (souris.getClicGauche()){
                        // recupere la case cliqué
                        int i,j;
                        Point p1 =souris.getPosition();
                        i=p1.getX()/100;
                        j=p1.getY()/100;
                        // si on est pas a premier clic on met a jour la variable
                        if(clic!=0){
                            clic+=1;
                        }
                        // On initialise la piece sauvegardé
                        Piece sauv = plat.getCase(i, j);
                        // Si la case joué est une piece et de la couleur du joueur
                        if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='B' ){
                            ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                            // on affiche le plateau
                            plat.affiche(f);
                            // on parcours les coups possible de la piece
                            for (Position p2 : tab){ 
                                // recuperation de la position de base
                                Position pos =plat.getCase(i, j).getPosition();
                                // si il ya une piece a l'endroit du coup possible on la sauvegarde
                                if (plat.getCase2(p2)!=null){
                                    sauv =plat.getCase2(p2);
                                }
                                // on verifie si on peut jouer le coup possible
                                if (plat.deplacer(plat.getCase(i, j).getPosition(),p2));
                                // une fois joué on verifie si ce coup ne nous a pas mis en echec si non on rajoute un cercle pour le coup possible
                                if (plat.estEchec('B')==false){
                                    f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                                }
                                // on dejoue le coup et on rajoute la piece qu'on a pris si il y en avait une 
                                plat.deplacer(p2,pos);
                                plat.ajt(sauv);
                            }
                            f.rafraichir();
                            // si on est au premier clic on met a jour la variable
                            if (clic==0){
                                clic+=1;
                            }
                            // on implement la position from par la position de notre premier clic
                            if (clic ==1){
                                from = new Position(i,j);
                            }
                        }
                        // Si on est au deuxieme clic
                        if (clic==2){
                            // On actualise et recupere les coordonnées de la souris
                            plat.affiche(f);
                            Point p3 =souris.getPosition();
                            i=p3.getX()/100;
                            j=p3.getY()/100;
                            Position to = new Position(i,j);
                            // On verifie que le coup qu'on veut jouer et jouable et ne nous met pas en echec
                            if ( plat.deplacer(from, to) && plat.estEchec('B')==false){
                                // si oui on dejoue ce coup la 
                                plat.deplacer(to,from);
                                // on indique que le coup est bien joué 
                                verif=true;
                                if (plat.deplacer(from, to)){
                                    // on joue le coup et actualise le plateau
                                    plat.affiche(f);
                                    // en cas de situation d'echec on l'affiche 
                                    if (plat.estEchec('N')){
                                        int roix=plat.getRoi('N').getPosition().getx();
                                        int roiy=plat.getRoi('N').getPosition().gety();
                                        f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                                    }
                                    f.rafraichir();
                                    // on change de joueur
                                    joueur=2;
                                }
                                clic=0;
                            }
                            
                            // si la case cliqué est mauvaise on réaffiche les coups possible
                            else{
                                // on recupere notre erreur
                                Position error = plat.getCase2(to).getPosition();
                                // on dejoue le coup erreur
                                plat.deplacer(to,from);
                                // Affichage des coups possible
                                ArrayList<Position> tab2 = plat.getCase2(from).getDeplacementPossible(plat);
                                    for (Position p2 : tab2){
                                        // on retire l'erreur des coups possible
                                        if ((p2.getx()==error.getx() && p2.gety()==error.gety())==false){
                                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                                        }
                                    }
                                    f.rafraichir();
                                // tant que le coup n'est pas joué
                                while (verif==false){
                                    // on fait une pause 
                                    Thread.sleep(500);
                                    // on detecte le clic pour la nouvelle case a jouer 
                                    if (souris.getClicGauche()){
                                        plat.affiche(f);
                                        Point p4 =souris.getPosition();
                                        i=p4.getX()/100;
                                        j=p4.getY()/100;
                                        Position to2 = new Position(i,j);
                                        // si le coup est jouable
                                        if (plat.deplacer(from, to2) && plat.estEchec('B')==false){
                                            // on dejoue le coup
                                            plat.deplacer(to2,from);
                                            // on indique que le coup est joué 
                                            verif=true;
                                            // on joue le coup et actualise le plateau
                                            if (plat.deplacer(from, to2)){
                                                plat.affiche(f);
                                                // on affiche si on est en situation d'echec
                                                if (plat.estEchec('N')){
                                                    int roix=plat.getRoi('N').getPosition().getx();
                                                    int roiy=plat.getRoi('N').getPosition().gety();
                                                    f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                                                }
                                                f.rafraichir();
                                                // on change de joueur
                                                joueur=2;
                                            }
                                            clic=0;
                                        }
                                    }
                                }
                            }  
                        }
                    }
                    
                }
                // On est pas dans une situation d'echec donc on va detecter les clics
                if (souris.getClicGauche()){
                    // recupere la case cliqué
                    int i,j;
                    Point p1 =souris.getPosition();
                    i=p1.getX()/100;
                    j=p1.getY()/100;
                    // si on est pas a premier clic on met a jour la variable
                    if(clic!=0){
                        clic+=1;
                    }
                    // Si la case joué est une piece et de la couleur du joueur
                    if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='B'){
                        ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                        plat.affiche(f);
                        // on parcours les coups possible et on rajoute des cercle pour les coups possible
                        for (Position p2 : tab){
                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                        }
                        f.rafraichir();
                        // mise a jour des clics
                        if (clic==0){
                            clic+=1;
                        }
                        if (clic ==1){
                            from = new Position(i,j);
                        }
                    }
                    if (clic==2){
                        // on recupere le 2eme clic 
                        plat.affiche(f);
                        Point p3 =souris.getPosition();
                        i=p3.getX()/100;
                        j=p3.getY()/100;
                        Position to = new Position(i,j);
                        // on verifie si le deplacement est possible si oui on affiche le plateau mis a jour
                        if (plat.deplacer(from, to)){
                            plat.affiche(f);
                            // verification et affichage de la situation d'echec
                            if (plat.estEchec('N')){
                                int roix=plat.getRoi('N').getPosition().getx();
                                int roiy=plat.getRoi('N').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            f.rafraichir();
                            // changement de joueur
                            joueur=2;
                        }
                        clic=0;
                    }
                }
            }
            // Pour le joueur 2 
            if (joueur==2){
                verif =false;
                System.out.print("");
                // Tant qu'on est dans une situation d'echec on va detecter les clics
                while (plat.estEchec('N')==true ){
                    if (souris.getClicGauche()){
                        // on recupere la case ou on a cliqué
                        int i,j;
                        Point p1 =souris.getPosition();
                        i=p1.getX()/100;
                        j=p1.getY()/100;
                        if(clic!=0){
                            clic+=1;
                        }
                        Piece sauv = plat.getCase(i, j);
                        // Si la case joué est une piece et de la couleur du joueur
                        if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='N' ){
                            ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                            plat.affiche(f);
                            // On parcours les coups possible
                            for (Position p2 : tab){ 
                                Position pos =plat.getCase(i, j).getPosition();
                                // si il ya une piece a l'endroit du coup possible on la sauvegarde
                                if (plat.getCase2(p2)!=null){
                                    sauv =plat.getCase2(p2);
                                }
                                // On joue le coup si possible
                                if (plat.deplacer(plat.getCase(i, j).getPosition(),p2));
                                // Si on est pas en echec avec ce coup on l'affiche
                                if (plat.estEchec('N')==false){
                                    f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                                }
                                // on annule notre coup et on replace la piece prise si il yen a eu une
                                plat.deplacer(p2,pos);
                                plat.ajt(sauv);
                            }
                            // mise a jour
                            f.rafraichir();
                            if (clic==0){
                                clic+=1;
                            }
                            if (clic ==1){
                                from = new Position(i,j);
                            }
                        }
                        if (clic==2){
                            // On actualise et recupere les coordonnées de la souris
                            plat.affiche(f);
                            Point p3 =souris.getPosition();
                            i=p3.getX()/100;
                            j=p3.getY()/100;
                            Position to = new Position(i,j);
                            // On verifie que le coup qu'on veut jouer et jouable et ne nous met pas en echec
                            if ( plat.deplacer(from, to) && plat.estEchec('N')==false){
                                // si oui on dejoue ce coup la 
                                plat.deplacer(to,from);
                                // on indique que le coup est bien joué 
                                verif=true;
                                if (plat.deplacer(from, to)){
                                    // on joue le coup et actualise le plateau
                                    plat.affiche(f);
                                    // en cas de situation d'echec on l'affiche 
                                    if (plat.estEchec('B')){
                                        int roix=plat.getRoi('B').getPosition().getx();
                                        int roiy=plat.getRoi('B').getPosition().gety();
                                        f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                                    }
                                    f.rafraichir();
                                    // on change de joueur
                                    joueur=1;
                                }
                                clic=0;
                            }
                            // si la case cliqué est mauvaise on réaffiche les coups possible
                            else{
                                // on recupere notre erreur
                                Position error = plat.getCase2(to).getPosition();
                                // on dejoue le coup erreur
                                plat.deplacer(to,from);
                                // Affichage des coups possible
                                ArrayList<Position> tab2 = plat.getCase2(from).getDeplacementPossible(plat);
                                    for (Position p2 : tab2){
                                        // on retire l'erreur des coups possible
                                        if ((p2.getx()==error.getx() && p2.gety()==error.gety())==false){
                                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                                        }
                                    }
                                    f.rafraichir();
                                // tant que le coup n'est pas joué
                                while (verif==false){
                                    // on fait une pause 
                                    Thread.sleep(500);
                                    // on detecte le clic pour la nouvelle case a jouer 
                                    if (souris.getClicGauche()){
                                        plat.affiche(f);
                                        Point p4 =souris.getPosition();
                                        i=p4.getX()/100;
                                        j=p4.getY()/100;
                                        Position to2 = new Position(i,j);
                                        // si le coup est jouable
                                        if (plat.deplacer(from, to2) && plat.estEchec('N')==false){
                                            // on dejoue le coup
                                            plat.deplacer(to2,from);
                                            // on indique que le coup est joué 
                                            verif=true;
                                            // on joue le coup et actualise le plateau
                                            if (plat.deplacer(from, to2)){
                                                plat.affiche(f);
                                                // on affiche si on est en situation d'echec
                                                if (plat.estEchec('B')){
                                                    int roix=plat.getRoi('B').getPosition().getx();
                                                    int roiy=plat.getRoi('B').getPosition().gety();
                                                    f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                                                }
                                                f.rafraichir();
                                                // on change de joueur
                                                joueur=1;
                                            }
                                            clic=0;
                                        }
                                    }
                                }
                            }  
                            
                        }
                    }
                    
                }
                // On est pas dans une situation d'echec donc on va detecter les clics
                if (souris.getClicGauche()){
                    // recuperation de la position cliqué
                    int i,j;
                    Point p1 =souris.getPosition();
                    i=p1.getX()/100;
                    j=p1.getY()/100;
                    if(clic!=0){
                        clic+=1;
                    }
                    // Si la case est une piece et de la bonne couleur
                    if (plat.getCase(i, j)!=null && plat.getCase(i, j).getCouleur()=='N'){
                        ArrayList<Position> tab = plat.getCase(i, j).getDeplacementPossible(plat);
                        plat.affiche(f);
                        // on ajoute les cercle pour les coups possible
                        for (Position p2 : tab){
                            f.ajouter(new Texture("./images/Cercle.png",new Point(p2.getx()*100, p2.gety()*100),100,100));
                        }
                        // mise a jour
                        f.rafraichir();
                        if (clic==0){
                            clic+=1;
                        }
                        if (clic ==1){
                            from = new Position(i,j);
                        }
                    }
                    // si on est au deuxieme clic
                    if (clic==2){
                        // on recupere la case cliqué
                        plat.affiche(f);
                        Point p3 =souris.getPosition();
                        i=p3.getX()/100;
                        j=p3.getY()/100;
                        Position to = new Position(i,j);
                        // Si un deplacement est possible on le fait
                        if (plat.deplacer(from, to)){
                            plat.affiche(f);
                            // On verifie et affiche la situation d'echec
                            if (plat.estEchec('B')){
                                int roix=plat.getRoi('B').getPosition().getx();
                                int roiy=plat.getRoi('B').getPosition().gety();
                                f.ajouter(new Texture("./images/Cercle_echec.png",new Point(roix*100, roiy*100),100,100));
                            }
                            f.rafraichir();
                            // changement de joueur
                            joueur=1;
                        }
                        clic=0;
                    }
                }
            }
        }
    }
}