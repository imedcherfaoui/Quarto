import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class Fenetre4 extends Fenetre1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Creation des bouttons
	JButton bouton1 = new JButton("REPRENDRE");
	JButton bouton2 = new JButton("NOUVELLE PARTIE");
	JButton bouton4 = new JButton("QUITTER");

	public Fenetre4() {
		//appel du constructeur de la classe Fenetre1
		super ();
	}

	public void buildPanel() {
		//design et position du bouton 
		bouton1.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton1.setBackground(new Color(233, 150, 122));
		//Position 
		bouton1.setBounds(300,160, 255, 70);
		//Ajout au panel
		this.getContentPane().add(bouton1);
		bouton1.addActionListener(this);

		//design et position du bouton 
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.addActionListener(this);
		//Position 
		bouton2.setBounds(300, 260, 255, 70);
		//Ajout au panel
		this.getContentPane().add(bouton2);


		//design et position du bouton 
		bouton4.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton4.setBackground(new Color(233, 150, 122));
		//Position 
		bouton4.setBounds(300, 360, 255, 70);

		//Ajout au panel
		this.getContentPane().add(bouton4);
		bouton4.addActionListener(this);


	}


	public void actionPerformed( ActionEvent ev )
	{ 

		Object ae = ev.getSource();

		// Reprendre la partie en cours
		if(ae == bouton1) {
			this.dispose();
			;

		}  
		if(ae == bouton2) {
			this.dispose();
			Frame[] fen6 = Fenetre6.getFrames();
			fen6[0].dispose();
			Fenetre1 fen1 = new Fenetre2();
			try {
				fen1.buildPanel();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} 

		if(ae == bouton4) {
			System.exit(0);

		} 
	}
}