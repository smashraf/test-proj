package rohan.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class LargestZeroSumTest {

    LargestZeroSum largestZeroSum = new LargestZeroSum();

    public Object[] getData() {
        return new Object[] { new Object[] { new Integer[] { -1, -1, -2, 3, 4, 5, -9 }, 0, 0, 0, 6 },
                new Object[] { new Integer[] { -1, -1, 2 }, 0, 0, 0, 3 },
                new Object[] { new Integer[] { 1, 5, 10, -1, 1 }, 0, 0, 0, 2 },
                new Object[] { new Integer[] { 6, -1, 1 }, 0, 0, 0, 2 },
                new Object[] { new Integer[] { 6, 0, 0, 0 }, 0, 0, 0, 3 },
                new Object[] { new Integer[] { 6 }, 0, 0, 0, 0 }, new Object[] { new Integer[] { 0 }, 0, 0, 0, 1 } };
    }

    @Test
    @Parameters(method = "getData")
    public void getLargestSubSetTest(Integer[] S, int N, int i, int count, int ans) {
        Assert.assertTrue(largestZeroSum.getLargestSubSet(S, N, 0, 0) == ans);
    }

    @Test
    @Parameters(method = "getData")
    public void getLargestSumSetIterativeTest(Integer[] S, int N, int i, int count, int ans) {
        Assert.assertTrue(largestZeroSum.getLargestSumSetIterative(S, N, 0, 0) == ans);
    }

    @Test
    @Parameters(method = "getData")
    public void getgetLargestSumSetSmartTest(Integer[] S, int N, int i, int count, int ans) {
        Assert.assertTrue(largestZeroSum.getLargestSumSetSmart(S, N, 0, 0) == ans);
    }

}
