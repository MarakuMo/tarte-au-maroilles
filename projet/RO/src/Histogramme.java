package rech;

import java.util.HashMap;
import java.util.Iterator;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset;

public class Histogramme {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private HashMap<Character, Integer> histo;
	private int maxint = 0;
	private char maxchar;

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
		// impression();
		// afficherMax();
	}

	public Histogramme(String text) {
		this();
		compterOcc(text);
	}

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

	public void impression() {
		int l = alphabet.length();
		for (int i = 0; i < l; i++) {
			Character aux = alphabet.charAt(i);
			Integer val = histo.get(aux);
			System.out.println("Le caractère " + aux + " apparaît " + val
					+ " fois.");
		}
	}

	public void afficherMax() {
		System.out.println("Le caractère qui apparait le plus est : " + maxchar
				+ " (" + maxint + " fois).");
	}

	public HashMap<Character, Integer> getHistogramme() {
		return histo;
	}
	
	public void paint(String titre){
		DrawHisto d= new DrawHisto(titre);
		d.setVisible(true);
	}
	
	
	public class DrawHisto extends JFrame { 

		private static final long serialVersionUID = 1L;
		private JPanel pnl; 
		private String titre;

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
	    setSize(400, 250); 

	    DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
	    
		Character c;
		int val ;
		
		for (int i= 0; i<alphabet.length();i++){
			c = alphabet.charAt(i) ;
			val = histo.get(c);
			dataset.addValue(val, c ,"");
		}
	    
	   
	    JFreeChart barChart = ChartFactory.createBarChart("Texte de référence " + titre, "Charactères", 
	      "nombre d'occurence", dataset, PlotOrientation.VERTICAL, true, true, false); 
	    ChartPanel cPanel = new ChartPanel(barChart); 
	    pnl.add(cPanel); 
	  } 

//	  public static void main(String[] args) { 
//	    TestBarChart tbc = new TestBarChart(); 
//	    tbc. 
//	  } 
	}

}

 







