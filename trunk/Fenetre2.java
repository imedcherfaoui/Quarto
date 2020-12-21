/**
 * @author  CHAIBI yamina & BOUZIDI Siham
 */

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;


/**
 *  La classe Fenetre2 est une JFrame, c'est la 2eme fenetre du jeu elle hérite de la super classe Fenetre1
 **/

public class Fenetre2 extends Fenetre1 {

	private static final long serialVersionUID = 1L;
	
	/**
	 * le panel qui contient tous les élèments de la Fenetre 
	 */
	JPanel pan ;
	/**
	 * Choix joueur :1er joueur 
	 */
	JButton bouton1 = new JButton("1 JOUEUR");
	/**
	 * Choix joueur :2eme joueur 
	 */
	JButton bouton2 = new JButton("2 JOUEURS ");
	/**
	 * Retour fenetre précédente 
	 */
	JButton bouton3 = new JButton("RETOUR");
	
	//permet de savoir quel mode de jeu le joueur a choisit
	public static boolean  a=false; 
	
	/**
	 * Constructeur de la Jframe
	 */
	
	public Fenetre2() {
		super ();
	}
	/**
	 *  Initialisation des composants de la Fenetre et l'ajoute au _container de la JFrame 
	 **/
	
	public void buildPanel() {

		//Constructeur des boutons
		
		// bouton joueur1
		bouton1.addActionListener(this);
		bouton1.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton1.setBackground(new Color(233, 150, 122));
		bouton1.setBounds(300, 160, 255, 65);
		this.getContentPane().add(bouton1);

		// bouton joueur2
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setBounds(300,260,255 , 65);
		bouton2.addActionListener(this);
		this.getContentPane().add(bouton2);

		// bouton Retour
		bouton3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton3.setBackground(new Color(233, 150, 122));
		bouton3.setBounds(300,360, 255, 65);
		bouton3.addActionListener(this);
		this.getContentPane().add(bouton3);
		this.setVisible(true);
	}

	/**
	 * Méthode de définition des actions pour chaque bouton.
	 */
	public void actionPerformed( ActionEvent ev )
	{ 

		Object ae = ev.getSource();

		//Si le joueur appuit sur le bouton 1, cette fenetre se ferme et crée une fenetre de type fenetre 5
		if(ae == bouton1) {
			a=false;
			this.dispose();
			Fenetre5 jeu = new Fenetre5();
			jeu.buildPanel();
		} 
		//Si le joueur appuit sur le bouton 2, cette fenetre se ferme et crée une fenetre de type Fenetre6 ( plateau de jeu)
		if(ae == bouton2) {
			a=true;
			this.dispose();
			Fenetre6 jeu = new Fenetre6();
			jeu.cree();
			try {
				jeu.buildPanel();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} 
		//Si le joueur appuit sur le bouton 3
		if(ae == bouton3) {
			this.dispose();
			//Cette fenetre se ferme et Crée une fenetre1
			Fenetre1 fen1 = new Fenetre1();
			try {
				fen1.buildPanel();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fen1.setVisible(true);

		} 
	}
}