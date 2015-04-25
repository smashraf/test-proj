package rohan.junit;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class CoinChangeTest {

    private CoinChange coinChange = new CoinChange();

    public Object[] getData() {
        return new Object[] { new Object[] {new Integer[]{ 1, 2, 3 }, 4, 0, 4},
                new Object[] {new Integer[]{ 2, 5, 3, 6 }, 10, 0, 5},
                new Object[] {new Integer[]{ 2, 5, 3, 6 }, -1, 0, 0}
        };
    }
    
    public Object[] getDpData() {
        return new Object[] { new Object[] {new Integer[]{ 1, 2, 3 }, 4, 4L},
                new Object[] {new Integer[]{ 2, 5, 3, 6 }, 10, 5L},
                new Object[] {new Integer[]{41,34,46,9,37,32,42,21,7,13,1,24,3,43,2,23,8,45,19,30,29,18,35,11},250,15685693751L}
        };
    }

    @Test
    @Parameters(method = "getData")
    public void getNumberOfWaysTest(Integer S[], int N, int i, int ans) {
        Assert.assertTrue(coinChange.getNumberOfWays(S, N, i) == ans);
    }
    
    @Test
    @Parameters(method = "getDpData")
    public void getNumberOfWaysDpTest(Integer S[], Integer N, Long ans) {
        Assert.assertTrue(coinChange.getNumberOfWaysDp(S, N).equals(ans));
    }

}
