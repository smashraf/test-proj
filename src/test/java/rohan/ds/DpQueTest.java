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

    @Test
    public void getLongestBitonicSeqTest() {
        int[] arr = { 1, 11, 2, 10, 4, 5, 2, 1 };
        Assert.assertEquals(6, dpQue.getLongestBitonicSeq(arr));
    }

    public Object[] getMaxSubArrayForSumArray() {
        return new Object[] { new Object[] { new int[] { 14, 20, 3, 10, 5, 111, 5 }, 15 },
                new Object[] { new int[] { 14, 20, 3, 10, 5, 111, 5, 5, 5 }, 15 } };
    }

    @Test
    @Parameters(method = "getMaxSubArrayForSumArray")
    public void getMaxSubArrayForSumTest(int[] arr, int n) {
        System.out.println(dpQue.getMaxSubArrayForSum(arr, n).toString());
    }

    @Test
    public void getLargestZeroOneSubArrayTest() {
        // Integer [] arr = {1, 0, 1, 1, 1, 0, 0};
        Integer[] arr = { 1, 1, 1, 1 };
        System.out.println(dpQue.getLargestZeroOneSubArray(arr));
    }
    
    @Test
    public void maxCircularSubArrayTest() {
        //Integer a[] = {8, -8, 9, -9, 10, -11, 12};
        Integer a[] = {10, -3, -4, 7, 6, 5, -4, -1};
        System.out.println(dpQue.maxCircularSubArray(a));
    }
    
    @Test
    public void getMaxAsTest() {
        dpQue.getMaxAs(7);
        dpQue.getMaxAs(20);
        dpQue.getMaxAs(8);
        dpQue.getMaxAs(11);
    }

}
