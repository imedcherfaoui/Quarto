/**
 * 
 * @author CHAIBI Yamina & BOUZIDI Siham
 * 
 * Fentere généré lors de l'appuie sur le bouton MENU de la fenetre de jeu.
 * La fenetre dispose de trois boutons:
 * REPRENDRE : pour reprendre la partie 
 * NOUVELLE PARTIE : pour commencer une nouvelle partie ( ouvre une fenetre 2 avec les mode de jeu)
 * QUITTER : pour quitter l'application
 *
 */

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 *  La classe Fenetre4 est une JFrame, c'est la 3eme fenetre du jeu elle hérite de la super classe Fenetre1
 **/
public class Fenetre4 extends Fenetre1 {
	
	private static final long serialVersionUID = 1L;
	//Creation des bouttons
	/**
	 * Reprendre une partie en cours 
	 */
	JButton bouton1 = new JButton("REPRENDRE");
	/**
	 * NOUVELLE PARTIE : commencer une nouvelle partie 
	 */
	JButton bouton2 = new JButton("NOUVELLE PARTIE");
	/**
	 * QUITTER : quitter le jeu
	 */
	JButton bouton4 = new JButton("QUITTER");

	/**
	 * Constructeur de la Jframe
	 */
	public Fenetre4() {
		super ();
	}

	/**
	 *  Initialisation des composants de la Fenetre et l'ajoute au _container de la JFrame 
	 **/
	
	public void buildPanel() {
		//design et position du bouton 1
		bouton1.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton1.setBackground(new Color(233, 150, 122));
		//Position 
		bouton1.setBounds(300,160, 255, 70);
		//Ajout au panel
		this.getContentPane().add(bouton1);
		bouton1.addActionListener(this);

		//design et position du bouton 2
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.addActionListener(this);
		//Position 
		bouton2.setBounds(300, 260, 255, 70);
		//Ajout au panel
		this.getContentPane().add(bouton2);


		//design et position du bouton 4
		bouton4.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton4.setBackground(new Color(233, 150, 122));
		//Position 
		bouton4.setBounds(300, 360, 255, 70);

		//Ajout au panel
		this.getContentPane().add(bouton4);
		bouton4.addActionListener(this);

	}
	/**
	 * Méthode de définition des actions pour chaque bouton.
	 */
	public void actionPerformed( ActionEvent ev )
	{ 

		Object ae = ev.getSource();

		// bouton Reprendre la partie en cours
		if(ae == bouton1) {
			this.dispose();
			Frame[] fen6 = Fenetre6.getFrames();
			fen6[0].setVisible(true);

		}  
		// bouton Nouvelle partie 
		if(ae == bouton2) {
			this.dispose();
			//Sinon on ferme cette fenetre et la fenetre du jeu et on crée une fenetre de type Fenetre2
			Frame[] fen6 = Fenetre6.getFrames();
			fen6[0].dispose();
			Fenetre1 fen1 = new Fenetre2();
			try {
				fen1.buildPanel();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} 
		// bouton quitter 
		if(ae == bouton4) {
			System.exit(0);

		} 
	}
}