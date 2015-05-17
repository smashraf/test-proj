package rohan.ds;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class StackQueTest {

    private StackQue stackQue = new StackQue();

    @Test
    public void verifyBalanceTest() {
        Assert.assertTrue(stackQue.verifyBalance("(2+2)"));
        Assert.assertFalse(stackQue.verifyBalance("({}2+2)"));
        Assert.assertTrue(stackQue.verifyBalance("{(2+2)}[3+2]"));
        Assert.assertFalse(stackQue.verifyBalance("{(2+2)}([3+2])"));
        Assert.assertTrue(stackQue.verifyBalance("[()]{}[[()()]()]"));
    }

    @Test
    public void findSpanTest() {
        System.out.println(Arrays.toString(stackQue.findSpan(new int[] { 6, 3, 4, 5, 2, 7 })));
    }

    @Test
    public void findLargestRectangleTest() {
        Assert.assertEquals(12, stackQue.findLargestRectangle(new int[] { 6, 2, 5, 4, 5, 1, 6 }));
        Assert.assertEquals(14, stackQue.findLargestRectangle(new int[] { 6, 2, 5, 4, 5, 2, 6 }));
    }

}
