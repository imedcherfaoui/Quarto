
/**
 * 
 * @author BOUZIDI Siham

 * 
 * Partie pour jouer contre l'ordinateur 
 *
 */

import java.awt.Component;
import java.awt.Frame;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class PartieIA extends Partie implements Serializable{

	private static final long serialVersionUID = 1L;
	private JoueurIA joueur2;
	private TableDeJeu jeu;
	private Joueur joueur1 ;
	private int prochainJoueur;

	//Constructeur cas 2 Joueurs humains,
	public PartieIA(int niv) {
		this.joueur1= new Joueur(1);
		this.joueur2= new JoueurIA(niv,2);
		this.jeu= new TableDeJeu();
		this.prochainJoueur=0;
	}
	
	public Pions getreserve(int i) {
		return jeu.getReserve(i);
	}

	public Pions getPlateau(int i , int j) {
		return jeu.getPlateau(i, j);
	}



	public Pions getPions(int i) {
		return jeu.getReserve(i);
	}

	public Pions choisirPion(int i) {
		return joueur1.choisirPions(jeu,i);
	}
	
	 
	public void poserPions(Pions p,int i, int j) {
		prochainJoueur= (prochainJoueur+1)%2;
		joueur1.poserPions(jeu, p, i, j);
	}
	
	//Le joueur 2 (LIA) pose le pion passer en argument et renvoie un pion 
	public Pions joueIA(Pions p) {
		prochainJoueur= (prochainJoueur+1)%2;
		return joueur2.meilleurCoup(jeu, p);
		
	}

	//Génere des boites de dialogue si l un des joueur a gagner 
	public void gagnerPartie() {
		if( jeu.testVictoire()) {
			int result;
			if(prochainJoueur==0) {
				result = JOptionPane.showConfirmDialog((Component) null, "BRAVO!! \nVous avez gagné",
						"Message", JOptionPane.DEFAULT_OPTION);

			}
			else {
				result = JOptionPane.showConfirmDialog((Component) null, "Vous avez perdu",
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
	
	public int getI() {
		return joueur2.getI();
	}
	
	public int getJ() {
		return joueur2.getJ();
	}


}
