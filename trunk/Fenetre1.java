
/**
 * @author CHAIBI yamina & BOUZIDI Siham .
 */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 *  La classe Fenetre1 est une JFrame, c'est la 1ere fenetre du jeu
 *  Cette classe implémente ActionListener pour gérer les boutons
 **/

public class Fenetre1 extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	/**
	 * La Fenetre du jeu .
	 */
	JFrame fenetre;
	/**
	 * le panel qui contient tous les élèments de la Fenetre 
	 */
	JPanel pan;
	
	JLabel quarto = new JLabel("QUARTO!");
	/**
	 * CHARGER PARTIE : charger une partie sauvgardée
	 */
	JButton bouton2 = new JButton("CHARGER PARTIE");
	/**
	 * NOUVELLE PARTIE : commencer une nouvelle partie 
	 */
	JButton bouton3 = new JButton("NOUVELLE PARTIE");
	/**
	 * QUITTER : quitter le jeu
	 */
	JButton bouton4 = new JButton("QUITTER");

	
	/**
	 * Constructeur de la Jframe
	 */
	public Fenetre1() {

		//Constructeur 
		
		this.getContentPane().setBackground(new Color(255, 248, 220));
		this.getContentPane().setForeground(new Color(233, 150, 122));
		this.setBounds(230, 10,900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);	
	}

	/**
	 *  Initialisation des composants de la Fenetre et l'ajoute au _container de la JFrame 
	 **/
	
	public void buildPanel() throws IOException{

		//Constructeur des boutons
		
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.addActionListener(this);
		bouton2.setBounds(300, 160, 255, 80);
		this.getContentPane().add(bouton2);
		
		bouton3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton3.setBackground(new Color(233, 150, 122));
		bouton3.setBounds(300, 260, 255, 80);
		this.getContentPane().add(bouton3);
		bouton3.addActionListener(this);
		
		bouton4.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton4.setBackground(new Color(233, 150, 122));
		bouton4.setBounds(300, 360, 255, 80);
		this.getContentPane().add(bouton4);
		bouton4.addActionListener(this);
		
		quarto.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC,40 ));
		quarto.setBounds(330, 60, 200, 100);
		this.getContentPane().add(quarto);
		
		this.setVisible(true);
	}
	
	/**
	 * Cette méthode permet de charger des Objets à partir du nom de fichier défini.
	 */
	public void charger()
	{
		//Charge le mode de jeu
		boolean mode = (boolean) Serialisation.readSerializable("sauvegardermode.txt");
		//Charge la fenetre de jeu
		Fenetre6 f = Serialisation.readSerializableFenetre("sauvegarde.txt");
		//Charge le plateau de jeu
		PlateauJeu jeu = (PlateauJeu) Serialisation.readSerializable("sauvegarderJeu.txt");
		//Charge le plateau reserve
		PlateauReserve plateau = (PlateauReserve) Serialisation.readSerializable("sauvegarderPlateau.txt");
		
		if( mode==false){
			PartieIA partie = (PartieIA) Serialisation.readSerializable("sauvegarderPartie.txt");
			f.reprendre(partie, plateau, jeu);
		}
		else {
			Partie partie = (Partie) Serialisation.readSerializable("sauvegarderPartie.txt");
			f.reprendre(partie, plateau, jeu);
		}
	
		try {
			f.buildPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Méthode de définition des actions pour chaque bouton.
	 */
	public void actionPerformed(ActionEvent ev) {

		Object ae = ev.getSource();
		// bouton charger 
		if (ae == bouton2) {
			this.dispose();
			charger();
		}
		// bouton nouvelle partie
		if (ae == bouton3) {
			this.dispose();
			Fenetre2 fen2 = new Fenetre2();
			fen2.buildPanel();
		}
		// bouton Quitter
		if (ae == bouton4) {
			System.exit(0);
		}

	}
}