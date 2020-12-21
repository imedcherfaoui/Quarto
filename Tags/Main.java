package TableDeJeu;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;


public class Main {
	
	public static void main(String[] args) {
		int i,j; 
		Pions p ;
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
	
		
		// Cree la table de jeu et les pions
		TableDeJeu jeu= new TableDeJeu();
		jeu.creePions();
	
		do {
		// l'utilisateur veut jouer 
		System.out.println("Voulez vous jouer a 1 ou 2 joueur");
		i= sc.nextInt();
			sc.nextLine();
		}while(i<1 || i>2);
		
		
		//* JOUER A DEUX JOUEUR
		if(i==2) {
			
			Partie partie = new Partie(jeu);
			
			do{
				do{
					// JOUEUR 1 CHOISIT LA PIECE A JOUER  
					System.out.println("Joueur 1 vous voulez donner quel piece");
					i = sc.nextInt();
						sc.nextLine();
						
				}while((i<0 || i>15) || jeu.testCaseVide(i));
				
				p=partie.getJoueur(1).choisirPions(jeu, i);
					
				//JOUEUR 2 JOUE LA PIECE
				
				do {
					System.out.println("Joueur 2 vous voulez poser votre piece dans quelle case");
					i = sc.nextInt(); // on vide la ligne
						sc.nextLine();
					j = sc.nextInt();
						sc.nextLine();
				}while(((i<0 || i>3) && (j<0 || j>3) )|| !jeu.testCaseVide(i,j));
					 
				partie.getJoueur(2).poserPions(jeu, p, i, j); 
				// le joueur 2 place la piece donner par le joueur 1
				
				if(!jeu.testVictoire()) { // SI LA PARIE N EST PAS FINIE 
					
					do {
						// JOUEUR 2 CHOISIT LA PIECE JOUEUR
						System.out.println("Joueur 2 vous voulez donner quel piece");
						i = sc.nextInt();
						sc.nextLine();
					}while((i<0 || i>15) || jeu.testCaseVide(i));
					
					p=partie.getJoueur(2).choisirPions(jeu, i);
					
					do {
						// JOUEUR 1 JOUE LA PIECE  
						System.out.println("Joueur 1 vous voulez poser votre piece dans quelle case");
						i = sc.nextInt();
						sc.nextLine();
						j= sc.nextInt();	
						sc.nextLine();	
					}while(((i<0 || i>3) && (j<0 || j>3)) || !jeu.testCaseVide(i,j) );
				
					partie.getJoueur(1).poserPions(jeu, p,i,j);	
				}
			}while(!jeu.testVictoire());
			
		System.out.println(jeu.testVictoire());
		} 
		
		
		
		// JOUER CONTRE L ORDINATEUR
		else{
			Pions p1;
			int niv;
			
			do {
				System.out.println("Vous voulez quel niveaux");
				niv = sc.nextInt();	
			}while (niv!=1 && niv!=2 && niv!=3);
			
			Partie partie = new Partie(niv,jeu);
			JoueurIA joueur2 = (JoueurIA) partie.getJoueur(2);
			
			
			do {
				do {
					// JOUEUR 1 CHOISIT LA PIECE A JOUER  
					System.out.println("Joueur 1 vous voulez donner quel piece");
					i = sc.nextInt();
					sc.nextLine();
				}while((i<0 || i>15) || jeu.testCaseVide(i));
				
				p=partie.getJoueur(1).choisirPions(jeu, i);
				
				//IA joue le jeu
				
				p1=joueur2.meilleurCoup(jeu,p);
				
				
				do {
					// JOUEUR 1 JOUE LA PIECE  
					System.out.println("Joueur 1 vous voulez poser votre piece dans quelle case");
					i = sc.nextInt();
					sc.nextLine();
					j= sc.nextInt();	
					sc.nextLine();	
				}while(((i<0 || i>3) && (j<0 || j>3)) || !jeu.testCaseVide(i,j) );
					
				partie.getJoueur(1).poserPions(jeu, p1,i,j);	
					
				
				
			}while(!jeu.testVictoire());
			
			System.out.println(jeu.testVictoire());
			
		}
	}
}
		
		