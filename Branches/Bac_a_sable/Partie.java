package TableDeJeu;
import java.io.*;



public class Partie {

	
	private TableDeJeu Jeu;
	private Joueur Joueurs[];
	private Joueur ProchainJoueur;

	
	//Constructeur cas 1 Joueur humain
	public Partie(Niveaux Niveau) {
		Joueurs = new Joueur[2];
	
		
		this.Joueurs[1]= new JoueurHumain(1);
		this.Joueurs[2]= new JoueurIA(Niveau, 2);
	}
	
	
	//Constructeur cas 2 Joueurs humains,
 	public Partie () {
		Joueurs = new Joueur[2];
		
		this.Joueurs[1]= new JoueurHumain(1);
		this.Joueurs[2]= new JoueurHumain(2);	
	}
	
	
	//Méthodes pour sauvgarder une partie
	public void sauvarderPartie() throws IOException {
		ObjectOutputStream  fic= null;
		try {
			fic =new ObjectOutputStream( 
					new BufferedOutputStream( 
							new FileOutputStream(
									new File("sauvgarde.txt"))));
			
			fic.writeObject(Jeu);
			fic.writeObject(ProchainJoueur);
			fic.writeObject(Joueurs);
	
			
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
		return Jeu.testVictoire();
	}
	
	
}
