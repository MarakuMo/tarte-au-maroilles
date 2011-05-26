import java.io.IOException;

public class TestVigenere {

	public static void main(String[] args) throws IOException {

		// déchiffrement de Chiffre 4 à partir de la clef donnée 
		String mode = "d";
		String source = "src/Chiffre4";
		String clef = "mrtvfuencxozdphila";
		String[] arg2 = new String[] {
				mode,
				source,
				"src/texte_dechiffre.txt",
				clef };
		vigenere.main(arg2);
		System.out.println("Operation Réussie, Consulteé le fichier src/texte_dechiffre.txt ");
	}
}