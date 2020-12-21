/**
 * @author BOUZIDI Siham 
 * Evenements qui se produisent lors de l'appuie sur une case du plateau de jeu ( Partie contre l'ia)
 */

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class ListenerCaseIA implements MouseListener , Serializable {
	
	private static final long serialVersionUID = 1L;
	public   Case case1;
	int i, j; //Coordon�e de la case 

	public ListenerCaseIA(Case case1, int i , int j) {
		super();
		this.case1 = case1;
		this.i=i;
		this.j=j;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	/**
	 *  M�thode Mousepressed de MouseListener 
	 *  G�re l'affichage des messages � l'ecran 
	 *  D�place le pion choisit par le joueur dans la case Reserve 
	 *   **/
	public void mousePressed(MouseEvent e) {
		Fenetre6.label_1.setVisible(true);
		Fenetre6.label_4.setVisible(false);
		case1.setSelect(true);
		//On deplace le pion qui est dans la case choix dans cette case
		Fenetre6.jeu.deplacer(case1);


	}
	/**
	 * 	MouseReleased renvoi les coordonn�es de la case s�lectionn�e � la partie jeu du code (cot� IA)
	 *   **/
	public void mouseReleased(MouseEvent e) {
		//On pose le pion choisit juste avant dans la case qui correspond de plateau de jeu
		Fenetre6.partieIA.poserPions(ListenerPionIA.p1,i,j);
		//On v�rifie si la partie n'est pas termin�e
		Fenetre6.partieIA.gagnerPartie();


	}

}




