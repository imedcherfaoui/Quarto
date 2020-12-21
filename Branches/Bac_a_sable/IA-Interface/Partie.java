
import java.awt.Component;
import java.awt.Frame;
import java.io.*;


import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSeparatorUI;


public class Partie implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TableDeJeu jeu;
	private Joueur joueur1 ;
	private Joueur joueur2;
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

	public Pions getreserve(int i) {
		return jeu.getReserve(i);
	}

	public Pions getPlateau(int i , int j) {
		return jeu.getPlateau(i, j);
	}

	public Joueur getJoueur(int i) {
		if(i==1)return joueur1;
		else return joueur2;
	}

	public int prochJoueur () {
		return prochainJoueur;
	}


	public Pions getPions(int i) {
		return jeu.getReserve(i);
	}


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

	public void poserPions(Pions p, int i, int j) {

		if (prochainJoueur==0) {
			joueur1.poserPions(jeu, p, i, j);
		}
		else {
			joueur2.poserPions(jeu, p, i, j);	
		}

	}

public void setPartie(Partie p) {
	
	jeu=p.jeu;
	prochainJoueur=p.prochainJoueur;
	joueur1=p.joueur1;
	joueur2=p.joueur2;	
}


	//  Methode pour afficher la boite de dialogue si l un des joueur a gagner
	public void gagnerPartie() {
		if( jeu.testVictoire()) {
			int result;
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
				fen[0].dispose();
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

	
	public void sauvegarderPartie() {
		try {
			// ouverture d'un flux de sortie vers le fichier "personne.serial"
			FileOutputStream fos = new FileOutputStream("sauvegarde.txt");

			// création d'un "flux objet" avec le flux fichier
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			try {
				// sérialisation : écriture de l'objet dans le flux de sortie
				oos.writeObject(this);
				
				// on vide le tampon
				oos.flush();
				
				System.out.println("Sauvegarde réalisée avec succès !");
			} finally {
				// fermeture des flux
				try {
					oos.close();
				} finally {
					fos.close();
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Erreur IO lors de la sauvegarde de partie.");
		}
	}
	
	
	
	
	
	public void chargerPartie() {
		try {
			// ouverture d'un flux d'entrée depuis le fichier "partie.data"
			FileInputStream fis = new FileInputStream("sauvegarde.txt");
			// création d'un "flux objet" avec le flux fichier
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			try {
				// désérialisation : lecture de l'objet depuis le flux d'entrée
				this.setPartie((Partie) ois.readObject());
				System.out.println("Chargement réalisé avec succès !");
			} finally {
				// on ferme les flux
				try {
					ois.close();
				} finally {
					fis.close();
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Erreur IO lors du chargement de partie.");
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
			System.out.println("Erreur ClassNotFound lors de la désérialisation.");
		}
	}
	
	

}
