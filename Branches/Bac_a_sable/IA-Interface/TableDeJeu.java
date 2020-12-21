import java.io.Serializable;

import javax.swing.JOptionPane;

public class TableDeJeu  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pions plateau [][];
	private Pions reserve [] ;

	//Constructeur
	public TableDeJeu(){
		plateau= new Pions [4][4];
		reserve= new Pions[16];	

		// COULEUR FORME TAILLE CREUX 
		int i, j;
		reserve[0]= new Pions(1,1,1,1,0);
		reserve[1]= new Pions(-1,1,1,1,1);
		reserve[2]= new Pions(1,1,1,-1,2);
		reserve[3]= new Pions(-1,1,1,-1,3);
		reserve[4]= new Pions(1,-1,1,1,4);
		reserve[5]= new Pions(-1,-1,1,1,5);
		reserve[6]= new Pions(1,-1,1,-1,6);
		reserve[7]= new Pions(-1,-1,1,-1,7);
		reserve[8]= new Pions(1,1,-1,1,8);
		reserve[9]= new Pions(-1,1,-1,1,9);
		reserve[10]= new Pions(1,1,-1,-1,10);
		reserve[11]= new Pions(-1,1,-1,-1,11);
		reserve[12]= new Pions(1,-1,-1,1,12);
		reserve[13]= new Pions(-1,-1,-1,1,13);
		reserve[14]= new Pions(1,-1,-1,-1,14);
		reserve[15]= new Pions(-1,-1,-1,-1,15);


		for( i=0; i<4; i++) {
			for( j=0; j<4 ; j++) {
				plateau[i][j]=null;
			}
		}	
	}



	// Méthode qui renvoie la reserve
	public Pions getReserve(int n) {
		return reserve[n];
	}

	public Pions choisirPions(int i) {
		Pions p = null;
		if (testCaseVide(i)==false) p= reserve[i]; reserve[i]=null; return p;
	}
	// Méthode qui renvoie le plateau
	public Pions getPlateau(int i,int j) {
		return plateau[i][j];
	}


	// vérifier si une case précise du plateau est vide
	public boolean testCaseVide(int i, int j) {
		return plateau[i][j]==null;
	}

	//vérifier si une case précide de reserve est vide                       
	public boolean testCaseVide(int i) {
		return reserve[i]==null;
	}


	// poser un pion dans une case pércise
	public void poserPions(Pions p , int i , int j) {
		plateau[i][j]=p;
	}

	// annuler un pion
	public void annulerPions(Pions p, int i, int j) {
		plateau[i][j]=null;
		reserve[p.getIndice()]=p;
	}



	// Vérifier si il y a 4 pieces alingés avec une caractéristique commune	
	public boolean testVictoire() {

		boolean bool =false ;
		int i,j; // indice des boucle
		int forme=0 , couleur=0 , creux=0 , taille=0; 

		// On vérifie si il ya une ligne gagnante 
		for(i=0; i<4;i++) {
			creux=0; forme=0; taille=0; couleur=0;
			for(j=0;j<4;j++) {


				// On test si il y a une case vide dans la ligne 
				if(testCaseVide(i,j)) j=4;
				else {
					creux += plateau[i][j].getCreux(); 
					forme += plateau[i][j].getForme();
					taille += plateau[i][j].getTaille();
					couleur += plateau[i][j].getCouleur();
				}	
			}

			if( creux== -4|| creux== 4 ||
					forme== -4 || forme== 4 ||
					couleur== -4 || couleur== 4 ||
					taille== -4 || couleur== 4 ) 
				bool=true;

		}


		// On rénitialise les variable

		// On vérifie si il y a une colomne gagnante
		for(j=0; j<4;j++) {
			creux=0; forme=0; taille=0; couleur=0;
			for(i=0;i<4;i++) {

				// On test si il y a une case vide dans la colomne 
				if(testCaseVide(i,j)) i=4; 
				else {
					creux += plateau[i][j].getCreux(); 
					forme += plateau[i][j].getForme();
					taille += plateau[i][j].getTaille();
					couleur += plateau[i][j].getCouleur();
				}
			}

			if( creux== -4|| creux== 4 ||
					forme== -4 || forme== 4 ||
					couleur== -4 || couleur== 4 ||
					taille== -4 || couleur== 4 ) 

				bool= true;

		}
		// On vérifie si l'une des diagonale est gagnante 

		// On vérifie la premiere diagonale 
		creux=0; forme=0; taille=0; couleur=0;
		// On test d'abord si il ne y a pas de case vide		
		if(!testCaseVide(0,0) && !testCaseVide(1,1) && !testCaseVide(2,2) && !testCaseVide(3,3)) {

			creux = creux	+ plateau[0][0].getCreux()
					+ plateau[1][1].getCreux()
					+ plateau[2][2].getCreux()
					+ plateau[3][3].getCreux();

			forme = forme	+plateau[0][0].getForme()
					+plateau[1][1].getForme()
					+plateau[2][2].getForme()
					+plateau[3][3].getForme();

			taille = taille +plateau[0][0].getTaille()
					+plateau[1][1].getTaille()
					+plateau[2][2].getTaille()
					+plateau[3][3].getTaille();

			couleur = couleur 	+plateau[0][0].getCouleur()
					+plateau[1][1].getCouleur()
					+plateau[2][2].getCouleur()
					+plateau[3][3].getCouleur();




			if( creux== -4|| creux== 4 ||
					forme== -4 || forme== 4 ||
					couleur== -4 || couleur== 4 ||
					taille== -4 || couleur== 4 ) 

				bool= true;


		}

		// On vérifie la deuxieme diagonale 
		creux=0; forme=0; taille=0; couleur=0;
		// On test si il y a pas de case vide
		if(!testCaseVide(0,3) && !testCaseVide(1,2) && !testCaseVide(2,1) && !testCaseVide(3,0)) {

			creux = creux	+plateau[0][3].getCreux()
					+plateau[1][2].getCreux()
					+plateau[2][1].getCreux()
					+plateau[3][0].getCreux();

			forme = forme	+plateau[0][3].getForme()
					+plateau[1][2].getForme()
					+plateau[2][1].getForme()
					+plateau[3][0].getForme();

			taille = taille 	+plateau[0][3].getTaille()
					+plateau[1][2].getTaille()
					+plateau[2][1].getTaille()
					+plateau[3][0].getTaille();

			couleur = couleur 	+plateau[0][3].getCouleur()
					+plateau[1][2].getCouleur()
					+plateau[2][1].getCouleur()
					+plateau[3][0].getCouleur();

			if( creux== -4|| creux== 4 ||
					forme== -4 || forme== 4 ||
					couleur== -4 || couleur== 4 ||
					taille== -4 || couleur== 4 )
			bool = true;

		}

		return bool;

	}
	
	
}







