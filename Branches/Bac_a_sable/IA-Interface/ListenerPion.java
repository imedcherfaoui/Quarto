
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class ListenerPion implements MouseListener {

	public static PlateauReserve plateau;
	Pion pion;
	static int c;
	public static Pions p;
	static Pion Cpion;

	//public static Joueur joueurChoix ;

	public ListenerPion(Pion pion, PlateauReserve plateauReserve){
		ListenerPion.plateau=plateauReserve;
		this.pion=pion;
	}



	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {
	
	}

	public void mousePressed(MouseEvent arg0) {

		
		plateau.afficherPossibilites(pion);
		plateau.deplacer();
		
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		Fenetre6.choisir();
		
	


	}

	public void mouseReleased(MouseEvent arg0) {
		//ListenerCase.iAchoisiPion();
	
		c = PlateauReserve.IndiceCaseCode(ListenerCase.plateau.a,ListenerCase.plateau.b);
		p= ListenerCase.partie.choisirPion(c);

		
		
		ListenerCase.jeu.deplacerAlea();
		iachoisiPion();
		JoueurPoseLePion();

	}



	
	public void iaPoselePion() {
	ListenerCase.jeu.deplacerAlea();
	}
	
	
	public static void iachoisiPion() {
		// ia choisi le pion le pose dans la case et le retourne pour que le joueur 1 le pose à son tour 
		Case case1 =plateau.IndiceCase(PlateauReserve.alea());
	plateau.caseActive=case1;
		Cpion=plateau.ChoisiAlea();
		plateau.afficherPossibilites(Cpion);
		plateau.deplacer();
		
		
	}
	
	public static void JoueurPoseLePion() {
		
		plateau.afficherPossibilites(Cpion);
		plateau.deplacer();
	}
	
}
