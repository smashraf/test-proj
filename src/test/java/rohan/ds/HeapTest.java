package rohan.ds;

import java.util.Arrays;

import org.junit.Test;

public class HeapTest {

    private MaxHeap maxHeap = new MaxHeap(10);

    @Test
    public void testHeap() {
        maxHeap.insert(10);
        maxHeap.insert(15);
        maxHeap.insert(12);
        maxHeap.insert(6);
        maxHeap.insert(18);
        maxHeap.insert(9);
        System.out.println(Arrays.toString(maxHeap.arr));
    }

}
