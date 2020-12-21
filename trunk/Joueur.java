
/**
 * 
 * @author BOUZIDI Siham
 *
 */
import java.io.Serializable;
/**
*Classe Joueur, gére les pions choisis et posés par chaque joueur
*le joueur est identifié par son numéro
 **/
public class Joueur implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	// Attribut 
	protected static int numero;
	//Constructeur
	protected Joueur(int numero) {
		this.numero=numero;
	}	
	//Méthode pour choisir un Pions
	public Pions choisirPions(TableDeJeu jeu , int i) {
			return jeu.choisirPions(i);
		}
		
	//
	public void poserPions( TableDeJeu jeu, Pions p, int i, int j) {
		jeu.poserPions(p,i, j);
		}
		
}