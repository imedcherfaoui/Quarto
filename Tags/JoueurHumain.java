package TableDeJeu;

public class JoueurHumain extends Joueur {

	protected JoueurHumain(int numero) {
		super(numero);
	}

	public int demandeAide(TableDeJeu jeu) {
		
		int p = JoueurIA.aideJoueur(jeu);
		//la classe aide joueur de joueur IA retourne une caractétistique (La moin avantagieuse)
			return p;
		}

}
