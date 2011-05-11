import java.io.IOException;

public class vigenere {
	public Text file_in;
	public String file_out;
	public String key ;
	public boolean chiffrement ;
	
	public vigenere(){
		key="";
	}
	
	public static void main(String args[]){	
		boolean go = true;
		
		vigenere v = new vigenere();
		if(args[0].equals("c") && (args.length== 3) ){
			v.chiffrement = true;
		}else if(args[0].equals("d") && (args.length== 3)){
			v.chiffrement = false;
		}else{
			go = false;
			System.out.println("[!] Veuillez respecter le modèle! : vigenere c/d <file-in> <file-out> <cle> [!]");
		}
		if(go)
			try {
				v.file_in = new Text(args[1]);
				v.file_out = args[2];
				v.key = args[3];
				if(v.chiffrement){
					v.chiffrer();
				}else{
					v.dechiffrer();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			
	}

	public void dechiffrer() {
		
		
	}

	public void chiffrer() {
		
		
	}
	
	

}
