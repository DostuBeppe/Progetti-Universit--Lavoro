package sort;

import static java.lang.System.nanoTime;
import static sort.Sorting.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class SortTiming {

  /**
   * Metodo per l
   * @return
   */
  public static ArrayList<BigInteger> loadingFromFile() {
    ArrayList<BigInteger> array = new ArrayList<BigInteger>();
    try {
      FileReader r = new FileReader(
              "C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\sort\\integers.csv");
      BufferedReader br = new BufferedReader(r);
      String line;
      while ((line = br.readLine()) != null) {
        array.add(new BigInteger(line));
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return array;
  }

  public static void main(String[] args) {
    ArrayList<BigInteger> array = loadingFromFile();
    ArrayList<BigInteger> raw_array = array;
    long t1 = nanoTime();
    long t2 = nanoTime();
    raw_array = array;
    System.out.println("L'algo MERGE SORT NO GARBAGE ci mette ");
    t1 = nanoTime();
    mergeSortNoGarbage(raw_array);
    t2 = nanoTime();
    if (!isSorted(raw_array))
      throw new RuntimeException("non ha ordinato");
    System.out.printf("%9.2f;\n", (t2 - t1) / 1E9);
  }
}
