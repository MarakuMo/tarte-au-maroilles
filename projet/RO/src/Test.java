import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String[] arg = new String[] {
				"c",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre2.txt",
				"bidule" };
		vigenere.main(arg);
		// String[] arg2 = new String[] {
		// "d",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_dechiffre.txt",
		// "abcht" };
		// vigenere.main(arg2);

		Text t = new Text(
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt");
		float i = Text.indiceCoincidence(t.getContenu());
		System.out.println("IC du texte entier = " + i + "\n");
		float max = 0;
		int maxlsc = 0;
		for (int lsc = 25; lsc > 2; lsc--) {
			String s = t.sousChaine(lsc);
			float k = Text.indiceCoincidence(s);
			if (k > max) {
				max = k;
				maxlsc = lsc;
			}
			System.out.println(lsc + " max = " + k);
		}
		System.out.println("max = " + max);
		System.out.println("maxlsc = " + maxlsc);
		// System.out.println(t.getContenu());

		// vigenere v = new vigenere();

	}
}
