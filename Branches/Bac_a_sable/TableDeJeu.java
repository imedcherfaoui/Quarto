package TableDeJeu;

public class TableDeJeu implements Cloneable {
	
	private Pions plateau [][];
	private Pions reserve [] ;
	
	//Constructeur
	public TableDeJeu(){
		plateau= new Pions [4][4];
		reserve= new Pions[16];	
	}
	
	// Creer les pions ou r�initialiser 
	public void creePions() {
		int i, j;
		reserve[0]= new Pions(1,1,1,1,0);
		reserve[1]= new Pions(1,1,1,-1,1);
		reserve[2]= new Pions(1,1,-1,1,2);
		reserve[3]= new Pions(1,1,-1,-1,3);
		reserve[4]= new Pions(1,-1,1,1,4);
		reserve[5]= new Pions(1,-1,1,-1,5);
		reserve[6]= new Pions(1,-1,-1,1,6);
		reserve[7]= new Pions(1,-1,-1,-1,7);
		reserve[8]= new Pions(-1,1,1,1,8);
		reserve[9]= new Pions(-1,1,1,-1,9);
		reserve[10]= new Pions(-1,1,-1,1,10);
		reserve[11]= new Pions(-1,1,-1,-1,11);
		reserve[12]= new Pions(-1,-1,1,1,12);
		reserve[13]= new Pions(-1,-1,1,-1,13);
		reserve[14]= new Pions(-1,-1,-1,1,14);
		reserve[15]= new Pions(-1,-1,-1,-1,15);
		
	
		for( i=0; i<4; i++) {
			for( j=0; j<4 ; j++) {
				plateau[i][j]=null;
			}
		}	
	}
	
	// M�thode qui renvoie la reserve
	public Pions getReserve(int n) {
		return reserve[n];
	}
	
	public Pions choisirPions(int i) {
		Pions p = null;
		if (testCaseVide(i)==false) p= reserve[i]; reserve[i]=null; return p;
	}
	// M�thode qui renvoie le plateau
	public Pions getPlateau(int i,int j) {
		return plateau[i][j];
	}
	
	
	// v�rifier si une case pr�cise du plateau est vide
	public boolean testCaseVide(int i, int j) {
		return plateau[i][j]==null;
	}
	
	//v�rifier si une case pr�cide de reserve est vide
	public boolean testCaseVide(int i) {
		return reserve[i]==null;
	}
	
	
	// poser un pion dans une case p�rcise
	public void poserPions(Pions p , int i , int j) {
		if(i<4 && i>0) {
			if(testCaseVide(i,j)) {
				plateau[i][j]=p;
			}
		}
	}
	
	// annuler un pion
	public void annulerPions(Pions p, int i, int j) {
		plateau[i][j]=null;
		reserve[p.getIndice()]=p;
	}


	
	// V�rifier si il y a 4 pieces aling�s avec une caract�ristique commune	
	public boolean testVictoire() {
		int i,j; // indice des boucle
		int forme=0 , couleur=0 , creux=0 , taille=0; 
		
		// On v�rifie si il ya une ligne gagnante 
		for(i=0; i<4;i++) {
			creux=0; forme=0; taille=0; couleur=0;
			for(j=0;j<4;j++) {
				
				// On test si il y a une case vide dans la ligne 
				if(testCaseVide(i,j)) break;

				else {
					creux += plateau[i][j].getCreux(); 
					forme += plateau[i][j].getForme();
					taille += plateau[i][j].getTaille();
					couleur += plateau[i][j].getCouleur();
				}	
			}
					couleur*=couleur;
					forme*=forme;
					taille *= taille;
					creux *=creux;
					if( creux==16 ||
							 forme==16 ||
								couleur==16 ||
									taille==16) return true;
				
			
		}
		
		
		// On r�nitialise les variable
		
		// On v�rifie si il y a une colomne gagnante
		for(j=0; j<4;j++) {
			creux=0; forme=0; taille=0; couleur=0;
			for(i=0;i<4;i++) {
				
				// On test si il y a une case vide dans la colomne 
				if(testCaseVide(i,j)) break; 
				else {
					creux += plateau[i][j].getCreux(); 
					forme += plateau[i][j].getForme();
					taille += plateau[i][j].getTaille();
					couleur += plateau[i][j].getCouleur();
				}
			}
			couleur*=couleur;
			forme*=forme;
			taille *= taille;
			creux *=creux;
			
			if( creux==16 ||
					 forme==16 ||
						couleur==16 ||
							taille==16) return true;
		
			
		}
	
		// On v�rifie si l'une des diagonale est gagnante 
		
		// On v�rifie la premiere diagonale 
		creux=0; forme=0; taille=0; couleur=0;
		// On test d'abord si il ne y a pas de case vide		
		if(testCaseVide(0,0)== false && testCaseVide(1,1)== false && testCaseVide(2,2)== false && testCaseVide(3,3)==false) {
			
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
					
			
			couleur*=couleur;
			forme*=forme;
			taille *= taille;
			creux *=creux;
			if( creux==16 ||
					 forme==16 ||
						couleur==16 ||
							taille==16) return true;
		
		}
		
		// On v�rifie la deuxieme diagonale 
		creux=0; forme=0; taille=0; couleur=0;
		// On test si il y a pas de case vide
		if(testCaseVide(0,3)==false && testCaseVide(1,2)==false && testCaseVide(2,1)==false && testCaseVide(3,0)==false) {
			
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
					
			couleur*=couleur;
			forme*=forme;
			taille *= taille;
			creux *=creux;
			
			if( creux==16 ||
					 forme==16 ||
						couleur==16 ||
							taille==16) return true;
		
		}
		return false;
	
	}
}

			
	
		
	
	

