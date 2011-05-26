import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;


// Classe qui permet de tracer les indices de coincidences, donnant à l'utilisateur
// une vision plus globale du problème.
public class DrawIC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnl;
	private String titre;
	private HashMap<Integer, Float> hmIC; // Tableau des couples longeur, IC(longueur) 

	public DrawIC(HashMap<Integer, Float> hmic) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
		this.hmIC = hmic;
		titre = "valeur de IC pour tous les Characters";
		pnl = new JPanel(new BorderLayout());
		setContentPane(pnl);
		setSize(400, 250); // taille de la fenetre

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		int t = hmIC.values().size();

		for (Integer i = 0; i < t; i++) { // pour toutes les longueurs disponibles
			// on associe à cette longueur son indice de coincidences (un baton de l'histogramme)
			dataset.addValue(hmIC.get(i), "", i.toString());
		}

		JFreeChart barChart = ChartFactory.createBarChart(
				"Texte de référence " + titre, "longueur de clef :",
				"Indices de coinsidence IC", dataset, PlotOrientation.VERTICAL,
				true, true, true);
		ChartPanel cPanel = new ChartPanel(barChart);
		pnl.add(cPanel);
	}

}