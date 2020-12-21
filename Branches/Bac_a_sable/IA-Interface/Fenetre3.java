import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;


public class Fenetre3 extends Fenetre1 {
	

	JButton bouton1 = new JButton("Menu");
	JButton bouton2 = new JButton("Sauvegarder");

	
	 public Fenetre3() {
		  super ();
		 }
	 
	 public void buildPanel() {
		 
		 JSplitPane sp= new JSplitPane();
			JPanel p=new JPanel();
			JPanel p2=new JPanel();
			sp.setSize(new Dimension(800,600));
			sp.setDividerLocation(650);
			
			p.setLayout(new GridLayout(6,1,20,10));
			
			
			p.add(bouton1);
			bouton1.addActionListener(this);

			p.add(bouton2);
			bouton2.addActionListener(this);

			
			try {
				p2.add(new PlateauReserve());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			p2.setLayout(new GridLayout(1,2,20,10));
			
			sp.setRightComponent(p);
			sp.setLeftComponent(p2);
		
			fenetre.add(sp);
			fenetre.setVisible(true);
	    
	 }
	 
	 
	 public void actionPerformed( ActionEvent ev )
		{ 
		
		Object ae = ev.getSource();
		
		if(ae == bouton1) {
			  Fenetre4 fen4 = new Fenetre4();
			   fen4.buildPanel();
			   
			} 
		
		}
	
}
