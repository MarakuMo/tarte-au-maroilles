import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Text {

	private String contenu;

	public Text(String filepath) throws IOException {

		String texte = "";
		InputStream ips = new FileInputStream(filepath);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		String ligne;
		while ((ligne = br.readLine()) != null) {
			texte += ligne + "\n";
		}
		br.close();
		contenu = texte;
	}

	public String getContenu() {
		return contenu;
	}

	public int indiceCoincidence() {
		int l = this.contenu.length();
		Histogramme h = new Histogramme(this);
		HashMap<Character, Integer> hist = h.getHistogramme();	
		int somme = 0;
		for (int i = 0; i < 25; i++) {
			char c = (char) (97+i);
			Integer a = hist.get(c);
			somme += a*(a-1);
		}
		somme = somme/l/(l-1);
		return somme;
	}

}
