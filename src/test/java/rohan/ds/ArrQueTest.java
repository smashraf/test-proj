package rohan.ds;

import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;
import junitparams.Parameters;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ArrQueTest {

    private ArrQue arrQue = new ArrQue();

    public Object[] getArrays() {
        return new Object[] { new Object[] { new int[] { 5, 4, 3, 2, 1 }, new int[] { 1, 2, 3, 4, 5 } },
                new Object[] { new int[] { 2, 4, 1, 3, 5 }, new int[] { 1, 2, 3, 4, 5 } },
                new Object[] { new int[] { 2, 4, 1 }, new int[] { 1, 2, 4 } } };
    }

    public Object[] getArray() {
        return new Object[] { new Object[] { new int[] { 1, 2, 2, 2, 5 }, 2, 1 },new Object[] { new int[] { }, 2, -1 } };
    }

    @Test
    @Parameters(method = "getArrays")
    public void mergeSortTest(int[] arr1, int[] arr2) {
        arrQue.mergeSort(arr1, 0, arr1.length - 1);
        System.out.println(arrQue.c);
        Assert.assertArrayEquals(arr2, arr1);
    }

    @Test
    @Parameters(method = "getArray")
    public void binSrchMinTest(int[] arr, int x, int ans) {
        Assert.assertEquals(ans, arrQue.binSrchMin(arr, 0, arr.length - 1, x));
    }
    
    @Test
    @Parameters(method = "getArray")
    public void binSrchMaxTest(int[] arr, int x, int ans) {
        Assert.assertEquals(3, arrQue.binSrchMax(arr, 0, arr.length - 1, 2));
    }

}