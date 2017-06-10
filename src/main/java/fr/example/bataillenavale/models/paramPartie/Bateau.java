package fr.example.bataillenavale.models.paramPartie;

public class Bateau {
	private int taille;
	private int x;
	private int y;
	private boolean orientation;
	private int vie;
	
	public Bateau() {
		super();
	}

	public Bateau(int taille, int x, int y, boolean orientation, int vie) {
		super();
		this.taille = taille;
		this.x = x;
		this.y = y;
		this.orientation = orientation;
		this.vie = vie;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isOrientation() {
		return orientation;
	}

	public void setOrientation(boolean orientation) {
		this.orientation = orientation;
	}

	public int getVie() {
		return vie;
	}

	public void setVie(int vie) {
		this.vie = vie;
	}
	
	
	
}
