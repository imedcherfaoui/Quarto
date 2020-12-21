import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;


public class PlateauReserve extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;

	private static final int TAILLELIGNE = 2;
	private static final int TAILLECOLONNE = 8;
	Case choix = new Case();


	public Case caseActive;
	Case t[][] = new Case[2][8] ; 
	static int a ;
	static int b;
	public Case CaseActiveIa;


	// initialiser le plateau reserve 
	public PlateauReserve() throws IOException{

		setLayout(new GridLayout(TAILLELIGNE, TAILLECOLONNE));

		for(int i=0; i<2; i++){
			for(int j=0; j<8; j++){

				t [i][j] = new Case();


			}
		}



		for(int i=0; i<2; i++){
			for(int j=0; j<8; j++){

				t [i][j].addMouseListener(new ListenerCase(t [i][j], this));
				add(t [i][j]);


			}
		}

		init();	
	}

	// méthode pour créér des pion selon d'indice 
	private Pion creerPion(int indice, boolean deplace, Pions pions) throws IOException{
		Pion pion = new Pion(indice, deplace, pions);

		pion.addMouseListener(new ListenerPion(pion, this));
		return pion;
	}




	// initialiser les cases de la reserve 
	private void init() throws IOException{


		getCase(0,0).add(creerPion(0, true, ListenerCase.partie.getPions(0)));

		getCase(0,1).add(creerPion(1, true, ListenerCase.partie.getPions(1)));

		getCase(0,2).add(creerPion(2, true, ListenerCase.partie.getPions(2)));

		getCase(0,3).add(creerPion(3, true, ListenerCase.partie.getPions(3)));

		getCase(0,4).add(creerPion(4, true, ListenerCase.partie.getPions(4)));

		getCase(0,5).add(creerPion(5, true, ListenerCase.partie.getPions(5)));

		getCase(0,6).add(creerPion(6, true, ListenerCase.partie.getPions(6)));

		getCase(0,7).add(creerPion(7, true, ListenerCase.partie.getPions(7)));

		getCase(1,0).add(creerPion(8, true, ListenerCase.partie.getPions(8)));

		getCase(1,1).add(creerPion(9, true, ListenerCase.partie.getPions(9)));

		getCase(1,2).add(creerPion(10, true, ListenerCase.partie.getPions(10)));

		getCase(1,3).add(creerPion(11, true, ListenerCase.partie.getPions(11)));

		getCase(1,4).add(creerPion(12, true, ListenerCase.partie.getPions(12)));

		getCase(1,5).add(creerPion(13, true, ListenerCase.partie.getPions(13)));

		getCase(1,6).add(creerPion(14, true, ListenerCase.partie.getPions(14)));

		getCase(1,7).add(creerPion(15, true, ListenerCase.partie.getPions(15)));


	}



	public void afficherPossibilites(Pion p){

		for(int m =0; m<2; m++){
			for (int n=0;n<8;n++)
				// vérifie si un case est selectionné, si c'est le cas il vérifie si elle est pas vide, puis si le pion passé en parametre y est
				if(getCase(m,n).getComponentCount()!=0 && getCase(m,n).getComponent(0).equals(p)){

					// recupération de la case selectionné
					caseActive=getCase(m,n);  
					// récupere les coordonnées de la case active + sa couleur 
					selectionnerCasesPlateau(m,n);
					//	ListenerCase.jeu.selectionnerCasesReserve();


				}
		}
		// récupération indices de la case active 
		a =getLigne(caseActive);
		b =getColonne(caseActive);
	}



	public void deplacer() {
		
		if(choix.getComponentCount()==0) {
			ListenerCase.plateau.choix.add(ListenerCase.plateau.caseActive.getComponent(0));
			ListenerCase.plateau.choix.repaint();
		}




	}
	public void nonSelectionnerCases(){

		for (int i=0;i<2;i++) {
			for (int j=0; j<8;j++) {
				// test si la case est vide et la mets en couleur (ici bleu)
				getCase(i, j).setSelectionnee(false);

			}
		}	
	}




	public void selectionnerCasesPlateau(int i, int j){


		getCase(i, j).setSelectionnee(true);
		ListenerCase.jeu.selectionnerCases();


	}



	// attribuer à chaque indice du code du jeu un indice d'une case de l'interface 
	public Case IndiceCase(int i) {


		switch (i) {

		case 0 :
			return getCase(0, 0);

		case 1 :
			return getCase(0, 1);

		case 2 :
			return getCase(0, 2);

		case 3 :
			return getCase(0, 3);

		case 4 :
			return getCase(0, 4);

		case 5 :
			return getCase(0, 5);

		case 6 :
			return getCase(0, 6);

		case 7 :
			return getCase(0, 7);

		case 8 :

			return getCase(1, 0);

		case 9 :

			return getCase(1, 1);

		case 10 :

			return getCase(1, 2);

		case 11 :

			return getCase(1, 3);

		case 12 :

			return getCase(1, 4);

		case 13 :
			return getCase(0, 5);

		case 14 :
			return getCase(0, 6);

		case 15 :

			return getCase(0, 7);


		}
		return null;

	}

	// attribuer à chaque indice du code du jeu un indice d'une case de l'interface 



	public static int IndiceCaseCode (int i,int j) {

		if ( i==0 && j==0 )
			return 0;	
		if ( i==0 && j==1 )
			return 1;
		if ( i==0 && j==2 )
			return 2;
		if ( i==0 && j==3 )   
			return 3;
		if ( i==0 && j==4 )   
			return 4;
		if ( i==0 && j==5 )   
			return 5;
		if ( i==0 && j==6 )   
			return 6;
		if ( i==0 && j==7 )   
			return 7;
		if ( i==1 && j==0 )   
			return 8;
		if ( i==1 && j==1 )   
			return 9;
		if ( i==1 && j==2 )   
			return 10;
		if ( i==1 && j==3 )   
			return 11;
		if ( i==1 && j==4 )   
			return 12;
		if ( i==1 && j==5 )   
			return 13;
		if ( i==1 && j==6 )   
			return 14;
		if ( i==1 && j==7 )   
			return 15;
		else
			return -1;



	}


	// retourne la case selon sa position (ligne,colonne)
	public Case getCase(int i, int j){
		return t[i][j];
	}



	// retourne la case selon sa position (ligne)
	public Case getCase(int i){
		return (Case) getComponent(i);
	}



	// retourne la ligne de la case
	public int getLigne(Case case1){
		int res=0;
		for(int i=0; i<TAILLELIGNE; i++){
			for (int j=0; j< TAILLECOLONNE;j++) {
				if(getCase(i,j).equals(case1))
					res=i;
			}
		}
		return res;
	}

	// retourne la colonne de la case		
	public int getColonne(Case case1){
		int res=0;
		for(int i=0; i<TAILLELIGNE; i++){
			for (int j=0; j< TAILLECOLONNE;j++) {
				if(getCase(i,j).equals(case1))
					res=j;
			}
		}
		return res;
	}


	
	public static int alea() {
		int i;
		do {
			 Random rd = new Random(); 
			 i=rd.nextInt(16) ;
		}while (ListenerCase.jeu.IndiceCase(i).getComponentCount()!=0);
		System.out.println(+i);
		return i;
		}
	
	public Pion ChoisiAlea() {
		Pion pion = null;
		try {
			pion = new Pion(alea(),true,ListenerCase.partie.getPions(alea()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pion;
	}


}
