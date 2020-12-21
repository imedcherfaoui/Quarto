import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class ListenerCase implements MouseListener{

	public   Case case1;
	public static PlateauReserve plateau;
	public static PlateauJeu jeu;
	static int c;
	public static Pions p;
	public static Partie partie =new Partie ();
	//public static Joueur joueurPose ;

	public ListenerCase(Case case1,PlateauJeu jeu) {
		super();
		this.case1 = case1;
		ListenerCase.jeu=jeu;
	}
	public ListenerCase(Case case1, PlateauReserve plateau) {
		super();
		this.case1 = case1;
		ListenerCase.plateau = plateau;
	}


	public void mouseClicked(MouseEvent arg0) {


	}


	public void mouseEntered(MouseEvent arg0) {

	}


	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
		
		
			case1.isSelectionnee();
			jeu.deplacer(case1);
						
			
			Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		Fenetre6.poser();
		
	}


	public void mouseReleased(MouseEvent arg0) {


		partie.poserPions(ListenerPion.p, PlateauJeu.d,PlateauJeu.e);
		partie.gagnerPartie();


	}
	
	public Pion iachoisiPion() {
		// ia choisi le pion le pose dans la case et le retourne pour que le joueur 1 le pose à son tour 
		Case case1 =ListenerCase.plateau.IndiceCase(PlateauReserve.alea());
		ListenerCase.plateau.caseActive=case1;
		Pion pion1=(Pion) ListenerCase.plateau.caseActive.getComponent(0);
		plateau.afficherPossibilites(pion1);
		plateau.deplacer();
		return pion1;
		
	}
	
	
	
	public void iaPoselePion() {
	jeu.deplacerAlea();
	}
	
	
	public static void JoueurPoseLePion(Pion p) {
		plateau.afficherPossibilites(p);
		plateau.deplacer();
	}
	
	
	
}




