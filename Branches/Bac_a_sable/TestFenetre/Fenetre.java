import javax.swing.JFrame;

public class Fenetre extends JFrame {

	ConteneurFenetre pan;

	public Fenetre() {
		super();
		proprietesFenetre(); // appel à la méthode proprietesFenetre()
	}

	private void proprietesFenetre() {
		this.setSize(400, 300); // Taille de la fenêtre
		this.setResizable(false); // ne peut pas être redimensionnée
		this.setLocationRelativeTo(null); // centrée à l'écran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		pan = new ConteneurFenetre();
		this.setContentPane(pan);
	}
}
