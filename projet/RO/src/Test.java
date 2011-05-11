import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// Text t=new Text(args[0]);
		// System.out.println(t.getContenu());
		vigenere v = new vigenere();
		String[] arg = new String[] {
				"d",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_dechiffre.txt",
				"abcht" };
		vigenere.main(arg);
	}
}
