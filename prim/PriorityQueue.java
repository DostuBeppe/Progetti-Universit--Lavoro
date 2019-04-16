package prim;

import java.util.*;
import java.lang.*;
import java.util.function.DoubleSupplier;

/**
 * Classe implementante una Coda con priorita' attraverso l'uso di una struttura heap di generici.
 *
 * @param <T> Tipo dell'elemento
 * @param <P> Tipo della priorità
 */
class PriorityQueue<T, P extends DoubleSupplier> {
  private ArrayList<Node<T, P>> heap;
  private Comparator<P> cmp;
  private HashMap<Node<T, P>, Integer> hQueue;

  public PriorityQueue(Comparator<P> cmp) {
    heap = new ArrayList<>();
    this.cmp = cmp;
    hQueue = new HashMap<>();
  }

  /**
   * Metodo per il calcolo dell'indice del padre relativo ad un nodo
   *
   * @param i Indice del nodo di cui voglio calcolare il padre
   * @return L'indice del nodo padre di <code>i</code>
   */
  protected int getParent(int i) {
    if (i >= 0 && i < heap.size())
      return (int) Math.floor(i / 2);
    else
      return -1;
  }

  /**
   * Metodo per il calcolo dell'indice del figlio sinitro di un nodo dell'heap.
   *
   * @param i Indice del nodo di cui si vuole il figlio sinistro
   * @return Indice del figlio sinistro
   */
  protected int getLeft(int i) {
    if (i >= 0 && 2 * i < heap.size())
      return 2 * i;
    else
      return i;

  }

  /**
   * Metodo per il calcolo dell'indice del figlio destro di un nodo dell'heap.
   *
   * @param i Indice del nodo di cui si vuole il figlio destro
   * @return Indice del figlio destro
   */
  protected int getRight(int i) {
    if (i >= 0 && (2 * i) + 1 < heap.size())
      return (2 * i) + 1;
    else
      return i;
  }

  /**
   * Restitusce la dimensione della coda con priorita'.
   *
   * @return Il numero di elementi presenti nella coda
   */
  public int size() {
    return heap.size();
  }


  /**
   * Metodo per la conversione degli elementi presenti nell'array in un heap, ordinandoli in base alla loro priorita'.
   *
   * @param i Indice da cui partire con la riorganizzazione degli elementi
   */
  protected void heapify(int i) {
    int max = indexOfMax(i, getLeft(i), getRight(i));
    if (max != i) {
      Node<T, P> tmp = heap.get(i);
      hQueue.put(heap.get(max), i);
      heap.set(i, heap.get(max));
      hQueue.put(tmp, max);
      heap.set(max, tmp);
      heapify(max);
    }
  }

  /**
   * Metodo per calcolare il nodo con priorita' maggiore tra quelli in esame passati come parametri.
   *
   * @param parent Indice del nodo padre
   * @param left   Indice del nodo sinistro
   * @param right  Indice del nodo destro
   * @return Indice del nodo con priorita' maggiore
   */
  private int indexOfMax(int parent, int left, int right) {
    if ((cmp.compare(heap.get(parent).getPriority(), heap.get(left).getPriority()) >= 0) &&
            (cmp.compare(heap.get(parent).getPriority(), heap.get(right).getPriority()) >= 0)) {
      return parent;
    } else if ((cmp.compare(heap.get(right).getPriority(), heap.get(parent).getPriority()) >= 0) &&
            (cmp.compare(heap.get(right).getPriority(), heap.get(left).getPriority()) >= 0)) {
      return right;
    } else
      return left;
  }

  /**
   * Inserisce un nuovo elemento all'interno della coda.
   *
   * @param node nodo da inserire
   */
  public void insert(Node<T, P> node) {

    heap.add(node);
    int size = heap.size() - 1;
    hQueue.put(node, size);
    riseUp(size);
  }

  /**
   * Restituisce il primo elemento della coda (il primo valore di priorità minimo), rimuovendolo da
   * essa.
   *
   * @return il primo elemento, <code>null</code> se la coda e' vuota
   */
  public Node<T, P> extract() {
    if (heap.size() > 0) {
      Node<T, P> tmp = heap.get(0);
      int p = heap.size() - 1;
      heap.set(0, heap.get(p));
      hQueue.put(heap.get(p), 0);
      heap.remove(p);
      hQueue.remove(p);
      if (p > 0)
        heapify(0);
      return tmp;
    } else {
      return null;
    }
  }

  /**
   * Prende l'elemento di indice <code>i</code> (ricevuto come parametro) da riposizionare e ne
   * trova la giusta posizione nell'heap, facendolo muovere verso l'alto.
   *
   * @param i indice dell'elemento di cui si deve trovare la giusta posizione
   */
  private void riseUp(int i) {
    Node<T, P> tmp;
    if (i > 0 && cmp.compare(heap.get(i).getPriority(), heap.get(getParent(i)).getPriority()) > 0) {
      tmp = heap.get(i);
      hQueue.put(heap.get(getParent(i)), i);
      heap.set(i, heap.get(getParent(i)));
      hQueue.put(tmp, getParent(i));
      heap.set(getParent(i), tmp);
      riseUp(getParent(i));
    }

  }

  /**
   * Metodo per l'aggiornamento della priorita' di un nodo e la modifica dell'heap per mantenere la struttura.
   *
   * @param node     Nodo di cui aggiornare la priorita'
   * @param priority Nuova priorita' da impostare all'elemento
   */
  protected void updatePriority(Node<T, P> node, P priority) {
    if (hQueue.containsKey(node) && heap.contains(node)) {
      int pos = heap.indexOf(node);
      node.setPriority(priority);
      heap.get(pos).setPriority(priority);
      if (cmp.compare(priority, heap.get(getParent(pos)).getPriority()) > 0)
        riseUp(pos);
      else
        heapify(pos);
    }
  }

  /**
   * Metodo di stampa su console del contenuto dell'heap
   */
  public void print() {
    for (int i = 0; i < heap.size(); i++) {
      System.out.println("--" + heap.get(i).toString() + "--");
    }
  }


}
