import javax.swing.JFrame;

public class Fenetre extends JFrame {

	ConteneurFenetre pan;

	public Fenetre() {
		super();
		proprietesFenetre(); // appel � la m�thode proprietesFenetre()
	}

	private void proprietesFenetre() {
		this.setSize(400, 300); // Taille de la fen�tre
		this.setResizable(false); // ne peut pas �tre redimensionn�e
		this.setLocationRelativeTo(null); // centr�e � l'�cran
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		pan = new ConteneurFenetre();
		this.setContentPane(pan);
	}
}
