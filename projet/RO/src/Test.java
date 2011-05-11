import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// Text t=new Text(args[0]);
		// System.out.println(t.getContenu());
		vigenere v = new vigenere();
		String[] arg = new String[] {
				"c",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
				"abcht" };
		vigenere.main(arg);
		String[] arg2 = new String[] {
				"d",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_dechiffre.txt",
				"abcht" };
		vigenere.main(arg2);
	}
}
