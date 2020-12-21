import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConteneurFenetre extends JPanel {

	private JLabel etiquette, descriptionPhoto;
	private JButton bouton;
	private JTextField champTexte;
	private JLabel image;
	private ImageIcon iconPhoto;
	
	public ConteneurFenetre() {
		super();
		this.proprietesConteneur();

	}

	private void proprietesConteneur() {
		this.setLayout(null);
		this.ProprietesEtiquette();
		this.PropDescriptionPhoto();
		this.PropBouton();
		this.propChampTexte();
		this.AfficheImage();

	}

	private void ProprietesEtiquette() {
		etiquette = new JLabel();
		this.etiquette.setBounds(150, 22, 350, 100);
		this.etiquette.setText("Texte de l'étiquette");
		this.add(etiquette);
	}
	
	private void PropDescriptionPhoto() {
		descriptionPhoto = new JLabel();
		this.descriptionPhoto.setBounds(150, 150, 350, 100);
		this.descriptionPhoto.setText("Photo d'un loutre");
		this.add(descriptionPhoto);
	}

	private void PropBouton() {
		bouton = new JButton();
		this.bouton.setText("Appuyer");
		this.bouton.setBounds(160, 46, 90, 20);
		this.add(bouton);
	}
	
	private void propChampTexte() {
		champTexte = new JTextField();
		this.champTexte.setBounds(150, 20, 100, 25);
		this.add(champTexte);
	}
	
	private void AfficheImage() {
		image = new JLabel();
		iconPhoto = new ImageIcon("images/loutre.jpg");
		this.image.setBounds(150, 80, 100, 100); //Taille de l'image
		this.image.setIcon(iconPhoto); //integration de l'image à son conteneur
		this.add(image);
	}
}
