package TableDeJeu;

public class Test {
	
	//TEST DE LA METHODE testVictoire de la classe TableDeJeu
	/*
	public class Main {
		
		public static void main(String[] args) {
			
			TableDeJeu jeu= new TableDeJeu();
			jeu.creePions();
			Partie partie = new Partie(jeu);
			
			
			System.out.println(jeu.getReserve(0).getCouleur());
			partie.getJoueur(1).poserPions(jeu, jeu.getReserve(0),0,0);
			partie.getJoueur(1).poserPions(jeu, jeu.getReserve(1),1,1);
			partie.getJoueur(1).poserPions(jeu, jeu.getReserve(2),2,2);
			partie.getJoueur(1).poserPions(jeu, jeu.getReserve(3),3,3);
			System.out.println(jeu.testVictoire());
			
		}
	}
	*/
	
	
	
	//  TEST DE LA Methode meulleurCoup de la classe JoueurIA
	
	/*
	public static void main(String[] args) {
		
		TableDeJeu jeu= new TableDeJeu();
		jeu.creePions();
		Partie partie = new Partie(3, jeu);
		Pions p1;
		JoueurIA joueur2 = (JoueurIA) partie.getJoueur(2);

		

		System.out.println(jeu.testCaseVide(0,0));
		
		partie.getJoueur(1).poserPions(jeu, jeu.getReserve(0),0,0);
		System.out.println(jeu.testCaseVide(0,0));
		partie.getJoueur(1).poserPions(jeu, jeu.getReserve(1),1,1);
		partie.getJoueur(1).poserPions(jeu, jeu.getReserve(2),2,2);
		p1=joueur2.meilleurCoup(jeu,jeu.getReserve(3));
		System.out.println(jeu.testVictoire());
		
	}
}

*/
}
