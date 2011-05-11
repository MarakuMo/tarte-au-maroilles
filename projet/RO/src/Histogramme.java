import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Histogramme {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public HashMap<Character,Integer> histogramme;
	
	public Histogramme(){
		histogramme = new HashMap<Character,Integer>();
	}
	
	public static void main(String args[]){	
		String fichier =args[0];
		String texte = "";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				System.out.println(ligne);
				texte+=ligne+"\n";
			}
			br.close(); 
			Histogramme h = new Histogramme();
			
			h.classer(texte);
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public  void classer(String texte){
		int l = texte.length();
		char aux;
		int occ;
		
		for(int i=0;i<l;i++){
			aux = texte.charAt(i);
			occ = histogramme.remove(aux);
			occ ++;
			histogramme.put(aux,occ);
		}
		
	}
	public void impression(){
		int l = alphabet.length();
		char aux;
		int val;
		
		for(int i=0;i<l;i++){
			aux = alphabet.charAt(i);
			val = histogramme.get(aux);
			System.out.println("Le caractère "+aux+" apparait "+val+ "fois.");
		}
	}
	
}