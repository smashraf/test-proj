package rohan.ds;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    // This is an array of lists - 1 list for each vertex representing its
    // neighbours
    // Just like int [] a is an array of integers
    public List<Integer>[] adj;

    public int V  = 0;

    // Initialize the graph
    public Graph(int V) {
        this.V = V;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " : ");
            for (Integer a : adj[i]) {
                System.out.print(a + " -> ");
            }
            System.out.println();
        }
    }
}
