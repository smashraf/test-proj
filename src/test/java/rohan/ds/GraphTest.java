package rohan.ds;

import org.junit.Test;

public class GraphTest {
    
    Graph graph;
    
    @Test
    public void testGraph() {
        graph = new Graph(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.printGraph();
    }

}
