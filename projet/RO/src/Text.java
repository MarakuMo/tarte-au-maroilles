import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

}
