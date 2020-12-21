
/**
 * 
 * @author BOUZIDI Siham
 *
 */
import java.io.Serializable;
/**
*Classe Joueur, g�re les pions choisis et pos�s par chaque joueur
*le joueur est identifi� par son num�ro
 **/
public class Joueur implements Serializable{ 
	
	private static final long serialVersionUID = 1L;
	// Attribut 
	protected static int numero;
	//Constructeur
	protected Joueur(int numero) {
		this.numero=numero;
	}	
	//M�thode pour choisir un Pions
	public Pions choisirPions(TableDeJeu jeu , int i) {
			return jeu.choisirPions(i);
		}
		
	//
	public void poserPions( TableDeJeu jeu, Pions p, int i, int j) {
		jeu.poserPions(p,i, j);
		}
		
}