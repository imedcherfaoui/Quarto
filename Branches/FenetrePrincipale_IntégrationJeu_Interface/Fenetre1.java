import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Fenetre1 extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JFrame fenetre;
	JPanel pan;
	JLabel quarto = new JLabel("QUARTO!");
	JButton bouton2 = new JButton("CHARGER PARTIE");
	JButton bouton3 = new JButton("NOUVELLE PARTIE");
	JButton bouton4 = new JButton("QUITTER");

	public Fenetre1() {

		//JFrame frame = new JFrame("Quarto");
		this.getContentPane().setBackground(new Color(255, 248, 220));
		this.getContentPane().setForeground(new Color(233, 150, 122));
		this.setBounds(230, 10,900, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		this.setVisible(true);	
	}

	public void buildPanel() throws IOException{

		
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

	public void actionPerformed(ActionEvent ev) {

		Object ae = ev.getSource();

		if (ae == bouton4) {
			System.exit(0);
		}
		if (ae == bouton3) {
			this.dispose();
			Fenetre2 fen2 = new Fenetre2();
			fen2.buildPanel();
			

		}

	}
}