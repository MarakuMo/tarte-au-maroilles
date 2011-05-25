import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Kasiski {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out
					.println(" Veuillez respecter le modèle : Kasiski <file-in> <file-ref>");
		} else {
			try {
				Text t = new Text(args[0]);
				int tp = 100;
				if(t.getContenu().length()/100 > 100){
					tp= t.getContenuSansEspace().length()/100;
				}
				HashMap<Integer, Float> hmIC = Kasiski.remplirIC(t,tp);
				DrawIC d = new DrawIC(hmIC);
				d.setVisible(true);
				Integer n = longueurCle(t, 100);
				boolean ok = false;
				while (!ok) {
					System.out.println("Longueur de Clé proposée  :  " + n);
					System.out
							.println("Appuyez sur <y> pour valider, sinon Entrez votre longueur");
					boolean ok0 = false;
					while (!ok0) {
						Scanner sc = new Scanner(System.in);
						String aux = sc.next();
						// System.out.println("Vous Avez choisi :  " + aux);
						try {
							if (aux.intern() == "y") {
								ok = true;
								ok0 = true;
							} else if (aux.intern() != "y") {
								n = Integer.parseInt(aux);
								if (n > 1) {
									ok = false;
									ok0 = true;
								} else {
									ok = false;
									ok0 = false;
								}

							}
						} catch (Exception e) {
							System.out
									.println(" [!] Choix Incorrect [!] Veuillez choisir <y> ou entrez un nombre.");
							ok0 = false;
						}

						Float[][] tableauICM = Kasiski.calculDecalage(t, n);
						Integer[] a = Kasiski.decalagesMaximaux(tableauICM);
						String[] b = Kasiski.deductionCle(a);
						String s = extractionCle(b, args[0], args[1],
								"src/texte_decrypte.txt");
						String[] arg2 = new String[] { "d", args[0],
								"src/texte_decrypte.txt", s };
						vigenere.main(arg2);
						System.out
								.println("Cette Clé vous convient-elle ? <y> / <n>");
						boolean ok2 = false;
						while (!ok2) {
							Scanner sc2 = new Scanner(System.in);
							String aux2 = sc2.next();
							if (aux2.intern() == "y") {
								ok = true;
								ok2 = true;
							} else if (aux2.intern() == "n") {
								ok = false;
								ok2 = true;
							} else {
								System.out
										.println(" [!] Choix Incorrect [!] Veuillez choisir :  <y> / <n>");
								ok2 = false;
							}
						}
					}
				}
			}

			catch (IOException e) {
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

	private static int epurer(Float[] v) {
		// System.out.println("début épurer");

		// int indice = -1;

		int i = 0;
		while (i < v.length && (v[i] == 0)) {

			i++;
		}

		// int res = indice;
		// for(int k=0; k <inds.size();k++){
		// res = pgcd(res,inds.get(k));
		// }

		System.out.println("La longueur de la clé est " + (i + 2) + ".");
		return i + 2;
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
		// Float moy = (float) 0;
		// for (int i = 2; i < hmIC.size() + 2; i++) {
		// moy += hmIC.get(i);
		// }
		// moy /= hmIC.size();
		// float seuil = moy ;

		// Calcul des pics

		Float[] vprime = new Float[hmIC.size()];
		vprime[0] = (float) 0;
		vprime[hmIC.size() - 1] = (float) 0;

		for (int i = 3; i < hmIC.size() + 1; i++) {
			Float pred;
			Float succ;
			Float nb = hmIC.get(i);
			pred = hmIC.get(i - 1);
			succ = hmIC.get(i + 1);

			if ((nb - pred) > 0.015 && (nb - succ) > 0.015) {
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
			// System.out.println(res[i]);
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
		System.out.println("la bonne cle est : " + tab[ind]);
		return tab[ind];
	}

}