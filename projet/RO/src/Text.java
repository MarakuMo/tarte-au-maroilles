import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;


public class Text {

	private String contenu;

	public Text(String filepath) throws IOException {
		File f = new File(filepath);
		FileReader fr = new FileReader(f);
		char[] cbuf = new char[10000];
		fr.read(cbuf);
		this.contenu = cbuf
		System.out.println(u);
		
		
	}

	public String getContenu() {
		return contenu;
	}
	
	
}
