package rech;

import java.io.IOException;
import java.util.HashMap;

public class TestLongueurCle {

	public static void main(String[] args) throws IOException {
		String pathTexte = "/home/med/NetBeansProjects/rech/src/rech/Chiffre4";
		
		Text t = new Text(pathTexte);
				//int n = Kasiski.longueurCle(t, 100);
              
                //HashMap<Integer, Float> hmIC = Kasiski.remplirIC(t,t.getContenu().length()/100);
		HashMap<Integer, Float> hmIC = Kasiski.remplirIC(t,100);
		DrawIC d = new DrawIC(hmIC);
                d.setVisible(true);

	}
}