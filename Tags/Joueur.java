package TableDeJeu; 

public class Joueur {
	
	// Attrinut 
	protected static int numero;
	

	//Constructeur
	protected Joueur(int numero) {
		this.numero=numero;
	}	
	
	//Méthode pour choisir un Pions
	public Pions choisirPions(TableDeJeu jeu , int i) {
			return jeu.choisirPions(i);
		}
		

	public void poserPions( TableDeJeu jeu, Pions p, int i, int j) {
		jeu.poserPions(p,i, j);
		}
		
}