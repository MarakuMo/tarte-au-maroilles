import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String pathTexte = "Chiffre7";
		String pathRef = "Ref6";
		// String pathSortie =
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0d";

		// String[] arg = new String[] {
		// "c",
		// pathTexte,
		// pathSortie,
		// "paris" };
		// vigenere.main(arg);
		// String[] arg2 = new String[] {
		// "d",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0",
		// "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0d",
		// "abcht" };
		// vigenere.main(arg2);

		String[] arg = new String[] { pathTexte, pathRef };
		Kasiski.main(arg);

		// Kasiski.extractionCle(b, pathTexte, pathRef, pathSortie)
		// System.out.println("IC = "+Text.indiceCoincidence(t.getContenu()));
		// System.out.println("ICM = "+Text.indiceCoincidenceMutuelle(t.getContenu(),t.getContenu()));
	}
}
