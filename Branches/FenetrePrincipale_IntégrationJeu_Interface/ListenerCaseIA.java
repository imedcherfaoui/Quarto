import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ListenerCaseIA implements MouseListener{


	public   Case case1;
	static int c;
	int i, j;




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

	public void mousePressed(MouseEvent e) {
		Fenetre6.label_1.setVisible(true);
		Fenetre6.label_4.setVisible(false);
		case1.setSelect(true);
		Fenetre6.jeu.deplacer(case1);


	}


	public void mouseReleased(MouseEvent e) {

		Fenetre6.partieIA.poserPions(ListenerPionIA.p1,i,j);
		Fenetre6.partieIA.p();
		Fenetre6.partieIA.gagnerPartie();


	}

}




