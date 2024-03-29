package TableDeJeu;
/* import java.util.Random; */
 
 

public class JoueurIA extends Joueur{
		
	
	//Attribut
	private static int PROF;
		
	//Constructer
	public JoueurIA( int niveau, int numero){
		super(numero);
		switch (niveau) {
		case 1 : PROF=2;
		case 2 : PROF=4;
		case 3 : PROF=6;
		}
			
			
 	}
	
	static float max (float a , float b) {
		if(a>b)return a;
		else return b;
	}
	
	static float min (float a , float b) {
		if(a>b)return b;
		else return a;
	}
	
	
	
	// m�thode pour decider du meilleur coup
	public Pions meilleurCoup(TableDeJeu jeu, Pions pion) {
		int i, j , k; 
		float alpha=0, beta=200;
		int max=0; //Position max
		float valeur; //valeur du coup selectionn� 
		int x=0,y=0; // position des piece
		
		// il faut d'abord choisir la meilleure position pour la piece doner 
		//donc pour chaque position 
		for(i=0; i<4; i++) {
			for(j=0; j<4; j++) {
				if(jeu.testCaseVide(i, j)) {
				//On recupere sa valeur avec la fonction alpha beta 
				valeur = valeurAlphaBeta(pion,i , j , max , PROF, jeu, alpha ,  beta);
				//Si notre valeur est superieur a alpha
					if (valeur > alpha) {
						//Alors on retient notre position et on modifie alpha
						alpha=valeur;
						x = i;
				  		y = j;
				  		
					}
				}
			}
		}
		
		// On place la meilleure piece dans le tabeau et on cherche la pire piece a donner
		jeu.poserPions(pion, x, y);
		// On reinitialise les valeurs
		alpha=0 ; beta=200;
		
		Pions p = new Pions();
		// Pour chaque piece de la reserve on va la placer dans toute les case du tableau
		for(k=0;k<16;k++) {
			if(jeu.testCaseVide(k)) {
				p=jeu.getReserve(k);
				//Pur chaque position on regarde la valeur d evaluation
				for(i=0; i<4; i++) {
					for(j=0; j<4; j++) {
						if(jeu.testCaseVide(i,j)) {
							valeur=valeurAlphaBeta(p,i , j , max, PROF, jeu, alpha ,  beta);
							alpha=max(alpha, valeur);
						}
					}
				}
			}
			//On prends le minimum pour chaque piece
			if(alpha<beta)
				beta=alpha;
				p=jeu.getReserve(k);
		}
		// on donne la pire piece  avec la valeur la plus petite 
		return p;
		
		
		
}

	
	
		//Methode pour attribuer une valeur a un coup 
	public float valeurAlphaBeta(Pions pion, int x , int y , int max , int profondeur, TableDeJeu jeu, float alpha , float beta) {
		int i=0, j=0, k=0 ;
		float evaluation=0, tmp=0; // evaluation et evaluation temporaire
		int vide=0; // case vide
		
		for(i=0; i<4; i++) {
		    for(j=0; j<4; j++) {
		        if (jeu.testCaseVide(i, j)) 
		        	vide++;
		    }
		}
		
		//On commence par poser le pions
		jeu.poserPions(pion, x, y);
		vide--;
		
		// Si le nombre de case est vide ou la profondeur est 0 ( conditions d'arret)
		if(vide==0 || profondeur==0) {
			// on �value la piece puis on la retire
			evaluation= evaluerPion(max, jeu, x , y);
			jeu.annulerPions(pion, x, y);
			
			return evaluation;
		}
		else {
			// si on a gagn� la partie et la profondeur est maximum
			if(jeu.testVictoire() && profondeur==PROF) {
				jeu.annulerPions(pion, x, y);
				return 200;
			} 
		
			
			else {
				// si c est un �tat max on fait une recherche alpha
				if(max==0) {
					//Pour chaque piece
					for(i=0; i<16; i++) {
						// on traite les piece non plac�
						if(!jeu.testCaseVide(i)) {
							// On traite son cas dans chacune des case vide du plateau du jeu
						    for(j=0; j<4; j++) {
						    	for(k=0; k<4; k++) {
							    	  if(jeu.testCaseVide(j,k)) {

							    		  tmp=valeurAlphaBeta(pion,j,k,(max+1)%2, profondeur-1,jeu, alpha , beta);
							    		  alpha=max(alpha,tmp);
							    		  // si alpha est plus grand que beta on coupe alpha
							    		  if(alpha>=beta) {
							    		  jeu.annulerPions(pion, j, k);
							    		  return alpha;	  
							    		  }
							    	  }	  
						    	}	
						    }
						}
					}
					
					// on retire notre piece notre piece
					jeu.annulerPions(pion, x, y);
					return alpha;
					
				// si c est pas un etat max !! on fait une recherche beta
				}
				else {
					//Pour chaque piece
					for(i=0; i<16; i++) {
						// on traite les piece non plac�
						if(!jeu.testCaseVide(i)) {
							// On traite son cas dans chacune des case vide du plateau du jeu
						    for(j=0; j<4; j++) {
							      for(k=0; k<4; k++) {
							    	  if(jeu.testCaseVide(j,k)) {
							    		  tmp=valeurAlphaBeta(pion,j,k,(max+1)%2, profondeur-1,jeu, alpha , beta);
							    		  alpha=min(beta,tmp);
							    		  if(beta<=alpha) {
							    			 jeu.annulerPions(pion, j, k);
							    			 return beta;
							    		  }
							    	  }	  
							     }
						    }
						}
					}
				}
			}
		}
		return 0;
}
	
	
		// M�thode pour evaluer un coup
	static float evaluerPion(int max ,TableDeJeu jeu , int x, int y) {
	
		int i,j ; // indice des boucles
		float eval; // Evaluation de la partie 
		float conex; // Evaluation de la connextivit� entre les pieces
		float evaluation=0; // Evaluation finale
		int nb=0; // nombre de piece dans une ligne
		int vide=0; // nbre de case vide
	
		if(!jeu.testCaseVide(x,y)) {
		
		// Calcul e l'evaluation de la partie
	  
		//calcul du nombres de cases vides apr�s le coup
		for( i=0;i<4; i++) {
			for( j=0; j<4; j++) {
				if (jeu.testCaseVide(i,j)) {
					vide++;  
				}
			}
		}
		
	   //
		if(jeu.testVictoire()) {
			eval = 200;
		} else{
			//Si il n'y a pas de pi�ces vide et que l'on a pas gagn�
			if (vide == 0) {
			//Alors il y a match nul
				eval = 199;} 
			else {
				//Sinon c'est normal et on continue
				eval = 100; }
			}	
		
		// Calcul de la conx entre les piece
		conex=0;
		
		// les lignes
	
		// Initialisation
		int couleur=0; int forme=0 ; int taille=0; int creux=0;
		
		couleur= jeu.getPlateau(x,y).getCouleur();
		forme= jeu.getPlateau(x,y).getForme();
		taille =jeu.getPlateau(x,y).getTaille();
		creux = jeu.getPlateau(x,y).getCreux();
		 
		nb=1;
		
		for(i=0; i<4 ; i++) {
			if(i!= x) {
				if(!jeu.testCaseVide(i,y)){
					couleur+= jeu.getPlateau(i, y).getCouleur();
					forme += jeu.getPlateau(i, y).getForme();
					creux += jeu.getPlateau(i, y).getCreux();
					taille += jeu.getPlateau(i, y).getTaille();
					
					nb++;
				}
			}
		}
		
		couleur*=couleur;
		forme*=forme;
		taille *= taille;
		creux *=creux;
		nb*=nb;
		
		// si nb est superieur a 1 alors on a des pieces coll� entre elle
		
		if(nb>1) {
			// on v�rifie chaque caractt�ristique
			
			if(couleur==nb)conex++;
			if(forme==nb)conex++;
			if(taille==nb)conex++;
			if(creux==nb)conex++;
		}
		
		
		// les colomne 
		// les initialisiation
		
		nb=1;
		
		couleur= jeu.getPlateau(x,y).getCouleur();
		forme= jeu.getPlateau(x,y).getForme();
		taille =jeu.getPlateau(x,y).getTaille();
		creux = jeu.getPlateau(x,y).getCreux();
		
		
		for(i=0; i<4 ; i++) {
			if(i!= y) {
				if(!jeu.testCaseVide(x,i)){
					couleur+= jeu.getPlateau(x, i).getCouleur();
					forme += jeu.getPlateau(x, i).getForme();
					creux += jeu.getPlateau(x, i).getCreux();
					taille += jeu.getPlateau(x, i).getTaille();
					
					nb++;
				}
			}
		}
		
		couleur*=couleur;
		forme*=forme;
		taille *= taille;
		creux *=creux;
		nb*=nb;
		
	
		// si nb est superieur a 1 alors on a des pieces coll� entre elle
		
		if(nb>1) {
			// on v�rifie chaque caractt�ristique
			
			if(couleur==nb)conex++;
			if(forme==nb)conex++;
			if(taille==nb)conex++;
			if(creux==nb)conex++;
		}
		
		
		// premiere diagonale
		
		// on v�rifie d'abord que la piece est dans la diagonale
		
		if(x==y) {
			
			// on initialise
			nb=1;
			
		couleur= jeu.getPlateau(x,y).getCouleur();
		forme= jeu.getPlateau(x,y).getForme();
		taille =jeu.getPlateau(x,y).getTaille();
		creux = jeu.getPlateau(x,y).getCreux();
			
			for(i=0; i<4 ; i++) {
				if(i!= x) {
					if(jeu.testCaseVide(i,i)==false){
						couleur+= jeu.getPlateau(i, i).getCouleur();
						forme += jeu.getPlateau(i, i).getForme();
						creux += jeu.getPlateau(i, i).getCreux();
						taille += jeu.getPlateau(i, i).getTaille();
						
						nb++;
					}
				}
			}
			// si nb est superieur a 1 alors on a des pieces coll� entre elle
			couleur*=couleur;
			forme*=forme;
			taille *= taille;
			creux *=creux;
			nb*=nb;
			
			if(nb>1) {
				// on v�rifie chaque caractt�ristique
				
				if(couleur==nb)conex++;
				if(forme==nb)conex++;
				if(taille==nb)conex++;
				if(creux==nb)conex++;
			}
		}
		
		// seconde diagonale
		
		if(x==(3-y)) {
			nb=1;
			
			couleur= jeu.getPlateau(x,y).getCouleur();
			forme= jeu.getPlateau(x,y).getForme();
			taille =jeu.getPlateau(x,y).getTaille();
			creux = jeu.getPlateau(x,y).getCreux();
			
			for(i=0; i<4 ; i++) {
				if(i!=x) {
					if(jeu.testCaseVide(i,(3-i))==false ){
						couleur+= jeu.getPlateau(i, 3-i).getCouleur();
						forme += jeu.getPlateau(i, 3-i).getForme();
						creux += jeu.getPlateau(i, 3-i).getCreux();
						taille += jeu.getPlateau(i, 3-i).getTaille();
						
						nb++;
					}
				}
			}
			// si nb est superieur a 1 alors on a des pieces coll� entre elle
			
			couleur*=couleur;
			forme*=forme;
			taille *= taille;
			creux *=creux;
			nb*=nb;
			
			if(nb>1) {
				// on v�rifie chaque caractt�ristique
				
				if(couleur==nb)conex++;
				if(forme==nb)conex++;
				if(taille==nb)conex++;
				if(creux==nb)conex++;
			}
		}
		
		
		conex+=100;
		
		evaluation = (float) ( 0.5*eval+0.5*conex);
		
		return evaluation;	
		}
	return 0;
	}
}	
/*		
	//M�thode
		
	// m�thode pour IA Bete  
	


	// choisir un Pion au hasard
	public Pions choisirPionsIA(TableDeJeu jeu) {
		
		int i;
		do {
			Random rd = new Random(); 
			 i =rd.nextInt(16) ;
		}while (jeu.testCaseVide(i));
		
		return jeu.getReserve(i);
	}
	
	// poser le pions sur la premiere case vide

	public void poserPionsIA (TableDeJeu tab, Pions p) {
		int i=0; int j=0;
		for( i=0;i<4;i++) {
			for(j=0; j<4 && tab.testCaseVide(i,j);j++) {}
		}
		
		tab.poserPions(p,i,j);
	}

}
	

*/
	
