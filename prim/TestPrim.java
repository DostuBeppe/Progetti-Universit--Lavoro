package prim;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Questa Classe viene utilizzata per implementare MST_prim
 * carica il file italian_dist_graph.csv e calcola tutti gli alberi
 * della foresta, crata dall'algoritmo
 * inizialmente il file viene caricato in un array di stringhe,
 * successivamente, attarverso codesto array, raccogliendo le giuste informazione e creando il Grafo
 */
public class TestPrim {


    public static void main(String [] args) throws Exception {
        Prim<String, DoubleToDouble> graph = new Prim<>(new DoubleComparator(), false, true);
        FileReader f;
        f=new FileReader("C:\\Users\\Beppe\\IdeaProjects\\laboratorio-algoritmi-2017-18\\src\\prim\\italian_dist_graph.csv");
        BufferedReader b;
        b=new BufferedReader(f);
        String s = "";
        String[] array;
        int i=0;
        String primo;
        s=b.readLine();
        array=s.split(",");
        primo=array[0];
        System.out.println("leggo il punto di partenza:"+primo);
        graph.addVertex(primo);
        graph.addVertex(array[1]);
        graph.addEdge(array[0],array[1], new DoubleToDouble(Double.parseDouble(array[2])));
        while(true){
            try {
                s=b.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(s==null)
                break;
            array = s.split(",");
            graph.addVertex(array[0]);
            graph.addVertex(array[1]);
            graph.addEdge(array[0],array[1], new DoubleToDouble(Double.parseDouble(array[2])));

        }
        graph.print();

        System.out.println("  \n\n\n                                                                       STAMPO IL PRIM \n\n");
        long time = System.currentTimeMillis();
        ArrayList<Graph<String, DoubleToDouble>> prim=graph.MST_prim(primo);
        time = System.currentTimeMillis() - time;
        System.out.println(time);


        int numVertex=0;
        double totalWright=0.0;
        int numEdges=0;

        for(int j=0; j<prim.size();j++){
            numVertex+=prim.get(j).size();
            totalWright+=prim.get(j).totalWeight();
            numEdges+=prim.get(j).numEdge();
        }
        System.out.println("vertici: "+numVertex);
        System.out.println("peso: "+String.format("%.3f",totalWright));
        System.out.println("archi: "+numEdges);


    }


}
