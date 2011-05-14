import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String[] arg = new String[] {
				"c",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
				"gfqgh" };
		vigenere.main(arg);
		// String[] arg2 = new String[] {
		// "d",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/texte_dechiffre.txt",
		// "abcht" };
		// vigenere.main(arg2);

		Text t = new Text(
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt");
		// System.out.println(t.getContenu());
		// vigenere v = new vigenere();
		Kasiski.longueurCle(t, 14);
	}
}
