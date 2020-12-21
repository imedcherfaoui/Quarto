/**
 *  @author BOUZIDI Siham & CHAIBI Yamina
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
/**
 *  Classe ListenerPion, g�re les pions du plateau de jeu et de la r�serve 
 **/
public class ListenerPion implements MouseListener , Serializable{

	private static final long serialVersionUID = 1L;
	Pion pion;
	static int c;
	public static Pions p;
	int i,j;


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
	/**
	 *  M�thode Mousepressed de MouseListener 
	 *  G�re l'affichage des messages � l'ecran 
	 *  D�place le pion de la case reserve dans le plateau de jeu et demande au joueur suivant de choisir un pion pour son adversaire  
	 *   **/
	public void mousePressed(MouseEvent arg0) {

		//deplace le pion de cette case pour le mettre dans la case choix
		Fenetre6.plateau.deplacer(Fenetre6.plateau.indiceCase(i, j));
		
		//tout les label a false et la m�thode "choisir" d�finie le label qui doit �tre initialis� � true
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		Fenetre6.choisir();
	}

	/**
	 * 	MouseReleased renvoi les coordonn�es de la case s�lectionn�e � la partie "jeu" du code 
	 *   **/
	public void mouseReleased(MouseEvent arg0) {

		c = PlateauReserve.indiceCaseCode(i,j);
		p= Fenetre6.partie.choisirPion(c);
		//On retire le pion du plateau reserve
	
		

	}
}
