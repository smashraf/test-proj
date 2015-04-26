package rohan.ds;

import org.junit.Test;

public class WeightedGraphTest {

    private WeightedGraph dag;

    @Test
    public void weightedGraphTest() {
        dag = new WeightedGraph(5);
        dag.addEdge(0, 1, 4);
        dag.addEdge(0, 2, 1);
        dag.addEdge(2, 1, 2);
        dag.addEdge(1, 4, 3);
        dag.addEdge(2, 3, 2);
        dag.printGraph();
    }

}
