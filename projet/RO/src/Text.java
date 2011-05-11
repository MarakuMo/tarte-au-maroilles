import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Text {

	private String contenu;

	public Text(String filepath) throws IOException {
		/*File f = new File(filepath);
		FileReader fr = new FileReader(f);
		char[] cbuf = new char[10000];
		fr.read(cbuf);
		String s = "";
		for (int i = 0; i < cbuf.length; i++) {
			s = s.concat(Character.valueOf(cbuf[i]).toString());
		}
		this.contenu = s;*/
		String texte ="";
		InputStream ips=new FileInputStream(filepath); 
		InputStreamReader ipsr=new InputStreamReader(ips);
		BufferedReader br=new BufferedReader(ipsr);
		String ligne;
		while ((ligne=br.readLine())!=null){
			texte+=ligne+"\n";
		}
		br.close(); 
		contenu = texte;
	}

	public String getContenu() {
		return contenu;
	}

}
