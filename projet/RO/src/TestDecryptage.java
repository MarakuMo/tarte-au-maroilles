import java.io.IOException;

public class TestDecryptage {

	public static void main(String[] args) throws IOException {
		String pathTexte = "/home/med/NetBeansProjects/rech/src/rech/Chiffre4";
		String pathRef = "/home/med/NetBeansProjects/rech/src/rech/Ref45";
		String l = "18";

		String[] arg = new String[] { pathTexte, pathRef, l };
		Kasiski.main(arg);

	}
}
