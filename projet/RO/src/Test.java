import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String[] arg = new String[] {
				"c",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123",
				"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_chiffre.txt",
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
		// System.out.println(t.getContenu());
		// vigenere v = new vigenere();
		int n = Kasiski.longueurCle(t, 14);
		Float[][] tableauICM = Kasiski.calculDecalage(t, n);
		Integer[] a = Kasiski.decalagesMaximaux(tableauICM);
		Kasiski.deductionCle(a);
		//System.out.println("IC = "+Text.indiceCoincidence(t.getContenu()));
		//System.out.println("ICM = "+Text.indiceCoincidenceMutuelle(t.getContenu(),t.getContenu()));
	}
}
