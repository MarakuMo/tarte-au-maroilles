import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class Histogramme {
	// ensemble des lettres de l'alphabet
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	// Table de stockage des couples lettre / occurence
	private HashMap<Character, Integer> histo;
	// maximum d'occurence du cara
	private int maxint = 0;
	// Caractère qui apparait le plus dans le texte
	private char maxchar;

	
	// Initialisation de la table de stockage
	// les occurences de chaques lettres seront mises à 0 dans un premier temps
	public Histogramme() {
		histo = new HashMap<Character, Integer>();
		for (int i = 0; i < alphabet.length(); i++) {
			Character c = (char) (97 + i);
			histo.put(c, 0);
		}
	}

	public Histogramme(Text args0) {
		this();
		compterOcc(args0.getContenu());
	}

	public Histogramme(String text) {
		this();
		compterOcc(text);
	}

	// Prend en entrée un texte, le parcours caractère par caractère 
	// en mettant à jour le nombre d'occurence à chaque pas .
	private void compterOcc(String texte) {
		int l = texte.length();
		for (int i = 0; i < l; i++) {
			Character aux = texte.charAt(i);
			if (aux != ' ' && aux != '\n' && aux != '\t') {
				int v = this.histo.get(aux);
				v++;
				histo.put(aux, v);
				if (v > maxint) {
					maxint = v;
					maxchar = aux;
				}
			}
		}
	}

	// Affiche sur la sortie Standard le nombre d'occurence pour chaques lettres stockés dans 
	// le tableau "histo"
	public void impression() {
		int l = alphabet.length();
		for (int i = 0; i < l; i++) {
			Character aux = alphabet.charAt(i);
			Integer val = histo.get(aux);
			System.out.println("Le caractÃ¨re " + aux + " apparaÃ®t " + val
					+ " fois.");
		}
	}

	// Affiche sur la sortie Standard le caractère qui apparait le plus (avec le nombre d'apparition)
	public void afficherMax() {
		System.out.println("Le caractÃ¨re qui apparait le plus est : " + maxchar
				+ " (" + maxint + " fois).");
	}

	public HashMap<Character, Integer> getHistogramme() {
		return histo;
	}

	// trace sous forme graphique notre histogramme.
	public void paint(String titre) {
		DrawHisto d = new DrawHisto(titre);
		d.setVisible(true);
	}

	// Classe d'affichage graphique de l'histogramme 
	public class DrawHisto extends JFrame {

		private static final long serialVersionUID = 1L;
		private JPanel pnl;
		private String titre; // titre de l'histogramme

		public DrawHisto(String title) {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
					System.exit(0);
				}
			});
			titre = title;
			pnl = new JPanel(new BorderLayout());
			setContentPane(pnl);
			setSize(400, 250); // taille de la fenetre 

			DefaultCategoryDataset dataset = new DefaultCategoryDataset();

			Character c;
			int val;

			for (int i = 0; i < alphabet.length(); i++) {
				c = alphabet.charAt(i); // pour toutes les lettres de l'alphabet 
				val = histo.get(c); // on récupere le nombre d'occurence
				dataset.addValue(val, c, ""); // et on affiche sous formes d'histogramme les couples caractère/nb_occurence.
			}

			
			JFreeChart barChart = ChartFactory.createBarChart(
					"Texte de référence " + titre, "Charactères",
					"nombre d'occurence", dataset, PlotOrientation.VERTICAL,
					true, true, false);
			
			ChartPanel cPanel = new ChartPanel(barChart);
			pnl.add(cPanel);
		}

	}

}
