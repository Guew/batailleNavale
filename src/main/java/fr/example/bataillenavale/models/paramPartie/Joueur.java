package fr.example.bataillenavale.models.paramPartie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Joueur {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long idJoueur;
	private String nom;
	private Long partieGagne;
	
	@OneToOne
	private Partie p;
	
	@OneToMany(mappedBy="idPartie")
	private List<Partie> parties = new ArrayList<>();

	public Joueur() {
		super();
	}

	public Joueur(String nom, Long partieGag) {
		super();
		this.nom = nom;
		this.partieGagne = partieGag;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getPartieGag() {
		return partieGagne;
	}

	public void setPartieGag(Long partieGag) {
		this.partieGagne = partieGag;
	}

	public Partie getP() {
		return p;
	}

	public void setP(Partie p) {
		this.p = p;
	}

	


	@Override
	public String toString() {
		return "Joueur [nom=" + nom + "]";
	}

	public Partie CreerPartie() {
		Partie p = new Partie(this, 60, 0, this);
		this.p=p;
		p.demarrerPartie();
		p.setStatut(Statut.Ouvert);

		return p;
	}

	public void rejoindrePartie(Partie p) {
		if (p.getJ1()==null) {
			p.setJ1(this);
			this.p=p;
		} else {
			p.setJ2(this);
			this.p=p;
		}
		
		
		p.setStatut(Statut.Encours);
	}


	public void tir(int x,int y) {
			Tir t = new Tir(x, y, this);
			
			p.gererTir(t);

	}
	
	public void quitterPartie() {
		if (p.getJ1() == this) {
			p.setJ1(null);
			p.setStatut(Statut.Ouvert);
		} else {
			p.setJ2(null);
			p.setStatut(Statut.Ouvert);
		}
	
		
	}

}
