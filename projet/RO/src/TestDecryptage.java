import java.io.IOException;


public class TestDecryptage {

	public static void main(String[] args) throws IOException {
		String pathTexte = "src/Chiffre1";
		String pathRef = "src/Ref0123";


		String[] arg = new String[] {pathTexte, pathRef};
		Kasiski.main(arg);

	}
}
