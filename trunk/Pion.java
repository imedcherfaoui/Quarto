/**
 * @author CHAIBI Yamina
 * Classe Pion,ajoute les pions au format PNG au container des cases du plateau reserve
 */
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;



public class Pion extends JPanel {

	private static final long serialVersionUID = 1436178861615738480L;


	int indice; // l'indice du pions dans la reserve
	public Pion(int indice, Pions pion) throws IOException {
		this.indice=indice;
		// opaque pour un fond d'image transparant
		setOpaque(false);
	}

	@Override



	public void paintComponent(Graphics g){
		
		super.paintComponent(g);

		switch (indice) {

		case 0 : 
			// Pion GrandCarrePlat Noir 

			java.awt.Image pion0 = null;
			try {
				pion0 = ImageIO.read(this.getClass().getResource(  "GrandCarrePlat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion0, 0, 0, getWidth(), getHeight(), this);
			break;
		case 1 :
			// Pion GrandCarrePlat Blanc

			java.awt.Image pion1 = null;
			try {
				pion1 = ImageIO.read(this.getClass().getResource(  "GrandCarrePlatBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion1, 0, 0, getWidth(), getHeight(), this);
			break;

		case 2:
			// Pion Noir GrandCarre avec un trou 

			java.awt.Image pion2 = null;
			try {
				pion2 = ImageIO.read(this.getClass().getResource(  "GrandCarreTroue.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion2, 0, 0, getWidth(), getHeight(), this);
			break;

		case 3:
			// Pion Blanc GrandCarre avec un trou  

			java.awt.Image pion3 = null;
			try {
				pion3 = ImageIO.read(this.getClass().getResource(  "GrandCarreTroueBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion3, 0, 0, getWidth(), getHeight(), this);
			break;

		case 4:
			// pion noir GrandRondPlat 

			java.awt.Image pion4 = null;
			try {
				pion4 = ImageIO.read(this.getClass().getResource(  "GrandRondPlat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion4, 0, 0, getWidth(), getHeight(), this);
			break;
		case 5:
			// pion blanc GrandRondPlat 

			java.awt.Image pion5 = null;
			try {
				pion5 = ImageIO.read(this.getClass().getResource(  "GrandRondPlatBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion5, 0, 0, getWidth(), getHeight(), this);
			break;
		case 6 :
			// Pion noir GrandRondTroue
			java.awt.Image pion6 = null;
			try {
				pion6 = ImageIO.read(this.getClass().getResource(  "GrandRondTroue.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion6, 0, 0, getWidth(), getHeight(), this);
			break;
		case 7 :
			// Pion blanc  GrandRondTroue


			java.awt.Image pion7 = null;
			try {
				pion7 = ImageIO.read(this.getClass().getResource(  "GrandRondTroueBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion7, 0, 0, getWidth(), getHeight(), this);
			break;
		case 8:
			java.awt.Image pion8 = null;
			try {
				pion8 = ImageIO.read(this.getClass().getResource(  "PetitCarrePlat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion8, 0, 0, getWidth(), getHeight(), this);
			break;
		case 9:
			java.awt.Image pion9 = null;
			try {
				pion9 = ImageIO.read(this.getClass().getResource(  "PetitCarrePlatBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			g.drawImage(pion9, 0, 0, getWidth(), getHeight(), this);
			break;
		case 10:
			java.awt.Image pion10 = null;
			try {
				pion10 = ImageIO.read(this.getClass().getResource(  "PetitCarreTroue.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion10, 0, 0, getWidth(), getHeight(), this);
			break;

		case 11:
			java.awt.Image pion11 = null;
			try {
				pion11 = ImageIO.read(this.getClass().getResource(  "PetitCarreTroueBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion11, 0, 0, getWidth(), getHeight(), this);
			break;
		case 12:
			java.awt.Image pion12 = null;
			try {
				pion12 = ImageIO.read(this.getClass().getResource(  "PetitRondPlat.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion12, 0, 0, getWidth(), getHeight(), this);
			break;

		case 13:
			java.awt.Image pion13 = null;
			try {
				pion13 = ImageIO.read(this.getClass().getResource(  "PetitRondPlatBLANC.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion13, 0, 0, getWidth(), getHeight(), this);
			break;
		case 14:
			java.awt.Image pion14 = null;
			try {
				pion14 = ImageIO.read(this.getClass().getResource(  "PetitRondTroue.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			g.drawImage(pion14, 0, 0, getWidth(), getHeight(), this);
			break;
		case 15:
			Image pion15 = null;
			try {
				pion15 = ImageIO.read(this.getClass().getResource( "PetitRondTroueBLANC.png"));
			} catch (IOException e) {

				e.printStackTrace();
			}
			g.drawImage(pion15, 0, 0, getWidth(), getHeight(), this);
			break;
		}
	}
}
