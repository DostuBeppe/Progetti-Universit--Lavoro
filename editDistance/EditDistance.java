package editDistance;

/**
 * Classe implementante l'algoritmo di Edit Distance tra stringhe.
 * Contiene una prima implementazione ricorsiva ed una utilizzante un approccio di programmazione dinamica.
 */
public class EditDistance {

  /**
   * Metodo pubblico per calcolare la distanza di edit tra due stringhe in modo ricorsivo.
   * Le operazioni conteggiate sono la cancellazione e l'inserimento di un carattere.
   * @param s1 Prima stringa in input
   * @param s2 Seconda stringa in input
   * @return Il numero di operazioni per strasformare la prima stringa nella seconda
   */
  public static int edit_distance(String s1, String s2) {
    return getEditDist(s1, s2, s1.length(), s2.length());
  }

  /**
   * Metodo pubblico per calcolare la distanza di edit tra due stringhe con l'approccio di programmazione lineare.
   * Le operazioni conteggiate sono la cancellazione e l'inserimento di un carattere.
   * @param s1 Prima stringa in input
   * @param s2 Seconda stringa in input
   * @return Il numero di operazioni necessarie per trasformare la prima stringa nella seconda
   */
  public static int edit_distance_dyn(String s1, String s2) {
    return getEditDistDP(s1, s2, s1.length(), s2.length());
  }

  /**
   * Metodo privato ricorsivo per il calcolo della distanza di edit tra due stringhe.
   * Le operazioni conteggiate sono la cancellazione e l'inserimento di un carattere.
   * @param s1 Prima stringa in input
   * @param s2 Seconda stringa in input
   * @param ls1 Lunghezza della prima stringa in input
   * @param ls2 Lunghezza della seconda string in input
   * @return Il numero di operazioni necessarie per trasformare la prima stringa nella seconda
   */
  private static int getEditDist(String s1, String s2, int ls1, int ls2) {
    if (ls1 == 0) return ls2;
    if (ls2 == 0) return ls1;
    if (s1.charAt(ls1 - 1) == s2.charAt(ls2 - 1))
      return getEditDist(s1, s2, ls1 - 1, ls2 - 1);
    int ins = getEditDist(s1, s2, ls1, ls2 - 1);
    int del = getEditDist(s1, s2, ls1 - 1, ls2);
    return 1 + Integer.min(ins, del);
  }

  /**
   * Metodo privato di programmazione dinamica per il calcolo della distanza di edit tra due stringhe.
   * Le operazioni conteggiate sono la cancellazione e l'inserimento di un carattere.
   * @param s1 Prima stringa in input
   * @param s2 Seconda stringa in input
   * @param ls1 Lunghezza della prima stringa in input
   * @param ls2 Lunghezza della seconda string in input
   * @return Il numero di operazioni necessarie per trasformare la prima stringa nella seconda
   */
  private static int getEditDistDP(String s1, String s2, int ls1, int ls2) {
    int dp[][] = new int[ls1 + 1][ls2 + 1];
    for (int i = 0; i <= ls1; i++) {
      for (int j = 0; j <= ls2; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          int ins = dp[i][j - 1];
          int del = dp[i - 1][j];
          dp[i][j] = 1 + Integer.min(ins, del);
        }
      }
    }
    return dp[ls1][ls2];
  }

}
