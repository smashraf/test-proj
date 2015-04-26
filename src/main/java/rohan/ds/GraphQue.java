package rohan.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Queue;

public class GraphQue {

    public void dfs(Graph graph) {
        boolean visited[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++)
            visited[i] = false;
        for (int i = 0; i < graph.V; i++) {
            dfsUtil(visited, graph, i);
        }
    }

    private void dfsUtil(boolean visited[], Graph graph, int v) {
        if (visited[v] == true)
            return;
        visited[v] = true;
        System.out.println("Node :" + v);
        for (Integer adjVertex : graph.adj[v]) {
            if (!visited[adjVertex])
                dfsUtil(visited, graph, adjVertex);
        }
    }

    public void bfs(Graph graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean visited[] = new boolean[graph.V];
        for (int i = 0; i < graph.V; i++)
            visited[i] = false;
        for (int i = 0; i < graph.V; i++) {
            queue.add(i);
            bfsUtil(graph, visited, queue);
        }
    }

    public void bfsUtil(Graph graph, boolean[] visited, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            Integer currentNode = queue.remove();
            if (!visited[currentNode])
                System.out.println("Node :" + currentNode);
            visited[currentNode] = true;
            for (Integer adjVertex : graph.adj[currentNode]) {
                if (!visited[adjVertex])
                    queue.add(adjVertex);
            }
        }
    }

    public void bellmanFord(WeightedGraph graph, int start) {
        int[] parent = new int[graph.V];
        double[] distance = new double[graph.V];
        for(int i=0;i<graph.V;i++) {
            parent[i] = -1;
            distance[i] = Double.MAX_VALUE;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        parent[start] = -1;
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            for (Entry<Integer, Double> entry : graph.adj[vertex].entrySet()) {
                if (distance[vertex] + entry.getValue() < distance[entry.getKey()]) {
                    distance[entry.getKey()] = distance[vertex] + entry.getValue();
                    parent[entry.getKey()] = vertex;
                    queue.add(entry.getKey());
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));
    }
    
    public int countPaths(int [][]graph, int s, int d, int c) {
        if(s==d) return c+1;
        for(int j=0;j<graph.length;j++) {
            
            if(graph[s][j] == 1) c +=  countPaths(graph,j,d,c);
        }
        return c;
    }
}
