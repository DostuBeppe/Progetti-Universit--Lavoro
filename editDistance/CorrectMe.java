package editDistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Applicazione pratica dell'algoritmo di Edit Distance implementato.
 * Carica una frase dal file 'correctme.txt' ed in base alle parole contenute nel dizionario
 * 'dictionary.txt' prova a correggerla con le parole a distanza minima.
 */
public class CorrectMe {

  /**
   * Classe di supporto per gestire il risultato della ricerca.
   * Conterra' le parole e la loro distanza dalla parola analizzata.
   */
  public static class Result {
    int distance;
    String word;

    private Result(int dist, String word) {
      this.distance = dist;
      this.word = word;
    }
  }

  /**
   * Metodo per la creazione dell'ArrayList che conterra' le parole del dizionario da utilizzare.
   *
   * @param path Percorso dove trovare il file 'dictionary.txt'
   * @return ArrayList contenente le parole del dizionario
   */
  private static ArrayList<String> loadingDictionaryFromFile(String path) {
    ArrayList<String> array = new ArrayList<String>();
    try {
      FileReader file = new FileReader(path);
      BufferedReader br = new BufferedReader(file);
      String line;
      while ((line = br.readLine()) != null) array.add(line);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return array;
  }

  /**
   * Metodo per il caricamento della frase da correggere.
   * Recupera il contenuto dal file 'correctme.txt', elimina la punteggiatura e converte le maiuscole.
   * Infine, scompone la frase ottenuta in un array di stringhe.
   *
   * @param path Percorso dove trovare il file 'correctme.txt'
   * @return Array di stringhe pronte per essere elaborato con il metodo di EditDistance
   */
  private static String[] loadingTargetFromFile(String path) {
    String[] array = null;
    try {
      FileReader file = new FileReader(path);
      BufferedReader br = new BufferedReader(file);
      String line;
      line = br.readLine();
      System.out.println("Frase originale:\n" + line);
      array = line.toLowerCase().replaceAll("[^a-zA-Z0-9\\s+]", "").split(" ");
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return array;
  }

  public static void main(String[] args) {

    String pathDictionary = "C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\editDistance\\dictionary.txt";
    String pathCorrectme = "C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\editDistance\\correctme.txt";
    ArrayList<String> dictionary = loadingDictionaryFromFile(pathDictionary);
    String[] correctme = loadingTargetFromFile(pathCorrectme);

    String corrected = "";
    int t_dist;
    Result res;

    for (String word : correctme) {
      res = new Result(Integer.MAX_VALUE, "");
      for (String dict : dictionary) {
        t_dist = EditDistance.edit_distance_dyn(word, dict);
        if (t_dist < res.distance) {
          res.distance = t_dist;
          res.word = dict;
        }
      }
      System.out.println(word + " --> " + res.word + " d:" + res.distance);
      corrected += res.word + " ";
    }
    System.out.println("Frase corretta:\n" + corrected);
  }

}
