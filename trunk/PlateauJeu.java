/**
 * 
 * @authors CHAIBI Yamina & BOUZIDI Siham
 * 
 * Construction du plateau de jeu avec ces cases
 * D�finition des m�thodes qui s'applique a ce plateau
 * 
 */

import java.awt.GridLayout;


import javax.swing.JPanel;

/**
 * Cette classe rassemble les diff�rents �l�ments du plateau de jeu. Elle sert � instancier le plateau de jeu selon une configuration donn�e.
 * 
 */
public class PlateauJeu extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;


	//Constante qui indique le nombre de ligne et de colomne 
	private static final int TAILLELIGNE = 4;
	private static final int TAILLECOLONNE = 4;

	//Plateau � deux dimensions qui repr�sente le plateau de jeu
	Case t2[][];
	Case casa ; 

	//variable qui stock les coordonn�es de la case s�l�ctionn�e
	static int d ;
	static int e;


	/**
	 * Constructeur du plateau de jeu 
	 * initialise le plateau de jeu 
	 */	
	public PlateauJeu(){

		//Cr�ation du plateau
		t2= new Case[4][4];

		setLayout(new GridLayout(TAILLELIGNE, TAILLECOLONNE));
		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){
				// Cr�ation des case avec attribution d'un Mouselistener 
				t2 [i][j] = new Case();

				//Cas 2 joueurs on ajoute aux case du plateau jeu des Mouselistener de ListenerCase
				if(Fenetre2.a==true)t2 [i][j].addMouseListener(new ListenerCase(t2 [i][j],i,j));

				//Cas 1 joueur on ajoute aux case du plateau jeu des mouselisetener de ListenerCaseIA
				else t2 [i][j].addMouseListener(new ListenerCaseIA(t2 [i][j],i,j));

				add(t2 [i][j]);
			}
		}
	}


	// initialiser setselectionnee � true de chaque case
	public void selectionnerCases(){

		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				if( getCaseJeu(i, j).getComponentCount()==0){  
					getCaseJeu(i, j).setSelect(true);
					getCaseJeu(i, j).select();
				}
			}	
		}
	}


	//initialiser setselectionnee � false de chaque case
	public void nonSelectionnerCases(){

		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				getCaseJeu(i, j).setSelect(false);
				getCaseJeu(i, j).select();
			}
		}	
	}

	// Retourne la case du jeu des coordonn�e prit en arguement
	public  Case getCaseJeu (int i, int j) {
		return t2[i][j];
	}


	// retourne la case selon sa position (ligne)
	public Case getCaseJeu(int i){
		return (Case) getComponent(i);
	}


	// retourne l indice de la ligne de la case
	public int getLigne(Case case1){
		int res=0;
		for(int i=0; i<TAILLELIGNE; i++){
			for (int j=0; j< TAILLECOLONNE;j++) {
				if(getCaseJeu(i,j).equals(case1))
					res=i;
			}
		}
		return res;
	}


	// retourne l'indice de la colonne de la case		
	public int getColonne(Case case1){
		int res=0;
		for(int i=0; i<TAILLELIGNE; i++){
			for (int j=0; j< TAILLECOLONNE;j++) {
				if(getCaseJeu(i,j).equals(case1))
					res=j;
			}
		}
		return res;
	}

	// M�thode qui renvoit la case du plateau de jeu des coordon�es rentr�s en argument
	public Case indiceCaseCode (int i,int j) {
		if ( i==0 && j==0 )
			return getCaseJeu(0, 0);	
		if ( i==0 && j==1 )
			return getCaseJeu(0, 1);
		if ( i==0 && j==2 )
			return getCaseJeu(0, 2);
		if ( i==0 && j==3 )   
			return getCaseJeu(0, 3);
		if ( i==1 && j==0 )   
			return getCaseJeu(1, 0);
		if ( i==1 && j==1 )   
			return getCaseJeu(1, 1);
		if ( i==1 && j==2 )   
			return getCaseJeu(1, 2);
		if ( i==1 && j==3 )   
			return getCaseJeu(1, 3);
		if ( i==2 && j==0 )   
			return getCaseJeu(2, 0);
		if ( i==2 && j==1 )   
			return getCaseJeu(2, 1);
		if ( i==2 && j==2 )   
			return getCaseJeu(2, 2);
		if ( i==2 && j==3 )   
			return getCaseJeu(2, 3);
		if ( i==3 && j==0 )   
			return getCaseJeu(3, 0);
		if ( i==3 && j==1 )   
			return getCaseJeu(3, 1);
		if ( i==3 && j==2 )   
			return getCaseJeu(3, 2);
		if ( i==3 && j==3 )   
			return getCaseJeu(3, 3);
		else 
			return getCaseJeu(0, 0);
	}




	//Methode deplacer le pion choisi dans la case choix
	public void deplacer(Case case1){

		if(case1.getComponentCount()==0) {
			//On ajoute a la case le pion qui se trouve dans la case choix 
			case1.add(Fenetre6.plateau.choix.getComponent(0));
			case1.revalidate();
			case1.repaint();

			//On remet toute les case du plateau de jeu en non selectionn�e
			nonSelectionnerCases();

			//On efface ce qu il y a dans la case choix et on la reconstruit 
			Fenetre6.plateau.choix.remove(getComponent(0));
			Fenetre6.plateau.choix.revalidate();
			Fenetre6.plateau.choix.repaint();

			Fenetre6.plateau.nonSelectionnerCases();
		
		}
	}


	//Methode pour pour que le l ia pose le pion dans le plateau et retourne le pion a qu elle a choisit
	public Pions joueIA(Pions pion) {

		//On fait appel a la m�thode poserPions dans la partieIA (L IA pose le pions)
		Pions p = Fenetre6.partieIA.joueIA(pion);
		
			Case casa1 = Fenetre6.plateau.indiceCase(p.getIndice());
			

			//On r�cupere les coordon�e de la case choisit
			int i = Fenetre6.partieIA.getI();
			int j = Fenetre6.partieIA.getJ();

			//On r�cupere la case des coordon�e pass� en argument
			casa = t2[i][j];

				//Ajoute ce qu il y a dans la case choix dans la case choisit par l IA
				casa.add(Fenetre6.plateau.choix.getComponent(0));
				casa.revalidate();
				casa.repaint();

				nonSelectionnerCases();
				
				//Supprime ce qu il y a dans la case choix
				Fenetre6.plateau.choix.removeAll();
				Fenetre6.plateau.choix.revalidate();
				Fenetre6.plateau.choix.repaint();

				Fenetre6.plateau.nonSelectionnerCases();
				
				//Test si l IA a gagn� 
				Fenetre6.partieIA.gagnerPartie();
		
				//Pose le pion choisit par l IA dans la case choix
				Fenetre6.plateau.choix.add(casa1.getComponent(0));
				Fenetre6.plateau.choix.revalidate();
				Fenetre6.plateau.choix.repaint();

				casa1.remove(getComponent(0));
				casa1.revalidate();
				casa1.repaint();
		return p;
	}
}






