import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;


public class PlateauJeu extends JPanel {

	private static final long serialVersionUID = 6726708245444190460L;
	private static final int TAILLELIGNE = 4;
	private static final int TAILLECOLONNE = 4;
	Case t2[][] ;
Case casa ;
	//public Case case1; 
	static int d ;
	static int e;


	// Consctructeur du plateau de jeu
	public PlateauJeu(){
		t2= new Case[4][4];
		setLayout(new GridLayout(TAILLELIGNE, TAILLECOLONNE));

		for(int i=0; i<4; i++){
			for(int j=0; j<4; j++){

				t2 [i][j] = new Case();
				t2 [i][j].addMouseListener(new ListenerCase(t2 [i][j], this));
				add(t2 [i][j]);
			}
		}
	}




	// initialiser setselectionnee à true de chaque case
	public void selectionnerCases(){

		//	Pion pion = (Pion)(plategetCase(i, j).getComponent(0));

		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				//	getCaseReserve(i, j).setSelectionnee(true);
				if( getCaseJeu(i, j).getComponentCount()==0){  // test si la case est vide et la mets en couleur (ici bleu)
					getCaseJeu(i, j).setSelectionnee(true);

				}
			}	
		}
	}



	//initialiser setselectionnee à false de chaque case
	public void nonSelectionnerCases(){


		for (int i=0;i<4;i++) {
			for (int j=0; j<4;j++) {
				// test si la case est vide et la mets en couleur (ici bleu)
				getCaseJeu(i, j).setSelectionnee(false);

			}
		}	
	}

	
	
	
	public void deplacerAlea() {
		
		casa = getCaseJeu(alea());

		if(casa.getComponentCount()==0) {
			casa.add(ListenerCase.plateau.choix.getComponent(0));
			nonSelectionnerCases();
			ListenerCase.plateau.choix.removeAll();
			ListenerCase.plateau.choix.repaint();
			ListenerCase.plateau.nonSelectionnerCases();
			Pion p=(Pion)(casa.getComponent(0));
			p.setdeplace(true);
		}
		
	}
	
	
	
	
	
	
	
	
	

	public void deplacer(Case case1){

		d=getLigne(case1);
		e =getColonne(case1);	

		if(case1.getComponentCount()==0) {
			case1.add(ListenerCase.plateau.choix.getComponent(0));
			nonSelectionnerCases();
			ListenerCase.plateau.choix.removeAll();
			ListenerCase.plateau.choix.repaint();
			ListenerCase.plateau.nonSelectionnerCases();
			Pion p=(Pion)(case1.getComponent(0));
			p.setdeplace(true);
		}

	}




	// retourne la case selon sa position (ligne,colonne)
	public Case getCaseJeu(int i, int j){
		return t2[i][j];		

	}



	// retourne la case selon sa position (ligne)
	public Case getCaseJeu(int i){
		return (Case) getComponent(i);
	}






	// retourne la ligne de la case
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





	// retourne la colonne de la case		
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

	
/*
	public static int alea() {
		 Random rd = new Random(); 
		 return rd.nextInt(16) ;
	}
	
	*/
	
	
	public Case IndiceCase(int i) {


		switch (i) {

		case 0 :
			return getCaseJeu(0, 0);

		case 1 :
			return getCaseJeu(0, 1);

		case 2 :
			return getCaseJeu(0, 2);

		case 3 :
			return getCaseJeu(0, 3);

		case 4 :
			return getCaseJeu(1, 0);

		case 5 :
			return getCaseJeu(1, 1);

		case 6 :
			return getCaseJeu(1, 2);

		case 7 :
			return getCaseJeu(1, 3);

		case 8 :

			return getCaseJeu(2, 0);

		case 9 :

			return getCaseJeu(2, 1);

		case 10 :

			return getCaseJeu(2, 2);

		case 11 :

			return getCaseJeu(2, 3);

		case 12 :

			return getCaseJeu(3, 0);

		case 13 :
			return getCaseJeu(3, 1);

		case 14 :
			return getCaseJeu(3, 2);

		case 15 :

			return getCaseJeu(3, 3);


		}
		return null;

	}
	
	
	
	public static int alea() {
	
	int i;
	do {
		Random rd = new Random(); 
		 i =rd.nextInt(16) ;
	}while (ListenerCase.jeu.IndiceCase(i).getComponentCount()!=0);
	 System.out.println(+i);

	return i;
	}
	
	
	
	
	
	
	
}



