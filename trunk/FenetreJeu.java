
import java.io.IOException;
/**
 * @author CHAIBI Yamina
*
 **/
public class FenetreJeu {
	/**
	 *  Méthode main de notre jeu !
	 *  Permet d'instancier la 1ere JFrame
	 *   **/
		// Lancer la fenetre du jeu 
	public static void main(String[] agrs) {
	    Fenetre1 fen1 = new Fenetre1();
	    try {
			fen1.buildPanel();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	     
		
	}
		
		
}