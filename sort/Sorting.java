package sort;

import java.util.ArrayList;

public class Sorting {

  /**
   * Controlla che l'array passato come parametro sia ordinato.
   *
   * @param a array da controllare
   * @return <code>true</code> se l'array e' ordinato, <code>false</code>
   * altrimenti
   */
  public static <T extends Comparable<? super T>> boolean isSorted(ArrayList<T> a) {
    for (int i = 0; i < a.size() - 1; i++) {
      if (a.get(i + 1).compareTo(a.get(i)) < 0) {
        return false;
      }
    }
    return true;
  }

  /**
   * Ordina l'array utilizzando l'algoritmo InsertionSort.
   *
   * @param a array da ordinare
   */
  public static <T extends Comparable<? super T>> void insertionSort(ArrayList<T> a) {
    int n = a.size();
    for (int i = 0; i < n; i++) {
      T x = a.get(i);
      int j = i;
      while (j > 0 && x.compareTo(a.get(j - 1)) < 0) {
        a.set(j, a.get(j - 1));
        j--;
      }
      a.set(j, x);
    }
  }

  /**
   * Ricerca la posizione in cui inserire l'elemento <code>x</code> all'interno
   * dell'array, compresa tra gli estremi passati come parametro.
   *
   * @param x   elemento da inserire
   * @param a   array su cui effettuare la ricerca
   * @param ini indice iniziale
   * @param end indice finale
   * @return la posizione in sui inserire l'elemento
   */
  static <T extends Comparable<? super T>> int binSearch(T x, ArrayList<T> a, int ini, int end) {
    if (x.compareTo(a.get(ini)) < 0) {
      return ini;
    }
    if (x.compareTo(a.get(end)) >= 0) {
      return end + 1;
    }
    while (ini <= end) {
      int mid = (ini + end) >>> 1;
      if (x.compareTo(a.get(mid)) < 0) {
        end = mid - 1;
      } else {
        ini = mid + 1;
      }
    }
    return ini;
  }

  /**
   * Ordina l'array utilizzando l'algoritmo InsertionSort.<br>
   * Si avvale dell'utilizzo della ricerca binaria e dello scorrimento iniziale
   * degli elementi gia' ordinati
   *
   * @param a array da ordinare
   */
  public static <T extends Comparable<? super T>> void insertionBinSort(ArrayList<T> a) {
    int n = a.size();
    if (n == 0) {
      return;
    }
    int start = 1;
    while (start < n && a.get(start).compareTo(a.get(start - 1)) >= 0) {
      start++;
    }
    if (start == n) {
      return;
    }
    for (int i = start; i < n; i++) {
      T x = a.get(i);
      int iInser = binSearch(x, a, 0, i - 1);
      for (int j = i; j > iInser; j--) {
        a.set(j, a.get(j - 1));
      }
      a.set(iInser, x);
    }
  }

  /**
   * Ordina l'array utilizzando l'argoritmo MergeSort.
   *
   * @param a array da ordinare
   */
  public static <T extends Comparable<? super T>> void mergeSortBasic(ArrayList<T> a) {
    mergeSortBasic(a, 0, a.size() - 1);
  }

  /**
   * Chiamata ricorsiva dell'argoritmo MergeSort.
   *
   * @param a     array da ordinare
   * @param first estemo inferiore dell'intervallo da ordinare
   * @param last  estremo superiore dell'intervallo da ordinare
   */
  private static <T extends Comparable<? super T>> void mergeSortBasic(ArrayList<T> a, int first, int last) {
    if (first >= last) {
      return;
    }
    int m = (first + last) >>> 1;
    mergeSortBasic(a, first, m);
    mergeSortBasic(a, m + 1, last);
    mergeBasic(a, first, m, last);
  }

  /**
   * Procedura di fusione di due segmenti ordinati dello stesso array sul
   * posto.<br>
   * Fonde i segmenti [fst .. mid] e [mid+1 .. lst] in temporaneo poi ricopia il
   * risultato.
   *
   * @param a   array di cui fondere i due segmenti
   * @param fst limite inferiore
   * @param mid indice della posizione mediana
   * @param lst limite superiore
   */
  static <T extends Comparable<? super T>> void mergeBasic(ArrayList<T> a, int fst, int mid, int lst) {
    int n = lst - fst + 1;
    int i = fst, j = mid + 1;
    ArrayList<T> c = new ArrayList<T>(n);
    while (i <= mid && j <= lst) {
      c.add(a.get(i).compareTo(a.get(j)) <= 0 ? a.get(i++) : a.get(j++));
    }
    while (i <= mid) {
      c.add(a.get(i++));
    }
    while (j <= lst) {
      c.add(a.get(j++));
    }
    for (int h = 0; h < n; h++) {
      a.set(fst + h, c.get(h));
    }
  }

  /**
   * Ordina l'array utilizzando l'algoritmo MergeSort.<br>
   * OTTIMIZZAZIONI: viene utilizzato un array ausiliario per tutta l'elaborazione
   * al posto di istanziarne uno ad ogni chiamata del merge, con un notevole
   * risparmio in spazio di memoria.
   *
   * @param a array da ordinare
   */
  public static <T extends Comparable<? super T>> void mergeSortNoGarbage(ArrayList<T> a) {
    int n = a.size();
    ArrayList<T> aux = a;
    mergeSortNoGarbage(a, 0, n - 1, aux);
  }

  /**
   * Chiamata ricorsiva dell'argoritmo MergeSort.
   *
   * @param a     array da ordinare
   * @param first estemo inferiore dell'intervallo da ordinare
   * @param last  estremo superiore dell'intervallo da ordinare
   * @param aux   array di supporto alla fusione
   */
  private static <T extends Comparable<? super T>> void mergeSortNoGarbage(ArrayList<T> a, int first, int last,
                                                                           ArrayList<T> aux) {
    if (first >= last) {
      return;
    }
    int m = (first + last) >>> 1;
    mergeSortNoGarbage(a, first, m, aux);
    mergeSortNoGarbage(a, m + 1, last, aux);
    mergeNoGarbage(a, first, m, last, aux);
  }

  /**
   * Procedura di fusione di due segmenti ordinati dello stesso array sul posto,
   * usando un singolo array ausiliario.<br>
   * Fonde i segmenti [fst .. mid] e [mid+1 .. lst] dell'array da ordinare usando
   * <code>c</code>, migliorando la fase di ricopiatura da un array all'altro,
   * spostando gli elementi non toccati nella sezione sinistra del merge al fondo
   * dell'array iniziale <code>a</code>, evitandone quindi un inutile passaggio
   * tra i due array.
   *
   * @param a   array di cui bisogna fondere i due segmenti
   * @param fst limite inferiore
   * @param mid indice della posizione mediana
   * @param lst limite superiore
   * @param c   array ausiliario
   */
  static <T extends Comparable<? super T>> void mergeNoGarbage(ArrayList<T> a, int fst, int mid, int lst,
                                                               ArrayList<T> c) {
    int i = fst, j = mid + 1, k = fst;
    while (i <= mid && j <= lst) {
      c.set(k++, a.get(i).compareTo(a.get(j)) <= 0 ? a.get(i++) : a.get(j++));
    }
    int h = mid, l = lst;
    while (h >= i) {
      a.set(l--, a.get(h--));
    }
    for (int r = fst; r < k; r++) {
      a.set(r, c.get(r));
    }
  }
}
