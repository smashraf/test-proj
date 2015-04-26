package rohan.ds;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class WeightedGraph {

    // Representing the adjacent vertices as the vertex and the weight of the
    // edge connecting them. This is an array of maps
    public Map<Integer, Double>[] adj;

    public int V;

    public WeightedGraph(int V) {
        this.V = V;
        adj = (HashMap<Integer, Double>[]) new HashMap[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashMap<>();
        }
    }

    public void addEdge(int p, int q, double w) {
        adj[p].put(q, w);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");
            for (Entry<Integer, Double> adjVertex : adj[i].entrySet()) {
                System.out.print(adjVertex.getKey() + "(" + adjVertex.getValue() + ") -> ");
            }
            System.out.println();
        }
    }
}
