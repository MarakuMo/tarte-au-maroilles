import java.util.HashMap;

public class Kasiski {

	// 1 : Trouver la longueur n de la clé
	/*
	 * Ne pas dépasser des tests de clés de longueur 15. <=> 2 < m < 15
	 */
	public static int longueurCle(Text t, int m) {
		HashMap<Integer, Float> hmIC = remplirIC(t, m);
		return epurer(estPic(hmIC));
	}

	private static int epurer(Float[] v) {
		// System.out.println("début épurer");
		Float mem = (float) 0;
		int indice = -1;
		for (int i = 0; i < v.length; i++) {
			if (v[i] - mem > 0.01) {
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

	private static HashMap<Integer, Float> remplirIC(Text t, int m) {
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
		float seuil = moy + moy * 10 / 100;

		// Calcul des pics
		Float[] vprime = new Float[hmIC.size()];
		for (int i = 2; i < hmIC.size() + 2; i++) {
			Float pred;
			Float succ;
			Float nb = hmIC.get(i);
			if (i != 2) {
				pred = hmIC.get(i - 1);
			} else {
				pred = (float) 0;
			}
			if (i != hmIC.size() + 1) {
				succ = hmIC.get(i + 1);
			} else {
				succ = (float) 0;
			}
			if (nb > seuil && nb > pred && nb > succ) {
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
			res[i] = longalpha - indmax;
			// System.out.println(res[i]);
		}
		return res;
	}

	// 3 : En déduire la bonne clé

	public static void deductionCle(Integer[] tableau) {
		String s = "a";
		for (int i = 0; i < tableau.length; i++) {
			s += Histogramme.alphabet.charAt(tableau[i]);
		}
		for (int i = 0; i < Histogramme.alphabet.length(); i++) {
			String s2 = "";
			s2 += Text.texteDecale(s, i);
			System.out.println(s2);
		}
	}

}
