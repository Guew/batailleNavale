package fr.example.bataillenavale.models.paramPartie;

public class LauncherTest {

    public static void main(String[] args) {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();

        j1.setNom("Luc");
        j2.setNom("Jean");

        
        Partie p = j1.CreerPartie();
        
        

        
        
        j2.rejoindrePartie(p);
       
        
        p.getMap1().affichageMap();
        System.out.println("-----------------------");
        
        p.getMap2().affichageMap();

        System.out.println("-----------------------");
        System.out.println("Joueur 1 " +p.getJ1().getNom() + "Vie :"+ p.getMap1().getVieEnCours());
        System.out.println("Joueur 1 " +p.getJ2().getNom() + "Vie :"+p.getMap2().getVieEnCours());
        System.out.println("Nbtour : " + p.getNbtours());
        System.out.println("Tour en Cours : " + p.getTourEnCours());
        
        System.out.println("-----------------------");
        j1.tir(1, 1);
        System.out.println("-----------------------");
        j1.tir(1, 1);
        System.out.println("-----------------------");
        j1.tir(1, 1);
        System.out.println("-----------------------");
        j2.tir(2, 1);
        System.out.println("-----------------------");
        j1.tir(2, 1);
        System.out.println("-----------------------");
        j2.tir(3, 1);
        System.out.println("-----------------------");
        j1.tir(3, 1);
        System.out.println("-----------------------");
        j2.tir(4, 1);
        System.out.println("-----------------------");
        j1.tir(4, 1);
        System.out.println("-----------------------");
        j2.tir(5, 1);
        System.out.println("-----------------------");
        j1.tir(5, 1);
        System.out.println("-----------------------");
        
        
        System.out.println("-----------------------");
        System.out.println("Vie Joueur 1 " + p.getMap1().getVieEnCours()+" - Nombre de victoire "+p.getJ1().getPartieGag());
        System.out.println("Vie Joueur 2 "+p.getMap2().getVieEnCours()+" - Nombre de victoire "+p.getJ2().getPartieGag());
       
        
        System.out.println("-----------------------");
    }
    }
