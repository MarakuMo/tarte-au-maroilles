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

	// 3 : En déduire la bonne clé
}
