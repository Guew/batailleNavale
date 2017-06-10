package fr.example.bataillenavale.models.paramPartie;

public class Case {
	private int x;
	private int y;
	private statutCase statut = statutCase.nonDecouvert;
	private statutBateau statutBat;

	private Bateau b;
	
	@Override
	public String toString() {
		return "Case [x=" + x + ", y=" + y + ", statut=" + statut + ", b=" + b + "]";
	}
	
	public statutBateau getStatutBat() {
		return statutBat;
	}




	public void setStatutBat(statutBateau statutBat) {
		this.statutBat = statutBat;
	}



	public Bateau getB() {
		return b;
	}



	public void setB(Bateau b) {
		this.b = b;
	}



	public Case() {
		super();
	}

	
	
	public Case(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}



	public Case(int x, int y, statutCase statut) {
		super();
		this.x = x;
		this.y = y;
		this.statut = statut;
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


	public statutCase getStatut() {
		return statut;
	}

	public void setStatut(statutCase statut) {
		this.statut = statut;
	}
	
	
}
