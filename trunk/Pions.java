/**
 * 
 * @author BOUZIDI Siham
 * 
 * Pions avec toute leurs propriétés 
 * Utilisation des -1 et 1 pour les propriétés, dans le but de faciliter la gestion des pions 
 * 
 *
 */

import java.io.Serializable;

public class Pions implements Serializable {
	
	private static final long serialVersionUID = 1L;
	// Attribut
	private int  couleur; // 1 Pour la couleur NOIR et 0 pour la couleur BLANC
	private int  forme; // 1 pour la forme CARRE et 0 pour la forme ROND
	private int  taille; // 1 pour la taille GRAND et 0 pour la taille PETIT
	private int  creux; // 1 pour Creux et 0 pour pas Creux
	private boolean situation ; // true si le pion est placé false sinon
	private int indice ; //indice du pions
	
	// Constructeur
	public Pions (int couleur, int forme, int taille, int creux, int indice) {
		this.couleur=couleur;
		this.forme=forme;
		this.taille=taille;
		this.creux=creux;
		this.indice= indice;
		this.situation=false;
		}


	public void setSituation(boolean situation) {
		this.situation=situation;
	}
	
	public boolean getSituation() {
		return situation;
	}
	public int getCouleur() {
		return couleur;
	}
	
	public int getForme() {
		return forme;
	}
	
	public int getTaille() {
		return taille;
	}

	public int getCreux() {
		return creux;
	}
	
	public int getIndice() {
		return indice;
	}
	

}

