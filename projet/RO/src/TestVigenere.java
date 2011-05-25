import java.io.IOException;

public class TestVigenere {

	public static void main(String[] args) throws IOException {

//		String[] arg = new String[] {
//				"c",
//				"src/Chiffre4",
//				"src/texte_chiffre.txt",
//				"mrtokuencxozdphilat" };
//		vigenere.main(arg);
		String[] arg2 = new String[] {
				"d",
				"src/Chiffre4",
				"src/texte_dechiffre.txt",
				"mrtvfuencxozdphila" };
		vigenere.main(arg2);
		System.out.println("Operation Réussie, Consulter les fichiers src/texte_dechiffre.txt et src/texte_chiffre.txt ");
	}
}