package TableDeJeu;	
import java.util.Random;
public class JoueurIA extends Joueur {
	public JoueurIA(){
		super(numero);
	}
	
	
	// poser le pions sur la premiere case vide

		public void poserPionsIA (TableDeJeu tab, Pions p) {
			int i=0; int j=0;
			do {
			i = (int) Math.random() * 5 + 3;
			Random rn = new Random(); 
			j = rn.nextInt(4); }while(tab.testCaseVide(i,j)==false);
			tab.poserPions(p,i,j);
			System.out.println("L'IA a posé le pion choisi dans la case  :  "+i+"~"+j);
		}
		
		
	// choisir un Pion au hasard
	public Pions choisirPionsIA(TableDeJeu jeu) {
		//Méthode 1
		int alea=0;
		do {
			Random rn = new Random(); 
			alea = 1 + rn.nextInt(16);
		}while (jeu.testCaseVide(alea));
		
		System.out.println("L'IA a choisi le pion   :  "+alea);
		return jeu.getReserve(alea);
	}
	//Méthode 2
	/*
	int alea;
	do {
		alea = (int) (Math.Random()*16)+1;
	}while (jeu.testCaseVide(alea));
	
	return jeu.getReserve(alea);       	*/
	
	
	

}