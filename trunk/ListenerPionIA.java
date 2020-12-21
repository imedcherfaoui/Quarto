/**
 * 
 * @author BOUZIDI Siham 
 * Evenements qui se produisent lors de l'appuie sur une case du plateau reserve ( partie contre l'ia)
 *
 */
 
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;


public class ListenerPionIA implements MouseListener  , Serializable  {

	private static final long serialVersionUID = 1L;
	static MouseEvent e ;
	Pion pion;
	static int c;
	int i, j;
	public static Pions p, p1 ;

	public ListenerPionIA(Pion pion, int i , int j){
		this.pion=pion;
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
	 *  D�place le pion de la case reserve dans le plateau de jeu 
	 *   **/
	public void mousePressed(MouseEvent e) {
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		//deplacement de ce pion dans la case choix 
		Fenetre6.plateau.deplacer(Fenetre6.plateau.indiceCase(i, j));

	}
	/**
	 * 	MouseReleased renvoi les coordonn�es de la case s�lectionn�e � la partie "jeu" du code (cot� IA)
	 *   **/
	public void mouseReleased(MouseEvent e) {
		//retire le pion choisit du plateau reserve
		c = PlateauReserve.indiceCaseCode(i,j);
		p= Fenetre6.partieIA.choisirPion(c);
		//L IA joue 
		p1=Fenetre6.jeu.joueIA(p);
		//Met le label4 a true pour que le joueur sache que c est a son tour de poser 
		Fenetre6.label_4.setVisible(true);

	}
}
