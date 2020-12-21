
import java.io.*;



public class Partie {

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

	public Joueur getJoueur(int i) {
		if(i==1)return joueur1;
		else return joueur2;
	}

	public void prochJoueur () {
		prochainJoueur= (prochainJoueur+1)%2;
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
			prochainJoueur= (prochainJoueur+1)%2;
			joueur1.poserPions(jeu, p, i, j);
		}
		else {
			prochainJoueur= (prochainJoueur+1)%2;
			joueur2.poserPions(jeu, p, i, j);	
		}
		
	}
	
	

	
	//Méthodes pour sauvgarder une partie
	public void sauvarderPartie() throws IOException {
		ObjectOutputStream  fic= null;
		try {
			fic =new ObjectOutputStream( 
					new BufferedOutputStream( 
							new FileOutputStream(
									new File("sauvgarde.txt"))));
			
			fic.writeObject(jeu);
			fic.writeInt(prochainJoueur);
			fic.writeObject(joueur1);
			fic.writeObject(joueur2);
	
			
			fic.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	//Méthode pour charger une partie
	public void chargerPartie () throws IOException  {
		ObjectInputStream fic= null;
		try {
			fic =new ObjectInputStream( 
					new BufferedInputStream( 
							new FileInputStream(
									new File("sauvgarde.txt"))));
			
			fic.readObject();
			
			
			fic.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean gagnerPartie() {
		return jeu.testVictoire();
	}
	
	
}
