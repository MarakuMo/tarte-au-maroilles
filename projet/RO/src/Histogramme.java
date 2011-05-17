import java.util.HashMap;

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

}