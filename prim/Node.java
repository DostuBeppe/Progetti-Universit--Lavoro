package prim;

import java.util.*;
import java.util.function.DoubleSupplier;

/**
 * Classe di supporto per la generazione dei nodi, composti da un elemento ed una priorita'.
 * Si differenzia dalla versione del package priorityQueue per la presenza di un riferimento al nodo padre.
 *
 * @param <T> Contenuto del nodo
 * @param <P> Priorita' associata
 */
class Node<T, P extends DoubleSupplier> {
  private Node<T, P> parent;
  private T elem;
  private P priority;


  public Node(T elem, P priority, Node<T, P> parent) {
    this.elem = elem;
    this.priority = priority;
    this.parent = parent;
  }

  /**
   * Restituisce l'elemento contenuto nel nodo.
   *
   * @return Elemento contenuto
   */
  public T getElem() {
    return this.elem;
  }

  /**
   * Restitutisce il nodo padre del nodo.
   * @return Il nodo padre del nodo su cui viene richiamato il metodo
   */
  public Node<T, P> getParent() {
    return this.parent;
  }

  /**
   * Restituisce la priorita' associata al nodo.
   *
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
   * Sostituisce l'elemento contenuto nel nodo
   * @param parent Nuovo contenuto del nodo padre
   */

  public void setParent(Node<T, P> parent) {
    this.parent = parent;
  }

  /**
   * Imposta una nuova priorita' al nodo
   * @param priority Nuovo valore del nodo da associare
   */
  public void setPriority(P priority) {
    this.priority = priority;
  }

  public String toString() {
    if (priority == null)
      return elem.toString();
    return elem.toString() + " " + priority.getAsDouble();
  }

  public static void main(String[] args) {
    Node<String, DoubleToDouble> node = new Node<>("A", new DoubleToDouble(2.0), null);
    Node<String, DoubleToDouble> node2 = new Node<>("B", new DoubleToDouble(1.0), node);
    Node<String, DoubleToDouble> node3 = new Node<>("C", new DoubleToDouble(7.0), node2);
    Node<String, DoubleToDouble> node4 = new Node<>("D", new DoubleToDouble(5.0), node3);
    Node<String, DoubleToDouble> node5 = new Node<>("E", new DoubleToDouble(15.0), node4);
    DoubleComparator cmp = new DoubleComparator();
    PriorityQueue<String, DoubleToDouble> pq = new PriorityQueue<>(cmp);

    pq.insert(node);
    pq.insert(node2);
    pq.insert(node3);
    pq.insert(node4);
    pq.insert(node5);
    System.out.println();
    System.out.println("nuova print");
    pq.extract();
    pq.print();
    System.out.println("nuova print");
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
