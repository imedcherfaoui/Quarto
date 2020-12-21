import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Fenetre2 extends Fenetre1 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel pan ;
	JButton bouton1 = new JButton("1 JOUEUR");
	JButton bouton2 = new JButton("2 JOUEUR ");
	JButton bouton3 = new JButton("RETOUR");
	public static boolean  a=false;


	public Fenetre2() {
		super ();
	}

	public void buildPanel() {

		bouton1.addActionListener(this);
		bouton1.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton1.setBackground(new Color(233, 150, 122));
		bouton1.setBounds(300, 160, 255, 65);
		this.getContentPane().add(bouton1);

		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setBounds(300,260,255 , 65);
		bouton2.addActionListener(this);
		this.getContentPane().add(bouton2);

		bouton3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton3.setBackground(new Color(233, 150, 122));
		bouton3.setBounds(300,360, 255, 65);
		bouton3.addActionListener(this);
		this.getContentPane().add(bouton3);
		this.setVisible(true);
	}


	public void actionPerformed( ActionEvent ev )
	{ 

		Object ae = ev.getSource();

		if(ae == bouton1) {
			a=false;
			this.dispose();
			Fenetre5 jeu = new Fenetre5();
			jeu.buildPanel();
		} 
		if(ae == bouton2) {
			a=true;
			this.dispose();
			Fenetre6 jeu = new Fenetre6();
			try {
				jeu.buildPanel();
			} catch (IOException e) {

				e.printStackTrace();
			}

		} 
		if(ae == bouton3) {
			this.dispose();
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