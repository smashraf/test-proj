package rohan.ds;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class GraphQue {
    
    public int c=0;

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
        for (int i = 0; i < graph.V; i++) {
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
                if (distance[vertex] + entry.getValue() < distance[entry
                        .getKey()]) {
                    distance[entry.getKey()] = distance[vertex]
                            + entry.getValue();
                    parent[entry.getKey()] = vertex;
                    queue.add(entry.getKey());
                }
            }
        }
        System.out.println(Arrays.toString(distance));
        System.out.println(Arrays.toString(parent));
    }

    public int countPaths(int[][] graph, int s, int d, boolean[] visited) {
        visited[s] = true;
        if (s == d)
            c++;
        else {
            for (int j = 0; j < graph.length; j++) {
                if ((graph[s][j] == 1) && !visited[j])
                    countPaths(graph, j, d, visited);
            }
        }
        visited[s] = false;
        return c;
    }

    public void topologicalSort(DirectedGraph graph) {
        boolean[] visited = new boolean[graph.V];
        Stack<Integer> nodes = new Stack<>();
        for (int i = 0; i < graph.V; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < graph.V; i++) {
            topSort(graph, i, visited, nodes);
        }
        // Printing in reverse order to get
        while (!nodes.isEmpty())
            System.out.print(nodes.pop() + " , ");
    }

    public void topSort(DirectedGraph graph, int v, boolean[] visited, Stack<Integer> nodes) {
        if (visited[v] == true)
            return;
        visited[v] = true;
        for (Integer adjVertex : graph.adj[v]) {
            if (!visited[adjVertex])
                topSort(graph, adjVertex, visited, nodes);
        }
        nodes.push(v);
    }

    public int findIslands(int[][] graph) {
        int count = 0;
        boolean[][] visited = new boolean[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++)
            for (int j = 0; j < graph.length; j++)
                visited[i][j] = false;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++)
                if (!visited[i][j] && graph[i][j] == 1) {
                    count++;
                    findIslandUtil(graph, i, j, visited);
                }
        }
        System.out.println("No of islands = " + count);
        return count;
    }

    public void findIslandUtil(int[][] graph, int x, int y, boolean[][] visited) {
        if (visited[x][y])
            return;
        visited[x][y] = true;
        // Finding the adjacents for this prob is different, identify the 8
        // neighbours
        if (x + 1 < graph.length && graph[x + 1][y] == 1)
            findIslandUtil(graph, x + 1, y, visited);
        if (x - 1 >= 0 && graph[x - 1][y] == 1)
            findIslandUtil(graph, x - 1, y, visited);
        if (x + 1 < graph.length && y + 1 < graph.length && graph[x + 1][y + 1] == 1)
            findIslandUtil(graph, x + 1, y + 1, visited);
        if (x + 1 < graph.length && y - 1 >= 0 && graph[x + 1][y - 1] == 1)
            findIslandUtil(graph, x + 1, y - 1, visited);
        if (x - 1 >= 0 && y - 1 >= 0 && graph[x - 1][y - 1] == 1)
            findIslandUtil(graph, x - 1, y - 1, visited);
        if (x - 1 >= 0 && y + 1 < graph.length && graph[x - 1][y + 1] == 1)
            findIslandUtil(graph, x - 1, y + 1, visited);
        if (y - 1 >= 0 && graph[x][y - 1] == 1)
            findIslandUtil(graph, x, y - 1, visited);
        if (y + 1 < graph.length && graph[x][y + 1] == 1)
            findIslandUtil(graph, x, y + 1, visited);
    }

}
