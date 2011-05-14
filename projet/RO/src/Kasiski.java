import java.util.HashMap;

public class Kasiski {

	// 1 : Trouver la longueur n de la clé
	public static int longueurCle(Text t, int m) {
		HashMap<Integer, Float> hmIC = remplirIC(t, m);
		int maxLongCle = getMaxLongueurCle(t, m, hmIC);
		Integer[] v = estPic(hmIC);
		int i = 0;
		while (v[i] == 0) {
			i++;
		}
		System.out.println("La longueur de la clé est " + v[i] + ".");
		return v[i];
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

	private static Integer[] estPic(HashMap<Integer, Float> hmIC) {
		// Calcul du seuil
		Float moy = (float) 0;
		for (int i = 2; i < hmIC.size() + 2; i++) {
			moy += hmIC.get(i);
		}
		moy /= hmIC.size();
		float seuil = moy + moy * 25 / 100;

		// Calcul des pics
		Integer[] vprime = new Integer[hmIC.size()];
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
				vprime[i - 2] = i;
			} else {
				vprime[i - 2] = 0;
			}
		}

		return vprime;
	}

	private static int getMaxLongueurCle(Text t, int m,
			HashMap<Integer, Float> hmIC) {
		float maxIC = 0;
		int maxlsc = 0;
		Float k;
		for (int i = 2; i < m + 1; i++) {
			k = hmIC.get(i);
			if (k > maxIC) {
				maxIC = k;
				maxlsc = i;
			}
		}
		return maxlsc;
	}

	// 2 : Trouver une liste de clés possibles

	// 3 : En déduire la bonne clé
}
