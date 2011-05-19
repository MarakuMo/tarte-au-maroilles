import java.io.IOException;
import java.util.HashMap;

public class Kasiski {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out
					.println(" Veuillez respecter le modèle : Kasiski <file-in> <file-ref>");
		} else {
			try {
				Text t = new Text(args[0]);
				int n = Kasiski.longueurCle(t, 100);// t.getContenu().length() /
													// 100);
				Float[][] tableauICM = Kasiski.calculDecalage(t, n);
				Integer[] a = Kasiski.decalagesMaximaux(tableauICM);
				String[] b = Kasiski.deductionCle(a);
				String s = extractionCle(b, args[0], args[1],
						"texte_decrypte.txt");
				String[] arg2 = new String[] {
						"d",
						args[0],
						"/home/auberi/Documents/Recherche_Operationnelle_projet/texte_decrypte.txt",
						s };
				vigenere.main(arg2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 1 : Trouver la longueur n de la clé
	/*
	 * Ne pas dépasser des tests de clés de longueur 15. <=> 2 < m < 15
	 */
	public static int longueurCle(Text t, int m) {
		HashMap<Integer, Float> hmIC = remplirIC(t, m);
		return epurer(estPic(hmIC));
	}

	public static int pgcd(int a, int b) { // début de pgcd ()

		if (a < b) // on veut le premier argument plus grand

			return (pgcd(b, a));
		else if (b == 0) // condition d'arrêt
			return (a);
		else
			// on poursuit l'algorithme d'Euclide

			return (pgcd(b, a % b));

	} // fin de pgcd ()

	private static int epurer(Float[] v) {
		// System.out.println("début épurer");
		Float mem = (float) 0;
		int indice = -1;
		for (int i = 0; i < v.length; i++) {
			if (v[i] - mem > 0.015) {
				mem = v[i];
				indice = i + 2;
			} else {
				v[i] = (float) 0;
			}
			// System.out.println(v[i]);
		}

		System.out.println("La longueur de la clé est " + indice + ".");
		return indice;
	}

	public static HashMap<Integer, Float> remplirIC(Text t, int m) {
		HashMap<Integer, Float> longueurs = new HashMap<Integer, Float>();
		for (int lsc = m; lsc > 1; lsc--) {
			String s = t.sousChaine(lsc);
			float k = Text.indiceCoincidence(s);
			longueurs.put(lsc, k);
		}
		return longueurs;
	}

	private static Float[] estPic(HashMap<Integer, Float> hmIC) {
		// System.out.println("début estPic");
		// Calcul du seuil
		Float moy = (float) 0;
		for (int i = 2; i < hmIC.size() + 2; i++) {
			moy += hmIC.get(i);
		}
		moy /= hmIC.size();
		float seuil = moy;

		// Calcul des pics
		Float[] vprime = new Float[hmIC.size()];
		for (int i = 2; i < hmIC.size() + 2; i++) {
			Float nb = hmIC.get(i);
			if (nb > seuil) {
				vprime[i - 2] = nb;
			} else {
				vprime[i - 2] = (float) 0;
			}
			// System.out.println(vprime[i - 2]);
		}

		return vprime;
	}

	// 2 : Trouver une liste de clés possibles

	/*
	 * Calcul des Indices de Coïncidence Mutuelle pour les décalages du texte s.
	 */
	public static Float[][] calculDecalage(Text t, int longueurCle) {
		Histogramme h = new Histogramme(t);
		int taille = h.getHistogramme().size();
		Float[][] tableauICM = new Float[longueurCle - 1][taille];
		String s0 = t.sousChaine(longueurCle);
		// System.out.println("s0 = " + s0);
		for (int i = 1; i < longueurCle; i++) {
			String si = t.sousChaine(longueurCle, i);
			// System.out.println("s" + i + " = " + si);
			for (int j = 0; j < taille; j++) {
				String sii = Text.texteDecale(si, j);
				if (j == 2 && i == 1) {
					// System.out.println(si);
					// System.out.println(sii);
				}
				tableauICM[i - 1][j] = Text.indiceCoincidenceMutuelle(s0, sii);
				// String a = "" + (char) (97 + j);
				// System.out.print(a +" : "+ tableauICM[i - 1][j] + "\t");
			}
			// System.out.println();
		}
		return tableauICM;
	}

	public static Integer[] decalagesMaximaux(Float[][] tableauICM) {
		int l = tableauICM.length;
		int longalpha = Histogramme.alphabet.length();
		Integer[] res = new Integer[l];
		for (int i = 0; i < res.length; i++) {
			Float ICMmax = (float) 0;
			Integer indmax = -1;
			for (int j = 0; j < longalpha; j++) {
				if (tableauICM[i][j] > ICMmax) {
					ICMmax = tableauICM[i][j];
					indmax = j;
				}
			}
			res[i] = (longalpha - indmax) % longalpha;
			// System.out.println(res[i] + " => " + (char) (97 + res[i]));
		}
		return res;
	}

	// 3 : En déduire la bonne clé

	public static String[] deductionCle(Integer[] tableau) {
		String s = "a";
		String[] res = new String[Histogramme.alphabet.length()];
		for (int i = 0; i < tableau.length; i++) {
			s += Histogramme.alphabet.charAt(tableau[i]);
		}
		for (int i = 0; i < Histogramme.alphabet.length(); i++) {
			String s2 = "";
			s2 += Text.texteDecale(s, i);
			// System.out.println(s2);
			res[i] = s2;
		}
		return res;
	}

	public static String extractionCle(String[] tab, String pathTexte,
			String pathRef, String pathSortie) throws IOException {
		float max = 0;
		int ind = -1;

		for (int i = 0; i < tab.length; i++) {
			String[] args = { "d", pathTexte, pathSortie, tab[i] };
			vigenere.main(args);
			Text t1 = new Text(pathSortie);
			Text t2 = new Text(pathRef);
			float aux = Text.indiceCoincidenceMutuelle(t1.getContenu(),
					t2.getContenu());
			if (aux > max) {
				ind = i;
				max = aux;
			}
		}
		System.out.println("La bonne clé est : " + tab[ind]);
		return tab[ind];
	}

}
