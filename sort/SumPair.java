package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

/**
 * Classe implementante la soluzione del problema proposto nell'esercizio 2.
 * Dato un file 'sums.txt', di ogni cifra presente in esso, viene chiesto di trovare in un tempo
 * O(n log n) due numeri nel file 'integers.csv' la cui somma sia tale cifra.
 */
public class SumPair {

  /**
   * Metodo per il caricamento dal file 'integers.csv' dei numeri da utilizzare nella ricerca della somma.
   *
   * @return Un ArrayList di BigInteger contenenti le cifre presenti sul file
   */
  public static ArrayList<BigInteger> loadingIntsFromFile() {
    ArrayList<BigInteger> array = new ArrayList<BigInteger>();
    try {
      FileReader r = new FileReader(
              "C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\sort\\integers.csv");
      BufferedReader br = new BufferedReader(r);
      String line;
      while ((line = br.readLine()) != null) {
        array.add(new BigInteger(line));
      }
      br.close();
      r.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return array;
  }

  /**
   * Metodo per il caricamento dal file 'sums.txt' delle somme di cui cercare gli addendi.
   *
   * @return Un ArrayList di BigInteger contenenti le somme sul file
   */
  public static ArrayList<BigInteger> loadingSumsFromFile() {
    ArrayList<BigInteger> array = new ArrayList<BigInteger>();
    try {
      FileReader r = new FileReader("C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\sort\\sums.txt");
      BufferedReader br = new BufferedReader(r);
      String line;
      while ((line = br.readLine()) != null) {
        array.add(new BigInteger(line));
      }
      br.close();
      r.close();
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return array;
  }

  /**
   * Metodo per la ricerca di due interi all'interno di un array la cui somma sia il numero passato in input.
   * La precondizione necessaria per utilizzare il metodo e' che l'array passato sia gia' ordinato.
   *
   * @param array Array ordinato di BigInteger su cui effettuare la ricerca degli addendi
   * @param sum   Numero di cui si vuole trovare gli addenti componenti
   * @return <code>true</code> se nell'array sono presenti 2 numeri che sommati danno come risultato <code>sum</code>, <code>false</code> altrimenti
   */
  private static boolean hasPair(ArrayList<BigInteger> array, BigInteger sum) {
    TreeMap<BigInteger, BigInteger> compl = new TreeMap<BigInteger, BigInteger>();
    BigInteger half = sum.divide(new BigInteger("2"));
    BigInteger last = array.get(array.size() - 1);
    if (half.compareTo(last) > 0)
      return false;
    for (BigInteger value : array) {
      if (sum.compareTo(value) < 0)
        return false;
      if (compl.containsKey(value)) {
        System.out.print(value + " + " + sum.subtract(value));
        return true;
      }
      compl.put(sum.subtract(value), sum.subtract(value));
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Carico i numeri...");
    ArrayList<BigInteger> raw_array = loadingIntsFromFile();

    System.out.println("Carico le somme...");
    ArrayList<BigInteger> sums = loadingSumsFromFile();

    System.out.println("Ordino l'array...");
    // mergeSortNoGarbage(raw_array);
    Collections.sort(raw_array);

    System.out.println("Inizio la ricerca!");
    String result;
    for (BigInteger tsum : sums) {
      System.out.print("Numero " + tsum + " = ");
      result = hasPair(raw_array, tsum) ? " coppia trovata!\n" : " nessuna coppia...\n";
      System.out.print(result);
    }
    System.out.println("Finito!");
  }
}
