package fr.example.bataillenavale.models.paramPartie;

public class Tir {

		int x;
		int y;
		Joueur joueurEnCours;
		
		
		public Tir() {
			super();
		}


		public Tir(int x, int y, Joueur joueurEnCours) {
			super();
			this.x = x;
			this.y = y;
			this.joueurEnCours = joueurEnCours;
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


		public Joueur getJoueurEnCours() {
			return joueurEnCours;
		}


		public void setJoueurEnCours(Joueur joueurEnCours) {
			this.joueurEnCours = joueurEnCours;
		}
		
		
}
