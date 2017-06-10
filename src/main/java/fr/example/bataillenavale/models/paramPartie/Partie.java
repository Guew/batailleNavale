package fr.example.bataillenavale.models.paramPartie;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Partie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long idPartie;
	
	@OneToOne
	private Joueur j1;
	
	@OneToOne
	private Joueur j2;
	@OneToOne
	private Joueur JoueurEnCours;

	private int nbtours = 60;
	private int tourEnCours = 0;
	@Enumerated
	private Statut statut;
	@OneToOne
	private Joueur gagnant;
	@Enumerated
	private StatutPartie condi;

	@OneToOne
	private Map map1;
	@OneToOne
	private Map map2;

	public Partie() {
		super();
	}

	public Partie(Joueur j1, int nbtours, int tourEnCours, Joueur joueurEnCours) {
		super();
		this.j1 = j1;
		this.nbtours = nbtours;
		this.tourEnCours = tourEnCours;
		JoueurEnCours = joueurEnCours;

		;
	}

	public StatutPartie getCondi() {
		return condi;
	}

	public void setCondi(StatutPartie condi) {
		this.condi = condi;
	}

	public Map getMap1() {
		return map1;
	}

	public void setMap1(Map map1) {
		this.map1 = map1;
	}

	public Map getMap2() {
		return map2;
	}

	public void setMap2(Map map2) {
		this.map2 = map2;
	}

	@Override
	public String toString() {
		return "Partie [j1=" + j1 + ", j2=" + j2 + ", JoueurEnCours=" + JoueurEnCours + ", nbtours=" + nbtours
				+ ", tourEnCours=" + tourEnCours + ", statut=" + statut + ", gagnant=" + gagnant + ", map1=" + map1
				+ ", map2=" + map2 + "]";
	}

	public Joueur getJ1() {
		return j1;
	}

	public void setJ1(Joueur j1) {
		this.j1 = j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public void setJ2(Joueur j2) {
		this.j2 = j2;
	}

	public int getNbtours() {
		return nbtours;
	}

	public void setNbtours(int nbtours) {
		this.nbtours = nbtours;
	}

	public int getTourEnCours() {
		return tourEnCours;
	}

	public void setTourEnCours(int tourEnCours) {
		this.tourEnCours = tourEnCours;
	}

	public Joueur getJoueurEnCours() {
		return JoueurEnCours;
	}

	public void setJoueurEnCours(Joueur joueurEnCours) {
		JoueurEnCours = joueurEnCours;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

	public Joueur getGagnant() {
		return gagnant;
	}

	public void setGagnant(Joueur gagnant) {
		this.gagnant = gagnant;
	}

	public void gererTir(Tir tir) {

		this.conditVictoire();
		this.tourEnCours++;
		this.setTourEnCours(this.tourEnCours);
		long partieWin=0;
		switch (this.getCondi()) {

		case termineNb:
			
			System.out.println("La partie est terminé ! Le nombre de tour est dépassée");
			if (this.getMap1().getVieEnCours() > this.getMap2().getVieEnCours()) {
				System.out.println("Joueur " + this.getJ1().getNom() + " Vous êtes le vainqueur !");
				
				partieWin++;
				this.getJ1().setPartieGag(partieWin);
				
			} else {
				System.out.println("Joueur :" + this.getJ2().getNom() + " Vous êtes le vainqueur !");
			
				partieWin++;
				this.getJ2().setPartieGag(partieWin);
				System.out.println(partieWin);
			}
			break;

		case termineJ1:
			System.out.println("Joueur :" + this.getJ1().getNom() + " Vous êtes le vainqueur !");
			
			partieWin++;
			this.getJ1().setPartieGag(partieWin);
			break;

		case termineJ2:
			System.out.println("Joueur :" + this.getJ2().getNom() + " Vous êtes le vainqueur !");
			
			partieWin++;
			this.getJ2().setPartieGag(partieWin);
			break;

		default:
			if (this.getJoueurEnCours() == this.getJ1()) {
				System.out.println("Tir Joueur 1 ");

				map2.gereTir(tir);
				System.out.println("Piuu piuu - Tir de " + this.getJoueurEnCours().getNom());
				this.setJoueurEnCours(this.getJ2());
				System.out.println(j1.getNom() + " : Vous êtes au tour : " + tourEnCours);
				

			} else {

				System.out.println("Tir Joueur 2 ");

				map1.gereTir(tir);
				System.out.println("Piuu piuu - Tir de " + this.getJoueurEnCours().getNom());
				this.setJoueurEnCours(this.getJ1());
				System.out.println(j2.getNom() + " : Vous êtes au tour : " + tourEnCours);
			}
			break;
		}
		
	}

	public void conditVictoire() {
		
		
		if (this.getTourEnCours() > this.getNbtours()) {
			
			System.out.println("Condition partie - nbTour");
			this.setCondi(StatutPartie.termineNb);
			System.out.println("CondiVictoire: " + this.getCondi());
			return;
		}
		if (this.getMap1().getVieEnCours() == 0) {
			System.out.println("Condition partie - J2");
			this.setCondi(StatutPartie.termineJ2);
			return;
		}
		if (this.getMap2().getVieEnCours() == 0) {
			System.out.println("Condition partie - J1");
			this.setCondi(StatutPartie.termineJ1);
		} else {
			
			System.out.println("Condition partie - En cours");
			this.setCondi(StatutPartie.enCours);
		}
	}

	public void demarrerPartie() {
		map1 = new Map();
		map2 = new Map();
	}

}