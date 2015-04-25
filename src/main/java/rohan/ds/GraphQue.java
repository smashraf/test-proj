package rohan.ds;

import java.util.ArrayDeque;
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

}
