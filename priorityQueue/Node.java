package priorityQueue;

import java.util.Comparator;
import java.util.function.DoubleSupplier;

/**
 * Classe di supporto per la generazione dei nodi, composti da un elemento ed una priorita'
 * @param <T> Contenuto del nodo
 * @param <P> Priorita' associata
 */
class Node<T, P> {
  private T elem;
  private P priority;

  public Node(T elem, P priority) {
    this.elem = elem;
    this.priority = priority;
  }

  /**
   * Restituisce l'elemento contenuto nel nodo.
   * @return Elemento contenuto
   */
  public T getElem() {
    return this.elem;
  }

  /**
   * Restituisce la priorita' associata al nodo.
   * @return Priorita' del nodo
   */
  public P getPriority() {
    return this.priority;
  }

  /**
   * Sostituisce l'elemento contenuto nel nodo
   * @param elem Nuovo contenuto del nodo
   */
  public void setElem(T elem) {
    this.elem = elem;
  }

  /**
   * Imposta una nuova priorita' al nodo
   * @param priority Nuovo valore del nodo da associare
   */
  public void setPriority(P priority) {
    this.priority = priority;
  }

  /**
   * Ovverride del metodo toString per visualizzare il nodo
   * con la sua Priorità
   *
   */
  public String toString() {
    if (priority == null)
      return elem.toString();
    return elem.toString() + " " + priority.toString();
  }

  public static void main(String[] args) {

    Node<String, Integer> node = new Node<>("A", 2);
    Node<String, Integer> node2 = new Node<>("B", 1);
    Node<String, Integer> node3 = new Node<>("C", 7);
    Node<String, Integer> node4 = new Node<>("D", 5);
    Node<String, Integer> node5 = new Node<>("E", 15);
    DoubleComparator cmp = new DoubleComparator();
  }

  static class DoubleComparator implements Comparator<DoubleToDouble> {
    public int compare(DoubleToDouble a, DoubleToDouble b) {
      return Double.compare(a.getAsDouble(), b.getAsDouble());
    }
  }

  static class DoubleToDouble implements DoubleSupplier {
    private double value;

    public DoubleToDouble(double value) {
      this.value = value;
    }

    public double getAsDouble() {
      return value;
    }
  }

}
