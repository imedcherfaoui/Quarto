
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ListenerPionIA implements MouseListener {

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

	public void mousePressed(MouseEvent e) {
		Fenetre6.label_1.setVisible(false);
		Fenetre6.label_4.setVisible(false);
	
		Fenetre6.plateau.deplacer(Fenetre6.plateau.indiceCase(i, j));

	}

	public void mouseReleased(MouseEvent e) {
		c = PlateauReserve.indiceCaseCode(i,j);
		p= Fenetre6.partieIA.choisirPion(c);
		
		p1=Fenetre6.jeu.joueIA(p);
		Fenetre6.label_4.setVisible(true);














	}
}
