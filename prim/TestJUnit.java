package prim;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class TestJUnit {
    Graph<String, StringToDouble> prova = new Graph<String, StringToDouble>(false, true);
    Graph<String, StringToDouble> prova2 = new Graph<String, StringToDouble>(true, true);
    Graph<String, StringToDouble> prova3 = new Graph<String, StringToDouble>(false, false);
    Graph<String, StringToDouble> prova4 = new Graph<String, StringToDouble>(true, false);

    @Test
    public void testInit() {
        assertNull(null);
    }


    @Test
    public void testCreationGraph() {
        Graph<String, StringToDouble> prova_test_insert = new Graph<String, StringToDouble>(false, true);
        assertNotNull(prova_test_insert);
        assertFalse(prova_test_insert.isDirect());
        assertTrue(prova_test_insert.isWeight());

        Graph<String, StringToDouble> prova_test_insert2 = new Graph<String, StringToDouble>(true, true);
        assertNotNull(prova_test_insert2);
        assertTrue(prova_test_insert2.isDirect());
        assertTrue(prova_test_insert2.isWeight());

        Graph<String, StringToDouble> prova_test_insert3 = new Graph<String, StringToDouble>(true, false);
        assertNotNull(prova_test_insert3);
        assertTrue(prova_test_insert3.isDirect());
        assertFalse(prova_test_insert3.isWeight());


        Graph<String, StringToDouble> prova_test_insert4 = new Graph<String, StringToDouble>(false, false);
        assertNotNull(prova_test_insert4);
        assertFalse(prova_test_insert4.isDirect());
        assertFalse(prova_test_insert4.isWeight());
    }

    @Test
    public void testAddVertex() {
        prova.addVertex("A");
        assertTrue(prova.checkVertex("A"));
        prova.addVertex("B");
        assertTrue(prova.checkVertex("B"));
        prova.addVertex("C");
        assertTrue(prova.checkVertex("C"));
        assertFalse(prova.checkVertex("D"));
    }


    @Test
    public void testRemoveVertex() {
        prova.removeVertex("A");
        assertFalse(prova.checkVertex("A"));
        prova.removeVertex("B");
        assertFalse(prova.checkVertex("B"));

        prova.removeVertex("C");
        assertFalse(prova.checkVertex("C"));
    }

    @Test
    public void testAddEdge() {
        prova.addVertex("A");
        prova.addVertex("B");
        prova.addVertex("C");
        prova.addEdge("A", "B", new StringToDouble("1.0"));
        prova.addEdge("B", "C", new StringToDouble("2.0"));
        assertTrue(prova.checkEdge("A", "B", new StringToDouble("1.0")));
        assertTrue(prova.checkEdge("B", "C", new StringToDouble("2.0")));
        assertFalse(prova.checkEdge("A", "C", new StringToDouble("1.0")));
    }

    @Test
    public void testAddEdge2() {
        prova2.addVertex("A");
        prova2.addVertex("B");
        prova2.addVertex("C");
        prova2.addEdge("A", "B", new StringToDouble("1.0"));
        prova2.addEdge("B", "C", new StringToDouble("2.0"));
        assertTrue(prova2.checkEdge("A", "B", new StringToDouble("1.0")));
        assertTrue(prova2.checkEdge("B", "C", new StringToDouble("2.0")));
        assertFalse(prova2.checkEdge("A", "C", new StringToDouble("1.0")));
    }

    @Test
    public void testAddEdge3() {
        prova3.addVertex("A");
        prova3.addVertex("B");
        prova3.addVertex("C");
        prova3.addEdge("A", "B");
        prova3.addEdge("B", "C");
        assertTrue(prova3.checkEdge("A", "B"));
        assertTrue(prova3.checkEdge("B", "C"));
        assertFalse(prova3.checkEdge("A", "C"));

    }

    @Test
    public void testAddEdge4() {
        prova4.addVertex("A");
        prova4.addVertex("B");
        prova4.addVertex("C");
        prova4.addEdge("A", "B");
        prova4.addEdge("B", "C");
        assertTrue(prova4.checkEdge("A", "B"));
        assertTrue(prova4.checkEdge("B", "C"));
        assertFalse(prova4.checkEdge("A", "C"));
    }

    @Test
    public void testNumEdgeIndirect() {
        int numEdge = 6;
        prova.addVertex("A");
        prova.addVertex("B");
        prova.addVertex("C");
        prova.addEdge("A", "B");
        prova.addEdge("B", "C");
        prova.addEdge("A", "C");
        assertEquals(numEdge, prova.numEdge());
    }

    @Test
    public void testNumEdgeDirect() {
        int numEdge = 2;
        prova2.addVertex("A");
        prova2.addVertex("B");
        prova2.addVertex("C");
        prova2.addEdge("A", "B");
        prova2.addEdge("B", "C");
        assertEquals(numEdge, prova2.numEdge());
    }

    @Test
    public void testTotalIsWeigthIndirect() {
        double total = 6.0;
        boolean thrown = false;
        prova.addVertex("A");
        prova.addVertex("B");
        prova.addVertex("C");
        prova.addEdge("A", "B", new StringToDouble("1.0"));
        prova.addEdge("B", "C", new StringToDouble("1.0"));
        prova.addEdge("A", "C", new StringToDouble("1.0"));
        try {
            assertTrue(total == prova.totalWeight());
        } catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    @Test
    public void testTotalIsntWeigthIndirect() {

        boolean thrown = false;
        prova3.addVertex("A");
        prova3.addVertex("B");
        prova3.addVertex("C");
        prova3.addEdge("A", "B");
        prova3.addEdge("B", "C");
        prova3.addEdge("A", "C");
        try {
            prova3.totalWeight();
        } catch (Exception e) {
            thrown = true;

        }
        assertTrue(thrown);
    }

    @Test
    public void testTotalIsWeigthDirect() {
        double total = 3.0;
        boolean thrown = false;
        prova2.addVertex("A");
        prova2.addVertex("B");
        prova2.addVertex("C");
        prova2.addEdge("A", "B", new StringToDouble("1.0"));
        prova2.addEdge("B", "C", new StringToDouble("1.0"));
        prova2.addEdge("A", "C", new StringToDouble("1.0"));

        try {
            assertTrue(total == prova2.totalWeight());
        } catch (Exception e) {
            thrown = true;
        }
        assertFalse(thrown);
    }

    @Test
    public void testTotalIsntWeigthDirect() {
        boolean thrown = false;
        prova4.addVertex("A");
        prova4.addVertex("B");
        prova4.addVertex("C");
        prova4.addEdge("A", "B");
        prova4.addEdge("B", "C");
        prova4.addEdge("A", "C");
        try {
            prova4.totalWeight();
        } catch (Exception e) {
            thrown = true;

        }
        assertTrue(thrown);
    }

    @Test
    public void testRemoveEdge() {
        prova.addVertex("A");
        prova.addVertex("B");
        prova.addVertex("C");
        prova.addEdge("A", "B", new StringToDouble("1.0"));
        prova.addEdge("B", "C", new StringToDouble("2.0"));
        assertTrue(prova.checkEdge("A", "B", new StringToDouble("1.0")));
        assertTrue(prova.checkEdge("B", "C", new StringToDouble("2.0")));
        assertFalse(prova.checkEdge("A", "C", new StringToDouble("1.0")));
        prova.removeEdge("A", "C");
        assertFalse(prova.checkEdge("A", "C", new StringToDouble("1.0")));
    }

    @Test
    public void testRemoveEdge2() {
        prova2.addVertex("A");
        prova2.addVertex("B");
        prova2.addVertex("C");
        prova2.addEdge("A", "B", new StringToDouble("1.0"));
        prova2.addEdge("B", "C", new StringToDouble("2.0"));
        assertTrue(prova2.checkEdge("A", "B", new StringToDouble("1.0")));
        assertTrue(prova2.checkEdge("B", "C", new StringToDouble("2.0")));
        assertFalse(prova2.checkEdge("A", "C", new StringToDouble("1.0")));
        prova2.removeEdge("A", "B");
        assertFalse(prova2.checkEdge("A", "B", new StringToDouble("1.0")));
    }

    @Test
    public void testRemoveEdge3() {
        prova3.addVertex("A");
        prova3.addVertex("B");
        prova3.addVertex("C");
        prova3.addEdge("A", "B");
        prova3.addEdge("B", "C");
        assertTrue(prova3.checkEdge("A", "B"));
        assertTrue(prova3.checkEdge("B", "C"));
        assertFalse(prova3.checkEdge("A", "C"));
        prova3.removeEdge("B", "C");
        assertFalse(prova3.checkEdge("B", "C"));

    }

    @Test
    public void testRemoveEdge4() {
        prova4.addVertex("A");
        prova4.addVertex("B");
        prova4.addVertex("C");
        prova4.addEdge("A", "B");
        prova4.addEdge("B", "C");
        assertTrue(prova4.checkEdge("A", "B"));
        assertTrue(prova4.checkEdge("B", "C"));
        assertFalse(prova4.checkEdge("A", "C"));
        prova4.removeEdge("A", "B");
        assertFalse(prova4.checkEdge("A", "B"));
    }

    @Test
    public void testCreationPrimIndirect() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        assertNotNull(graph);
    }

    @Test
    public void testCreationPrimDirect() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), true, true);
        assertNotNull(graph);
    }

    @Test
    public void testPrim2Direct() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), true, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("B", "C", new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");

        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertTrue(prim.get(0).checkEdge("B","C", new DoubleToDouble(2.0)));
    }

    @Test
    public void testPrim2Indirect() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("B", "C", new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");

        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertFalse(prim.get(0).checkEdge("B","A", new DoubleToDouble(1.0)));
        assertTrue(prim.get(0).checkEdge("B","C", new DoubleToDouble(2.0)));
    }

    @Test
    public void testPrim3Direct() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), true, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("C", "D", new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");

        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertFalse(prim.get(0).checkEdge("B","A", new DoubleToDouble(1.0)));
        assertTrue(prim.get(1).checkEdge("C","D", new DoubleToDouble(2.0)));
    }
    @Test
    public void testPrim3Indirect() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("C", "D", new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");

        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertFalse(prim.get(0).checkEdge("B","A", new DoubleToDouble(1.0)));
        assertTrue(prim.get(1).checkEdge("C","D", new DoubleToDouble(2.0)));

    }

    @Test
    public void testPrim4Direct() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), true, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("A", "C", new DoubleToDouble(2.0));
        graph.addEdge("B", "C", new DoubleToDouble(5.0));
        graph.addEdge("C", "D", new DoubleToDouble(7.0));
        graph.addEdge("C", "E", new DoubleToDouble(0.0));
        graph.addEdge("F", "G", new DoubleToDouble(2.0));


        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");

        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertTrue(prim.get(0).checkEdge("A","C", new DoubleToDouble(2.0)));
        assertTrue(prim.get(0).checkEdge("C","E", new DoubleToDouble(0.0)));
        assertTrue(prim.get(0).checkEdge("C","D", new DoubleToDouble(7.0)));


    }

    @Test
    public void testPrim4Indirect() {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addEdge("A", "B", new DoubleToDouble(1.0));
        graph.addEdge("A", "C", new DoubleToDouble(2.0));
        graph.addEdge("B", "C", new DoubleToDouble(5.0));
        graph.addEdge("C", "D", new DoubleToDouble(7.0));
        graph.addEdge("C", "E", new DoubleToDouble(0.0));
        graph.addEdge("F", "G", new DoubleToDouble(2.0));

        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");


        assertTrue(prim.get(0).checkEdge("A","B", new DoubleToDouble(1.0)));
        assertTrue(prim.get(0).checkEdge("A","C", new DoubleToDouble(2.0)));
        assertTrue(prim.get(0).checkEdge("C","E", new DoubleToDouble(0.0)));
        assertTrue(prim.get(0).checkEdge("C","D", new DoubleToDouble(7.0)));


        assertTrue(prim.get(1).checkEdge("F","G", new DoubleToDouble(2.0)) || prim.get(1).checkEdge("G","F", new DoubleToDouble(2.0)));

    }

    @Test
    public void testPrimIsntWeigth() {
        boolean thrown=false;
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, false);
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("A", "B");
        graph.addEdge("B", "C");

        try {
            ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim("A");
        } catch (Exception e) {
            thrown = true;

        }
        assertTrue(thrown);
    }


}
