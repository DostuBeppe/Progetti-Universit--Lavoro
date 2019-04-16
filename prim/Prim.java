package prim;


import java.util.function.DoubleSupplier;
import java.util.*;

/**
 * Implementazione dell'algoritmo di prim.
 *
 * @param <T> Tipologia di elementi contenuta nei vertici
 * @param <P> Tipologia di priorita' utilizzata per pesare gli archi
 */
class Prim<T, P extends DoubleSupplier> extends Graph<T, P> {

    private PriorityQueue<T, DoubleToDouble> pq;
    private Comparator<DoubleToDouble> cmp;

    /**
     * Classe Graph usata per creare eventuali grafi
     * sia diretti che indiretti, sia pesati che non pesati.
     * Utilizzando l'HashMap di Hashmap, per velocizzare la
     * ricerca dei vertici e rispettivi archi.
     *
     * @param cmp    usato per confrontare il peso
     * @param direct <code>true</code> grafo diretto, altrimenti <code>false</code>
     * @param weight grafo pesato o meno
     */

    public Prim(Comparator<DoubleToDouble> cmp, boolean direct, boolean weight) {

        super(direct, weight);
        this.cmp = cmp;
        pq = new PriorityQueue<T, DoubleToDouble>(cmp);
    }

    /**
     * Algoritmo usato per il calcolo delle foresta, minimum spanning tree (MST).
     *
     * @param start_vertex  è la radice del primo MST
     * @return ArryList di Grafi (che sono gli MST).
     */
    public ArrayList<Graph<T, P>> MST_prim(T start_vertex) {
        ArrayList<Graph<T, P>> forest = new ArrayList<>();
        Graph<T, P> tree = new Graph<>(true, true);
        HashMap<T, Node<T, DoubleToDouble>> hmVertex = new HashMap<>();
        Node<T, DoubleToDouble> tmp;
        for (T k : hm.keySet()) {
            tmp = new Node<>(k, new DoubleToDouble(Double.POSITIVE_INFINITY), null);
            hmVertex.put(k, tmp);
            pq.insert(hmVertex.get(k));
        }
        pq.updatePriority(hmVertex.get(start_vertex), new DoubleToDouble(0.0));
        while ((tmp = pq.extract()) != null && pq.size() >= 0) {

            T vertex = tmp.getElem();

            if (tmp.getParent() == null) {
                tree = new Graph<>(true, true);
                tree.addVertex(vertex);
                forest.add(tree);
            } else {
                tree.addVertex(vertex);
                tree.addEdge(tmp.getParent().getElem(), vertex, hm.get(tmp.getParent().getElem()).get(vertex));
            }

            for (T adjHm : getAccidentVertex(vertex)) {
                if (hm.get(vertex).get(adjHm).getAsDouble() < hmVertex.get(adjHm).getPriority().getAsDouble()) {
                    pq.updatePriority(hmVertex.get(adjHm), new DoubleToDouble(hm.get(vertex).get(adjHm).getAsDouble()));
                    hmVertex.get(adjHm).setParent(tmp);
                }
            }
        }
        return forest;
    }


    public static void main(String[] args) {

        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        String a = "A";
        String b = "B";
        String c = "C";
        String d = "D";
        String e = "E";
        String f = "F";
        String g = "G";
        String h = "H";

        graph.addVertex(a);
        graph.addVertex(b);
        graph.addVertex(c);
        graph.addVertex(d);
        graph.addVertex(e);
        graph.addVertex(f);
        graph.addVertex(g);
        graph.addVertex(h);
        graph.addEdge(a, b, new DoubleToDouble(1.0));
        graph.addEdge(a, c, new DoubleToDouble(5.0));
        graph.addEdge(b, d, new DoubleToDouble(7.0));
        graph.addEdge(c, d, new DoubleToDouble(2.0));
        graph.addEdge(b, c, new DoubleToDouble(3.0));
        graph.addEdge(d, e, new DoubleToDouble(1.0));
        graph.addEdge(g, f, new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> array = graph.MST_prim(a);
        for (Graph<String, DoubleToDouble> x : array) {
            x.print();
        }
    }
}

/**
 * Classe utilizzata per implementare DoubleSupplier nella Classe Double.
 * Il tutto per rendere tutto il progetto il più generico possibile.
 */
class DoubleToDouble implements DoubleSupplier {
    private double value;

    public DoubleToDouble(double value) {
        this.value = value;
    }

    public double getAsDouble() {
        return value;
    }
}

/**
 * Classe utilizzata per implementare il confronto tra DoubleSupplier.
 */
class DoubleComparator implements Comparator<DoubleToDouble> {
    public int compare(DoubleToDouble a, DoubleToDouble b) {
        return Double.compare(b.getAsDouble(), a.getAsDouble());
    }
}