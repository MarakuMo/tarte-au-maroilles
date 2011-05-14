import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Text {

	private String contenu;

	public Text(String filepath) throws IOException {
		String texte = "";
		InputStream ips = new FileInputStream(filepath);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		String ligne;
		while ((ligne = br.readLine()) != null) {
			texte += ligne + "\n";
		}
		br.close();
		contenu = texte;
	}

	public Text(String filepath, String text) throws IOException {
		this(filepath);
		this.contenu = text;
	}

	public String getContenu() {
		return contenu;
	}

	public static float indiceCoincidence(String text) {
		int l = text.length();
		Histogramme h = new Histogramme(text);
		HashMap<Character, Integer> hist = h.getHistogramme();
		int somme = 0;
		for (int i = 0; i < 25; i++) {
			char c = (char) (97 + i);
			Integer occ = hist.get(c);
			somme += occ * (occ - 1);
		}
		float somme1 = ((Integer) somme).floatValue();
		int div = l * (l - 1);
		float div1 = ((Integer) div).floatValue();
		float ic = somme1 / div1;
		return ic;
	}

	public String sousChaine(int longueur) {
		String s = this.contenu;
		String sprime = "";
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ' && c != '\n' && c != '\t') {
				if (i == j) {
					// System.out.println(i);
					sprime += c;
					j += longueur;
				}
			} else {
				// System.out.println("Espace en "+i);
				j++;
			}
		}
		return sprime;
	}
}
