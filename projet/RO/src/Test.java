import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		Text t = new Text(
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt");
		float i = Text.indiceCoincidence(t.getContenu());
		System.out.println("IC du texte entier = " + i + "\n");
		float maxmax = 0;
		int maxlong = 0;
		for (int lsc = 10; lsc > 2; lsc--) {

			float max = 0;
			for (int j = 0; j < t.getContenu().length() - lsc; j++) {
				String s = t.sousChaine(lsc, j);
				float k = Text.indiceCoincidence(s);
				if (k > max) {
					max = k;
				}
			}
			max /= t.getContenu().length();
			System.out.println(lsc + " max = " + max);
			if (max > maxmax) {
				maxmax = max;
				maxlong = lsc;
			}
		}
		System.out.println("maxmax = " + maxmax);
		System.out.println("maxlong = " + maxlong);
		// System.out.println(t.getContenu());

		// vigenere v = new vigenere();
		/*
		 * String[] arg = new String[] { "c",
		 * "/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123",
		 * "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt"
		 * , "abcht" }; vigenere.main(arg); String[] arg2 = new String[] { "d",
		 * "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt"
		 * ,
		 * "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_dechiffre.txt"
		 * , "abcht" }; vigenere.main(arg2);
		 */
	}
}
