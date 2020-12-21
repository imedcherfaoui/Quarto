

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Fenetre5 extends Fenetre1 implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	JLabel quarto = new JLabel("Choisissez le niveau:");
	JButton bouton2 = new JButton("FACILE");
	JButton bouton3 = new JButton("MOYEN");
	JButton bouton4 = new JButton("DIFFICILE");
	JButton bouton5 = new JButton("RETOUR");
	public static int b=0;

	public Fenetre5() {
		super();
	}

	public void buildPanel() {


		bouton2.setBackground(new Color(233, 150, 122));
		bouton2.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton2.addActionListener(this);
		bouton2.setBounds(300, 150, 255 , 60);
		this.getContentPane().add(bouton2);


		bouton3.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC, 20));
		bouton3.setBackground(new Color(233, 150, 122));
		bouton3.setBounds(300, 230, 255 , 60);
		this.getContentPane().add(bouton3);
		bouton3.addActionListener(this);



		bouton4.setFont(new Font("Book Antiqua", Font.BOLD | Font.ITALIC,20));
		bouton4.setBackground(new Color(233, 150, 122));
		bouton4.setBounds(300, 310, 255 , 60);
		this.getContentPane().add(bouton4);
		bouton4.addActionListener(this);
		
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

	public void actionPerformed(ActionEvent ev) {

		Object ae = ev.getSource();

		if (ae == bouton2) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=0;
			
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ae == bouton3) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=1;
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ae == bouton4) {
			this.dispose();
			Fenetre6 fen6= new Fenetre6();
			b=2;
			try {
				fen6.buildPanel();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ae == bouton5) {
			this.dispose();
			Fenetre2 fen2 = new Fenetre2();
			fen2.buildPanel();
			fen2.setVisible(true);
		} 
		
		

	}
}

