import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ListenerCase implements MouseListener{

	public Case case1;
	static int c;
	public static Pions p;
	int i,j;
	
	
									
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


	public void mousePressed(MouseEvent e) {
		case1.isSelectionnee();
		Fenetre6.jeu.deplacer(case1);
		
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_2.setVisible(false);
		Fenetre6.label_3.setVisible(false);
		Fenetre6.label_4.setVisible(false);
		Fenetre6.poser();
		
		
		
	}


	public void mouseReleased(MouseEvent e) {


		Fenetre6.partie.poserPions(ListenerPion.p, i,j);
		
		
	}
}




