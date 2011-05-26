import java.io.IOException;


public class TestDecryptage {

	public static void main(String[] args) throws IOException {
		String pathTexte = "src/Chiffre1"; // Texte à decrypter 
		String pathRef = "src/Ref0123"; // Texte référence

		// appel du programme sous la forme : 
		// Kasiski <file-in> <file-ref>
		String[] arg = new String[] {pathTexte, pathRef};
		Kasiski.main(arg);

	}
}
