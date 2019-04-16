package prim;

import java.util.function.DoubleSupplier;
import java.util.*;

/**
 * Classe Graph usata per creare eventuali grafi
 * sia diretti che indiretti, sia pesati che non pesati.
 * Utilizzando l'HashMap di Hashmap, per velocizzare la
 * ricerca dei vertici e rispettivi archi.
 *
 * @param <T> Tipo del vertice
 * @param <P> Tipo del peso
 */
class Graph<T, P extends DoubleSupplier> {
    private boolean direct;
    private boolean weight;
    protected HashMap<T, HashMap<T, P>> hm;

    /**
     * Il costruttore inizializza un grafo con
     * le caratteristiche dettate dall'utente
     *
     * @param direct identifica se il grafo sia orientato
     * @param weight identifica se il grafo sia pesato
     */

    public Graph(boolean direct, boolean weight) {
        this.direct = direct;
        this.weight = weight;
        this.hm = new HashMap<T, HashMap<T, P>>();
    }

    /**
     * Questo metodo è usato per accedere al campo direct e
     * capire l'orientamento del grafo
     *
     * @return <code>true</code> se il grafo è orientato
     * altrimenti <code>false</code>
     */
    public boolean isDirect() {
        return this.direct;
    }

    /**
     * Questo metodo è usato per accedere al campo weight e
     * capire se il grafo è pesato
     *
     * @return <code>true</code> se il grafo è pesato
     * altrimenti <code>false</code>
     */
    public boolean isWeight() {
        return this.weight;
    }

    /**
     * Questo metodo inserisce un vertice all'interno dell'hashmap
     * il vertice passato come parametro
     *
     * @param vertex il vertice che dovrà essere aggiunto
     */

    public void addVertex(T vertex) {
        if (!checkVertex(vertex)) {
            HashMap<T, P> newVertex = new HashMap<T, P>();
            hm.put(vertex, newVertex);
        }
    }

    /**
     * Questo metodo elimina un vertice, passato come parametro, da Grafo
     * inoltre se il vertice passato come parametro è presente negli adicenti di un
     * arco, verrà eliminato l'arco tra essi
     *
     * @param vertex
     */
    public void removeVertex(T vertex) {
        if (hm.containsKey(vertex)) {
            for (T v : hm.keySet()) {
                if (hm.get(v).containsKey(vertex))
                    removeEdge(v, vertex);
            }
            hm.remove(vertex);
        }
    }

    /**
     * Questo metodo controlla se all'interno dell'hashmap
     * è contenuto il vertice passato come parametro
     *
     * @param vertex vertice da cercare
     * @return <code>true</code> se è stato trovato, altrimenti <code>false</code>
     */
    protected boolean checkVertex(T vertex) {
        if (hm.containsKey(vertex))
            return true;
        return false;
    }

    /**
     * Questo metodo ricerca tutti gli adiacenti del vertice passato come parametro
     *
     * @param vertex di cui si vogliono sapere tutti i vertici adiacenti
     * @return Un set di Vertici
     */
    public Set<T> getAccidentVertex(T vertex) {
        return hm.get(vertex).keySet();
    }

    /**
     * Questo metodo aggiunge all'interno, tra due vertici, un arco
     * con il suo peso
     * Se il Grafo è diretto, allora l'arco verrà inserito una sola volta
     * altrimenti se sarà indiretto, l'arco sarà inserito due volte, ovvero,
     * dall'inizio alla fine e dalla fine all'inizio
     *
     * @param startVertex è il vertice di partenza
     * @param endVertex   è il vertice d'arrivo
     * @param weight      è il peso che dovrà avere l'arco
     */

    public void addEdge(T startVertex, T endVertex, P weight) {

        if (isDirect() && hm.containsKey(startVertex) && hm.containsKey(endVertex)) {
            if (!hm.get(startVertex).containsKey(endVertex))
                hm.get(startVertex).put(endVertex, weight);
        } else if (hm.containsKey(startVertex) && hm.containsKey(endVertex)) {
            if (!hm.get(startVertex).containsKey(endVertex)) {
                hm.get(startVertex).put(endVertex, weight);
                hm.get(endVertex).put(startVertex, weight);
            }
        }
    }

    /**
     * Questo metodo aggiunge all'interno tra due vertici un arco
     * con peso nullo
     * Se il Grafo è diretto, allora l'arco verrà inserito una sola volta
     * altrimenti se sarà indiretto, l'arco sarà inserito due volte, ovvero,
     * dall'inizio alla fine e dalla fine all'inizio
     *
     * @param startVertex vertice di partenza
     * @param endVertex   vertice di arrivo
     */
    public void addEdge(T startVertex, T endVertex) {
        addEdge(startVertex, endVertex, null);
    }

    /**
     * Questo metodo conta il numero di archi all'interno del Grafo
     *
     * @return il numero che è uguale al numero di tutti gli archi presenti nel Grafo
     */
    public int numEdge() {
        int count = 0;
        for (T v : hm.keySet()) {
            count += hm.get(v).size();
        }
        return count;
    }

    /**
     * Questo metodo è utilizzato per elimare un arco dal Grafo
     * Se il Grafo è diretto, elimina solo un arco con il peso corrispettivo,
     * altrimetni nel caso in cui sia indiretto, elminierà due archi, dalla partenza
     * dalla fine e dalla fine all'inizio
     *
     * @param startVertex Vertice di partenza
     * @param endVertex   Vertice di arrivo
     */
    public void removeEdge(T startVertex, T endVertex) {
        if (isDirect()) {
            if (hm.containsKey(startVertex) && hm.containsKey(endVertex)) {
                if (hm.get(startVertex).containsKey(endVertex)) {
                    hm.get(startVertex).remove(endVertex);
                }
            }
        } else {
            if (hm.containsKey(startVertex) && hm.containsKey(endVertex)) {
                if (hm.get(startVertex).containsKey(endVertex)) {
                    hm.get(startVertex).remove(endVertex);
                }
                if (hm.get(endVertex).containsKey(startVertex)) {
                    hm.get(endVertex).remove(startVertex);
                }
            }
        }
    }

    /**
     * Questo metodo controlla se all'interno del grafo esista un arco
     * con il peso speso specificato tra i due vertici passati come parametro
     *
     * @param start  vertice di partenza
     * @param end    vertiche di arrivo
     * @param weight peso dell'arco
     * @return <code>true</code> se è stato trovato, altrimenti <code>false</code>
     */
    protected boolean checkEdge(T start, T end, P weight) {

        return hm.containsKey(start) && hm.get(start).containsKey(end) && hm.get(start).get(end).getAsDouble() == weight.getAsDouble();
    }

    /**
     * Questo metodo controlla se all'interno del grafo esista un arco
     * tra i due vertici passati come parametro
     *
     * @param start vertice di partenza
     * @param end   vertice di arrivo
     * @return <code>true</code> se è stato trovato, altrimenti <code>false</code>
     */
    protected boolean checkEdge(T start, T end) {

        return hm.containsKey(start) && hm.get(start).containsKey(end);
    }

    /**
     * Questo metodo controlla la dimensione del Grafo
     *
     * @return la dimensione del Grafo
     */
    public int size() {
        return hm.size();
    }

    /**
     * Questo metodo conta il peso di tutto il grafo, solo se è pesato
     *
     * @return il numero totale del peso del Grafo
     * @throws Exception lancia l'eccezione se il metodo è richuamto su un grafo non pesato
     */
    public double totalWeight() throws Exception {
        double total = 0.0;
        if (isWeight()) {
            for (T w : hm.keySet()) {
                for (T k : hm.get(w).keySet()) {
                    total = total + hm.get(w).get(k).getAsDouble();
                }
            }
        } else throw new Exception("is not weighted, impossible!");

        return total;
    }

    /**
     * Questo metodo visualizza lo stato del Grafo, evidenziando tutti i collegamenti
     */

    public void print() {
        for (T n : hm.keySet()) {
            System.out.print("\n{[" + n + " => ");
            for (T m : hm.get(n).keySet()) {
                if (isWeight()) {
                    System.out.print(m + " " + " = Peso = " + hm.get(n).get(m).getAsDouble() + "] =>\t");
                } else {
                    System.out.print(m + " ] =>\t");
                }
            }
            System.out.print("}\n");
        }
    }


    public static void main(String[] args) throws Exception {
        Graph<String, StringToDouble> prova = new Graph<String, StringToDouble>(false, true);
        prova.addVertex("A");
        prova.addVertex("B");
        prova.addVertex("C");
        prova.addVertex("D");
        prova.addEdge("A", "D", new StringToDouble("2.0"));
        prova.addEdge("A", "B", new StringToDouble("3.0"));
        prova.addEdge("B", "C", new StringToDouble("1.0"));
        prova.print();
        System.out.println(prova.totalWeight());
        System.out.println(prova.numEdge());
    }

}

/**
 * Questa è usata per risoluzione dell'esercizio assegnato
 * Trasforma un tipo String in un tipo Double, così può usare come peso
 */
class StringToDouble implements DoubleSupplier {
    private String value;
    private double doubleValue;

    public StringToDouble(String s) {
        this.value = s;
        doubleValue = Double.parseDouble(s);
    }

    public double getAsDouble() {
        return doubleValue;
    }


    public String toString() {
        return value;
    }


}
