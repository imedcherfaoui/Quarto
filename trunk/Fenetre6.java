
/**
 * 
 * @author CHAIBI Yamina & BOUZDDI siham
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

/**
 *  La classe Fenetre6 est une JFrame, c'est la fenetre de jeu principale
 *  Cette classe implémente Serialisable pour gérer la sauvegarde de partie 
 **/
public class Fenetre6 extends Fenetre1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Partie Joueur 1 - Joueur 2 
	 */
	public static Partie partie ;
	/**
	 * Partie Joueur - Ordinateur
	 */
	public static PartieIA partieIA;
	/**
	 * Plateau Reserve du jeu : stock les pions  
	 */
	public static PlateauReserve plateau;
	/**
	 * Plateau du jeu
	 */
	public static PlateauJeu jeu ;
	
	public boolean mode;
	/**
	 * Ouverture 1ere page du jeu, le menu 
	 */
	JButton bouton1 = new JButton("Menu");
	/**
	 * Sauvegarder une partie en cours
	 */
	JButton button2 = new JButton("Sauvegarder");
	/**
	 * QUITTER : quitter le jeu
	 */
	JButton button3 = new JButton("Quitter");
	/**
	 * Bouton OK 
	 */
	JButton ok = new JButton("Ok");
	/**
	 Panel qui contient les labels ci-dessous
	 */
	public static JPanel panneau = new JPanel();

	//Label qui indique le joueur qui doit jouer
	public static Label label_1 = new Label("Joueur1 choisissez un pion pour votre adversaire");
	public static Label label_2 = new Label("Joueur2 posez le pion sur le plateau");
	public static Label label_3 = new Label("Joueur2 choisissez un pion pour votre adversaire");
	public static Label label_4 = new Label("Joueur1 posez le pion sur le plateau");

	/**
	 * Constructeur de la Jframe
	 */
	public Fenetre6() {
		super();
	}
	
	/**
	 * Cette méthode permet de charger les Objets de la partieIA à partir des Objets passés en paramètre
	 */
	public void reprendre(PartieIA partieIA, PlateauReserve plateau, PlateauJeu jeu ) {
		this.partieIA = partieIA;
		this.plateau = plateau;
		this.jeu = jeu;
	}

	/**
	 * Cette méthode permet de charger les Objets de la partie à partir des Objets passés en paramètre
	 */
	public void reprendre(Partie partie, PlateauReserve plateau, PlateauJeu jeu) {
		this.partie = partie;
		this.plateau = plateau;
		this.jeu = jeu;
	}
	
	/**
	 * Cette méthode crée une partie selon le mode
	 */
	public void cree() {
		mode=Fenetre2.a;
		//Cas 2 joueurs crée une partie de type partie
		if(mode==true) partie = new Partie ();
		//Cas 1 joueur crée une partie de type partie IA
		else partieIA =  new PartieIA(Fenetre5.b);
		
		try {
			plateau = new PlateauReserve();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Creation du plateau de jeu
		jeu = new PlateauJeu();
	}
	
	/**
	 *  Initialisation des composants de la Fenetre et l'ajoute au _container de la JFrame 
	 **/
	public void buildPanel() throws IOException {

		//Creation d un panel qui contient la reserve
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setBounds(96, 90, 693, 151);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(233, 150, 122)));
		panel.setLayout(null);
		
		
		plateau.setForeground(new Color(233, 150, 122));
		plateau.setBounds(10, 11, 673, 129);
		panel.add(plateau);
		getContentPane().add(panel);

		//Creation du panel qui contient le plateau de jeu
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(233, 150, 122));
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, new Color(233, 150, 122)));
		panel_1.setBounds(191, 269, 516, 349);
		panel_1.setLayout(null);

		
		jeu.setBounds(10, 11, 496, 327);
		panel_1.add(jeu);
		getContentPane().add(panel_1);

		//Creation du bouton Menu avec son design

		bouton1.setBackground(new Color(233, 150, 122));
		bouton1.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC,18));
		bouton1.setBounds(180, 11, 120, 60); //Positon 
		bouton1.addActionListener(this); // Ajout d une action au bouton
		getContentPane().add(bouton1); //Ajout au panel

		// Creation du bouton sauvgarder avec son design
		button2.setBackground(new Color(233, 150, 122));
		button2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		button2.setBounds(378, 11, 140, 60); //Positon
		button2.addActionListener(this); // Ajout d une action au bouton
		getContentPane().add(button2); //Ajout au panel

		//Creation du bouton quitter avec son design
		button3.setBackground(new Color(233, 150, 122));
		button3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 18));
		button3.setBounds(586, 11, 120, 60); //Positon 
		button3.addActionListener(this); // Ajout d une action au bouton
		getContentPane().add(button3); //Ajout au panel

		label_1.setFont(new Font("Arial", Font.BOLD, 18));
		label_1.setAlignment(Label.CENTER);
		label_1.setBounds(210, 243, 460, 30);
		getContentPane().add(label_1);
		label_1.setVisible(true);

		label_2.setFont(new Font("Arial", Font.BOLD, 23));
		label_2.setAlignment(Label.CENTER);
		label_2.setBounds(210, 243, 453, 30);
		getContentPane().add(label_2);
		label_2.setVisible(false);

		label_3.setFont(new Font("Arial", Font.BOLD, 18));
		label_3.setAlignment(Label.CENTER);
		label_3.setBounds(210, 243, 460, 30);
		getContentPane().add(label_3);
		label_3.setVisible(false);

		label_4.setFont(new Font("Arial", Font.BOLD, 23));
		label_4.setAlignment(Label.CENTER);
		label_4.setBounds(210, 243, 453, 30);
		getContentPane().add(label_4);
		label_4.setVisible(false);

		JPanel c= new JPanel();
		c.setBackground(new Color(233, 150, 122));
		c.setBorder(new MatteBorder(1, 1, 1, 1, new Color(233, 150, 122)));
		c.setBounds(744, 309, 102, 92);
		c.setLayout(new GridLayout(1,1));
		c.add(Fenetre6.plateau.choix);
		getContentPane().add(c);

		setVisible(true);
	}

	//Label pour indiquer le joueur qui doit poser le pion dans le cas 2 joueurs
	public static void poser() {
		if (Fenetre6.partie.prochJoueur()==0) {
			Fenetre6.label_1.setVisible(true);
		}else {
			Fenetre6.label_3.setVisible(true);
		}
	}

	// Label pour indiquer le joueur qui doit choisir le pion dans le Cas 2 joueurs
	public static void choisir() {
		if(Fenetre6.partie.prochJoueur()==0) {
			Fenetre6.label_2.setVisible(true);
		}else {
			Fenetre6.label_4.setVisible(true);
		}
	}
	
	/**
	 * Cette méthode permet de sauvegarder par méthode de sérialisation, des Objets dans chaque fichier défini.
	 */
	public void sauvgarder() {
		Serialisation.saveSerializable(this,"sauvegarde.txt");
		Serialisation.saveSerializable(jeu,"sauvegarderJeu.txt");
		Serialisation.saveSerializable(plateau,"sauvegarderPlateau.txt");
		Serialisation.saveSerializable(mode,"sauvegardermode.txt");
		if(mode==true)
			Serialisation.saveSerializable(partie,"sauvegarderPartie.txt");
		else 
			Serialisation.saveSerializable(partieIA,"sauvegarderPartie.txt");
		
	}

	/**
	 * Méthode de définition des actions pour chaque bouton.
	 */
	public void actionPerformed(ActionEvent ev) {
		
		Object ae = ev.getSource();
		// Menu
		if (ae == bouton1) {
			this.setVisible(false);
			Fenetre4 fen4= new Fenetre4();
			fen4.buildPanel();
		}
		// sauvegarder
		if (ae == button2) {
			sauvgarder();
		}
		//Quitter
		if (ae == button3) {
			System.exit(0);
		}

	}


}