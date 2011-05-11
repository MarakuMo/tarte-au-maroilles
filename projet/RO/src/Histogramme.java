import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Histogramme {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public HashMap<Character, Integer> histo;
	int maxint = 0;
	char maxchar;
	private String text;

	public Histogramme() {
		histo = new HashMap<Character, Integer>();
	}

	public Histogramme(Text args0) {
/*		String fichier = args0;
		String texte = "";*/

		// lecture du fichier texte
		try {
/*			InputStream ips = new FileInputStream(fichier);
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			String ligne;
			while ((ligne = br.readLine()) != null) {
				texte += ligne + "\n";
			}
			br.close();*/
			histo = new HashMap<Character, Integer>();
			classer(args0.getContenu());
			impression();
			max();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private void classer(String texte) {
		int l = texte.length();
		Character aux;
		Integer occ;

		for (int i = 0; i < l; i++) {
			aux = texte.charAt(i);
			occ = histo.remove(aux);
			if (occ == null) {
				occ = 0;
			}
			occ++;
			if (occ > maxint) {
				maxint = occ;
				maxchar = aux;
			}
			histo.put(aux, occ);
		}
	}

	public void impression() {
		int l = alphabet.length();
		Character aux;
		Integer val;

		for (int i = 0; i < l; i++) {
			aux = alphabet.charAt(i);
			val = histo.get(aux);
			if (val == null) {
				val = 0;
			}
			System.out.println("Le caractère " + aux + " apparaît " + val
					+ "fois.");
		}
	}

	public void max() {
		System.out.println("Le caractère qui apparait le plus est : " + maxchar
				+ " (" + maxint + " fois)");
	}

	public HashMap<Character, Integer> getHistogramme() {
		return histo;
	}

}