import java.io.IOException;
import java.util.HashMap;

public class TestLongueurCle {

	public static void main(String[] args) throws IOException {
		String pathTexte = "src/Chiffre0";

		Text t = new Text(pathTexte);

		HashMap<Integer, Float> hmIC = Kasiski.remplirIC(t, 100);
		DrawIC d = new DrawIC(hmIC);
		d.setVisible(true);

	}
}
