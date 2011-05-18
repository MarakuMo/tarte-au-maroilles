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
		int size = hist.size();
		for (int i = 0; i < size; i++) {
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

	public static float indiceCoincidenceMutuelle(String s1, String s2) {
		Histogramme h1 = new Histogramme(s1);
		Histogramme h2 = new Histogramme(s2);
		int l1 = s1.length();
		int l2 = s2.length();
		float div = l1 * l2;
		float res = (float) 0;
		HashMap<Character, Integer> histo1 = h1.getHistogramme();
		HashMap<Character, Integer> histo2 = h2.getHistogramme();
		int size1 = histo1.size();
		int size2 = histo2.size();
		if (size1 == size2) {
			for (int i = 0; i < size1; i++) {
				char c = (char) (97 + i);
				Integer occ1 = histo1.get(c);
				Integer occ2 = histo2.get(c);
				res += occ1 * occ2;
			}
			res /= div;
		} else {
			res = -1;
			System.err
					.println("Les alphabets des deux textes sont différents.");
		}
		return res;
	}

	public String getContenuSansEspace() {
		int i = 0;
		String res = "";
		Character c;

		while (i < contenu.length()) {
			c = contenu.charAt(i);

			if (c != ' ' && c != '\n' && c != '\t') {
				res += c;
			}
			i++;
		}

		return res;
	}

	public String sousChaine(int longueur) {
		return sousChaine(longueur, 0);
	}

	public String sousChaine(int longueur, int decalage) {
		String s = getContenuSansEspace();
		String sprime = "";
		int j = decalage;
		for (int i = decalage; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ' && c != '\n' && c != '\t') {
				if (i == j) {
					// System.out.println("lettre en "+i);
					sprime += c;
					int compteur = longueur;
					int ajustement = 0;
					while (compteur > 0
							&& i + longueur - compteur + ajustement < s
									.length()) {
						char c1 = s
								.charAt(i + longueur - compteur + ajustement);

						if (c1 != ' ' && c1 != '\n' && c1 != '\t') {
							j++;
							compteur--;
						} else {
							ajustement++;
						}
					}
				}
			} else {
				// System.out.println("Espace en "+i);
				j++;
			}
		}
		return sprime;
	}

	public static String texteDecale(String si, int j) {
		String s = "";
		for (int i = 0; i < si.length(); i++) {
			s += Histogramme.alphabet.charAt((si.charAt(i) + j - 97)
					% Histogramme.alphabet.length());
		}
		return s;
	}

}
