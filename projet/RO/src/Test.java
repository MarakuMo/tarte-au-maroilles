import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		String pathTexte= "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0";
		String pathRef= "/home/auberi/Documents/Recherche_Operationnelle_projet/Ref0123";
		String pathSortie="/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0d";
		
//		String[] arg = new String[] {
//				"c",
//				pathTexte,
//				pathSortie,
//				"paris" };
//		vigenere.main(arg);
//		 String[] arg2 = new String[] {
//		 "d",
//		 "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0",
//		 "/home/auberi/Documents/Recherche_Operationnelle_projet/Chiffre0d",
//		 "abcht" };
//		 vigenere.main(arg2);

		Text t = new Text(pathTexte);
		// System.out.println(t.getContenu());
		// vigenere v = new vigenere();
		int n = Kasiski.longueurCle(t, 30);
		Float[][] tableauICM = Kasiski.calculDecalage(t, n);
		Integer[] a = Kasiski.decalagesMaximaux(tableauICM);
		String[] b = Kasiski.deductionCle(a);
		Kasiski.extractionCle(b, pathTexte, pathRef, pathSortie);


//Kasiski.extractionCle(b, pathTexte, pathRef, pathSortie)
		// System.out.println("IC = "+Text.indiceCoincidence(t.getContenu()));
		// System.out.println("ICM = "+Text.indiceCoincidenceMutuelle(t.getContenu(),t.getContenu()));
	}
}
