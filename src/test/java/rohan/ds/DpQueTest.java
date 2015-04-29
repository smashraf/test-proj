package rohan.ds;

import static junitparams.JUnitParamsRunner.$;
import junit.framework.Assert;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class DpQueTest {

    private DpQue dpQue = new DpQue();

    public Object[] getIntegerArray() {
        return $($(new Integer[] { 1, 2, -4, 3, -5 }, 3), $(new Integer[] { 1, 2, 3 }, 6),
                $(new Integer[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 7), $(new Integer[] { -1 }, -1));
    }

    @Test
    @Parameters(method = "getIntegerArray")
    public void getMaxSubArrayTest(Integer[] arr, int ans) {
        Assert.assertEquals(ans, dpQue.getMaxSubArray(arr));
    }

    @Test
    @Parameters(method = "getIntegerArray")
    public void kadaneTest(Integer[] arr, int ans) {
        Assert.assertEquals(ans, dpQue.kadane(arr));
    }

    public Object[] getIntegerArrayForProduct() {
        return $($(new Integer[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 360), $(new Integer[] { 1, 2, 3 }, 6),
                $(new Integer[] { -2, -3, 4, -1, -2, 1, 5, -3 }, 360), $(new Integer[] { -1 }, 1));
    }

    @Test
    @Parameters(method = "getIntegerArrayForProduct")
    public void getMaxProductSubArrayTest(Integer[] arr, int ans) {
        Assert.assertEquals(ans, dpQue.getMaxProductSubArray(arr, 1, 1));
    }

    public Object[] getArrayLis() {
        return new Object[] { new Object[] { new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80 }, 6 } };
    }

    @Test
    @Parameters(method = "getArrayLis")
    public void lisTest(int[] arr, int ans) {
        Assert.assertTrue(dpQue.lis(arr) == ans);
    }

    @Test
    public void findMaxChainTest() {
        Pair[] arr = new Pair[] { new Pair(5, 24), new Pair(39, 60), new Pair(15, 28), new Pair(27, 40),
                new Pair(50, 90) };
        Assert.assertEquals(3, dpQue.findMaxChain(arr));
    }

}
