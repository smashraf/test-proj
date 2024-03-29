package rohan.ds;

import org.junit.Before;
import org.junit.Test;

public class GraphQueTest {

    private GraphQue graphQue = new GraphQue();

    private Graph graph;

    private DirectedGraph directedGraph;

    private WeightedGraph weightedGraph;

    @Before
    public void setup() {
        graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);

        weightedGraph = new WeightedGraph(5);
        weightedGraph.addEdge(0, 1, 4);
        weightedGraph.addEdge(0, 2, 1);
        weightedGraph.addEdge(1, 4, 3);
        weightedGraph.addEdge(2, 1, 2);
        weightedGraph.addEdge(2, 3, 2);

        directedGraph = new DirectedGraph(9);
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(4, 5);
        directedGraph.addEdge(5, 1);
        directedGraph.addEdge(4, 7);
        directedGraph.addEdge(5, 7);
        directedGraph.addEdge(6, 7);

    }

    @Test
    public void dfsTest() {
        graphQue.dfs(graph);
    }

    @Test
    public void bfsTest() {
        graphQue.bfs(graph);
    }

    @Test
    public void bellmanFordTest() {
        graphQue.bellmanFord(weightedGraph, 0);
    }

    @Test
    public void countPathsTest() {
        int arr[][] = { { 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 } };
        System.out.println(graphQue.countPaths(arr, 0, 0, new boolean[] { false, false, false, false, false }));
    }

    @Test
    public void topologicalSortTest() {
        graphQue.topologicalSort(directedGraph);
    }

    @Test
    public void findIslandsTest() {
        //int arr[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } };
        //int arr[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        int arr[][] = {{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1}, {1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
        graphQue.findIslands(arr);
    }

}
