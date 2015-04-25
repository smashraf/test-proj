package rohan.ds;

import org.junit.Before;
import org.junit.Test;

public class GraphQueTest {
    
    private GraphQue graphQue = new GraphQue();
    
    private Graph graph;
    
    @Before
    public void setup() {
        graph = new Graph(6);
        graph.addEdge(0, 3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        
    }
    
    @Test
    public void dfsTest() {
        graphQue.dfs(graph);
    }
    
    @Test
    public void bfsTest() {
        graphQue.bfs(graph);
    }

}
