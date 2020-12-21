
import java.io.IOException;


public class FenetreJeu {

		// Lancer la fenetre
	public static void main(String[] agrs) {
	    Fenetre1 fen1 = new Fenetre1();
	    try {
			fen1.buildPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	     
		
	}
		
		
}