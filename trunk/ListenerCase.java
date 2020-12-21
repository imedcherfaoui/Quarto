/**
 *  @author CHAIBI Yamina & BOUZIDI Siham
 */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
/**
 *  Classe ListenerCase, g�re les cases du plateau de jeu et de la r�serve 
 **/
public class ListenerCase implements MouseListener , Serializable{
	private static final long serialVersionUID = 1L;
	public Case case1;
	static int c;
	int i,j; //Coordon�e de la case 
	
	
									
	//public static Joueur joueurPose ;
	public ListenerCase(Case case1,int i , int j) {
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
		case1.isSelectionnee();
		//On place le Pion qui est dans la case choix dans cette case
		Fenetre6.jeu.deplacer(case1);
		
		//On remet tout les label a false
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		//La m�thode poser choisit quel labet mettre en visible 
		Fenetre6.poser();
	}
	/**
	 * 	MouseReleased renvoi les coordonn�es de la case s�lectionn�e � la partie jeu du code 
	 *   **/
	public void mouseReleased(MouseEvent e) {

		//On pose le pion choisit  dans le plateau de jeu
		Fenetre6.partie.poserPions(ListenerPion.p, i,j);
		//On verifie si la partie est termin�
		Fenetre6.partie.gagnerPartie();
	}
}