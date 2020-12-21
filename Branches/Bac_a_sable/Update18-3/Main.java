package TableDeJeu;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		int i,j; 
		Pions p;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		
		do {
		System.out.println("Voulez vous jouer à 1 ou 2 joueur");
		i= sc.nextInt();
		sc.nextLine(); if(i!=1 && i!=2) System.out.println("SVP choisisez 1 ou 2 !");
		}while(i<1 || i>2);
		
		if(i==2) {
			Joueur joueur_1 = new Joueur(1);
			Joueur joueur_2 = new Joueur(2);
			
			TableDeJeu jeu= new TableDeJeu();
			jeu.creePions();
			
			do {
				do{
					// JOUEUR 1 CHOISIT LA PIECE A JOUER  
					System.out.println("Joueur 1 -> vous voulez donner quelle piece ?");
					i = sc.nextInt();
						sc.nextLine();
						if((i<0 || i>15)) System.out.println("svp choisisez une pièce entre 0 et 16");
						if (jeu.testCaseVide(i)==true) System.out.println("pièce déja utilisée !");
				}while((i<0 || i>15) || jeu.testCaseVide(i)==true);
				
				p=joueur_1.choisirPions(jeu, i);
					
				//JOUEUR 2 JOUE LA PIECE
				
				do {
					System.out.println("Joueur 2 -> vous voulez poser votre piece dans quelle case ? (entre 0 et 4)");
					i = sc.nextInt();
					sc.nextLine();
					j= sc.nextInt();
					sc.nextLine();
					if((i<0 || i>3) || (j<0 || j>3)) System.out.println("svp choisisez des chiffres entre 0 et 4");
					if (jeu.testCaseVide(i,j)==false) System.out.println("case déja utilisée !");
				}while((i<0 || i>3) || (j<0 || j>3) || jeu.testCaseVide(i,j)==false);
					
				joueur_2.poserPions(jeu, p, i, j);
				
				
				
			
				if(jeu.testVictoire()==false) { // SI LA PARIE N EST PAS FINIE 
					
					do {
						// JOUEUR 2 CHOISIT LA PIECE JOUEUR
						System.out.println("Joueur 2 -> vous voulez donner quelle piece ?");
						i = sc.nextInt();
						sc.nextLine();
						if((i<0 || i>15)) System.out.println("svp choisisez une pièce entre 0 et 16");
						if (jeu.testCaseVide(i)==true) System.out.println("pièce déja utilisée !");
					}while((i<0 || i>15) || jeu.testCaseVide(i)==true );
					
					p=joueur_2.choisirPions(jeu, i);
					
					do {
						// JOUEUR 1 JOUE LA PIECE  
						System.out.println("Joueur 1 -> vous voulez poser votre piece dans quelle case ? (entre 0 et 4)");
						i = sc.nextInt();
						sc.nextLine();
						j= sc.nextInt();	
						sc.nextLine();	
						if((i<0 || i>3) || (j<0 || j>3)) System.out.println("svp choisisez des chiffres entre 1 et 5");
						if (jeu.testCaseVide(i,j)==false) System.out.println("case déja utilisée !");
					}while((i<0 || i>3) || (j<0 || j>3) || jeu.testCaseVide(i,j)==false );
					
					joueur_1.poserPions(jeu, p, i, j);
					
				}
				
			}while(jeu.testVictoire()==false);
			
			System.out.println("le jeu est fini");
			
			
		}
		else {
			
			Joueur joueur_1 = new Joueur(1);
			JoueurIA joueur_2 = new JoueurIA();
			
			TableDeJeu jeu= new TableDeJeu();
			jeu.creePions();
			
			do {
				do {
					// JOUEUR 1 CHOISIT LA PIECE A JOUER  
					System.out.println("Joueur 1 -> vous voulez donner quelle piece");
					i = sc.nextInt();
					sc.nextLine();
					if((i<0 || i>15)) System.out.println("svp choisisez une pièce entre 0 et 16");
					if (jeu.testCaseVide(i)==true) System.out.println("pièce déja utilisée !");
				}while((i<0 || i>15) || jeu.testCaseVide(i)==true );
				
				p=joueur_1.choisirPions(jeu, i);

				//IA joue la piece
				joueur_2.poserPionsIA(jeu, p);
				
				if(jeu.testVictoire()==false) { // SI LA PARTIE N EST PAS TERMINEE
					
					p=joueur_2.choisirPionsIA(jeu);
					p.getPions();;
					do {
						// JOUEUR 1 PLACE LE PION
						System.out.println("Joueur 1 -> vous voulez poser votre piece dans quelle case ? (entre 0 et 4)");
						i = sc.nextInt();
						sc.nextLine();
						j= sc.nextInt();
						sc.nextLine();
						if((i<0 || i>3) || (j<0 || j>3)) System.out.println("svp choisisez des chiffres entre 1 et 5");
						if(jeu.testCaseVide(i,j)==false) System.out.println("Case déja utilisée !");
					}while((i<0 || i>3) || (j<0 || j>3) || jeu.testCaseVide(i,j)==false);
					
					joueur_1.poserPions(jeu, p, i, j);
					
				}
				
			}while(jeu.testVictoire()==false);
			
		}	
	}
}