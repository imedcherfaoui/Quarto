
import java.awt.GridLayout;
import java.io.IOException;


import javax.swing.JPanel;


public class PlateauReserve extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;

	//Constantes pour indiquer la taille des colonne et des lignes
	private static final int TAILLELIGNE = 2;
	private static final int TAILLECOLONNE = 8;
	//public Case caseActive;
	static int a ;
	static int b;
	Case t[][] ;
	Case pion;
	Case choix;



	// Constructeur du plateau Reserve 
	public PlateauReserve() throws IOException{
		//On crée la case choix
		choix  = new Case();

		//On crée le plateau reserve
		t= new Case[2][8];

		setLayout(new GridLayout(TAILLELIGNE, TAILLECOLONNE));

		for(int i=0; i<2; i++){
			for(int j=0; j<8; j++) {
				t [i][j] = new Case();
				add(t [i][j]);
			}
		}
		init();	
	}

	// méthode pour créér des pion selon d'indice 
	private Pion creerPion(int indice, Pions pions,int i, int j) throws IOException{
		Pion pion = new Pion(indice, pions);

		//Cas 2 joueurs on ajoute aux pion du plateau reserve des Mouselistener de ListenerPion
		if(Fenetre2.a==true) pion.addMouseListener(new ListenerPion(pion,i,j));
		//Cas 1 joueur on ajoute aux pion du plateau reserve des mouselisetener de ListenerPionIA
		else pion.addMouseListener(new ListenerPionIA(pion,i,j));

		return pion;
	}




	// initialiser les cases de la reserve 
	private void init() throws IOException{
		if (Fenetre2.a==true) {
			//Crée les pions dans la partie dans le cas 1 joueur
			t[0][0].add(creerPion(0,  Fenetre6.partie.getPions(0),0,0));
			t[0][1].add(creerPion(1,  Fenetre6.partie.getPions(1),0,1));
			t[0][2].add(creerPion(2,  Fenetre6.partie.getPions(2),0,2));
			t[0][3].add(creerPion(3,  Fenetre6.partie.getPions(3),0,3));
			t[0][4].add(creerPion(4,  Fenetre6.partie.getPions(4),0,4));
			t[0][5].add(creerPion(5,  Fenetre6.partie.getPions(5),0,5));
			t[0][6].add(creerPion(6,  Fenetre6.partie.getPions(6),0,6));
			t[0][7].add(creerPion(7,  Fenetre6.partie.getPions(7),0,7));
			t[1][0].add(creerPion(8,  Fenetre6.partie.getPions(8),1,0));
			t[1][1].add(creerPion(9,  Fenetre6.partie.getPions(9),1,1));
			t[1][2].add(creerPion(10,  Fenetre6.partie.getPions(10),1,2));
			t[1][3].add(creerPion(11,  Fenetre6.partie.getPions(11),1,3));
			t[1][4].add(creerPion(12,  Fenetre6.partie.getPions(12),1,4));
			t[1][5].add(creerPion(13,  Fenetre6.partie.getPions(13),1,5));
			t[1][6].add(creerPion(14,  Fenetre6.partie.getPions(14),1,6));
			t[1][7].add(creerPion(15,  Fenetre6.partie.getPions(15),1,7));
		}
		else {
			//Crée les pions dans la partie partieIa ! cas deux joueurs
			t[0][0].add(creerPion(0,  Fenetre6.partieIA.getPions(0),0,0));
			t[0][1].add(creerPion(1,  Fenetre6.partieIA.getPions(1),0,1));
			t[0][2].add(creerPion(2,  Fenetre6.partieIA.getPions(2),0,2));
			t[0][3].add(creerPion(3,  Fenetre6.partieIA.getPions(3),0,3));
			t[0][4].add(creerPion(4,  Fenetre6.partieIA.getPions(4),0,4));
			t[0][5].add(creerPion(5,  Fenetre6.partieIA.getPions(5),0,5));
			t[0][6].add(creerPion(6,  Fenetre6.partieIA.getPions(6),0,6));
			t[0][7].add(creerPion(7,  Fenetre6.partieIA.getPions(7),0,7));
			t[1][0].add(creerPion(8,  Fenetre6.partieIA.getPions(8),1,0));
			t[1][1].add(creerPion(9,  Fenetre6.partieIA.getPions(9),1,1));
			t[1][2].add(creerPion(10,  Fenetre6.partieIA.getPions(10),1,2));
			t[1][3].add(creerPion(11,  Fenetre6.partieIA.getPions(11),1,3));
			t[1][4].add(creerPion(12,  Fenetre6.partieIA.getPions(12),1,4));
			t[1][5].add(creerPion(13,  Fenetre6.partieIA.getPions(13),1,5));
			t[1][6].add(creerPion(14,  Fenetre6.partieIA.getPions(14),1,6));
			t[1][7].add(creerPion(15,  Fenetre6.partieIA.getPions(15),1,7));
		}
	}

/*
	//Méthode qui initilise la case active et affiche les case encore vide du plateau jeu
	public void caseDuPion(Pion p){
		for(int m =0; m<2; m++){
			for (int n=0;n<8;n++)
				// vérifie si un case est selectionné, si c'est le cas il vérifie si elle est pas vide, puis si le pion passé en parametre y est
				if(getCase(m,n).getComponentCount()!=0 && getCase(m,n).getComponent(0).equals(p)){
					// recupération de la case selectionné
					caseActive=getCase(m,n);  
					// récupere les coordonnées de la case active 
					selectionnerCasesPlateau(m,n);
				}
		}
		// récupération indices de la case active 
		a =getLigne(caseActive);
		b =getColonne(caseActive);

	}
	*/



	// Méthode qui retourne la case du plateau de l indice passer en argument
	public Case indiceCase(int indice) {
		switch (indice) {
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
			return getCase(1, 5);
		case 14 :
			return getCase(1, 6);
		case 15 :
			return getCase(1, 7);
		}
		return null;
	}


	// attribuer à chaque indice du code du jeu un indice d'une case de l'interface 
	public static int indiceCaseCode (int i,int j) {
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
	
	public Case indiceCase (int i,int j) {
		if ( i==0 && j==0 )
			return t[0][0];	
		if ( i==0 && j==1 )
			return t[0][1];
		if ( i==0 && j==2 )
			return t[0][2];
		if ( i==0 && j==3 )   
			return t[0][3];
		if ( i==0 && j==4 )   
			return t[0][4];
		if ( i==0 && j==5 )   
			return t[0][5];
		if ( i==0 && j==6 )   
			return t[0][6];
		if ( i==0 && j==7 )   
			return t[0][7];
		if ( i==1 && j==0 )   
			return t[1][0];
		if ( i==1 && j==1 )   
			return t[1][1];
		if ( i==1 && j==2 )   
			return t[1][2];
		if ( i==1 && j==3 )   
			return t[1][3];
		if ( i==1 && j==4 )   
			return t[1][4];
		if ( i==1 && j==5 )   
			return t[1][5];
		if ( i==1 && j==6 )   
			return t[1][6];
		if ( i==1 && j==7 )   
			return t[1][7];
		else 
			return t[0][0];
	}





	public void selectionnerCasesPlateau(int i, int j){
		getCase(i,j).setSelect(true);
		getCase(i,j).select();
		Fenetre6.jeu.selectionnerCases();
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


	public void nonSelectionnerCases(){
		for (int i=0;i<2;i++) {
			for (int j=0; j<8;j++) {
				getCase(i, j).setSelect(false);
			}
		}	
	}


	//Deplacer la case active dans la case choix
	public void deplacer(Case caseActive) {
		if(choix.getComponentCount()==0) {
			Fenetre6.plateau.choix.add(caseActive.getComponent(0));
			Fenetre6.plateau.choix.revalidate();
			Fenetre6.plateau.choix.repaint();

			caseActive.removeAll();
			caseActive.revalidate();
			caseActive.repaint();
			
		}
	}
}
