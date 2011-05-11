import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Text {

	private String contenu;

	public Text(String filepath) throws IOException {
		File f = new File(filepath);
		FileReader fr = new FileReader(f);
		char[] cbuf = new char[10000];
		fr.read(cbuf);
		String s = "";
		for (int i = 0; i < cbuf.length; i++) {
			s = s.concat(Character.valueOf(cbuf[i]).toString());
		}
		this.contenu = s;
	}

	public String getContenu() {
		return contenu;
	}

}
