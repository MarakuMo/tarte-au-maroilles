import java.io.IOException;

public class TestVigenere {

	public static void main(String[] args) throws IOException {

		// d�chiffrement de Chiffre 4 � partir de la clef donn�e 
		String mode = "d";
		String source = "src/Chiffre4";
		String clef = "mrtvfuencxozdphila";
		String[] arg2 = new String[] {
				mode,
				source,
				"src/texte_dechiffre.txt",
				clef };
		vigenere.main(arg2);
		System.out.println("Operation R�ussie, Consulte� le fichier src/texte_dechiffre.txt ");
	}
}