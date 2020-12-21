
/**
 * @author BOUZIDI Siham & CHAIBI Yamina
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *  La classe Fenetre5 est une JFrame, c'est la 4eme fenetre du jeu elle hérite de la super classe Fenetre1
 **/
public class Fenetre5 extends Fenetre1 implements ActionListener {

	
	private static final long serialVersionUID = 1L;


	JLabel quarto = new JLabel("Choisissez le niveau:");
	/**
	 * Choix type de partie : Facile 
	 **/
	JButton bouton2 = new JButton("FACILE");
	/**
	 * Choix type de partie : Moyen
	 **/
	JButton bouton3 = new JButton("MOYEN");
	/**
	 * Choix type de partie : Difficile 
	 **/
	JButton bouton4 = new JButton("DIFFICILE");
	/**
	 * Retour fenetre précédente 
	 */
	JButton bouton5 = new JButton("RETOUR");
	
	public static int b=0;

	/**
	 * Constructeur de la Jframe
	 */
	public Fenetre5() {
		super();
	}	
	/**
	 *  Initialisation des composants de la Fenetre et l'ajoute au _container de la JFrame 
	 **/
	public void buildPanel() {
		// bouton2 
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.addActionListener(this);
		bouton2.setBounds(300, 150, 255 , 60);
		this.getContentPane().add(bouton2);
		
		// bouton3
		bouton3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton3.setBackground(new Color(233, 150, 122));
		bouton3.setBounds(300, 230, 255 , 60);
		this.getContentPane().add(bouton3);
		bouton3.addActionListener(this);
		
		// bouton4
		bouton4.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC,20));
		bouton4.setBackground(new Color(233, 150, 122));
		bouton4.setBounds(300, 310, 255 , 60);
		this.getContentPane().add(bouton4);
		bouton4.addActionListener(this);
		
		// bouton5
		bouton5.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton5.setBackground(new Color(233, 150, 122));
		bouton5.setBounds(300, 390, 255 , 60);
		this.getContentPane().add(bouton5);
		bouton5.addActionListener(this);

		quarto.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 25));
		quarto.setBounds(320, 0, 300, 250);
		this.getContentPane().add(quarto);

		this.setVisible(true);
	}

	/**
	 * Méthode de définition des actions pour chaque bouton.
	 */
	public void actionPerformed(ActionEvent ev) {

		Object ae = ev.getSource();
		// bouton FACILE 
		if (ae == bouton2) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=0;
			fen6.cree();
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// bouton MOYEN
		if (ae == bouton3) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=1;
			fen6.cree();
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// bouton DIFFICILE
		if (ae == bouton4) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=2;
			fen6.cree();
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// bouton retour
		if(ae == bouton5) {
			this.dispose();
			Fenetre2 fen2 = new Fenetre2();
			fen2.buildPanel();
			fen2.setVisible(true);
		} 
		
		

	}
}

