import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class Histogramme {
	public static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public HashMap<Character,Integer> histogramme;
	int maxint = 0;
	char maxchar;
	
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
				texte+=ligne+"\n";
			}
			br.close(); 
			Histogramme h = new Histogramme();
			
			h.classer(texte);
			h.impression();
			h.max();
			
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	
	public  void classer(String texte){
		int l = texte.length();
		Character aux;
		Integer occ;
		
		for(int i=0;i<l;i++){
			aux = texte.charAt(i);
			occ = histogramme.remove(aux);
			if(occ == null){
				occ = 0;
			}
			occ ++;
			if(occ > maxint){
				maxint = occ;
				maxchar = aux;
			}
			histogramme.put(aux,occ);
		}
		
	}
	public void impression(){
		int l = alphabet.length();
		Character aux;
		Integer val;
		
		for(int i=0;i<l;i++){
			aux = alphabet.charAt(i);
			val = histogramme.get(aux);
			if(val == null){
				val = 0;
			}
			System.out.println("Le caractère "+aux+" apparait "+val+ "fois.");
		}
	}
	public void max(){
		System.out.println("Le caractère qui apparait le plus est : " + maxchar+ " ("+maxint +" fois)");
	}

	
}