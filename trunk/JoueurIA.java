/**
 *  @author BOUZIDI Siham
 */
import java.io.Serializable;
import java.util.Random;
 
public class JoueurIA extends Joueur implements Serializable{


	/**
	 * Intéligence artificiele avec qui on poura jouer une partie
	 * Contient plusieurs niveaux : facile, moyen et difficile
	 */
	private static final long serialVersionUID = 1L;
	//Attribut
	private int niv;
	private int posX, posY;


	//Constructer
	public JoueurIA( int niveau, int numero){
		super(numero);
		this.niv= niveau;
	}

	static float max (float a , float b) {
		if(a>b)return a;
		else return b;
	}

	static float min (float a , float b) {
		if(a>b)return b;
		else return a;
	}


	public void placerAlea(Pions p,TableDeJeu jeu) {
		Random rn = new Random();
		Random r  = new Random();
		int i;
		int j;
		do {
			i = r.nextInt(4); 
			j = rn.nextInt(4); 
		}while(jeu.testCaseVide(i,j)==false);
		jeu.poserPions(p,i,j);
		posX=i;
		posY=j;


	}
	/**
	 *  Méthode qui décide du meilleur coup
	 *   **/
		public Pions meilleurCoup(TableDeJeu jeu, Pions p) {
	
		int i, j , k=0; //indice de boucles
		float min=200; //Valeur min
		float valeur; //valeur du coup selectionné 
		int x=0,y=0; // position de la place a placer 
		boolean poser = false;
		Random rn = new Random(); 


		if(niv==0) {
			//Niveau zéro place les Pions par hasard avec la fonctions random
			placerAlea(p,jeu);
			do {
				i = rn.nextInt(16);
			}while (jeu.testCaseVide(i));
			return 	jeu.choisirPions(i);

		}else {
			//IA pas trés intéligente qui évite de donner le piece gagnante 
			if(niv==1) {
				//Place le pion dans la case gagnante si elle existe sinon elle la pose au hasard
				for(i=0; i<4; i++) {
					for(j=0; j<4; j++) {
						if(jeu.testCaseVide(i, j)) {
							jeu.poserPions(p,i,j);
							if(jeu.testVictoire()) { //Si la case est une case gangante elle la pose 
								posX=i;
								posY=j;
								i=4;
								j=4;
							}else jeu.annulerPions(p,i,j);
						}
					}
				}
				//Si elle ne trouve pas de de case gangante elle pose la piece dans une case au hasard
				if(p.getSituation()==false) placerAlea(p,jeu);

				for(i=0; i<16; i++) {
					// on traite les piece non placé
					if(!jeu.testCaseVide(i)) { 
						p=jeu.getReserve(i);
						poser=false;
						// On traite son cas dans chacune des case vide du plateau du jeu
						for(j=0; j<4; j++) {
							for(k=0; k<4; k++) {
								if(jeu.testCaseVide(j,k)) {
									// Si le pion est un pion gagnant elle le donne pas 
									jeu.poserPions(p, j, k);
									if(jeu.testVictoire()) poser = true;
									jeu.annulerPions(p,j,k);
								}
							}
						}
						if(poser==false) return p;
					}
				}
				// si elle a pas encore choisi de pion elle renvoie un pion au hasard
				i=0;
				do {
					i++;
				}while(jeu.testCaseVide(i));
				return jeu.choisirPions(i);

			}
			else {
				// IA qui pose le pion dans une case gangant ou alors dans une case avec le moins de chance de gagner 
				min =200;
				for(i=0; i<4; i++) {
					for(j=0; j<4; j++) {
						if(jeu.testCaseVide(i, j)) {
							jeu.poserPions(p,i,j);
							if(jeu.testVictoire()) {
								//Si la case est gagnate elle sort de la boucle et retien les coordonée
								jeu.annulerPions(p,i,j);
								x=i;
								y=j;
								i=4;
								j=4;
							}else 
							{	// Sinon elle evalue le pion dans toute les case et elle garde les coordonée de la pire case
								valeur=evaluerPion(jeu,i,j);
								jeu.annulerPions(p,i,j);

								if(valeur<=min) {
									min=valeur;
									x=i;
									y=j;
								}
							}
						}
					}
				}
				//Elle pose le pion
				jeu.poserPions(p, x, y);
				posX=x;
				posY=y;


				for(i=0; i<16; i++) {
					// on traite les piece non placé
					if(!jeu.testCaseVide(i)) { 
						p=jeu.getReserve(i);
						poser=false;
						// On traite son cas dans chacune des case vide du plateau du jeu
						for(j=0; j<4; j++) {
							for(k=0; k<4; k++) {
								if(jeu.testCaseVide(j,k)) {
									// Si le pion est un pion gagnant elle le donne pas 
									jeu.poserPions(p, j, k);
									if(jeu.testVictoire()) {poser = true;}
									jeu.annulerPions(p,j,k);
								}
							}
						}
						if(poser==false) return jeu.choisirPions(i);
					}
				}
				// si elle a pas encore choisi de pion elle renvoie un pion au hasard
				i=0;
				do {
					i++;
				}while(jeu.testCaseVide(i));
				return jeu.choisirPions(i);
			}
		}
	}

	/**
	 * Méthode qui évalue un coup
	 *   **/
		float evaluerPion(TableDeJeu jeu , int x, int y) {
		int i,j ; // indice des boucles
		float eval = 0; // Evaluation de la partie 
		float conex = 0; // Evaluation de la connextivité entre les pieces
		float evaluation=0; // Evaluation finale
		int nb=0; // nombre de piece dans une ligne
		int vide=0; // nbre de case vide

		if(!jeu.testCaseVide(x,y)) {


			//calcul du nombres de cases vides aprés le coup
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
				//Si il n'y a pas de pièces vide et que l'on a pas gagné
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

			// si nb est superieur a 1 alors on a des pieces dans la meme ligne

			if(nb>1) {
				// on vérifie chaque caracttéristique

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


			// si nb est superieur a 1 alors on a des pions dans la meme colomne 

			if(nb>1) {
				// on vérifie chaque caracttéristique

				if(couleur==nb)conex++;
				if(forme==nb)conex++;
				if(taille==nb)conex++;
				if(creux==nb)conex++;
			}


			// premiere diagonale

			// on vérifie d'abord que la piece est dans la diagonale

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
				// si nb est superieur a 1 alors on a des pieces collé entre elle
				couleur*=couleur;
				forme*=forme;
				taille *= taille;
				creux *=creux;
				nb*=nb;

				if(nb>1) {
					// on vérifie chaque caracttéristique

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
				// si nb est superieur a 1 alors on a des pieces collé entre elle

				couleur*=couleur;
				forme*=forme;
				taille *= taille;
				creux *=creux;
				nb*=nb;

				if(nb>1) {
					// on vérifie chaque caracttéristique

					if(couleur==nb)conex++;
					if(forme==nb)conex++;
					if(taille==nb)conex++;
					if(creux==nb)conex++;
				}
			}
		}

		conex+=100;
		evaluation = (float) ( 0.5*eval+0.5*conex);

		return evaluation;
	}


	public int getI() {
		return posX;
	}
	public int getJ() {
		return posY;
	}
}




