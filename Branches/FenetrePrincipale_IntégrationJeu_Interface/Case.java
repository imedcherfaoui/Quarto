import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;


public class Case extends JPanel {

	private static final long serialVersionUID = -1839026893240660968L;
	
	private boolean select; // vrai si la case est selectionnée faux sinon

	//Constructeur
	public Case(){
		setBackground(new Color(255, 248, 220));
		setForeground(new Color(233, 150, 122));
		setLayout(new GridLayout(1,0));
		initCouleur();
	}

	//Renvoie si la case est selectionnée ou pas
	public boolean isSelectionnee() {
		return select;
	}
	
	public void setSelect (boolean select ) {
		this.select=select;
	}

	
	//Change la couleur de la case si elle est selectionnée
	public void select() {
		if(select){
			setBackground(new Color(233, 150, 122));
			setForeground(new Color(255, 248, 220));
		}
		else {
			initCouleur();
		}
	}

	// Initialise les couleurs de la case
	private void initCouleur(){
		setBackground(new Color(255, 248, 220));
		setForeground(new Color(233, 150, 122));
	}

	// Crée les contour de la case
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
		g2d.setPaint(paint);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
	
}
