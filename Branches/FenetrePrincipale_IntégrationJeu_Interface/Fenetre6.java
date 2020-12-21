import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class Fenetre6 extends Fenetre1 {
	// Partie deux joueurs
	public static Partie partie ;
	// Partie un joueur
	public static PartieIA partieIA;
	public static PlateauReserve plateau;
	public static PlateauJeu jeu ;

	JButton bouton1 = new JButton("Menu");
	JButton button2 = new JButton("Sauvegarder");
	JButton button3 = new JButton("Quitter");
	JButton ok = new JButton("Ok");

	//Panel qui contient les label ci dessous
	public static JPanel panneau = new JPanel();

	//Label qui indique le joueur qui doit jouer
	public static Label label_1 = new Label("Joueur1 choisissez un pion pour votre adversaire");
	public static Label label_2 = new Label("Joueur2 posez le pion sur le plateau");
	public static Label label_3 = new Label("Joueur2 choisissez un pion pour votre adversaire");
	public static Label label_4 = new Label("Joueur1 posez le pion sur le plateau");

	//Constructeur de la Fenetre
	public Fenetre6() {
		super();
	}



	public void buildPanel() throws IOException {

		//Cas 2 joueurs crée une partie de type partie
		if(Fenetre2.a==true) partie = new Partie ();
		//Cas 1 joueur crée une partie de type partie IA
		else partieIA =  new PartieIA(Fenetre5.b);
		
		


		//Creation d un panel qui contient la reserve
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setBounds(96, 90, 693, 151);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, new Color(233, 150, 122)));
		panel.setLayout(null);


		// Creation du plateau reserve de pions

		try {
			plateau = new PlateauReserve();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		//Creation du plateau de jeu
		jeu = new PlateauJeu();
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
		//Cas 2joueurs
		if(Fenetre2.a==true)c.add(Fenetre6.plateau.choix);
		//Case 1joueurs
		else c.add(Fenetre6.plateau.choix);
		c.setLayout(new GridLayout(1,1));
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



	public void actionPerformed(ActionEvent ev) {
		Object ae = ev.getSource();
		if (ae == bouton1) {

			Fenetre4 fen4= new Fenetre4();
			fen4.buildPanel();
		}
		if (ae == button2) {
		}
		if (ae == button3) {
			System.exit(0);
		}

	}


}