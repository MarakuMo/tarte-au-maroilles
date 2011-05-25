import java.util.HashMap;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class DrawIC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnl;
	private String titre;
	private HashMap<Integer, Float> hmIC; 

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
		setSize(400, 250);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		int t = hmIC.values().size();

		for (Integer i = 0; i < t; i++) {

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