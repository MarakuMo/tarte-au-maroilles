import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class vigenere {
	public Text file_in;
	public String file_out;
	public String key;
	public boolean chiffrement;

	public vigenere() {
		key = "";
	}

	public static void main(String args[]) {
		boolean go = true;

		vigenere v = new vigenere();
		if (args[0].equals("c") && (args.length == 4)) {
			v.chiffrement = true;
		} else if (args[0].equals("d") && (args.length == 4)) {
			v.chiffrement = false;
		} else {
			go = false;
			System.out
					.println("[!] Veuillez respecter le modèle! : vigenere c/d <file-in> <file-out> <cle> [!]");
		}
		if (go)
			try {
				v.file_in = new Text(args[1]);
				v.file_out = args[2];
				v.key = args[3];
				if (v.chiffrement) {
					v.chiffrer();
				} else {
					v.dechiffrer();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

	}

	public void dechiffrer() throws IOException {
		String s = this.file_in.getContenu();
		String s_out = "";
		int indice_cle = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				s_out = s_out.concat(" ");
			} else if (s.charAt(i) == '\n') {
				s_out = s_out.concat("\n");
			} else if (s.charAt(i) == '\t') {
				s_out = s_out.concat("\t");
			} else {
				int n = ((Character) s.charAt(i)).hashCode() - 97;
				int m = ((Character) this.key.charAt(indice_cle)).hashCode() - 97;
				Character a = (char) ((n - m + 26) % 26 + 97);
				s_out+=a;
				indice_cle = (indice_cle + 1) % this.key.length();
			}
		}
		File f = new File(this.file_out);
		FileWriter fw = new FileWriter(f);
		fw.write(s_out);
		fw.close();
		System.out.println(s_out);
	}

	public void chiffrer() {

	}

}
