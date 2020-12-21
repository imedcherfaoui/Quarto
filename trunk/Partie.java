/**
 * 
 * @author BOUZIDI Siham 
 * 
 * Partie pour jouer a deux joueurs 
 *
 */


import java.awt.Component;
import java.awt.Frame;
import java.io.*;
import javax.swing.JOptionPane;


public class Partie implements Serializable{


	private static final long serialVersionUID = 1L;
	private TableDeJeu jeu;
	private Joueur joueur1 ;
	private Joueur joueur2;
	//Determine le joueur qui doit jouer
	private int prochainJoueur;




	//Constructeur cas 1 Joueur humain
	public Partie(int niveau) { 

		this.joueur1= new Joueur(1);
		this.joueur2= new JoueurIA( niveau, 2);
		this.jeu= new TableDeJeu();
		this.prochainJoueur=0;
	}

	//Constructeur cas 2 Joueurs humains,
	public Partie() {
		this.joueur1= new Joueur(1);
		this.joueur2= new Joueur(2);
		this.jeu= new TableDeJeu();
		this.prochainJoueur=0;

	}
	
	public Pions getPions(int i) {
		return jeu.getReserve(i);
	}

	public int prochJoueur() {
		return prochainJoueur;
	}
	public Pions getPlateau(int i , int j) {
		return jeu.getPlateau(i, j);
	}

	//Fonction pour choisir un pion 
	public Pions choisirPion(int i) {
		if (prochainJoueur==0) {
			prochainJoueur= (prochainJoueur+1)%2;
			return joueur1.choisirPions(jeu, i);
		}
		else {
			prochainJoueur= (prochainJoueur+1)%2;
			return joueur2.choisirPions(jeu, i);

		}
	}
	
	//Méthode pour poser un pion 
	public void poserPions(Pions p, int i, int j) {

		if (prochainJoueur==0) {
			joueur1.poserPions(jeu, p, i, j);
		}
		else {
			joueur2.poserPions(jeu, p, i, j);	
		}

	}

	//  Methode pour afficher la boite de dialogue si l un des joueur a gagner
	public void gagnerPartie() {
		if( jeu.testVictoire()) {
			int result;
			//Si le joueur a gagner
			if(prochainJoueur==0) {
				result = JOptionPane.showConfirmDialog((Component) null, "BRAVO Joueur1 !! \nVous avez gagné",
						"Message", JOptionPane.DEFAULT_OPTION);

			}
			else {
				result = JOptionPane.showConfirmDialog((Component) null, "BRAVO Joueur2 !! \nVous avez gagné",
						"Message", JOptionPane.DEFAULT_OPTION);
			}

			if(result==0) {
				Frame[]  fen = Fenetre6.getFrames();
				for(int i=0; i<fen.length;i++){
					fen[i].dispose();
				}
				Fenetre1 fen1 = new Fenetre1();
				try {
					fen1.buildPanel();
				} catch (IOException e) {

					e.printStackTrace();
				}
				fen1.setVisible(true);	
			}
			else {
				System.exit(0);

			}

		}
	}


	



}
