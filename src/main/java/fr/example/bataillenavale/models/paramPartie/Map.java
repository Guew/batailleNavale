package fr.example.bataillenavale.models.paramPartie;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Map {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idMap;
	private int taille = 10;
	@Transient
	private List<Case> cases = new ArrayList<>();
	@Transient
	private List<Bateau> bateaux = new ArrayList<>();
	private int vieEnCours;

	public int getVieEnCours() {
		return vieEnCours;
	}

	public void setVieEnCours(int vieEnCours) {
		this.vieEnCours = vieEnCours;
	}

	@Override
	public String toString() {
		return "Map [taille=" + taille + ", grille=" + cases + ", bateaux=" + bateaux + "]";
	}

	public Map() {
		super();
		for (int y = 0; y < taille; y++) {
			for (int x = 0; x < taille; x++) {
				Case c = new Case(x, y);
				c.setStatut(statutCase.nonDecouvert);
				cases.add(c);
				
			}
		}
		this.ajouterBateau();
	}


	public long getIdMap() {
		return idMap;
	}

	public void setIdMap(long idMap) {
		this.idMap = idMap;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public List<Case> getGrille() {
		return cases;
	}

	public void setGrille(List<Case> grille) {
		this.cases = grille;
	}

	public List<Bateau> getBateaux() {
		return bateaux;
	}

	public void setBateaux(List<Bateau> bateaux) {
		this.bateaux = bateaux;
	}

	public void ajouterBateau() {
		Bateau b = new Bateau(5, 1, 1, true, 5);
		bateaux.add(b);
		vieEnCours=b.getVie();

		for (int i = 0; i < b.getTaille() ; i++) {
			Case e = cases.get(convertCoordToindex(b.getX() + i, b.getY()));
			e.setB(b);
			e.setStatut(statutCase.nonDecouvert);
		}

	}

	public void gereTir(Tir tir) {
		Case e = cases.get(convertCoordToindex(tir.x, tir.y));
		switch (e.getStatut()) {
		case nonDecouvert:
			e.setStatut(statutCase.decouvert);
			
			
			if (e.getB()!=null) {
				
				System.out.println("Boom");
				
				vieEnCours--;
				e.getB().setVie(vieEnCours);
				System.out.println("Votre bateau a " + e.getB().getVie() + " vie(s)");
			}else{
				System.out.println("Plouf");
			}
			
			
			break;
		case decouvert:
			System.out.println("Deja tiré");

			break;
		}
	}

	private int convertCoordToindex(int x, int y) {
		return (y * taille) + x;
	}

	public void affichageMap() {

		for (int y = 0; y < taille; y++) {
			for (int x = 0; x < taille; x++) {
				Case c = cases.get(convertCoordToindex(x, y));

				if (c.getB() != null) {
					System.out.print("0 ");
				} else  {
					System.out.print("- ");
				}

			}
			System.out.println();
		}

	}
}
