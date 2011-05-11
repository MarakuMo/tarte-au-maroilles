import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Histogramme {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public HashMap<String,Integer> histogramme;
	
	public Histogramme(){
		histogramme = new HashMap<String, Integer>();
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
			
			classer(texte);
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public void classer(String texte){
		
		
	}
	
}