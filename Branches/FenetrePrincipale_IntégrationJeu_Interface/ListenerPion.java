
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;


public class ListenerPion implements MouseListener {

	Pion pion;
	static int c;
	public static Pions p;
	static Pion Cpion;
	int i,j;

	//public static Joueur joueurChoix ;

	public ListenerPion(Pion pion,int i , int j){
		this.pion=pion;
		this.i=i;
		this.j=j;
	}



	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

		//Fenetre6.plateau.caseDuPion(pion);
		Fenetre6.plateau.deplacer(Fenetre6.plateau.indiceCase(i, j));
		
		
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		Fenetre6.choisir();
	}

	public void mouseReleased(MouseEvent arg0) {

		c = PlateauReserve.indiceCaseCode(i,j);
		p= Fenetre6.partie.choisirPion(c);
		
	
		

	}
}
